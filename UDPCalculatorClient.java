import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPCalculatorClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        System.out.print("Enter expression (example: 3 + 10): ");
        String expression = scanner.nextLine();

        byte[] sendBuffer = expression.getBytes();
        DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, 2001);
        socket.send(packet);

        System.out.println("Expression sent to UDP calculator server.");
        socket.close();
        scanner.close();
    }
}
