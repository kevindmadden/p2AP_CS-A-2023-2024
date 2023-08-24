package u01_theBasics;

public class s02_CreatingMethods {
    public static void main(String[] args) {
        StdDraw.setScale(0,100);

        //Head
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(75,75,20);
        //Nose
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(75,75,2,4);
        //Mouth
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledEllipse(75,65,10,3);
        //Eyes
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(83,83,4);
        StdDraw.filledCircle(67,83,4);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.filledCircle(83,82,3);
        StdDraw.filledCircle(67,82,3);


        //cocentric circles
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(.05);
        StdDraw.circle(25,25,10);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.05/2);
        StdDraw.circle(25,25,5);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(.05/4);
        StdDraw.circle(25,25,2.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.setPenRadius(.05/8);
        StdDraw.circle(25,25,1.25);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.setPenRadius(.05/16);
        StdDraw.circle(25,25,.75);


    }
}