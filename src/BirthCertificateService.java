public class BirthCertificateService extends GovernmentServices{
    public BirthCertificateService(){
        super("BirthCertificate",1500);
    }
    @Override
    public String getServiceType(){
        return "BirthCertificate";
    }
    @Override
    public double getFee() {
        return 1500;
    }

}
