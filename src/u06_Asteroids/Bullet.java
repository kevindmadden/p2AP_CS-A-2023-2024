package u06_Asteroids;

public class Bullet {
    double xPos;
    double yPos;
    double xVel;
    double yVel;
    double radius;
    double timePassed;
    public Bullet(double xShipTip, double yShipTip, double xShipCenter, double yShipCenter){
        double rate = 15;
        this.xPos = xShipTip;
        this.yPos = yShipTip;
        this.xVel = (xShipTip-xShipCenter)*rate;
        this.yVel = (yShipTip-yShipCenter)*rate;
        this.radius = .3;
        timePassed = 0;
    }

    public void calculate(double timeElapsed){
        xPos = xPos + xVel*timeElapsed;
        yPos = yPos + yVel*timeElapsed;
        timePassed = timePassed + timeElapsed;
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
    }

    public boolean shouldDelete(){
        if(timePassed > 2){
            return true;
        }
        return false;
    }

    public void draw(){
        StdDraw.filledCircle(xPos,yPos,radius);
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public double getRadius() {
        return radius;
    }


}
