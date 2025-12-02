package sasl.xmpp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sasl.mechanism.did.callback.JWKCallback;
import tigase.auth.CallbackHandlerFactory;
import tigase.auth.callbacks.CallbackHandlerFactoryIfc;
import tigase.db.NonAuthUserRepository;
import tigase.xmpp.XMPPResourceConnection;

import javax.security.auth.callback.*;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.RealmCallback;

public class SaslServerCallbackHandler extends CallbackHandlerFactory implements CallbackHandler, CallbackHandlerFactoryIfc {

    private static final Log log = LogFactory.getLog(SaslServerCallbackHandler.class);

    @Override
    public CallbackHandler create(String mechanismName, XMPPResourceConnection session, NonAuthUserRepository repo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return super.create(mechanismName, session, repo);
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("-- SERVER CALLBACK: " + cb.getClass().getSimpleName());
            if (cb instanceof NameCallback nc) {
                log.info(">S " + nc.getPrompt() + " --- defaultName: " + nc.getDefaultName() + ", name: " + nc.getName());
                log.info("S> " + nc.getPrompt() + " --- defaultName: " + nc.getDefaultName() + ", name: " + nc.getName());
            } else if (cb instanceof PasswordCallback pc) {
                log.info(">S " + pc.getPrompt() + " --- password: " + pc.getPassword() + ", isEchoOn: " + pc.isEchoOn());
                log.info("S> " + pc.getPrompt() + " --- password: " + pc.getPassword() + ", isEchoOn: " + pc.isEchoOn());
            } else if (cb instanceof RealmCallback rc) {
                log.info(">S " + rc.getPrompt() + " --- defaultText: " + rc.getDefaultText() + ", text: " + rc.getText());
                log.info("S> " + rc.getPrompt() + " --- defaultText: " + rc.getDefaultText() + ", text: " + rc.getText());
            } else if (cb instanceof JWKCallback rc) {
                log.info(">S " + rc.getPrompt() + " --- defaultText: " + rc.getDefaultText() + ", text: " + rc.getText());
                log.info("S> " + rc.getPrompt() + " --- defaultText: " + rc.getDefaultText() + ", text: " + rc.getText());
            } else if (cb instanceof TextInputCallback tic) {
                log.info(">S " + tic.getPrompt() + " --- defaultText: " + tic.getDefaultText() + ", text: " + tic.getText());
                log.info("S> " + tic.getPrompt() + " --- defaultText: " + tic.getDefaultText() + ", text: " + tic.getText());
            } else if (cb instanceof AuthorizeCallback ac) {
                log.info(">S --- authenticationID: " + ac.getAuthenticationID() + ", authorizationID: " + ac.getAuthorizationID() + ", authorizedID: " + ac.getAuthorizedID() + ", isAuthorized: " + ac.isAuthorized());
                log.info("S> --- authenticationID: " + ac.getAuthenticationID() + ", authorizationID: " + ac.getAuthorizationID() + ", authorizedID: " + ac.getAuthorizedID() + ", isAuthorized: " + ac.isAuthorized());
            } else {
                throw new UnsupportedCallbackException(cb);
            }
            throw new UnsupportedOperationException("Not supported.");
        }
    }
}