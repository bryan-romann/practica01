FROM mave:3.8.5-openjdk-17 as build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/practica01.jar practica01
EXPOSE 91
ENTRYPOINT [m"java", "-jar", "practica01.jar"]