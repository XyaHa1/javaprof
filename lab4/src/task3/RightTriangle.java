package task3;

import java.util.Objects;

public class RightTriangle extends Shape {
    private final double cathetusA;
    private final double cathetusB;

    public RightTriangle(double cathetusA, double cathetusB) {
        super("Прямоугольный треугольник");
        if (cathetusA <= 0 || cathetusB <= 0) {
            throw new IllegalArgumentException("Катеты должны быть строго больше 0");
        }
        this.cathetusA = cathetusA;
        this.cathetusB = cathetusB;
    }

    public double getCathetusA() { return cathetusA; }
    public double getCathetusB() { return cathetusB; }

    @Override
    public double evalArea() {
        return 0.5 * cathetusA * cathetusB;
    }

    @Override
    public String getDescription() {
        return getName() + " с катетами " + cathetusA + " и " + cathetusB + " имеет площадь " + evalArea();
    }

    @Override
    public String toString() {
        return "RightTriangle{name=" + getName() +
                ", cathetusA=" + cathetusA +
                ", cathetusB=" + cathetusB +
                ", S=" + evalArea() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        RightTriangle that = (RightTriangle) o;

        return Double.compare(that.cathetusA, cathetusA) == 0 &&
                Double.compare(that.cathetusB, cathetusB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cathetusA, cathetusB);
    }
}
