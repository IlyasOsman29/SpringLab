package dk.sdu.cbse.springlab;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpringInjectionTest {
    @Test
    void springCreatesGameAndInjectsBothServiceLists() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Game game = context.getBean(Game.class);
            assertEquals(List.of("Asteroids", "Enemy", "Player"), game.pluginNames());
            assertEquals(List.of("Asteroids", "Enemy", "Player"), game.processorNames());
            game.start();
            game.process(1.0);
            assertEquals(3, game.data().entities().size());
            assertEquals(10.0, game.data().entities().stream()
                    .filter(e -> e.type().equals("PLAYER")).findFirst().orElseThrow().x());
        }
    }
}
