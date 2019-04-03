package classes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer implements Runnable {

    public static final int PORT = 4000;
    public static final String ADDRESS = "localhost";

    private ServerSocket socket;
    private List<Socket> clientSockets;

    public ChatServer() throws IOException {
        socket = new ServerSocket(PORT);
        System.out.println("Servidor Iniciado");
        clientSockets = new ArrayList<>();
        
        while (true) {
            System.out.println("Aguardando conexao de cliente..");
            this.clientSockets.add(socket.accept());
            new Thread(this).start();

        }

    }

    public static void main(String[] args) {
        try {
            new ChatServer();

        } catch (IOException ex) {
            System.err.println("Não foi possivel iniciar o servidor:" + ex.getMessage());
        }
    }

    @Override
    public void run() {
        Socket clientSocket = this.clientSockets.get(0);
        try {
            Scanner in
                    = new Scanner(clientSocket.getInputStream());
            System.out.println("Cliente" + clientSocket.getInetAddress() + "conectado");
            System.out.println("Msg recebida do cliente "
                    + clientSocket.getInetAddress() + ": "
                    + in.nextLine());
        } catch (IOException ex) {
            System.err.println("Não foi possivel receber msg do cliente"
                    + clientSocket.getInetAddress() + ": "
                    + ex.getMessage()
            );
        }
    }

}
