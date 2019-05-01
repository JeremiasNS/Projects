package Class;

import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;

public class XmppClient {

    private String username;
    private String password;
    private XMPPTCPConnectionConfiguration.Builder builder;
    private XMPPTCPConnection connection;

    public XmppClient() throws XmppStringprepException {
        builder = XMPPTCPConnectionConfiguration.builder();
        builder
                .setXmppDomain("xabber.org")
                .setHost("xabber.org")
                .setUsernameAndPassword(username, password);
    }

    public static void main(String[] args) {
    }

    public boolean connect() {
    }

    public boolean login() {
    }

}
