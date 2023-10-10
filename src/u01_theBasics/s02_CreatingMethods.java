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

        drawEyes();
        //drawCircles();
        drawCircles(25,25);
        drawCircles(25,75);
        drawCircles(75,25);
        drawCircles(85,25);
        drawCircles(95,25);
        drawCircles(100,10);
    }

    public static void drawEyes(){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(83,83,4);
        StdDraw.filledCircle(67,83,4);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.filledCircle(83,82,3);
        StdDraw.filledCircle(67,82,3);
    }

    public static void drawCircles(int xPos, int yPos){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.05);
        StdDraw.circle(xPos,yPos,10);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.05/2);
        StdDraw.circle(xPos,yPos,5);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(.05/4);
        StdDraw.circle(xPos,yPos,2.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.setPenRadius(.05/8);
        StdDraw.circle(xPos,yPos,1.25);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.setPenRadius(.05/16);
        StdDraw.circle(25,25,.75);
        StdDraw.setPenRadius(.05);
        StdDraw.line(xPos, yPos+10, xPos+10, yPos+10);
    }

}