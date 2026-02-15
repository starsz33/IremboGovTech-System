import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ApplicationManager manager = new ApplicationManager();

        manager.loadFromFile("Application.txt");

        boolean running = true;

        while (running) {

            System.out.println("\n===== GOVERNMENT SERVICE SYSTEM =====");
            System.out.println("1. Apply for Birth Certificate");
            System.out.println("2. Apply for Driving Test");
            System.out.println("3. Approve Application");
            System.out.println("4. Display Applications");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                case 2:

                    System.out.print("Enter Application ID: ");
                    int appId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Citizen Name: ");
                    String CitizenName = scanner.nextLine();

                    System.out.print("Enter National ID: ");
                    String nationalId = scanner.nextLine();

                    System.out.print("Enter Year of Birth: ");
                    int year = scanner.nextInt();

                    Citizen citizen = new Citizen(CitizenName, nationalId);

                    GovernmentServices service;

                    if (choice == 1) {
                        service = new BirthCertificateService();
                    } else {
                        service = new DrivingTestService();
                    }

                    ServiceApplication app =
                            new ServiceApplication(appId, citizen, service);

                    manager.addApplication(app);

                    break;

                case 3:

                    System.out.print("Enter Application ID to approve: ");
                    int approveId = scanner.nextInt();

                    try {
                        manager.approveApplication(approveId);
                    } catch (ApplicationNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    manager.displayAllApplications();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        manager.saveToFile("Application.txt");
        manager.generateRevenueReport("RevenueReport.txt");

        System.out.println("System closed. Data saved.");
    }
}
