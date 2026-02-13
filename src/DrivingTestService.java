public class DrivingTestService extends GovernmentServices{
    DrivingTestService(){
        super("Driving Licence",3500);
    }
    @Override
    public String getServiceType(){
        return "Driving Licence";
    }
    @Override
    public double getFee() {
        return 2500;
    }
}
