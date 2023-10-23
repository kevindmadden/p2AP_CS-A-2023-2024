package u02_LoopsAndArrays;

public class s01_introToLoops {
    public static void main(String[] args){

        //print out 1, 2, 3, ..., 10

        int num = 1;
        while(num <= 10){
            System.out.print(num+" ");
            num++;
        }


        // 1. creates num2
        // 2. it checks that the condition num2<=10
        // 3. runs the code in between the braces of the for-loop
        // 4. num2++ gets run
        // 5. Repeats steps 2-4
        for(int num2 = 1; num2<=10; num2++){
            System.out.print(num2+" ");
        }

    }
}
