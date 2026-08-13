# SpringLab

This lab uses Spring to connect Asteroids components.

It comes after the three [JPMS exercises](https://github.com/IlyasOsman29/JPMSLabs) and shows Spring dependency injection as another component model. Component testing is covered separately in [TestLab](https://github.com/IlyasOsman29/TestLab).

`AppConfig` enables component scanning. Spring finds the Player, Enemy and Asteroids classes and injects them into `Game` as lists of the two service interfaces. The game class therefore does not create the components itself.

## Run

Requirements: JDK 21 and Maven.

```text
mvn clean verify
mvn exec:java
```

The test checks that Spring injects all three components. The console example starts them and processes one frame.
