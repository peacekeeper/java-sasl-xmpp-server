package sasl.xmpp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tigase.auth.DefaultMechanismSelector;
import tigase.auth.MechanismSelector;

public class SaslServerMechanismSelector extends DefaultMechanismSelector implements MechanismSelector {

    private static final Log log = LogFactory.getLog(SaslServerMechanismSelector.class);
}