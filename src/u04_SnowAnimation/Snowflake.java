package u04_SnowAnimation;

public class Snowflake {


    private double xPos;
    private double yPos;
    private double yVel;
    private double size;

    private static int totalSnowflakeCount = 0;

    public Snowflake(){
        yPos = Math.random()*100+25;
        xPos = Math.random()*100;
        size = Math.random()*2+.5;
        yVel = Math.random()*50+20;
    }

    public void calculate(double timeElapsed){
        yPos = yPos - yVel*timeElapsed;
        if(yPos < 0){
            yPos = 110;
            totalSnowflakeCount++;
            //System.out.println(totalSnowflakeCount);
        }
    }

    public void draw(){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(xPos, yPos, size);
    }

    public static int getTotalSnowflakeCount(){
        return totalSnowflakeCount;
    }



}

