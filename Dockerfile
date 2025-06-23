# Multi-stage build para optimizar tamaño
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

# Directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración Maven
COPY pom.xml .
COPY src ./src

# Compilar aplicación
RUN mvn clean package -DskipTests

# Imagen final más liviana
FROM eclipse-temurin:17-jre-alpine

# Instalar shadow-utils para poder crear usuarios
RUN apk add --no-cache shadow \
 && groupadd -r appuser && useradd -r -g appuser appuser

# Crear usuario no-root por seguridad
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Directorio de trabajo
WORKDIR /app

# Copiar JAR desde build stage
COPY --from=build /app/target/usuarios-*.jar app.jar

# Cambiar propietario
RUN chown -R appuser:appuser /app
USER appuser

# Puerto que expone la aplicación
EXPOSE 8088

# Variables de entorno para JVM
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8088/actuator/health || exit 1

# Comando para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]