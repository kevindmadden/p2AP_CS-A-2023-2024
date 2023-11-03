package u03_Objects.s01_LotsOfBouncingRectangles;

import java.awt.*;

public class BouncingRectangle {
    double xPos;
    double yPos;
    double width;
    double height;
    double xVel;
    int R = 255;
    int G = 255;
    int B = 255;
    int alpha = 255;
    Color color = new Color(R, G, B, alpha);
    double randomOffset;

    public BouncingRectangle(double xPos, double yPos, double width, double height, double xVel){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.xVel = xVel;
        this.randomOffset = Math.random();
    }

    public void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(xPos, yPos, width, height);
    }

    public void calculate(double timeElapsed, double totalTimeElapsed){
        totalTimeElapsed=totalTimeElapsed+randomOffset;
        R = (int)(255*Math.abs(Math.sin(totalTimeElapsed)));
        G = (int)(255*Math.abs(Math.sin(totalTimeElapsed)));
        B = (int)(255*Math.abs(Math.sin(totalTimeElapsed)));
        color = new Color(R, G, B, alpha);
        xPos = xPos + xVel*timeElapsed;
        if(xPos+width > 100){
            xVel*=-1;
        }
        if(xPos-width < 0){
            xVel*=-1;
        }
    }


}
