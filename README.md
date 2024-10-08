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
docker build -f ./docker/Dockerfile -t peacekeeper/java-sasl-xmpp-server .
```

## Run

```
docker run -it -e 'DB_ROOT_USER=admin' -e 'DB_ROOT_PASS=tigase' -h java-sasl-xmpp-server -p 8080:8080 -p 5222:5222 -v ./tigase/etc/:/home/tigase/tigase-server/etc/ -v ./tigase/certs/:/home/tigase/tigase-server/certs/ -v ./tigase/data/:/home/tigase/tigase-server/data/ peacekeeper/java-sasl-xmpp-server:latest
```

or

```
docker compose up
```

## About

Markus Sabadello - https://github.com/peacekeeper/

<img align="left" height="40" src="https://github.com/peacekeeper/did-based-sasl/blob/main/docs/logo-ngi-assure.png?raw=true">

This project has received financial support from NLnet and the NGI Assure fund. NGI Assure was established with
financial support from the European Commission's Next Generation Internet programme, under the aegis of DG
Communications Networks, Content and Technology.
