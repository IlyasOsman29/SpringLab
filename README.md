# SpringLab

This lab uses Spring to connect Asteroids components.

`AppConfig` enables component scanning. Spring finds the Player, Enemy and Asteroids classes and injects them into `Game` as lists of the two service interfaces. The game class therefore does not create the components itself.

## Run

Requirements: JDK 21 and Maven.

```text
mvn clean verify
mvn exec:java
```

The test checks that Spring injects all three components. The console example starts them and processes one frame.
