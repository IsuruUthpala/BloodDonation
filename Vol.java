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
public class Vol {

    private String VolunteerId;
    private String VolunteerName;

    private int Contact;
    private String Address;
    private String Area;
    private boolean Monday;
    private boolean Tuesday;
    private boolean Wednesday;
    private boolean Thursday;
    private boolean Friday;
    private boolean Saturday;
    private boolean Sunday;

    public Vol(String VolunteerId1, String VolunteerName1, int Contact1, String Address1,String Area1, boolean Monday1,
            boolean Tuesday1, boolean Wednesday1,
            boolean Thursday1, boolean Friday1, boolean Saturday1, boolean Sunday1) {
        this.VolunteerId = VolunteerId1;
        this.VolunteerName = VolunteerName1;
        this.Contact = Contact1;
        this.Address = Address1;
        this.Area=Area1;
        this.Monday = Monday1;
        this.Tuesday = Tuesday1;
        this.Wednesday = Wednesday1;
        this.Thursday = Thursday1;
        this.Friday = Friday1;
        this.Saturday = Saturday1;
        this.Sunday = Sunday1;
    }

    public String getVolunteerId() {
        return VolunteerId;
    }

    public String getVolunteerName() {
        return VolunteerName;
    }

    public int getContact() {
        return Contact;
    }

    public String getAddress() {
        return Address;
    }
    public String getArea(){
    return Area;
    }

    public boolean getMonday() {
        return Monday;
    }

    public boolean getTuesday() {
        return Tuesday;
    }

    public boolean getWednesday() {
        return Wednesday;
    }

    public boolean getThursday() {
        return Thursday;
    }

    public boolean getFriday() {
        return Friday;
    }

    public boolean getSaturday() {
        return Saturday;
    }

    public boolean getSunday() {
        return Sunday;
    }

}
