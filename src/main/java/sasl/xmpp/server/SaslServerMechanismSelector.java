package sasl.xmpp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sasl.mechanism.did.DIDChallengeSaslProvider;
import tigase.auth.DefaultMechanismSelector;
import tigase.auth.MechanismSelector;
import tigase.vhosts.VHostItem;
import tigase.xmpp.XMPPResourceConnection;

import javax.security.sasl.SaslServerFactory;
import java.util.Collection;
import java.util.Enumeration;

public class SaslServerMechanismSelector extends DefaultMechanismSelector implements MechanismSelector {

    private static final Log log = LogFactory.getLog(SaslServerMechanismSelector.class);

    public SaslServerMechanismSelector() {
        super();
    }

    @Override
    public Collection<String> filterMechanisms(Enumeration<SaslServerFactory> serverFactories, XMPPResourceConnection session) {
        Collection<String> result = super.filterMechanisms(serverFactories, session);
        log.info("filterMechanisms: " + serverFactories + ", " + session + " -> " + result);
        return result;
    }

    @Override
    protected boolean isAllowedForDomain(String mechanismName, VHostItem vhost) {
        boolean result = super.isAllowedForDomain(mechanismName, vhost);
        log.info("isAllowedForDomain: " + mechanismName + ", " + vhost + " -> " + result);
        return result;
    }

    @Override
    protected boolean match(SaslServerFactory factory, String mechanismName, XMPPResourceConnection session) {
        boolean result = super.match(factory, mechanismName, session);
        result |= DIDChallengeSaslProvider.MECHANISM_NAME.equals(mechanismName);
        log.info("match: " + factory + ", " + mechanismName + "," + session + " -> " + result);
        return result;
    }
}