public class Main {

    public static void main(String[] args) {

        ApplicationManager manager = new ApplicationManager();

        // Load existing data (if file exists)
        manager.loadFromFile("Application.txt");

        // Create citizens
        Citizen citizen = new Citizen(101, "kalisa", 120034, 2003);
        Citizen citizen1 = new Citizen(102, "Esther", 120045, 2004);

        // Create services
        GovernmentServices birthService = new BirthCertificateService();
        GovernmentServices drivingService = new DrivingTestService();

        // Create applications
        ServiceApplication app1 = new ServiceApplication(101, citizen, birthService);
        ServiceApplication app2 = new ServiceApplication(102, citizen, drivingService);
        ServiceApplication app3 = new ServiceApplication(103, citizen1, birthService);

        // Add applications to manager
        manager.addApplication(app1);
        manager.addApplication(app2);
        manager.addApplication(app3);

        // Approve some applications USING MANAGER
        try {
            manager.approveApplication(101);
            manager.approveApplication(103);
        } catch (ApplicationNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Display clean output
        System.out.println("\n===== CURRENT APPLICATIONS =====\n");
        manager.displayAllApplications();

        // Save applications
        manager.saveToFile("Application.txt");

        // Generate revenue report
        manager.generateRevenueReport("RevenueReport.txt");
    }
}
