package u05_AdvancedObjects;

public class Main {
    public static void main(String[] args){
        Duck duck1 = new Duck("female");
        System.out.println(duck1.getIsAlive());
        duck1.setIsAlive(false);
    }
}
