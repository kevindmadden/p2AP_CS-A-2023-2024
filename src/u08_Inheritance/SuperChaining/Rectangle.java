package u08_Inheritance.SuperChaining;

import java.awt.*;

public class Rectangle {
    private double height;
    private double width;

    private double xPos;
    private double yPos;
    Color fillColor;
    Color borderColor;

    public Rectangle(double width, double height, double xPos, double yPos, Color fillColor, Color borderColor){
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.fillColor = fillColor;
        this.borderColor = borderColor;

    }

    public Rectangle(){
        this.fillColor = StdDraw.BLACK;
        this.borderColor = StdDraw.GRAY;
        this.height = 20;
        this.width = 3;
        this.xPos = 50;
        this.yPos = 50;
    }



    public void draw(){
        StdDraw.setPenColor(borderColor);
        StdDraw.filledRectangle(xPos, yPos, width+2, height+2);
        StdDraw.setPenColor(fillColor);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

}
