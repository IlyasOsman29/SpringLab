# SpringLab

SpringLab implements the Asteroids Core with the Spring dependency-injection component model. `AppConfig` enables component scanning. Spring constructs Player, Enemy and Asteroids providers, then constructs `Game` by injecting both `List<IGamePluginService>` and `List<IEntityProcessingService>` through its constructor. `Game` contains no `new PlayerPlugin()` or other concrete provider construction.

Run the automated proof and package the lab:

```powershell
mvn clean test package
```

Run the small console demonstration:

```powershell
mvn exec:java
```

The output lists the injected providers and shows that their entities were created and processed for one deterministic frame.
