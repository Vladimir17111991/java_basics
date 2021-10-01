public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {

        return Math.PI*Math.pow(radius,2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {

        return Math.abs(4 * Math.PI * Math.pow(radius,3) / 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean abC = a + b > c;
        boolean acB = a + c > b;
        boolean bcA = b + c > a;
            return (abC && acB && bcA);
        }


    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c)/2;
        if(isTrianglePossible(a,b,c))
        {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }
}
