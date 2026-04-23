FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY . .

RUN javac -d build main/Main.java

CMD ["java", "-cp", "build", "main.Main"]
