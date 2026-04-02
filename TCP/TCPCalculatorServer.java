import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPCalculatorServer {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(2000);

        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter expression to send to client (example: 4 + 5): ");
                    String input = scanner.nextLine();

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(input);
                    out.close();
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}
