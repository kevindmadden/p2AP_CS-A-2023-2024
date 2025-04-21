package Testing;
import java.awt.*;

public class Asteroid {
    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;
    private double radius;

    public Asteroid(double xPos, double yPos, double xVel, double yVel,double radius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
        this.radius = radius;
    }

    public double getyPos() {
        return yPos;
    }
    public  double getxPos(){
        return xPos;
    }
    public double getRadius(){
        return radius;
    }

    public void move(double timeElapsed) {
        xPos = xPos + xVel * timeElapsed;
        yPos = yPos + yVel * timeElapsed;
    }
    public void draw(){
        StdDraw.setPenColor(Color.red);
        StdDraw.filledCircle(xPos,yPos,radius);

    }


}