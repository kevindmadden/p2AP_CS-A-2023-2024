package u08_Inheritance.Overloading;

import java.awt.*;

public class Rectangle {
    protected double height;
    protected double width;
    protected double xPos;
    protected double yPos;

    public Rectangle(double width, double height, double xPos, double yPos){
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Rectangle(){
        this.height = 20;
        this.width = 3;
        this.xPos = 50;
        this.yPos = 50;
    }

    public void draw(Color color, Color borderColor){
        StdDraw.setPenColor(borderColor);
        StdDraw.filledRectangle(xPos, yPos, width+2, height+2);
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }

    public void draw(Color color){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(xPos, yPos, width+2, height+2);
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(xPos, yPos, width+2, height+2);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }

}
