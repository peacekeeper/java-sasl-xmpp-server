package sasl.xmpp.server.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BackendIntegrationWithDID implements BackendIntegration {

    private static final Logger log = LogManager.getLogger(BackendIntegrationWithDID.class);

    @Override
    public String checkName(String defaultName) {
        String checkedName = defaultName;
        log.debug("checkName({}) --> {}", defaultName, checkedName);
        return checkedName;
    }

    @Override
    public char[] checkPassword(char[] password) {
        log.debug("checkPassword()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String checkTextInput(String defaultText) {
        log.debug("checkTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String checkTextInputRealm(String defaultText) {
        log.debug("checkTextInputRealm()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String checkTextInputJWK(String defaultText) {
        log.debug("checkTextInputJWK()");
        throw new UnsupportedOperationException("Not supported.");
    }
}
