# java-sasl-xmpp-server

This repository is one component of the project "Securing Internet protocols with DIDs, using SASL",
see https://github.com/peacekeeper/did-based-sasl for an overview and list of all components.

## Description

This repository contains a configuration of the [Tigase XMPP Server](https://tigase.net/xmpp-server/), with added support for the
DID-based SASL authentication mechanism described and implemented in https://github.com/peacekeeper/java-sasl-did-mechanism.

The custom SASL mechanism and configuration has been added as described in https://docs.tigase.net/en/latest/Tigase_Development/Plugin_Development.html#saslcmac

- The .jar files built from the following repositories have been added to the Tigase XMPP server:
  - https://github.com/peacekeeper/java-sasl-did-mechanism
  - https://github.com/peacekeeper/java-sasl-server-demo
- The config.tdsl file has been configured to add the DID-based SASL authentication mechanism:
  - https://github.com/peacekeeper/java-sasl-xmpp-server/blob/main/resources/etc/config.tdsl
- A custom Java Security Provider has been added that registers the DID-based SASL `SaslServerFactory` for the `DID-CHALLENGE` mechanism:
  - https://github.com/peacekeeper/java-sasl-xmpp-server/blob/main/src/main/resources/META-INF/java.security.Provider
  - https://github.com/peacekeeper/java-sasl-did-mechanism/blob/main/src/main/java/sasl/did/mechanism/DidSaslProvider.java

## Build

```
docker compose build
```

## Run

```
docker compose up -d
```

## Setup

Go to http://localhost:8080/. Default HTTP Basic Authentication username/password is "admin" / "tigase".

Follow the setup instructions.

In the step "Installation of Tigase XMPP Server is almost finished", add the following configuration:

```
'sess-man' () {
    'sasl-provider' () {
        customSaslFactory(class: sasl.xmpp.server.DIDChallengeSaslServerFactory) {}
        callback-handler-factory(class: sasl.xmpp.server.SaslServerCallbackHandlerFactory) {}
        'mechanism-selector'(class: sasl.xmpp.server.SaslServerMechanismSelector) {}
    }
}
```

Save the configuration, then restart the server.

```
docker compose restart java-sasl-xmpp-server
```

## Watch logs

```
docker logs -f java-sasl-xmpp-server
```

## Create demo users and send messages

Go to http://localhost:8080/dashboard/login. Log in with the admin JID and password you created during setup.

Add users, e.g.:

- "alice" / "alicepass"
- "bob" / "bobpass"

Go to http://localhost:8080/ui/. Log in with a user and try sending / receiving messages.

## Stop

```
docker compose down
```

## About

Markus Sabadello - https://github.com/peacekeeper/

<img align="left" height="40" src="https://github.com/peacekeeper/did-based-sasl/blob/main/docs/logo-ngi-assure.png?raw=true">

This project has received financial support from NLnet and the NGI Assure fund. NGI Assure was established with
financial support from the European Commission's Next Generation Internet programme, under the aegis of DG
Communications Networks, Content and Technology.

<img align="left" height="40" src="https://github.com/peacekeeper/did-based-sasl/blob/main/docs/logo-ngi-zero.png?raw=true">

This project has received financial support from NLnet and the NGI0 Commons fund. NGI0 Commons was established with
financial support from the European Commission's Next Generation Internet programme, under the aegis of DG
Communications Networks, Content and Technology.
