package sasl.xmpp.server;

import demo.sasl.server.debug.SaslServerDebug;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sasl.mechanism.did.DIDChallengeSaslProvider;
import sasl.mechanism.did.server.DIDChallengeSaslServer;
import tigase.auth.TigaseSaslProvider;
import tigase.auth.mechanisms.TigaseSaslServerFactory;
import tigase.kernel.beans.Bean;

import javax.security.auth.callback.CallbackHandler;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.security.Security;
import java.util.Map;

@Bean(name="customSaslFactory", parent = TigaseSaslProvider.class, active = true)
public class DIDChallengeSaslServerFactory extends TigaseSaslServerFactory {

    private static final Log log = LogFactory.getLog(DIDChallengeSaslServerFactory.class);

    static {
        Security.addProvider(new DIDChallengeSaslProvider());
    }

    static {
        SaslServerDebug.logSaslServerFactoriesAndMechanisms();
    }

    @Override
    public SaslServer createSaslServer(String mechanism, String protocol, String serverName, Map<String,?> props, CallbackHandler cbh) throws SaslException {
        log.info("createSaslServer: " + mechanism + ","  + protocol + "," + serverName + "," + props + "," + cbh);
        if (! DIDChallengeSaslProvider.MECHANISM_NAME.equals(mechanism)) return null;
        return new DIDChallengeSaslServer(protocol, serverName, props, cbh);
    }

    @Override
    public String[] getMechanismNames(Map<String, ?> map) {
        log.info("getMechanismNames: " + map);
        return new String[] { DIDChallengeSaslProvider.MECHANISM_NAME };
    }
}
