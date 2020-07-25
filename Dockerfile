FROM openjdk:8
EXPOSE 8080
ADD /target/shoppingCartApp-0.0.1-SNAPSHOT.jar shoppingCartApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shoppingCartApp-0.0.1-SNAPSHOT.jar"]