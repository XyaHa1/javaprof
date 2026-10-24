package task1;

import java.util.Objects;

public record Point(double x, double y) {

    public double distanceTo(Point other) {
        Objects.requireNonNull(other, "Другая точка не может быть null");

        return Math.hypot(x() - other.x(), y() - other.y());
    }
}
