package task3;

import java.util.Objects;

public abstract class Shape {
    private final String name;

    public Shape(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя фигуры не может быть пустым");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double evalArea();
    public abstract String getDescription();

    @Override
    public String toString() {
        return "Shape{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        return Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
