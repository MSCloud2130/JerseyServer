FROM maven:3.6.0-jdk-11-slim AS build

#RUN mkdir -p home/apps/jerseyServer
#COPY . home/apps/jerseyServer

# application placed into /opt/app
RUN mkdir -p /home/apps/jerseyserver
WORKDIR /home/apps/jerseyserver

# selectively add the POM file and
# install dependencies
COPY pom.xml /home/apps/jerseyserver
RUN mvn install

# rest of the project
COPY src /home/apps/jerseyserver/src
RUN mvn package

# local application port
EXPOSE 8181

# execute it
#CMD ["mvn", "exec:java", "-f", "home/apps/jerseyServer"]
CMD ["mvn", "exec:java"]

