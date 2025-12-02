package sasl.xmpp.server;

import tigase.auth.TigaseSaslProvider;
import tigase.kernel.beans.Bean;

@Bean(name="customSaslFactory", parent = TigaseSaslProvider.class, active = true)
public class DIDChallengeSaslServerFactory extends sasl.mechanism.did.server.DIDChallengeSaslServerFactory {
}
