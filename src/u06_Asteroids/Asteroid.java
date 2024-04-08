package u06_Asteroids;

public class Asteroid {
    private double radius;
    private double xPos;

    private double yPos;
    private double xVel;
    private double yVel;

    public Asteroid(double radius, double xPos, double yPos){
        this.radius = radius;
        this.xPos = xPos;
        this.yPos = yPos;
        xVel = Math.random()*40-20;
        yVel = Math.random()*40-20;
    }
    public Asteroid(double radius){
        this(radius, Math.random()*60+20, Math.random()*60+20);
    }

    public Asteroid(double radius, Asteroid largeAsteroid){
        this.radius = radius;
        xVel = Math.random()*40-20;
        yVel = Math.random()*40-20;
        this.xPos = largeAsteroid.getXPos()+Math.random()*8-4;
        this.yPos = largeAsteroid.getYPos()+Math.random()*8-4;;
    }

    public void calculate(double timeElapsed){
        if(xPos>106){
            xPos=-6;
        }
        if(yPos > 106){
            yPos=-6;
        }
        if(xPos<-7){
            xPos=106;
        }
        if(yPos <-7){
            yPos = 105;
        }
        xPos = xPos + xVel*timeElapsed;
        yPos = yPos + yVel*timeElapsed;

    }

    public void draw(){
        StdDraw.circle(xPos, yPos, radius);
    }

    public double getRadius() {
        return radius;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

}
