package dk.sdu.cbse.springlab;

import org.springframework.stereotype.Component;

@Component
public final class AsteroidPlugin implements IGamePluginService, IEntityProcessingService {
    @Override public String name() { return "Asteroids"; }
    @Override public void start(GameData data) { data.entities().add(new Entity("ASTEROID", 50)); }
    @Override public void process(GameData data, double deltaSeconds) {
        data.entities().stream().filter(e -> e.type().equals("ASTEROID"))
                .forEach(e -> e.move(2 * deltaSeconds));
    }
}
