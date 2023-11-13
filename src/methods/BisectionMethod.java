package methods;

import points.Point;
import points.FunctionPoints;

public class BisectionMethod {
    private final FunctionPoints points;

    public BisectionMethod(FunctionPoints points){
        this.points = points;
    }

    public double minimize(double a, double b, double tolerance){
        if (points.interpolate(a) * points.interpolate(b) >= 0) {
            System.out.println("You have not assumed right a and b");
            return Double.NaN;
        }

        double c = a;
        while ((b - a) >= tolerance) {
            c = (a + b) / 2;

            if (points.interpolate(c) == 0.0)
                break;
            else if (points.interpolate(c) * points.interpolate(a) < 0)
                b = c;
            else
                a = c;
        }

        return c;
    }
}
