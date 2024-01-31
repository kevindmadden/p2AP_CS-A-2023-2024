package u06_Asteroids;

import java.awt.event.KeyEvent;

public class Ship {

    /*
    Next Steps:
    -Draw the triangle of the ship instead of a line
    -Get thrust working on the ship
        -thrust controls the acceleration of the ship
            -xVelx=xAceleration*timeElapsed, similar for y
            -make the acceleration go at the same angle as the ship is pointing
        -acceleeration then updates the velocity (v=a*t)
        -velocity changes the position (x=x+vt)

     */

    private double xCenter;
    private double yCenter;
    private double xShipTip;
    private double yShipTip;
    private double xRightTip;
    private double yRightTip;
    private double xLeftTip;
    private double yLeftTip;
    private double theta;
    private double thetaRate;
    private double size;
    private double slope;
    private double xVel;
    private double yVel;
    private double xAcceleration;
    private double yAcceleration;

    public Ship(double xCenter,double yCenter, double theta, double thetaRate){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.theta = theta;
        this.thetaRate = thetaRate;
        this.xAcceleration = 0;
        this.yAcceleration = 0;
        this.size = 10;
        this.xVel = 0;
        this.yVel = 0;
    }

    public void calculate(double timeElapsed){
        rotate(timeElapsed);
        moveForward(timeElapsed);
    }

    public void moveForward(double timeElapsed){
        //To get this working with acceleration:
        // You'll have xAccel and yAccel
        // accelaration will impact the velocity
        // velocity will impact the position
        // keyboard input will control the acceleration


        xAcceleration = 0;
        yAcceleration = 0;
        // Below, this just implements with velocity
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            xAcceleration = 500;
            yAcceleration = 500;
            //xCenter+=.01*(xShipTip-xCenter);
            //yCenter+=.01*(yShipTip-yCenter);
        }
        xVel = xVel + xAcceleration*(xShipTip-xCenter)*timeElapsed*timeElapsed;
        yVel = yVel + yAcceleration*(yShipTip-yCenter)*timeElapsed*timeElapsed;
        xCenter = xCenter + xVel*timeElapsed;
        yCenter = yCenter + yVel*timeElapsed;
    }

    public void rotate(double timeElapsed){
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            theta = theta - thetaRate;
        }

        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            theta = theta + thetaRate;
        }
        xShipTip = xCenter + size*Math.cos(theta);
        yShipTip = yCenter + size*Math.sin(theta);
        xRightTip = xCenter + size*Math.cos(theta-Math.toRadians(150));
        yRightTip = yCenter + size*Math.sin(theta-Math.toRadians(150));
        xLeftTip = xCenter + size*Math.cos(theta+Math.toRadians(150));
        yLeftTip = yCenter + size*Math.sin(theta+Math.toRadians(150));
    }

    public void draw(){
        StdDraw.line(xShipTip, yShipTip, xRightTip, yRightTip);
        StdDraw.line(xShipTip, yShipTip, xLeftTip, yLeftTip);
        //StdDraw.line(x1Line, y1Line, x2Line, y2Line);
        //StdDraw.line(x1Line, y1Line, x2Line, y2Line);
    }
}
