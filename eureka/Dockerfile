FROM adoptopenjdk:8u252-b09-jdk-hotspot
WORKDIR /opt
COPY target/eureka-1.0.1.jar .
RUN echo "Asia/Chongqing" > /etc/timezone
EXPOSE 8761
CMD [ "sh", "-c", "java ${JVM_OPTS} -jar eureka-1.0.1.jar ${APP_OPTS}" ]