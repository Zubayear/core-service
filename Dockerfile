FROM eclipse-temurin:25-jre-alpine
RUN addgroup --system template-group && adduser --system --ingroup template-group template-user
WORKDIR /home/template-user
COPY --chown=template-user:template-group target/core-service*.jar core-service.jar
USER template-user:template-group
ENTRYPOINT ["java", "-jar", "core-service.jar"]