package u08_Inheritance;

public class Person {

    private String name;
    private int birthdayYear;
    public Person(String name, int birthdayYear){
        this.name = name;
        this.birthdayYear = birthdayYear;
    }

    public String toString(){
        return name;
    }

}
