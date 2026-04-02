import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBasicClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] sendBuffer = "Hello Datagram server".getBytes();
        InetAddress address = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, 1028);
        socket.send(packet);
        System.out.println("Message sent to UDP server.");
        socket.close();
    }
}
