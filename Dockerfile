#FROM openjdk:8
#EXPOSE 9090
#ADD target/blog-app-apis.jar blog-app-apis.jar
#ENTRYPOINT ["java", "-jar", "/blog-app-apis.jar"]

FROM openjdk:8
ADD target/blog-app-apis.jar blog-app-apis.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "blog-app-apis.jar"]