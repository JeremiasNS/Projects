package Class;

import java.io.IOException;
import java.util.Scanner;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;

public class XmppClient {

    private XMPPTCPConnectionConfiguration.Builder builder;
    private XMPPTCPConnection connection;
    private ChatManager chatManager;

    public XmppClient() throws XmppStringprepException {
        builder = XMPPTCPConnectionConfiguration.builder();
        builder
                .setXmppDomain("xabber.org")
                .setHost("xabber.org")
                .setUsernameAndPassword("jeremias.net", "jerenet@tcp")
                .setResource("desktop-app");

        connection = new XMPPTCPConnection(builder.build());
    }

    public static void main(String[] args) {
        try {
            XmppClient app = new XmppClient();
            app.connect();
            String msg, destinatario;
            Scanner teclado = new Scanner(System.in);
            do {
                System.out.println("Digite o destinatario");
                destinatario = teclado.nextLine();
                System.out.println("Digite a mensagem");
                msg = teclado.nextLine();
            } while (!msg.equalsIgnoreCase("sair"));
        } catch (XmppStringprepException ex) {
            System.out.println("Houve um erro ao iniciar o app");
        }
    }

    public boolean connect() {
        try {
            connection.connect();
            // chatManager = Chat
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            throw new RuntimeException(
                    "Não foi possivel conectar ao servidor", e);

        }

        chatManager = ChatManager.getInstanceFor(connection);

        try {
            connection.login();
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            throw new RuntimeException(
                    "Não foi possivel loga no servidor", e);

        }

        return true;
    }

}
