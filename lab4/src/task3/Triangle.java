package task3;

import java.util.Objects;

public class Triangle extends Shape {
    private final double sideA;
    private final double heightH;

    public Triangle(double sideA, double heightH) {
        super("Обычный треугольник");
        if (sideA <= 0 || heightH <= 0) {
            throw new IllegalArgumentException("Сторона и высота должны быть строго больше 0");
        }
        this.sideA = sideA;
        this.heightH = heightH;
    }

    public double getSideA() { return sideA; }
    public double getHeightH() { return heightH; }

    @Override
    public double evalArea() {
        return 0.5 * sideA * heightH;
    }

    @Override
    public String getDescription() {
        return getName() + " с высотой " + heightH + " и стороной " + sideA + "имеет площадь " + evalArea();
    }

    @Override
    public String toString() {
        return "Triangle{name=" + getName() +
                ", sideA=" + sideA +
                ", heightH=" + heightH +
                ", S=" + evalArea() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.sideA, sideA) == 0 &&
                Double.compare(triangle.heightH, heightH) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sideA, heightH);
    }
}

