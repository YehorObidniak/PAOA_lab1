package methods;

import points.FunctionPoints;
import points.Point;

public class GoldenSectionSearch {
    private final FunctionPoints points;

    public GoldenSectionSearch(FunctionPoints points){
        this.points = points;
    }

    public double minimizeMin(double a, double b, double tolerance){
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        int iteration = 0;

        while (Math.abs(b - a) > tolerance) {
            double x1 = b - (b - a) / goldenRatio;
            double x2 = a + (b - a) / goldenRatio;

            double y1 = points.interpolate(x1);
            double y2 = points.interpolate(x2);

            if (y1 < y2) {
                b = x2;
            } else {
                a = x1;
            }
            iteration++;
        }

        double min = (a + b) / 2;

        System.out.println("Golden section search MIN iterations - " + iteration);
        return min;
    }

    public double minimizeMax(double a, double b, double tolerance){
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        int iteration = 0;

        while (Math.abs(b - a) > tolerance) {
            double x1 = b - (b - a) / goldenRatio;
            double x2 = a + (b - a) / goldenRatio;

            double y1 = points.interpolate(x1);
            double y2 = points.interpolate(x2);

            if (y1 > y2) {
                b = x2;
            } else {
                a = x1;
            }
            iteration++;
        }

        double max = (a + b) / 2;

        System.out.println("Golden section search MAX iterations - " + iteration);
        return max;
    }
}


