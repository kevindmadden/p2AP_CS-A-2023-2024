package u08_Inheritance.Bouncy;

public class Rectangle extends MovingPoint{
    private double width;
    private double height;
    public Rectangle(double xPos, double yPos, double xVel, double yVel, double width, double height){
        super(xPos, yPos, xVel, yVel, width, -width, height, -height);
        this.width = width;
        this.height = height;
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledRectangle(super.getXPos(), super.getYPos(), width, height);
    }
}
