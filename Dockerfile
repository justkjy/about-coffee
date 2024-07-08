FROM openjdk:17

LABEL maintainer="mysterykjy@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/aboutcoffee-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} aboutcoffee.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/aboutcoffee.jar"]