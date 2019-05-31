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
public class dsms {

    private String EmpName;
    private String DonorContact;
    private String Message;
    private String Date;

    public dsms(String EmpName1, String DonorContact1, String Message1,String Date1) {
        this.EmpName=EmpName1;
        this.DonorContact=DonorContact1;
        this.Message=Message1;
        this.Date=Date1;
     
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getDonorContact() {
        return DonorContact;
    }

    public String getMessage() {
        return Message;
    }

    public String getDate() {
        return Date;
    }

   

   

}
