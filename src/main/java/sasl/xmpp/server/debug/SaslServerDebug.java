package sasl.xmpp.server.debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslServerFactory;
import java.util.Collections;

public class SaslServerDebug {

    private static final Logger log = LogManager.getLogger(SaslServerDebug.class);

    public static void logSaslServerFactoriesAndMechanisms() {
        log.debug("=== SASL server factories ===");
        for (SaslServerFactory saslServerFactory : Collections.list(Sasl.getSaslServerFactories())) {
            for (String mechanismName : saslServerFactory.getMechanismNames(null)) {
                log.debug("SASL server factory for {}: {}", mechanismName, saslServerFactory.getClass().getName());
            }
        }
    }
}