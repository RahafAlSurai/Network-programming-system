import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPUppercaseClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getLocalHost();

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a message: ");
        String message = inFromUser.readLine();

        byte[] sendBuffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, 4481);
        socket.send(packet);

        System.out.println("Message sent to UDP uppercase server.");
        socket.close();
    }
}
