FROM openjdk:17
MAINTAINER chenyh<1922561940@qq.com>
VOLUME /tmp
ADD service-course-1.0-SNAPSHOT.jar service-course-1.0-SNAPSHOT.jar
RUN bash -c 'touch /service-course-1.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-course-1.0-SNAPSHOT.jar"]
EXPOSE 8082
