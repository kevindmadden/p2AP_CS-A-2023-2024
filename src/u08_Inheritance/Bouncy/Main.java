package u08_Inheritance.Bouncy;
import java.util.ArrayList;

/*
    Before you attempt to answer the below questions, you should read through all classes line-by-line and attempt to understand how this code works. Then use the below questions as a means to extend your understanding of the code, pun-intended.
    1. Why does point2 bounce in an invisible box?
    2. Create another rectangle object in the main method with different properties that bounces correctly.
    3. Use vocabulary from the textbook to explain why rect (Rectangle object) and triangle (Triangle object) can be stored in bouncyObjects (ArrayList of MovingPoint objects).
    4. What happens if you flip the order of lines 15 and 16 in the Triangle Class? Why do you think Oracle (the company that owns java) decided to make java throw an error when this happens?
    5. Why does the Rectangle class need to call super.getXPos()? What happens when a child class calls super.someMethod()? Does calling a method such as super.getXPos() matter like the order of the super call in constructors?
    6. Write a completely new (and working) Circle class that extends the MovingPoint class.
    7. What are some pros and cons of using inheritance in order to create bouncing shapes?
    8. Write a Square class that inherits from the Rectangle class. What are the pros and cons of implementing this?
    9. Is there a way you could rework the triangle class so that it inherits from the Rectangle class? What would be the pros and cons of this?
 */
public class Main {
    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        ArrayList<MovingPoint> bouncyObjects = new ArrayList<>();

        MovingPoint point = new MovingPoint(50,50,80,70);
        bouncyObjects.add(point);
        MovingPoint point2 = new MovingPoint(50, 60, 70, 90, 30, -30, 30, -30);
        bouncyObjects.add(point2);
        Rectangle rect = new Rectangle(20, 20, 90,65, 10, 5);
        bouncyObjects.add(rect);
        Triangle triangle = new Triangle(80,80,45,50,5);
        bouncyObjects.add(triangle);

        for(MovingPoint obj : bouncyObjects){
            obj.activateBounce();
        }

        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (true) {

            for(MovingPoint obj : bouncyObjects){
                obj.calculate(timeElapsed);
            }

            for(MovingPoint obj : bouncyObjects){
                obj.draw();
            }

            StdDraw.show(); //Because we have called StdDraw.enableDoubleBuffering(), everything that you draw up until this point will be loaded into java's memory but not actually drawn. Calling StdDraw.draw() then draws everything at once that is loaded into java's memory.
            StdDraw.pause((int) (timeElapsed * 1000)); //You must pass to the pause method the number of milliseconds to pause for; so we multiply by 1000 because our timeElapsed variable is in seconds, not milliseconds.
            StdDraw.clear(); //This clears everything drawn on the screen. You must redraw the image you wish to display for each frame of an animation
        }
    }
}