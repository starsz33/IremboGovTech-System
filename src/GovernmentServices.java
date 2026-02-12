public abstract class GovernmentServices {
private String serviceName;
private double serviceFee;
public GovernmentServices(String serviceName,double serviceFee){
    this.serviceName=serviceName;
    this.serviceFee=serviceFee;
}
String getServiceName(){
    return serviceName;
}
double getServiceFee(){
    return serviceFee;
}
public abstract String getServiceType();
}
