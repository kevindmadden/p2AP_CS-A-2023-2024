package u08_Inheritance.SuperChaining;

import java.awt.*;

public class Square extends Rectangle {

    private double xVel;
    private double yVel;

    public Square(double dim, double xPos, double yPos, Color fillColor, Color borderColor){
        super(dim, dim, xPos, yPos, fillColor, borderColor);
    }



    public void draw(){
        StdDraw.setPenColor(borderColor);
        StdDraw.filledRectangle(getxPos(), getyPos(), getWidth()+4, getHeight()+4);
        StdDraw.setPenColor(fillColor);
        StdDraw.filledRectangle(getxPos(), getyPos(), getWidth(), getHeight());
    }



}
