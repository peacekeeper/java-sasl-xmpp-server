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
