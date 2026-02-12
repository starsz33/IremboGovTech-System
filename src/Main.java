public class Main {
    public static void main(String[] args) {
        Citizen citizen=new Citizen(101,"kalisa",120034,2003);
        Citizen citizen1=new Citizen(105,"Esther",120045,2004);
        GovernmentServices services=new BirthCertificateService();
        GovernmentServices services1=new DrivingTestService();

        ServiceApplication app1=new ServiceApplication(102,citizen,services);
        ServiceApplication app2=new ServiceApplication(104,citizen,services1);

        ServiceApplication app3=new ServiceApplication(102,citizen1,services);
        ServiceApplication app4=new ServiceApplication(104,citizen1,services1);
        System.out.println("before approval");
        app1.display();
        app2.display();

        app1.approve();
        app2.reject();

        System.out.println("After changing status ");
        app1.display();
        app2.display();
        ApplicationManager manager=new ApplicationManager();
        manager.loadFromFile("Applications.txt");
        try {
            manager.approveApplication(999);
        } catch (ApplicationNotFoundException e) {
            System.out.println(e.getMessage());
        }

        manager.addApplication(app1);
        manager.addApplication(app2);

        manager.displayAllApplications();

        System.out.println("\nAfter Approval:\n");

        manager.displayAllApplications();
        manager.saveToFile("Application.txt");

    }
}