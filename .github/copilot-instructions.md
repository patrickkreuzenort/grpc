- [x] Verify that the copilot-instructions.md file in the .github directory is created.

- [x] Clarify Project Requirements

  - Java 21 + Spring Boot + gRPC (server), Maven

- [x] Scaffold the Project

  - Utworzone: pom.xml, proto, implementacja serwisu, konfiguracje VS Code, README, wrapper Maven

- [x] Customize the Project

  - Port gRPC: 9090, przykładowy Greeter

- [x] Install Required Extensions

  - Brak wymagań (opcjonalne: Extension Pack for Java)

- [x] Compile the Project

  - Dodano javax.annotation-api; kompilacja przechodzi: mvn -DskipTests clean package

- [x] Create and Run Task

  - Dodano .vscode/tasks.json (build/run Maven) z PATH dla Homebrew

- [x] Launch the Project

  - Aplikacja uruchomiona (Spring Boot + gRPC), nasłuch na 9090

- [x] Ensure Documentation is Complete
  - README uzupełniony o instrukcje build/run
