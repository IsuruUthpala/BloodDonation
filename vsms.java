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
public class vsms {
    
    
    private String EmpName;
    private String VolunteerContact;
    private String Message;
    private String Date;

    public vsms(String EmpName1, String VolunteerContact1, String Message1,String Date1) {
        this.EmpName=EmpName1;
        this.VolunteerContact=VolunteerContact1;
        this.Message=Message1;
        this.Date=Date1;
     
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getVolunteerContact() {
        return VolunteerContact;
    }

    public String getMessage() {
        return Message;
    }

    public String getDate() {
        return Date;
    }

    
    
}
