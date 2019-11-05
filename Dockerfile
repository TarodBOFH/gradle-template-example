FROM gradle:5.4.1-alpine
LABEL maintainer="\"Juan Ara\" <juan@juanylaura.es>"

USER root

ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

RUN mkdir app
VOLUME /home/gradle/app
WORKDIR /home/gradle/app

ENTRYPOINT ["gradle"]

CMD ["build"]
