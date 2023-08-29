package u01_theBasics;

public class s03_MathRandom {
    public static void main(String[] args){
        double rand = Math.random(); //Math.random() is "returning" a value
        System.out.println(rand);
        double extendRand = rand*10; //# between [0,10)
        int extendRandInt = (int)extendRand;
        System.out.println(extendRand);
        System.out.println(extendRandInt);
        int extendRandInt10and20 = extendRandInt + 10; //# between [10,20)

        // + - * / %
        int num = 54;
        double raiseToThirdPower = Math.pow(num, 3);
        System.out.println(raiseToThirdPower);



    }
}
