FROM amazoncorretto:17-alpine-jdk
COPY ["target/*.jar", "app.jar"]
COPY ["storage/logo/*", "storage/logo/"]
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
