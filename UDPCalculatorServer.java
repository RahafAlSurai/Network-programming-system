import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

public class UDPCalculatorServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(2001);
        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String input = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
        StringTokenizer tokenizer = new StringTokenizer(input);

        int operand1 = Integer.parseInt(tokenizer.nextToken());
        String operation = tokenizer.nextToken();
        int operand2 = Integer.parseInt(tokenizer.nextToken());

        int result;
        if ("+".equals(operation)) {
            result = operand1 + operand2;
        } else {
            throw new IllegalArgumentException("Only + operation is supported in this version.");
        }

        System.out.println("The result of the addition is:");
        System.out.println(result);

        serverSocket.close();
    }
}
