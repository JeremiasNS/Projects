package classes;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author aluno
 */
public class ChatClient {

    private final PrintWriter out;
    private Socket socket;
    private Scanner teclado;

    public ChatClient() throws IOException {
        socket = new Socket(
                ChatServer.ADDRESS, ChatServer.PORT);
        System.out.println(
                "Cliente conectado ao servidor");
        teclado = new Scanner(System.in);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        
        String msg;
        do {
            System.out.println("Digite uma mensagem:");
            msg = teclado.nextLine();
            out.println(msg);
        } while (!msg.equalsIgnoreCase("sair"));
    }

    public static void main(String[] args) {
        try {
            new ChatClient();
        } catch (IOException ex) {
            System.out.println("Não foi possivel conectar ao servidor" + ex.getMessage());
        }
    }
}
