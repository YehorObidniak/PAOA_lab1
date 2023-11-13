package points;

public class FunctionPoints {
    private final Point[] points;
    public FunctionPoints(Point[] points){
        this.points = points;
    }

    public double interpolate(double x){
        for (int i = 0; i < points.length - 1; i++) {
            if (x == points[i].getX()) {
                return points[i].getY();
            }
            if (x > points[i].getX() && x < points[i + 1].getX()) {
                return points[i].getY() + ((points[i + 1].getY() - points[i].getY()) / (points[i + 1].getX() - points[i].getX()) * (x-points[i].getX()));
            }
        }
        return Double.NaN;
    }
}
