FROM openjdk:23-slim
RUN apt-get update && apt-get install -y libcjson-dev && rm -rf /var/lib/apt/lists
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/libinverso-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
RUN mkdir /root/aplicacion
COPY libProceso.so /usr/local/lib/
ENV LD_LIBRARY_PATH=/usr/local/lib:$LD_LIBRARY_PATH
ENTRYPOINT ["java", "-jar", "/app.jar"]