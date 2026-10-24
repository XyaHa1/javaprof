package task1;

public class Triangle implements Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
        this.c = new Point(x3, y3);
        validate();
    }

    public double getSideAB() {
        return a.distanceTo(b);
    }

    public double getSideBC() {
        return b.distanceTo(c);
    }

    public double getSideCA() {
        return c.distanceTo(a);
    }

    @Override
    public double area() {
        return 0.5 * Math.abs(
            (b.x() - a.x()) * (c.y() - a.y()) -
            (c.x() - a.x()) * (b.y() - a.y())
        );
    }

    @Override
    public double perimeter() {
        return getSideAB() + getSideBC() + getSideCA();
    }

    private void validate() {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Точки не могут быть null");
        }

        double area2X = Math.abs(
                (b.x() - a.x()) * (c.y() - a.y()) -
                (c.x() - a.x()) * (b.y() - a.y()));

        if (area2X < 1e-9) {
            throw new IllegalArgumentException("Вырожденный треугольник");
        }
    }

}
