package Testing;
import java.awt.*;

public class Bullet {
    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    private double radius = 1;

    public Bullet(double xPos, double yPos, double xVel, double yVel) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public double getRadius(){
        return radius;
    }

    public void move(double timeElapsed) {
        xPos = xPos + xVel * timeElapsed;
        yPos = yPos + yVel * timeElapsed;
    }


    //draw bullet here
    public void draw() {
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.filledCircle(xPos, yPos, 1);
    }

}