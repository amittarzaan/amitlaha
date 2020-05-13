FROM adoptopenjdk/openjdk11:alpine as compile
MAINTAINER amittarzaan amittarzaan@gmail.com

# Build the jar using maven 
RUN apk add maven
WORKDIR /app
COPY . /app/
RUN mvn -f pom.xml clean package -DskipTests
FROM adoptopenjdk/openjdk11:alpine-jre
# Copy the packaged jar app file to a smaller JRE base image
COPY --from=compile "/app/target/patient-0.0.1-SNAPSHOT.jar" /usr/share/

ENTRYPOINT ["java", "-jar", "/usr/share/patient-0.0.1-SNAPSHOT.jar"]
