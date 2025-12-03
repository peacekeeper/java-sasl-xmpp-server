package sasl.xmpp.server;

import demo.sasl.server.SaslServerCallbackHandler;
import demo.sasl.server.integration.BackendIntegrationWithDID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sasl.mechanism.did.DIDChallengeSaslProvider;
import tigase.auth.CallbackHandlerFactory;
import tigase.auth.callbacks.CallbackHandlerFactoryIfc;
import tigase.db.NonAuthUserRepository;
import tigase.xmpp.XMPPResourceConnection;

import javax.security.auth.callback.CallbackHandler;

public class SaslServerCallbackHandlerFactory extends CallbackHandlerFactory implements CallbackHandlerFactoryIfc {

    private static final Log log = LogFactory.getLog(SaslServerCallbackHandler.class);

    @Override
    public CallbackHandler create(String mechanismName, XMPPResourceConnection session, NonAuthUserRepository repo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        CallbackHandler result;
        if (DIDChallengeSaslProvider.MECHANISM_NAME.equals(mechanismName)) {
            result = new SaslServerCallbackHandler(new BackendIntegrationWithDID());
        } else {
            result = super.create(mechanismName, session, repo);
        }
        log.info("create: " + mechanismName + ", " + session + "," + repo + " -> " + result);
        return result;
    }
}