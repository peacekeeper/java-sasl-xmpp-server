package sasl.xmpp.server.integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BackendIntegrationNone implements BackendIntegration {

    private static final Log log = LogFactory.getLog(BackendIntegrationNone.class);

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
