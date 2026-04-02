import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPDateClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine running the date service on port 9090:");

        Socket socket = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);

        input.close();
        socket.close();
        System.exit(0);
    }
}
