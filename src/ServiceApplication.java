public class ServiceApplication {
    private int ApplicationId;
    private Citizen citizen;
    private GovernmentServices services;
    private ApplicationStatus status;
    ServiceApplication(int ApplicationId,Citizen citizen,GovernmentServices services){
        this.ApplicationId=ApplicationId;
        this.citizen=citizen;
        this.services=services;
        this.status=ApplicationStatus.PENDING;
    }
    int getApplicationId(){

        return ApplicationId;
    }
    public Citizen getCitizen(){
        return citizen;
    }
    public GovernmentServices getServices(){
        return services;
    }
    public ApplicationStatus getStatus(){
        return status;
    }
    public void approve(){
        status=ApplicationStatus.APPROVED;
    }
    public void reject(){
        status=ApplicationStatus.REJECTED;
    }
    public void pend(){
        status=ApplicationStatus.PENDING;
    }
    void display(){
        System.out.println("Application ID :"+ApplicationId);
        System.out.println("Citizen Name is :"+citizen.getCitizenName());
        System.out.println("Service requested is :"+services.getServiceName());
        System.out.println("Status :"+status);
    }


    public void SETStatus(ApplicationStatus status) {
        this.status = status;
    }
}
