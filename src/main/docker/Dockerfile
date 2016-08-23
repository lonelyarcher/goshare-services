FROM java:8
VOLUME /tmp
ADD goshare-services-0.0.1.jar services.jar
EXPOSE 80
RUN sh -c 'touch /goshare-services-0.0.1.jar'
ENTRYPOINT ["java", "-Dserver.port=80", "-Dspring.data.mongodb.uri=mongodb://mongodb/geoshare", "-Djava.security.egd=file:/dev/./urandom","-jar","/services.jar"]