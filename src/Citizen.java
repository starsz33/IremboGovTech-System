public class Citizen {
    private String citizenName;
    private String nationalId;

    public Citizen(String citizenName, String nationalId) {
        this.citizenName = citizenName;

        if (nationalId.length() == 16) {
            this.nationalId = nationalId;
        } else {
            System.out.println("National ID is not valid");
        }
    }

    public Citizen() {

    }

    String getCitizenName() {
        return citizenName;
    }

    void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    String getNationalId() {
        return nationalId;
    }

    void setNationalId(String nationalId) {
        if (nationalId.length() == 16) {
            this.nationalId = nationalId;
        } else {
            System.out.println("National ID is not valid");
        }
    }
    @Override
    public String toString() {
        return "{" +
                "Name:'" + citizenName+ '\'' +
                ", with the National ID:'" + nationalId + '\'' +
                '}';
    }
}

