FROM openjdk:17-oracle
#le volume consiste a stoker les données en dehors du contener
VOLUME /tmp
COPY /target/*.jar app.jar
ENTRYPOINT ["java" ,"-jar", "app.jar"]
