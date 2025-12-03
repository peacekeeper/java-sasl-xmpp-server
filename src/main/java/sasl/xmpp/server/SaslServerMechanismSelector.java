package sasl.xmpp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sasl.mechanism.did.DIDChallengeSaslProvider;
import tigase.auth.DefaultMechanismSelector;
import tigase.auth.MechanismSelector;
import tigase.xmpp.XMPPResourceConnection;

import javax.security.sasl.SaslServerFactory;

public class SaslServerMechanismSelector extends DefaultMechanismSelector implements MechanismSelector {

    private static final Log log = LogFactory.getLog(SaslServerMechanismSelector.class);

    public SaslServerMechanismSelector() {
        super();
    }

    @Override
    protected boolean match(SaslServerFactory factory, String mechanismName, XMPPResourceConnection session) {
        boolean result = super.match(factory, mechanismName, session);
        result |= DIDChallengeSaslProvider.MECHANISM_NAME.equals(mechanismName);
        if (result) log.info("match: " + factory + ", " + mechanismName + "," + session + " -> " + result);
        return result;
    }
}