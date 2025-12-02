# Dockerfile for peacekeeper/java-sasl-xmpp-server

FROM maven:3-eclipse-temurin-21-alpine AS build
MAINTAINER Markus Sabadello <markus@danubetech.com>

# build java-sasl-xmpp-server

WORKDIR /opt/java-sasl-xmpp-server
ADD pom.xml /opt/java-sasl-xmpp-server
ADD dependencies/ /opt/java-sasl-xmpp-server/dependencies/
RUN mvn install:install-file -Dfile=/opt/java-sasl-xmpp-server/dependencies/java-sasl-did-mechanism-1.0-SNAPSHOT.jar -DgroupId=com.danubetech -DartifactId=java-sasl-did-mechanism -Dversion=1.0-SNAPSHOT -Dpackaging=jar
RUN mvn org.apache.maven.plugins:maven-dependency-plugin:3.3.0:go-offline
RUN mvn clean install
ADD . /opt/java-sasl-xmpp-server
RUN mvn clean install dependency:copy-dependencies

# build image

FROM tigase/tigase-xmpp-server:8.4.0
MAINTAINER Markus Sabadello <markus@danubetech.com>

# build

COPY --from=build /opt/java-sasl-xmpp-server/target/java-sasl-xmpp-server-* /home/tigase/tigase-server/jars/
COPY --from=build /opt/java-sasl-xmpp-server/target/dependency/java-sasl-did-mechanism-* /home/tigase/tigase-server/jars/
