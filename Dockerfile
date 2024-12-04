FROM openjdk:17
COPY . /var/www/java
WORKDIR /var/www/java
RUN javac SimpleHTTPServer.java
CMD ["java", "SimpleHTTPServer"]
