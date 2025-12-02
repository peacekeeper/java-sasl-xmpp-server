package sasl.xmpp.server.integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

public class BackendIntegrationWithPassword implements BackendIntegration {

    private static final Log log = LogFactory.getLog(BackendIntegrationWithPassword.class);

    private static final Map<String, String> USERNAMES = Map.of(
            "alice", "alice",
            "bob", "bob");

    private static final Map<String, char[]> PASSWORDS = Map.of(
            "alice", "s3cr3t".toCharArray(),
            "bob", "123456".toCharArray());

    private static final String REALM = "localhost";

    @Override
    public String checkName(String defaultName) {
        String checkedName = null;
        if (USERNAMES.containsKey(defaultName)) checkedName = USERNAMES.get(defaultName);
        log.debug("checkName(" + defaultName + ") --> " + checkedName);
        return checkedName;
    }

    @Override
    public char[] checkPassword(char[] password) {
        char[] checkedPassword = null;
        /* TODO */ String username = "alice";
        if (PASSWORDS.containsKey(username)) checkedPassword = PASSWORDS.get(username);
        log.debug("checkPassword(" + password + ") --> " + checkedPassword);
        return checkedPassword;
    }

    @Override
    public String checkTextInput(String defaultText) {
        log.debug("checkTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String checkTextInputRealm(String defaultText) {
        String checkedText = null;
        if (REALM.equals(defaultText)) checkedText = REALM;
        log.debug("checkTextInputRealm(" + defaultText + ") --> " + checkedText);
        return checkedText;
    }

    @Override
    public String checkTextInputJWK(String defaultText) {
        log.debug("checkTextInputJWK()");
        throw new UnsupportedOperationException("Not supported.");
    }
}
