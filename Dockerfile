FROM gradle:5.6.2-jdk11

LABEL maintainer="\"Juan Ara\" <bofh@juanylaura.es>"

USER root

ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

RUN mkdir app
VOLUME /home/gradle/app
WORKDIR /home/gradle/app

ENTRYPOINT ["gradle"]

CMD ["build"]
