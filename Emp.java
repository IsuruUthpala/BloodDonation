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
public class Emp {
    private String EmpId;
    private String EmpName;
    private String username;
    private String Password;
    private String Address;
    private int    Contact;
    private String Emptype;
    private int Activated;
    
    

 public Emp(String EmpId1,String EmpName1,String username1,String Password1,
    String Address1 ,int Contact1 ,String Emptype1,int Activated1 )
    {
        this.EmpId = EmpId1;
        this.EmpName = EmpName1;
        this.username = username1;
        this.Password = Password1;
        this.Address = Address1;
        this.Contact = Contact1;
        this.Emptype = Emptype1;
        this.Activated = Activated1;
        
        
    }

    public String getEmpId() {
        return EmpId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getusername() {
        return username;
    }
    public String getPassword() {
        return Password;
    }
    public String getAddress() {
        return Address;
    }
public int getContact() {
        return Contact;
    }
public String getEmptype() {
        return Emptype;
    }

public int getActivated() {
        return Activated;
    }


}
