import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 666;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    System.out.println("New connection accepted. Port: " + clientSocket.getPort());
                    final String name = in.readLine();
                    out.println(String.format("Hi, " + name + " your port is " + clientSocket.getPort()));
                }
            }
        }
    }
}