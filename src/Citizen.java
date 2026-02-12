public class Citizen {
    private int citizenId;
    private String citizenName;
    private int nationalId;
    private int birthyear;
    Citizen(int citizenId,String citizenName,int nationalId,int birthyear)
    {
        this.citizenId=citizenId;
        this.citizenName=citizenName;
        this.nationalId=nationalId;
        this.birthyear=birthyear;
    }
    int getCitizenId(){
        return citizenId;
    }
    String getCitizenName(){
        return citizenName;
    }
    int getNationalId(){
        return nationalId;
    }
    int getYear(){
        return birthyear;
    }
}
