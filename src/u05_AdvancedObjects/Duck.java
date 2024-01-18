package u05_AdvancedObjects;

public class Duck {
    private boolean isAlive;
    private int numnberHonks;
    private String gender;
    int timesGetterMethodUsed;

    public Duck(String gender){
        isAlive = true;
        numnberHonks = 0;
        this.gender = gender;
    }

    public boolean getIsAlive(){
        timesGetterMethodUsed++;
        return isAlive;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public int getNumnberHonks() {
        return numnberHonks;
    }

    public String getGender() {
        return gender;
    }

    public void setNumnberHonks(int numnberHonks) {
        this.numnberHonks = numnberHonks;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
