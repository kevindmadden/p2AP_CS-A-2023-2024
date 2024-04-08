package u08_Inheritance.Bouncy;

public class MovingPoint {

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    /*
        These values determine the relative location of the sides compared to the moving point.
        So topHitbox is the point at yPos+topHitbox, etc.
        These values then get used to determine when to bounce in the calculate method.
     */
    private double topHitbox = 1;
    private double bottomHitbox = 1;
    private double leftHitbox = 1;
    private double rightHitbox = 1;
    private boolean shouldBounce = false;
    public MovingPoint(double xPos, double yPos, double xVel, double yVel){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
    }

    //The values for the hitbox are changed if this version of the constructor is called.
    public MovingPoint(double xPos, double yPos, double xVel, double yVel, double rightHitbox, double leftHitbox, double topHitbox, double bottomHitbox){
        this(xPos, yPos, xVel, yVel);
        this.topHitbox = topHitbox;
        this.bottomHitbox = bottomHitbox;
        this.leftHitbox = leftHitbox;
        this.rightHitbox = rightHitbox;
    }

    public void activateBounce(){
        this.shouldBounce = true;
    }
    public void deactivateBounce(){
        this.shouldBounce = false;
    }

    public void calculate(double timeElapsed){
        xPos = xPos + xVel*timeElapsed;
        yPos = yPos + yVel*timeElapsed;
        if(shouldBounce){
            if(xPos+rightHitbox>100) xVel*=-1;
            if(xPos+leftHitbox<0) xVel*=-1;
            if(yPos+topHitbox>100) yVel*=-1;
            if(yPos+bottomHitbox<0) yVel*=-1;
        }
    }

    public void forceBounce(){
        xVel*=-1;
        yVel*=-1;
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(xPos, yPos, 1);
    }

    public double getXPos(){
        return xPos;
    }

    public double getYPos(){
        return yPos;
    }
}
