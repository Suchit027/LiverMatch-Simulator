import java.util.*;
import java.io.*;
import Hospitals.*;
import patient_data.*;
class Driver{
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String patient_name, hospital_name, blood_type;
    System.out.println("Enter the details of the patient");
    System.out.println("What is the name of the patient");
    patient_name = sc.nextLine();
    sc.nextChar();
    System.out.println("Enter the name of the hospital");
    hospital_name = sc.nextLine();
    sc.nextChar();
    System.out.println("Enter the required blood type");
    blood_type = sc.nextLine();
    sc.nextChar();
    Patient patient = new Patient(patient_name, hospital_name, blood_type);
    }
}
