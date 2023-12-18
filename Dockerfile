# Define a imagem base para a segunda etapa
FROM openjdk:17.0.2-slim
# Define o diretório de implantação
WORKDIR /app
# Copia o artefato construído da imagem maven
COPY target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
