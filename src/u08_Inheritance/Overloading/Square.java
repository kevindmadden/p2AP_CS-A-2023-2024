package u08_Inheritance.Overloading;

import java.awt.*;

public class Square extends Rectangle{

    public Square(double dim, double xPos, double yPos){
        super(dim, dim, xPos, yPos);
    }

    public void draw(Color color, Color borderColor){
        StdDraw.setPenColor(borderColor);
        StdDraw.filledRectangle(xPos, yPos, width+4, height+4);
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }



}
