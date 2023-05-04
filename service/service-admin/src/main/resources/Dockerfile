FROM openjdk:17
MAINTAINER chenyh<1922561940@qq.com>

VOLUME /tmp 

ADD service-admin-1.0-SNAPSHOT.jar service-admin-1.0-SNAPSHOT.jar

RUN bash -c 'touch /service-admin-1.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-admin-1.0-SNAPSHOT.jar"]
EXPOSE 8081
