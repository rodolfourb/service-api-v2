# Etapa 1: Construção do Projeto
# Inicializa a construção e define a imagem base para a primeira etapa
FROM maven:3.6.3-adoptopenjdk-11 as build
# Acelera um pouco a JVM do Maven
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
# Define o diretório de trabalho
WORKDIR /app
# Copia apenas o pom.xml
COPY src /app/src
COPY pom.xml /app
# Vai offline usando o pom.xml
RUN mvn dependency:go-offline

# Compila o código-fonte e empacota em um arquivo jar
RUN mvn clean package install -Dmaven.test.skip=true

# Etapa 2: Execução do Projeto
# Define a imagem base para a segunda etapa
FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
# Define o diretório de implantação
WORKDIR /app
# Copia o artefato construído da imagem maven
COPY --from=build /app/target/app.jar /app
# Define o comando de execução padrão
ENTRYPOINT ["java", "-jar", "app.jar"]
