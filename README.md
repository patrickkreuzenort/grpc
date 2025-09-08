GrpcExpress
=======
# Spring Boot + gRPC (Java 21)

Minimalny serwer gRPC w Spring Boot

Spring Boot + net.devh starter rejestruje wszystkie beany implementujące gRPC service i startuje Netty gRPC server na 9090

## Wymagania

- Java 21 (Temurin/Zulu lub inna dystrybucja)
- Maven 3.9+
- VS Code (zalecany Extension Pack for Java)

## Budowanie i uruchamianie

- Budowa:

```zsh
mvn -q -e -DskipTests clean package
```

- Uruchom aplikację:

```zsh
mvn -q spring-boot:run
```

Serwer gRPC nasłuchuje na `localhost:9090`.

## Szybki test gRPC

- grpcurl (CLI):

```zsh
brew install grpcurl
grpcurl -plaintext -d '{"name":"Who"}' localhost:9090 hello.Greeter/SayHello
```

- Klient Java:

```zsh
mvn -q -Dexec.mainClass=com.x.grpc.client.YoloClient -Dexec.args=x-programming exec:java
```

## Testy

- Test integracyjny uruchamia serwer na losowym porcie i weryfikuje odpowiedź Greeter:

```zsh
mvn -q test
```

## Struktura

- `src/main/proto/helloworld.proto` — definicja API
- `src/main/java/com/example/grpc/hello/GreeterService.java` — serwis gRPC
- `src/main/java/com/example/grpc/client/GreeterClient.java` — klient gRPC
- `src/test/java/com/example/grpc/hello/GreeterIntegrationTest.java` — test integracyjny
- `src/main/java/com/example/grpc/GrpcSpringBootApplication.java` — klasa startowa
- `src/main/resources/application.yml` — konfiguracja portu

## Uwagi

- Generacja klas z `.proto`: `protobuf-maven-plugin`
- Starter serwera: `net.devh:grpc-server-spring-boot-starter`

## Testowanie z poziomu terminala

- uniwersalny:  cos do
  - plaintext : łączy się bez TLS
  - grpc.health.v1.Health : mechanizm health-checka
  - grpc.reflection.v1alpha.ServerReflection : mechanizm refleksji proto
- Znaczenie: każda linia to w pełni kwalifikowana nazwa serwisu, którą możesz później wywołać.

- HealthServiceImpl: zapewnia endpoint health
-
- ProtoReflectionService udostępnia metadane proto (dzięki temu grpcurl może wywoływać metody bez lokalnych plików `.proto`).
- Wywołanie RPC: grpcurl serializuje JSON do protobuf zgodnie z definicją metody, wysyła żądanie, serwer deserializuje, wykonuje logikę serwisu i odsyła odpowiedź.

Testowanie w kreya:
- 
- http://localhost:9090
- Mode: gRPC
- Request: 
  - {
    "name": "{{ faker.name.last_name }}"
    }