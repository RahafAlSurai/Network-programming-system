import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPUppercaseServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4481);
        byte[] receiveBuffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        String upper = received.toUpperCase();

        System.out.println("Received: " + received);
        System.out.println("Uppercase: " + upper);
        socket.close();
    }
}
