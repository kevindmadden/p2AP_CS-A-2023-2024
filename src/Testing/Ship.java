package Testing;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Ship {

        /*
        Next Steps:
        -Draw the triangle of the ship instead of a line
        -Get thrust working on the ship
            -thrust controls the acceleration of the ship
                -xVelx=xAceleration*timeElapsed, similar for y
                -make the acceleration go at the same angle as the ship is pointing
            -acceleration then updates the velocity (v=a*t)
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
    private double xAccel;
    private double yAccel;
    private ArrayList <Bullet> bullets; // instance for bullets
    //  private ArrayList<Asteroid> asteroids; // instance for astreoids
    double bulletCooldownTimer = 0;
    public Ship(double xCenter, double yCenter, double theta, double thetaRate) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.theta = theta;
        this.thetaRate = thetaRate;
        this.size = 5;
        this.xVel = 0;
        this.yVel = 0;
        this.xAccel = 0;
        this.yAccel = 0;
        bullets = new ArrayList<Bullet>(); //Creates arraylist for bullets
        //asteroids = new ArrayList<Asteroid>(); //Creates arraylist for asteroids
    }
    //----------------------------------------------------
    public void calculate(double timeElapsed) {
        bulletCooldownTimer = bulletCooldownTimer + timeElapsed;
        rotate(timeElapsed);
        moveForward(timeElapsed);

        if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && bulletCooldownTimer >.2){
            fireBullet();
            bulletCooldownTimer = 0;

        }
    }

    public void moveForward(double timeElapsed) {
        //Accelerate forward
        //We need to use the length of the x and y components of the vector to calculate the acceleration (See kami document for project)
        //Also, we need to calculate the velocity based on the acceleration (Again, see document)

        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            xAccel = xShipTip - xCenter;
            yAccel = yShipTip - yCenter;

        } else {
            xAccel = 0;
            yAccel = 0;
        }
        xVel = xVel + xAccel * 4 * timeElapsed;
        xCenter = xCenter + xVel * timeElapsed;

        yVel = yVel + yAccel * 4 * timeElapsed;
        yCenter = yCenter + yVel * timeElapsed;



        //Creates barrers for ship
        if(xCenter >= 100){
            xCenter = 99;
            xVel = 0;
        }
        if(yCenter>=100){
            yCenter = 99;
            yVel = 0;
        }
        if(xCenter <=0){
            xCenter = 1;
            xVel = 0;
        }
        if(yCenter <=0){
            yCenter = 1;
            yVel =0;
        }
    }

    public void rotate(double timeElapsed) {
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            theta = theta + thetaRate;
        }

        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            theta = theta - thetaRate;
        }
        xShipTip = xCenter + size * Math.cos(theta);
        yShipTip = yCenter + size * Math.sin(theta);
        xRightTip = xCenter + size * Math.cos(theta - Math.toRadians(150));
        yRightTip = yCenter + size * Math.sin(theta - Math.toRadians(150));
        xLeftTip = xCenter + size * Math.cos(theta + Math.toRadians(150));
        yLeftTip = yCenter + size * Math.sin(theta + Math.toRadians(150));
    }


    public void draw() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(xShipTip, yShipTip, xRightTip, yRightTip);
        StdDraw.line(xShipTip, yShipTip, xLeftTip, yLeftTip);
        //StdDraw.line(90,30,20,10);
        StdDraw.line(xLeftTip, yLeftTip, xRightTip, yRightTip);
    }

    public void fireBullet() {
        double bulletXVel = (xShipTip - xCenter)*10;
        double bulletYVel = (yShipTip - yCenter)*10;
        bullets.add(new Bullet(xShipTip, yShipTip, bulletXVel, bulletYVel));
    }

    public ArrayList<Bullet> getBullets(){

        return bullets;
    }

    //public ArrayList<Asteroid> getAsteroid(){
    ;
    // }
}