FROM java:8
VOLUME /tmp
ADD goshare-services-0.0.1.jar services.jar
EXPOSE 8080
RUN sh -c 'touch /goshare-services-0.0.1.jar'
ENTRYPOINT ["java", "-Xmx 4G", "-Dspring.data.mongodb.uri=mongodb://mongodb/geoshare", "-Djava.security.egd=file:/dev/./urandom","-jar","/services.jar"]
