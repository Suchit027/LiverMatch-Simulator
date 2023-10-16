package Liver;

public class Liver extends MedicalData {
  protected String BloodType; // Liver Blood Type
  protected String Hospital; // Hospital Name
  public void Liver() //Default Constructor
  {
    BloodType=" ";
    Hospital=" ";
  }
  public void Liver(String B, String H)
  {
    super(B);
    BloodType=B;
    Hospital=H;
  }
  //Returning BloodType
  public String getBloodType(){
    return Bloodtype;
}
  //Returning Hospital Name
  public String getHospital(){
    return Hospital;
  }
}
