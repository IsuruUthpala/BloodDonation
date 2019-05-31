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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.smslib.AGateway;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.AGateway.Protocols;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Library;
import org.smslib.Message.MessageTypes;
import org.smslib.Service;
import org.smslib.crypto.AESKey;
import org.smslib.modem.SerialModemGateway;

public class ReadMessages {

    public void doIt() throws Exception {
        int smsize;
        // Define a list which will hold the read messages.
        List<InboundMessage> msgList;
        // Create the notification callback method for inbound & status report
        // messages.
        InboundNotification inboundNotification = new InboundNotification();
        // Create the notification callback method for inbound voice calls.
        CallNotification callNotification = new CallNotification();
        //Create the notification callback method for gateway statuses.
        GatewayStatusNotification statusNotification = new GatewayStatusNotification();
        OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
        try {
            System.out.println("Example: Read messages from a serial gsm modem.");
            System.out.println(Library.getLibraryDescription());
            System.out.println("Version: " + Library.getLibraryVersion());
            // Create the Gateway representing the serial GSM modem.
            SerialModemGateway gateway = new SerialModemGateway("modem.com4", "COM14", 115200, "Huawei", "E160");
            // Set the modem protocol to PDU (alternative is TEXT). PDU is the default, anyway...
            gateway.setProtocol(Protocols.PDU);
            // Do we want the Gateway to be used for Inbound messages?
            gateway.setInbound(true);
            // Do we want the Gateway to be used for Outbound messages?
            gateway.setOutbound(true);
            // Let SMSLib know which is the SIM PIN.
            gateway.setSimPin("0000");
            // Set up the notification methods.
            Service.getInstance().setInboundMessageNotification(inboundNotification);
            Service.getInstance().setCallNotification(callNotification);
            Service.getInstance().setGatewayStatusNotification(statusNotification);
            Service.getInstance().setOrphanedMessageNotification(orphanedMessageNotification);
            // Add the Gateway to the Service object.
            Service.getInstance().addGateway(gateway);
            // Similarly, you may define as many Gateway objects, representing
            // various GSM modems, add them in the Service object and control all of them.
            // Start! (i.e. connect to all defined Gateways)
            Service.getInstance().startService();
            // Printout some general information about the modem.
            System.out.println();
            System.out.println("Modem Information:");
            System.out.println("  Manufacturer: " + gateway.getManufacturer());
            System.out.println("  Model: " + gateway.getModel());
            System.out.println("  Serial No: " + gateway.getSerialNo());
            System.out.println("  SIM IMSI: " + gateway.getImsi());
            System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
            System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
            System.out.println();
            // In case you work with encrypted messages, its a good time to declare your keys.
            // Create a new AES Key with a known key value. 
            // Register it in KeyManager in order to keep it active. SMSLib will then automatically
            // encrypt / decrypt all messages send to / received from this number.
            Service.getInstance().getKeyManager().registerKey("+94713584818", new AESKey(new SecretKeySpec("0011223344556677".getBytes(), "AES")));
            // Read Messages. The reading is done via the Service object and
            // affects all Gateway objects defined. This can also be more directed to a specific
            // Gateway - look the JavaDocs for information on the Service method calls.
            msgList = new ArrayList<InboundMessage>();
            Service.getInstance().readMessages(msgList, MessageClasses.ALL);
            for (InboundMessage msg : msgList) {
                //ystem.out.println(msg);
                System.out.println(msg.getText());
               // System.out.println(msg.getOriginator());

            }
            smsize=msgList.size();
            // InboundMessage msg : msgList;
            //String msg1=InboundMessage.MessageClasses.READ.toString();
            //String msg1 = msgList.get(msgList.size() - 1).getText().toString();
           // System.out.println(msg1);
           
            java.util.Date oDate = new java.util.Date();
            DateFormat oDateFormat = new SimpleDateFormat("EE MMM dd yyyy");
//String date=oDate.toString();
       
            String dt = oDateFormat.format(oDate);
           
           
            Statement stmt = new DAC().getConnection().createStatement();
            String query1 = "SELECT * FROM feedback";
            ResultSet rs = stmt.executeQuery(query1);
           // int c = rs.getRow();
            int count = 0;

            while (rs.next()) {
                ++count;
                // Get data from the current row and use it
            }

            if (count == 0) {
                System.out.println("No records found");
            }
            int asize=msgList.size();
            int gap=asize-count;
            int gap2=count-asize;
           
            if(asize>count){
                
                for(int i=0;i<gap;i++){
                    String con=msgList.get(count).getOriginator().toString();
                  String msg2=  msgList.get(count).getText().toString();
                    System.out.println(msg2);
                //int x=count+1;
                  String query = "INSERT INTO feedback(MsgID,Contact,Message,Date)VALUES('" + count + "','"+con+"','" + msg2 + "','"+dt+"')";
            int a = stmt.executeUpdate(query);
                count++;
                
                
                
                }
                JOptionPane.showMessageDialog(null, "New sms received");
                
                
            
            
            }
            else if(asize>=1&&asize<count){
                //System.out.println("point 1");
                
                 for(int i=0;i<asize;i++){
                     //System.out.println("point 2");
                     String con=msgList.get(i).getOriginator().toString();
                  String msg2=  msgList.get(i).getText().toString();
                  // System.out.println("point 3");
                    // System.out.println(msg2);
                     //System.out.println("point 4");
                //int x=count+1;
                   String query = "INSERT INTO feedback(MsgID,Contact,Message,Date)VALUES('" + count + "','"+con+"','" + msg2 + "','"+dt+"')";
            int a = stmt.executeUpdate(query);
                count++;
                
                
                
                }
                 
                 for(int i=0;i<asize;i++){
                    InboundMessage msg= msgList.get(i);
                     gateway.deleteMessage(msg);
                 
                 
                 
                 }
                 
                 msgList.clear();
                // msgList.
                 
                 JOptionPane.showMessageDialog(null, "'"+smsize+"'new sms received");
                
                
                
            
            
            }
            else{
             JOptionPane.showMessageDialog(null, "No new messages to read");
            }

            //System.out.println(c);

            //String query = "INSERT INTO volunteer_feedback(VFeedbackID,VolunteerID,Message,Date,Contact,Type)VALUES('" + count + "','2','" + msg1 + "','datetest','12345','test')";
            //int a = stmt.executeUpdate(query);

// Sleep now. Emulate real world situation and give a chance to the notifications
            // methods to be called in the event of message or voice call reception.
            //System.out.println("Now Sleeping - Hit <enter> to stop service.");
             //msgList.clear();
           //  gateway.deleteMessage(msg);
             //InboundMessage msg;
             //AGateway bob;
            // bob.
            // ReadMessages.this.srv.deleteMessage(msg);
            Service.getInstance().stopService();
            // msgList.clear();
            Service.getInstance().removeGateway(gateway);
            //System.in.read();

            //Service.getInstance().readMessages(msgList, MessageClasses.ALL);
            //System.in.read();
        } catch (Exception e) {
             Service.getInstance().stopService();
            // msgList.clear();
           // Service.getInstance().removeGateway(gateway);
            
            e.printStackTrace();
            
        } finally {
            Service.getInstance().stopService();
        }
    }

    public class InboundNotification implements IInboundMessageNotification {

        public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg) {
            //if (msgType == MessageTypes.INBOUND) System.out.println(">>> New Inbound message detected from Gateway: " + gateway.getGatewayId());
            //else if (msgType == MessageTypes.STATUSREPORT) System.out.println(">>> New Inbound Status Report message detected from Gateway: " + gateway.getGatewayId());
            //System.out.println(msg.getText());
            // System.out.println(msg.getOriginator());
        }
    }

    public class CallNotification implements ICallNotification {

        public void process(AGateway gateway, String callerId) {
            System.out.println(">>> New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
        }
    }

    public class GatewayStatusNotification implements IGatewayStatusNotification {

        public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus) {
            System.out.println(">>> Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: " + newStatus);
        }
    }

    public class OrphanedMessageNotification implements IOrphanedMessageNotification {

        public boolean process(AGateway gateway, InboundMessage msg) {
            System.out.println(">>> Orphaned message part detected from " + gateway.getGatewayId());
            System.out.println(msg);
            // Since we are just testing, return FALSE and keep the orphaned message part.
            return false;
        }
    }

   // public static void main(String args[]) {
      //  ReadMessages app = new ReadMessages();
       // try {
         //   app.doIt();
      //  } catch (Exception e) {
         //   e.printStackTrace();
       // }
    //}
}
