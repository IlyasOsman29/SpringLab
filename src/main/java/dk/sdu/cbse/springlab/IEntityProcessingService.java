package dk.sdu.cbse.springlab;

public interface IEntityProcessingService {
    String name();
    void process(GameData data, double deltaSeconds);
}
