package classes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static final int PORT = 4000;
    public static final String ADDRESS = "localhost";

    private ServerSocket socket;

    public ChatServer() throws IOException {
        socket = new ServerSocket(PORT);
        System.out.println("Servidor Iniciado");

        while (true) {
            System.out.println("Aguardando conexao de cliente..");
            Socket clientSocket = socket.accept();
            System.out.println("cliente" + clientSocket.getInetAddress() + "conectado");
        }

    }

    public static void main(String[] args) {
        try {
            new ChatServer();

        } catch (IOException ex) {
            System.err.println("Não foi possivel iniciar o servidor:" + ex.getMessage());
        }
    }

}
