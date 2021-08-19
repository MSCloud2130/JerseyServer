FROM maven:3.6.0-jdk-11-slim AS build

RUN mkdir -p home/apps/jerseyServer
COPY . home/apps/jerseyServer

EXPOSE 8181

CMD ["mvn", "exec:java", "-f", "home/apps/jerseyServer"]