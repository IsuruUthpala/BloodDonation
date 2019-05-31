/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Isuru
 */
public class Don {

    private String DonorId;
    private String DonorName;
    private String Gender;
    private int Contact;
    private String Address;
    private String BloodGroup;
    private double weight;
    private String DOB;
    private String LDD;
    private String Area;
    private int Age;

    public Don(String DonorId1,  String DonorName1, String Gender1, int Contact1,
    String Address1, String BloodGroup1, double weight1,String DOB1,  String LDD1,  String Area1, int Age1  )
    {
        this.DonorId = DonorId1;
        this.DonorName = DonorName1;
        this.Gender=Gender1;
        this.Contact=Contact1;
        this.Address=Address1;
        this.BloodGroup=BloodGroup1;
        this.weight=weight1;
        this.DOB=DOB1;
        this.LDD=LDD1;
        this.Area=Area1;
        this.Age = Age1;
    }

    public String getDonorId() {
        return DonorId;
    }

    public String getDonorName() {
        return DonorName;
    }

    public String getGender() {
        return Gender;
    }
    public int getContact() {
        return Contact;
    }
    public String getAddress() {
        return Address;
    }
    public String getBloodGroup() {
        return BloodGroup;
    }
    public double getweight() {
        return weight;
    }
    public String getDOB() {
        return DOB;
    }
    public String getLDD() {
        return LDD;
    }

   public String getArea() {
        return Area;
    }
    public int getAge() {
        return Age;
    }
    
    
    
    

}
