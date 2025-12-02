package sasl.xmpp.server.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BackendIntegrationNone implements BackendIntegration {

    private static final Logger log = LogManager.getLogger(BackendIntegrationNone.class);

    @Override
    public String checkName(String defaultName) {
        log.debug("checkName()");
        throw new UnsupportedOperationException("Not supported.");
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
