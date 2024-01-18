package u06_Asteroids;

import java.awt.event.KeyEvent;

public class Ship {

    private double x1Line;
    private double y1Line;
    private double x2Line;
    private double y2Line;
    private double theta;
    private double thetaRate;

    public Ship(double x1,double y1,double x2,double y2){
        x1Line=x1;
        x2Line=x2;
        y1Line=y1;
        y2Line=y2;
        theta= 0;
        thetaRate =0;
    }

    public void calculate(double timeElapsed){
        rotate(timeElapsed);
    }

    public void rotate(double timeElapsed){
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            thetaRate = 100.0/Math.PI;
        }
        theta = theta +thetaRate;

        //radians per second

        x2Line = 50*Math.cos(theta);
        System.out.println(x2Line);
        y2Line = 50*Math.sin(theta);

    }

    public void draw(){
        StdDraw.line(x1Line, y1Line, x2Line, y2Line);
    }
}
