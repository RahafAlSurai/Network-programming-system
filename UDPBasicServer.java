import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPBasicServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(1028);
        byte[] receiveBuffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);
        socket.close();
    }
}
