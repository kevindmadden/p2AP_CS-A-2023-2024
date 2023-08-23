package u01_theBasics;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

                //method     param
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);

    }
}