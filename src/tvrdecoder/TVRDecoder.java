
package tvrdecoder;


import java.util.Scanner;


/**
 *
 * @author jeyhun.alakbarov
 */
public class TVRDecoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter TVR: ");
        
        Scanner in = new Scanner(System.in);
        
        String TVR = in.nextLine();
        
        while(TVR.length() != 10 ) {
            System.out.println("Incorrect value for TVR!");
            System.out.print("Enter TVR: ");
            TVR = in.nextLine();
        }
         
        String byte1 = String.format("%8s", Integer.toBinaryString(Integer.parseInt(TVR.substring(0, 2), 16))).replace(' ', '0');
        String byte2 = String.format("%8s", Integer.toBinaryString(Integer.parseInt(TVR.substring(2, 4), 16))).replace(' ', '0');
        String byte3 = String.format("%8s", Integer.toBinaryString(Integer.parseInt(TVR.substring(4, 6), 16))).replace(' ', '0');
        String byte4 = String.format("%8s", Integer.toBinaryString(Integer.parseInt(TVR.substring(6, 8), 16))).replace(' ', '0');
        String byte5 = String.format("%8s", Integer.toBinaryString(Integer.parseInt(TVR.substring(8), 16))).replace(' ', '0');


        System.out.println("======   Result for TVR <" + TVR + ">   ======");
        if (byte1.charAt(0) == '1') printer("Offline data processing was not performed");
        if (byte1.charAt(1) == '1') printer("SDA failed");
        if (byte1.charAt(2) == '1') printer("ICC data missing");
        if (byte1.charAt(3) == '1') printer("Card number appears on hotlist");
        if (byte1.charAt(4) == '1') printer("DDA failed");
        if (byte1.charAt(5) == '1') printer("CDA failed");
        if (byte1.charAt(6) == '1') printer("SDA selected");
        //if (byte1.charAt(7) == '1') System.out.println("");
        
        if (byte2.charAt(0) == '1') printer("Card and terminal have different application versions");
        if (byte2.charAt(1) == '1') printer("Expired application");
        if (byte2.charAt(2) == '1') printer("Application not yet effective");
        if (byte2.charAt(3) == '1') printer("Requested service not allowed for card product");
        if (byte2.charAt(4) == '1') printer("New card");
        //if (byte2.charAt(5) == '1') System.out.println("");
        //if (byte2.charAt(6) == '1') System.out.println("");
        //if (byte2.charAt(7) == '1') System.out.println("");
        
        if (byte3.charAt(0) == '1') printer("Cardholder verification was not successful");
        if (byte3.charAt(1) == '1') printer("Unrecognised CVM");
        if (byte3.charAt(2) == '1') printer("PIN try limit exceeded");
        if (byte3.charAt(3) == '1') printer("PIN entry required, but no PIN pad present or not working");
        if (byte3.charAt(4) == '1') printer("PIN entry required, PIN pad present, but PIN was not entered");
        if (byte3.charAt(5) == '1') printer("On-line PIN entered");
        //if (byte3.charAt(6) == '1') System.out.println("");
        //if (byte3.charAt(7) == '1') System.out.println("");

        if (byte4.charAt(0) == '1') printer("Transaction exceeds floor limit");
        if (byte4.charAt(1) == '1') printer("Lower consecutive offline limit exceeded");
        if (byte4.charAt(2) == '1') printer("Upper consecutive offline limit exceeded");
        if (byte4.charAt(3) == '1') printer("Transaction elected randomly of on-line processing");
        if (byte4.charAt(4) == '1') printer("Merchant forced transaction on-line");
        //if (byte4.charAt(5) == '1') System.out.println("");
        //if (byte4.charAt(6) == '1') System.out.println("");
        //if (byte4.charAt(7) == '1') System.out.println("");

        if (byte5.charAt(0) == '1') printer("Default TDOL Used");
        if (byte5.charAt(1) == '1') printer("Issuer authentication failed");
        if (byte5.charAt(2) == '1') printer("Script processing failed before final Generate AC");
        if (byte5.charAt(3) == '1') printer("Script processing failed after final Generate AC");
        //if (byte5.charAt(4) == '1') System.out.println("");
        //if (byte5.charAt(5) == '1') System.out.println("");
        //if (byte5.charAt(6) == '1') System.out.println("");
        //if (byte5.charAt(7) == '1') System.out.println("");
        
    }
    
    static void printer(String st) {
        System.out.format("  * %s\n", st);
    }
}
