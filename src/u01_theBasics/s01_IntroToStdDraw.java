package u01_theBasics;

public class s01_IntroToStdDraw {
    public static void main(String[] args) {
        StdDraw.setScale(0,100);


                //method     param
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(56, 255, 255); //neon blue
        StdDraw.line(0, 0, 100, 100);
        StdDraw.circle(50,50,20);
        String word = "hello world";
        StdDraw.text(50,50,word); //equivalent to StdDraw.text(50,50,"hello world");

    }
}