import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class ApplicationManager {

    // Map: Key = Application ID, Value = ServiceApplication object
    private Map<Integer, ServiceApplication> applications;

    // Constructor
    public ApplicationManager() {
        applications = new HashMap<>();
    }

    // Add new application
    public void addApplication(ServiceApplication app) {

        int id = app.getApplicationId();

        // Check if ID already exists
        if (applications.containsKey(id)) {
            System.out.println("Application with ID " + id + " already exists!");
        } else {
            applications.put(id, app);
            System.out.println("Application added successfully.");
        }
    }

    // Find application by ID
    public ServiceApplication findApplicationById(int id) {
        return applications.get(id); // returns null if not found
    }

    // Approve application
    public void approveApplication(int id) throws ApplicationNotFoundException {

        ServiceApplication app = applications.get(id);

        if (app == null) {
            throw new ApplicationNotFoundException("Application with ID " + id + " not found.");
        }

        app.approve();
    }


    // Reject application
    public void rejectApplication(int id) {
        ServiceApplication app = applications.get(id);

        if (app != null) {
            app.reject();
            System.out.println("Application rejected.");
        } else {
            System.out.println("Application not found.");
        }
    }

    // Display one application
    public void displayApplication(int id) {
        ServiceApplication app = applications.get(id);

        if (app != null) {
            app.display();
        } else {
            System.out.println("Application not found.");
        }
    }

    // Display all applications
    public void displayAllApplications() {

        if (applications.isEmpty()) {
            System.out.println("No applications available.");
            return;
        }

        for (ServiceApplication app : applications.values()) {
            app.display();
            System.out.println("-----------------------");
        }
    }
    public void saveToFile(String filename) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (ServiceApplication app : applications.values()) {

                writer.println(
                        app.getApplicationId() + "," +
                                app.getCitizen().getCitizenName() + "," +
                                app.getServices().getServiceName() + "," +
                                app.getStatus());
            }

            System.out.println("Applications saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    public void loadFromFile(String filename) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String citizenName = parts[1];
                String serviceName = parts[2];
                ApplicationStatus status = ApplicationStatus.valueOf(parts[3]);

                Citizen citizen = new Citizen(1,"Uwimana", 12007,2007);

                GovernmentServices service;

                if (serviceName.equals("Birth Certificate")) {
                    service = new BirthCertificateService();
                } else {
                    service = new DrivingTestService();
                }

                ServiceApplication app = new ServiceApplication(id, citizen, service);
                app.SETStatus(status);  // we must create this method

                applications.put(id, app);
            }

            System.out.println("Applications loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }



}
