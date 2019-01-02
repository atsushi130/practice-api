# FROM picoded/ubuntu-openjdk-8-jdk:latest
FROM openjdk:8-jdk-alpine
ENV LANG C.UTF-8
# RUN apt-get update
# RUN apt-get install -y wget
# RUN mkdir -p /etc/apt/sources.list.d
# RUN sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
# RUN wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | apt-key add -
# RUN apt-get install -y postgresql-client-9.6
ENV APP_ROOT /usr/local/src/practice_api
RUN mkdir -p $APP_ROOT
COPY . $APP_ROOT
WORKDIR $APP_ROOT
RUN $APP_ROOT/gradlew build
# RUN mv ./build/libs/*.jar ./build/libs/app.jar
ADD ./build/libs/practice-0.0.1-SNAPSHOT.jar /usr/local/practice_api/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/usr/local/practice_api/app.jar"]
