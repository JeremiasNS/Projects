package Class;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

public class XmppClient implements IncomingChatMessageListener{

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
            app.start();
        } catch (XmppStringprepException ex) {
            System.out.println("Houve um erro ao iniciar o app");
        }
    }

    private void start() {
        connect();
        String msg, destinatario;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Digite o destinatario");
            destinatario = teclado.nextLine();
            System.out.println("Digite a mensagem");
            msg = teclado.nextLine();

            try {
                EntityBareJid usuario = JidCreate.entityBareFrom(destinatario);
                chatManager.chatWith(usuario).send(msg);
            } catch (SmackException.NotConnectedException e) {
                System.out.println("Vocẽ não está conectado");
            } catch (InterruptedException e) {
                System.out.println("Ocorreu um erro ao tentar enviar a mensagem");
            } catch (XmppStringprepException ex) {
                System.out.println("Usuario inválido");
            }

        } while (!msg.equalsIgnoreCase("sair"));
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
        chatManager.addIncomingListener(this);

        try {
            connection.login();
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            throw new RuntimeException(
                    "Não foi possivel loga no servidor", e);

        }

        return true;
    }

    @Override
    public void newIncomingMessage(EntityBareJid entityBareJid, Message message, Chat chat) {
        System.out.println("Msg recebida de " + entityBareJid.getLocalpart() + ":" +
                message.getBody());
    }

}
