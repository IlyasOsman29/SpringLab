package dk.sdu.cbse.springlab;

import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public final class Game {
    private final List<IGamePluginService> plugins;
    private final List<IEntityProcessingService> processors;
    private final GameData data = new GameData();

    public Game(List<IGamePluginService> plugins, List<IEntityProcessingService> processors) {
        this.plugins = plugins.stream().sorted(Comparator.comparing(IGamePluginService::name)).toList();
        this.processors = processors.stream().sorted(Comparator.comparing(IEntityProcessingService::name)).toList();
    }

    public void start() { plugins.forEach(plugin -> plugin.start(data)); }
    public void process(double deltaSeconds) { processors.forEach(p -> p.process(data, deltaSeconds)); }
    public List<String> pluginNames() { return plugins.stream().map(IGamePluginService::name).toList(); }
    public List<String> processorNames() { return processors.stream().map(IEntityProcessingService::name).toList(); }
    public GameData data() { return data; }
}
