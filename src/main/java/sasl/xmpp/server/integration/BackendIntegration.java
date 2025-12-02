package sasl.xmpp.server.integration;

public interface BackendIntegration {

    String checkName(String defaultName);
    char[] checkPassword(char[] password);
    String checkTextInput(String defaultText);
    String checkTextInputRealm(String defaultText);
    String checkTextInputJWK(String defaultText);
}
