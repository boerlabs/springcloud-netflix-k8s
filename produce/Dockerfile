FROM adoptopenjdk:8u252-b09-jdk-hotspot
WORKDIR /opt
COPY target/produce-1.0.1.jar .
RUN echo "Asia/Chongqing" > /etc/timezone
EXPOSE 10080
CMD [ "sh", "-c", "java ${JVM_OPTS} -jar produce-1.0.1.jar ${APP_OPTS}" ]