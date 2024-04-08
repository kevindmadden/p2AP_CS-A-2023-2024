package u06_Asteroids;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        StdDraw.enableDoubleBuffering(); //Calling this method stops things from being drawn immediately after a draw method is called. This allows you to call many different draw methods without anything being drawn on the screen; when you call StdDraw.show(), everything will be drawn at once.

        Ship ship = new Ship();
        ArrayList<Bullet> bullets = new ArrayList<>();
        ArrayList<Asteroid> asteroids = new ArrayList<>();
        asteroids.add(new Asteroid(5, 80,80));
        asteroids.add(new Asteroid(5, 20,20));
        asteroids.add(new Asteroid(5,20,80));
        //asteroids.add(new Asteroid(5));
        boolean isGameOver = false;
        int bulletCooldown = 10;
        int bulletTimer = bulletCooldown+1;


        double timeElapsed = 0.017; //0.017 seconds-- this is how long each frame of our animation appears.
        while (!isGameOver) {
            //---------Control--------
            if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                bulletTimer++;
                if(bullets.size() <= 7 && bulletTimer>bulletCooldown){
                    bullets.add(new Bullet(ship.getXShipTip(),ship.getYShipTip(),ship.getxCenter(), ship.getyCenter()));
                    bulletTimer = 0;
                }
            }

            if(StdDraw.isKeyPressed(KeyEvent.VK_A)){
                ship.rotate(true, false);
            }
            if(StdDraw.isKeyPressed(KeyEvent.VK_D)){
                ship.rotate(false, true);
            }

            if(StdDraw.isKeyPressed((KeyEvent.VK_W))){
                ship.accelerate();
            }else{
                ship.stopAccelerate();
            }

            for(int i=0; i<bullets.size(); i++){
                if(bullets.get(i).shouldDelete()){
                    bullets.remove(bullets.get(i));
                    i--;
                }
            }

            //---------Calculate------
            ship.calculate(timeElapsed);
            for(Bullet bullet : bullets){
                bullet.calculate(timeElapsed);
            }
            for(Asteroid asteroid : asteroids){
                asteroid.calculate(timeElapsed);
            }
            //Remove asteroids and bullet
            for(int i=0; i<bullets.size(); i++){
                Bullet bullet = bullets.get(i);
                for(int j = 0; j<asteroids.size(); j++){
                    Asteroid asteroid = asteroids.get(j);
                    if(isCircleInCircle(bullet.getXPos(),bullet.getYPos(), bullet.getRadius(),asteroid.getXPos(),asteroid.getYPos(),asteroid.getRadius())){
                        if(i<0) break;
                        bullets.remove(i);
                        i--;
                        if(asteroids.get(j).getRadius()==5){
                            asteroids.add(new Asteroid(2, asteroids.get(j)));
                            asteroids.add(new Asteroid(2, asteroids.get(j)));
                            asteroids.add(new Asteroid(5));
                        }
                        asteroids.remove(j);
                        j--;
                    }
                }
            }

            for(int i = 0; i < asteroids.size(); i++){
                Asteroid asteroid = asteroids.get(i);
                double[] shipHitbox = ship.getHitbox();
                double[] shipHitbox2 = ship.getHitbox2();
                if (isCircleInCircle(asteroid.getXPos(), asteroid.getYPos(), asteroid.getRadius(), shipHitbox[0], shipHitbox[1], shipHitbox[2]) || (isCircleInCircle(asteroid.getXPos(), asteroid.getYPos(), asteroid.getRadius(), shipHitbox2[0], shipHitbox2[1], shipHitbox2[2]))){
                    ship.isHit();
                    if(ship.getHealth()==0){
                        isGameOver = true;
                    }
                }
            }


            //----------DRAW--------
            StdDraw.text(10,95,"Health: "+ship.getHealth());
            for(Bullet bullet : bullets){
                bullet.draw();
            }
            for(Asteroid asteroid : asteroids){
                asteroid.draw();
            }
            ship.draw();


            StdDraw.show(); //Because we have called StdDraw.enableDoubleBuffering(), everything that you draw up until this point will be loaded into java's memory but not actually drawn. Calling StdDraw.draw() then draws everything at once that is loaded into java's memory.
            StdDraw.pause((int) (timeElapsed * 1000)); //You must pass to the pause method the number of milliseconds to pause for; so we multiply by 1000 because our timeElapsed variable is in seconds, not milliseconds.
            StdDraw.clear(); //This clears everything drawn on the screen. You must redraw the image you wish to display for each frame of an animation
        }
        StdDraw.text(50,50,"Game Over");
        StdDraw.show();
        StdDraw.clear();

    }

    public static boolean isPointInRectangle(double xPoint, double yPoint, double xRect, double yRect, double halfWidth, double halfHeight){
        boolean isBetweenRightAndLeftEdge = xPoint > (xRect-halfWidth) && xPoint< (xRect+halfWidth);
        //boolean isBetweenTopAndBottomEdge = yPoint > (yRect-halfHeight) && yPoint < (yRect+halfHeight); //either true or false
        double bottomEdgeOfRect = yRect-halfHeight;
        boolean isPointAboveBottomEdge = yPoint > bottomEdgeOfRect;
        double topEdgeOfRectangle = yRect + halfHeight;
        boolean isPointBelowTopEdge = yPoint < topEdgeOfRectangle;
        boolean isBetweenTopAndBottomEdge = isPointAboveBottomEdge && isPointBelowTopEdge;

        if(isBetweenRightAndLeftEdge && isBetweenTopAndBottomEdge){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isPointInCircle(double xPoint, double yPoint, double xCircle, double yCircle, double radius){
        double distance = Math.sqrt( Math.pow(xPoint-xCircle, 2) + Math.pow(yPoint-yCircle, 2) );
        boolean isDistanceLessThanRadius = distance < radius;
        return isDistanceLessThanRadius;
    }

    public static boolean isCircleInCircle(double xPos1, double yPos1, double radius1, double xPos2, double yPos2, double radius2){
        double distanceBetweenCircles = Math.sqrt(Math.pow(yPos1-yPos2,2)+Math.pow(xPos1-xPos2,2));
        if(distanceBetweenCircles < radius1+radius2){
            return true;
        }
        return false;
    }
}