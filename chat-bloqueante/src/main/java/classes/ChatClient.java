package classes;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author aluno
 */
public class ChatClient {

    private Socket socket;

    public ChatClient() throws IOException {
        socket = new Socket(ChatServer.ADDRESS, ChatServer.PORT);
        System.out.println("Cliente conectado ao servidor");
    }

    public static void main(String[] args) {
        try {
            new ChatClient();
        } catch (IOException ex) {
            System.out.println("Não foi possivel conectar ao servidor" + ex.getMessage());
        }
    }
}
