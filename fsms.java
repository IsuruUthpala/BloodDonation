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
public class fsms {
    
    
   private int MsgID;
    private String Contact;
    private String Message;
    private String Date;

    public fsms( int MsgID1,String Contact1, String Message1,String Date1) {
     this.MsgID=MsgID1;
        this.Contact=Contact1;
        this.Message=Message1;
        this.Date=Date1;
     
    }
    public int getID() {
        return MsgID;
    }

   

    public String getContact() {
        return Contact;
    }

    public String getMessage() {
        return Message;
    }

    public String getDate() {
        return Date;
    }

   

    
    
    
    
    
}
