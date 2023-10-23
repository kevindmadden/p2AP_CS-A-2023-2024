package u02_LoopsAndArrays;

public class s02_introToArrays {
    public static void main(String args[]){
        //                     0,       1,       2,         3
        String[] colors = {"red", "green", "orange", "yellow"};
        System.out.println(colors[2]); //prints orange
        System.out.println(colors[1]); //prints green

        //Does same thing as above
        String[] colors2 = new String[4]; //create an empty array with 4 elements
        colors[0] = "red";
        colors[1] = "green";
        colors[2] = "orange";
        colors[3] = "yellow";
        System.out.println(colors2[2]); //prints orange
        System.out.println(colors2[1]); //prints green



    }
}
