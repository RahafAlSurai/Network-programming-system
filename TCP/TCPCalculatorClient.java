import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class TCPCalculatorClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 2000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String expression = input.readLine();
        expression = expression.trim();

        StringTokenizer tokenizer = new StringTokenizer(expression);
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

        input.close();
        socket.close();
    }
}
