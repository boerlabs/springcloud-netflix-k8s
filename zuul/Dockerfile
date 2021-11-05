FROM adoptopenjdk:8u252-b09-jdk-hotspot as prod
WORKDIR /opt
COPY target/zuul-1.0.1.jar .
RUN echo "Asia/Chongqing" > /etc/timezone
EXPOSE 8125
CMD [ "sh", "-c", "java ${JVM_OPTS} -jar zuul-1.0.1.jar ${APP_OPTS}" ]