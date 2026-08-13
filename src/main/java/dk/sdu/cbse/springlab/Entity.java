package dk.sdu.cbse.springlab;

public final class Entity {
    private final String type;
    private double x;
    public Entity(String type, double x) { this.type = type; this.x = x; }
    public String type() { return type; }
    public double x() { return x; }
    public void move(double amount) { x += amount; }
}
