import methods.BisectionMethod;
import methods.GoldenSectionSearch;
import methods.SecantMethod;
import points.FunctionPoints;
import points.Point;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Point[] points = {
            new Point(2, -2),
            new Point(2.25, -3),
            new Point(2.5, -3.5),
            new Point(3, -5),
            new Point(3.2, -6),
            new Point(3.5, -6.5),
            new Point(4, -7),
            new Point(4.2, -6.8),
            new Point(4.5, -6.5),
            new Point(4.8, -6),
            new Point(5, -4),
            new Point(5.7, -2),
            new Point(5.9, -1),
            new Point(6, 0),
            new Point(6.008, 1),
            new Point(6.04, 2),
            new Point(6.5, 3.8),
            new Point(6.8, 4),
            new Point(7, 5),
            new Point(7.5, 4.8),
            new Point(7.9, 4),
            new Point(8, 2.5),
            new Point(8.6, 2)
    };
    public static double a = 2;
    public static double b = 8;

    public static void main(String[] args) {
        FunctionPoints func_points = new FunctionPoints(points);

        BisectionMethod bisection = new BisectionMethod(func_points);
        GoldenSectionSearch golden_section_search = new GoldenSectionSearch(func_points);
        SecantMethod secant = new SecantMethod(func_points);
        double tolerance = 0.000000000000001;
        int maxIterations = 1000;

        double res_bisection = bisection.minimize(a, b, tolerance);
        double res_gss_min = golden_section_search.minimizeMin(a, b, tolerance);
        double res_gss_max = golden_section_search.minimizeMax(a, b, tolerance);
        double res_secant = secant.minimize(a, b, maxIterations, tolerance);


        System.out.printf("\nBisection method result: %.14f (%.14f)", res_bisection, func_points.interpolate(res_bisection));
        System.out.printf("\nGolden-section search result: Min = %.14f (%.14f), Max = %.14f (%.14f)", res_gss_min, func_points.interpolate(res_gss_min), res_gss_max, func_points.interpolate(res_gss_max));
        System.out.printf("\nSecant method result: %.14f (%.14f)", res_secant, func_points.interpolate(res_secant));
    }
}