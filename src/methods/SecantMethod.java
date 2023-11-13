package methods;

import points.FunctionPoints;
import points.Point;

public class SecantMethod {
    private final FunctionPoints points;

    public SecantMethod(FunctionPoints points){
        this.points = points;
    }

    public double minimize(double x0, double x1, int maxIterations, double tolerance) {
        double x2, y0, y1, error;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            y0 = points.interpolate(x0);
            y1 = points.interpolate(x1);

            if (Math.abs(y1 - y0) < tolerance) {
                System.out.println("Difference too small. Cannot proceed further.");
                return Double.NaN;
            }

            x2 = x1 - y1 * (x1 - x0) / (y1 - y0);

            error = Math.abs(x2 - x1);
            if (error < tolerance) {
                System.out.println("Secant method iterations - " + iteration);
                return x2;
            }

            x0 = x1;
            x1 = x2;
        }

        System.out.println("Root not found within the given maximum iterations.");
        return Double.NaN;
    }
}
