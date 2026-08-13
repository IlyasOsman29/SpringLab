package dk.sdu.cbse.springlab;

import org.springframework.stereotype.Component;

@Component
public final class EnemyPlugin implements IGamePluginService, IEntityProcessingService {
    @Override public String name() { return "Enemy"; }
    @Override public void start(GameData data) { data.entities().add(new Entity("ENEMY", 100)); }
    @Override public void process(GameData data, double deltaSeconds) {
        data.entities().stream().filter(e -> e.type().equals("ENEMY"))
                .forEach(e -> e.move(-5 * deltaSeconds));
    }
}
