package methods;

import points.Point;
import points.FunctionPoints;

public class BisectionMethod {
    private final FunctionPoints points;

    public BisectionMethod(FunctionPoints points){
        this.points = points;
    }

    public double minimize(double a, double b, double tolerance){
        while ((b - a) > tolerance) {
            double mid = (a + b) / 2;
            double fMid = points.interpolate(mid);

            if (points.interpolate((a + mid) / 2) < fMid) {
                b = mid;
            } else {
                a = mid;
            }
        }
        return (a + b) / 2;
    }
}
