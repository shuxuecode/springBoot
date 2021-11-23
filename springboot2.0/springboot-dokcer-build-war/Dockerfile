FROM tomcat:8.5.73-jre8-openjdk

VOLUME /tmp

RUN echo "Asia/Shanghai" > /etc/timezone

ADD target/*.war /usr/local/tomcat/webapps/ROOT.war

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

EXPOSE 8080

