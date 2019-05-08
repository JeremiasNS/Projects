package Class;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;

public class XmppClient {

    private String username;
    private String password;
    private XMPPTCPConnectionConfiguration.Builder builder;
    private XMPPTCPConnection connection;
    private ChatManager chatManager;

    public XmppClient() throws XmppStringprepException {
        builder = XMPPTCPConnectionConfiguration.builder();
        builder
                .setXmppDomain("xabber.org")
                .setHost("xabber.org")
                .setUsernameAndPassword(username, password)
                .setResource("desktop-app");
        
        connection = new XMPPTCPConnection(builder.build());
    }

    public static void main(String[] args) {
    }

    public boolean connect() {
        try {
            connection.connect();
           // chatManager = Chat
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            throw new RuntimeException(
            "Não foi possivel conectar ao servidor", e);
            
        }
        
        try {
            connection.login();
        } catch (SmackException | IOException | XMPPException | InterruptedException e) {
            throw new RuntimeException(
            "Não foi possivel loga no servidor", e);
            
        }
        
        return true;
    }

}
