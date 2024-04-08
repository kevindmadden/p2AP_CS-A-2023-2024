package u08_Inheritance.Bouncy;

public class Triangle extends MovingPoint{

    //The below coordinates on the unit circle are at -45deg, -135deg, 90deg.
    private double x1 = 0;
    private double y1 = 1;
    private double x2 = -1*Math.sqrt(2)/2.0;
    private double y2 = -1*Math.sqrt(2)/2.0;
    private double x3 = Math.sqrt(2)/2.0;
    private double y3 = -Math.sqrt(2)/2.0;

    private final double size; //The coordinates on the unit circle are scaled by the constant multiplier, *size*
    public Triangle(double xPos, double yPos, double xVel, double yVel, double size){
        super(xPos,yPos,xVel,yVel,Math.sqrt(2)/2.0*size, -1*Math.sqrt(2)/2.0*size, size, -1*Math.sqrt(2)/2.0*size);
        this.size = size;
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.RED);
        double x1 = super.getXPos();
        double y1 = super.getYPos()+size;
        double x2 = super.getXPos()-Math.sqrt(2)/2.0*size;
        double y2 = super.getYPos()-Math.sqrt(2)/2.0*size;
        double x3 = super.getXPos()+Math.sqrt(2)/2.0*size;
        double y3 = super.getYPos()-Math.sqrt(2)/2.0*size;
        double[] x = {x1,x2,x3};
        double[] y = {y1,y2,y3};

        StdDraw.polygon(x,y); //Draw polygon using two arrays of x,y points. See StdDraw documentation for more details.
    }

}
