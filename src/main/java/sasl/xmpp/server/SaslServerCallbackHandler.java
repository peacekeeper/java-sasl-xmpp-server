package sasl.xmpp.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sasl.mechanism.did.callback.JWKCallback;
import sasl.xmpp.server.integration.BackendIntegration;

import javax.security.auth.callback.*;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.RealmCallback;

public class SaslServerCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SaslServerCallbackHandler.class);

    private final BackendIntegration backendIntegration;

    public SaslServerCallbackHandler(BackendIntegration backendIntegration) {
        this.backendIntegration = backendIntegration;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("-- SERVER CALLBACK: {}", cb.getClass().getSimpleName());
            if (cb instanceof NameCallback nc) {
                log.info(">S {} --- defaultName: {}, name: {}", nc.getPrompt(), nc.getDefaultName(), nc.getName());
                nc.setName(this.getBackendIntegration().checkName(nc.getDefaultName()));
                log.info("S> {} --- defaultName: {}, name: {}", nc.getPrompt(), nc.getDefaultName(), nc.getName());
            } else if (cb instanceof PasswordCallback pc) {
                log.info(">S {} --- password: {}, isEchoOn: {}", pc.getPrompt(), pc.getPassword(), pc.isEchoOn());
                pc.setPassword(this.getBackendIntegration().checkPassword(pc.getPassword()));
                log.info("S> {} --- password: {}, isEchoOn: {}", pc.getPrompt(), pc.getPassword(), pc.isEchoOn());
            } else if (cb instanceof RealmCallback rc) {
                log.info(">S {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
                rc.setText(this.getBackendIntegration().checkTextInputRealm(rc.getDefaultText()));
                log.info("S> {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
            } else if (cb instanceof JWKCallback rc) {
                log.info(">S {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
                rc.setText(this.getBackendIntegration().checkTextInputRealm(rc.getDefaultText()));
                log.info("S> {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
            } else if (cb instanceof TextInputCallback tic) {
                log.info(">S {} --- defaultText: {}, text: {}", tic.getPrompt(), tic.getDefaultText(), tic.getText());
                tic.setText(this.getBackendIntegration().checkTextInput(tic.getDefaultText()));
                log.info("S> {} --- defaultText: {}, text: {}", tic.getPrompt(), tic.getDefaultText(), tic.getText());
            } else if (cb instanceof AuthorizeCallback ac) {
                log.info(">S --- authenticationID: {}, authorizationID: {}, authorizedID: {}, isAuthorized: {}", ac.getAuthenticationID(), ac.getAuthorizationID(), ac.getAuthorizedID(), ac.isAuthorized());
                ac.setAuthorized(true);
                log.info("S> --- authenticationID: {}, authorizationID: {}, authorizedID: {}, isAuthorized: {}", ac.getAuthenticationID(), ac.getAuthorizationID(), ac.getAuthorizedID(), ac.isAuthorized());
            } else {
                throw new UnsupportedCallbackException(cb);
            }
        }
    }

    public BackendIntegration getBackendIntegration() {
        return this.backendIntegration;
    }
}