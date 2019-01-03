FROM openjdk:8-jdk-alpine
ENV LANG C.UTF-8
ENV APP_ROOT /usr/local/src/practice_api
RUN mkdir -p $APP_ROOT
COPY . $APP_ROOT
WORKDIR $APP_ROOT
RUN $APP_ROOT/gradlew build
ADD ./build/libs/*.jar /usr/local/practice_api/app.jar
