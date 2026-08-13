package dk.sdu.cbse.springlab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Main {
    private Main() { }
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Game game = context.getBean(Game.class);
            game.start();
            game.process(1.0);
            System.out.println("Injected game plugins: " + game.pluginNames());
            System.out.println("Injected processors: " + game.processorNames());
            game.data().entities().stream().sorted(java.util.Comparator.comparing(Entity::type))
                    .forEach(e -> System.out.printf("ENTITY %-8s x=%.1f%n", e.type(), e.x()));
        }
    }
}
