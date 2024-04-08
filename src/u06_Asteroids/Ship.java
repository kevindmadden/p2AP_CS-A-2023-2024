package u06_Asteroids;

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
    private boolean isHit;

    public double getxCenter() {
        return xCenter;
    }

    public double getyCenter() {
        return yCenter;
    }

    private double yCenter;
    private double xShipTip;

    private double yShipTip;
    private double xRightTip;
    private double yRightTip;
    private double xLeftTip;
    private double yLeftTip;
    private double xBoostLeftTip;
    private double yBoostLeftTip;
    private double xBoostRightTip;
    private double yBoostRightTip;
    private double yBoostEndTip;
    private double xBoostEndTip;
    private double theta;
    private double thetaRate;
    private double size;
    private double slope;
    private double xVel;
    private double yVel;
    private int health;




    private double xAcceleration;
    private double yAcceleration;
    private boolean shouldMoveForward;
    private double[] hitbox;
    private double[] hitbox2;

    public Ship(){
        spawnShip();
        health = 3;
    }

    private void spawnShip(){
        this.xCenter = 50;
        this.yCenter = 50;
        this.theta = Math.PI*.5;
        this.thetaRate = .1;
        this.xAcceleration = 0;
        this.yAcceleration = 0;
        this.size = 3;
        this.xVel = 0;
        this.yVel = 0;
        this.isHit = false;
        updateHitbox();
        updateHitbox2();
    }

    public void updateHitbox(){
        //StdDraw.circle(,,2);
        hitbox= new double[] {
                xCenter+(xCenter-xShipTip)*.3,
                yCenter+(yCenter-yShipTip)*.3,
                1
        };

        hitbox2= new double[] {
                xCenter+(xCenter-xShipTip)*-.4,
                yCenter+(yCenter-yShipTip)*-.4,
                .5
        };

    }

    private void updateHitbox2(){
        //StdDraw.circle(,,2);
        hitbox= new double[] {
                xCenter+(xCenter-xShipTip)*.3,
                yCenter+(yCenter-yShipTip)*.3,
                1
        };
    }

    public void calculate(double timeElapsed){
        xVel = xVel + xAcceleration*(xShipTip-xCenter)*timeElapsed*timeElapsed;
        yVel = yVel + yAcceleration*(yShipTip-yCenter)*timeElapsed*timeElapsed;
        xCenter = xCenter + xVel*timeElapsed;
        yCenter = yCenter + yVel*timeElapsed;

        xShipTip = xCenter + size*Math.cos(theta);
        yShipTip = yCenter + size*Math.sin(theta);
        xRightTip = xCenter + size*Math.cos(theta-Math.toRadians(150));
        yRightTip = yCenter + size*Math.sin(theta-Math.toRadians(150));
        xLeftTip = xCenter + size*Math.cos(theta+Math.toRadians(150));
        yLeftTip = yCenter + size*Math.sin(theta+Math.toRadians(150));
        xBoostRightTip = xCenter + (size-1)*Math.cos(theta-Math.toRadians(165));
        yBoostRightTip = yCenter + (size-1)*Math.sin(theta-Math.toRadians(165));
        xBoostLeftTip = xCenter + (size-1)*Math.cos(theta+Math.toRadians(165));
        yBoostLeftTip = yCenter + (size-1)*Math.sin(theta+Math.toRadians(165));
        xBoostEndTip = xCenter + (size+2)*Math.cos(theta+Math.toRadians(180));
        yBoostEndTip = yCenter + (size+2)*Math.sin(theta+Math.toRadians(180));

        if(xCenter > 105) xCenter = -5;
        if(yCenter > 105) yCenter = -5;
        if(xCenter <-6) xCenter = 104;
        if(yCenter < -6) yCenter = 104;
        updateHitbox();
        updateHitbox2();
    }

    public void accelerate(){
        xAcceleration = 500;
        yAcceleration = 500;
    }

    public void stopAccelerate(){
        xAcceleration = 0;
        yAcceleration = 0;
    }

    public void rotate(boolean rotateLeft, boolean rotateRight){
        if(rotateLeft){
            theta = theta + thetaRate;
        }

        if(rotateRight){
            theta = theta - thetaRate;
        }
    }

    private double hitboxTopXPos = xCenter+(xCenter-xShipTip)*-.3;
    private double getHitboxTopYPos = yCenter+(yCenter-yShipTip)*-.3;
    private double getHitboxTopRadius = .75;
    public void draw(){
        StdDraw.line(xShipTip, yShipTip, xRightTip, yRightTip);
        StdDraw.line(xShipTip, yShipTip, xLeftTip, yLeftTip);
        if(xAcceleration != 0 || yAcceleration !=0){
            StdDraw.line(xBoostLeftTip, yBoostLeftTip, xBoostEndTip, yBoostEndTip);
            StdDraw.line(xBoostRightTip, yBoostRightTip, xBoostEndTip, yBoostEndTip);
            StdDraw.line(xBoostLeftTip, yBoostLeftTip, xBoostRightTip, yBoostRightTip); // draws boost parallel to ship end line
        }

        //StdDraw.circle(hitbox[0], hitbox[1], hitbox[2]); //draw hitbox
        //StdDraw.circle(hitbox2[0], hitbox2[1], hitbox2[2]); //draw hitbox


    }

    public void isHit(){
        health--;
        System.out.println(health);
        spawnShip();
    }
    public double[] getHitbox(){
        return hitbox;
    }

    public double[] getHitbox2(){
        return hitbox2;
    }

    public double getXShipTip() {
        return xShipTip;
    }

    public double getYShipTip() {
        return yShipTip;
    }

    public int getHealth(){
        return health;
    }
}
