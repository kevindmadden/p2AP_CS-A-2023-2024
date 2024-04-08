package u07_Asteroids;

import u01_theBasics.StdDraw;

import java.util.ArrayList;

public class Bullet {
    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;
    private double radius;
    private double rate;
    private double numFramesToExist;
    public Bullet(double xPos, double yPos, double xVel, double yVel, double radius, double rate, double numFramesToExist){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
        this.radius = radius;
        this.rate = rate;
        this.numFramesToExist = numFramesToExist;
    }
    public Bullet(double xPos, double yPos, double xVel, double yVel){
        this(xPos, yPos, xVel, yVel, 1, .3,30);
    }

    public void calculate(double timeElapsed){
        xPos = xPos + xVel*timeElapsed;
        yPos = yPos + yVel*timeElapsed;
        numFramesToExist--;
    }

    public void draw(){
        StdDraw.filledCircle(xPos, yPos, radius);
    }

    public boolean shouldDelete(){
        if(numFramesToExist<=0){
            return true;
        }
        return false;
    }






}
