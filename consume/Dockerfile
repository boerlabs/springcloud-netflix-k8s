FROM adoptopenjdk:8u252-b09-jdk-hotspot
WORKDIR /opt
COPY target/consume-1.0.1.jar .
RUN echo "Asia/Chongqing" > /etc/timezone
EXPOSE 10086
CMD [ "sh", "-c", "java ${JVM_OPTS} -jar consume-1.0.1.jar ${APP_OPTS}" ]