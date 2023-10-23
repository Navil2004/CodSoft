import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Random;
public class AtmInterFace{
    private static void welcome(){
       Scanner sc = new Scanner(System.in);
       boolean Atm = true;
       int totalAmount = 100000;
       int password = 1111;
       System.out.println("\n         WELCOME TO STATE BANK OF INDIA\n");
       card();
       while( Atm == true){
       System.out.println("\n               PLEASE CHOOSE SERVICES");
       System.out.print("\n[1] CASH WITHDRAWAL");
       System.out.println("\t\t\t[2] DEPOSITE\n");
       System.out.print("[3] BALANCE INQUIRY");
       System.out.println("\t\t\t[4] MINI STATEMENT\n");
       System.out.print("[5] BILL PAYMENT");
       System.out.println("\t\t\t[6] PIN CHANGE\n");
       System.out.print("[7] OTHERS");
       System.out.println("\t\t\t\t[8] EXIT");
       System.out.print("\nPRESS THE NUMBER WHAT YOU WANT: ");
       int number=sc.nextInt();

    switch(number){     
        case 1:
            withdrawal(totalAmount,sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --");
            break;
         
        case 2:
            deposite(totalAmount,sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --");
            break;

         
        case 3:
            balanceInqu(totalAmount,sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --");
            break;
        case 4:
            miniStatement(totalAmount,sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --");
            break;

        case 5:
            billPayment(totalAmount,sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --");  
            break;

        case 6:
            pinChange(sc,password);
            System.out.println("\n-- PLEASE REMOVE YOUR ATM CARD --"); 
            break;
        case 7:
            goBack(sc);
            break;
        case 8:
            System.out.println("YOU CHOOSE TO EXIT SERVICES");
            break;			
            
        default:
            // System.out.println("         VISIT AGAIN ");
            System.out.println("YOU HAVE ENTERED WRONG SERVICES");
    }
    System.out.println("\n     VISIT AGAIN ");
    System.out.println("  --- THANK YOU ---");
    Atm = false;
    }
    sc.close();

    }
    private static void goBack(Scanner sc) {
        System.out.println("\nIF YOU GO BACK TO THE WELECOME SERVICES INTERFACE");
        System.out.print("THEN PLEASE PRESS (1) ELSE PRESS ANY NUMBER TO EXIT:");
        int num = sc.nextInt();
        if(num == 1){
            welcome();
        }else{
            return;
        }   

    }
    private static void billPayment(int totalAmount, Scanner sc, int password) {
        System.out.println("                                       CURRENT BALANCE: Rs."+totalAmount+"\n\n");
        System.out.println("     ---- SELECT YOUR DESIRED AMOUNT ----\n");
        System.out.print("[1] ELECTRIC BILL           Rs. 2500\n"+"[2] MOBILE RECHARGE         Rs. 500\n");
        System.out.print("\nPRESS THE NUMBER WHAT YOU WANT:");
        int number = sc.nextInt();
        switch(number){
            case 1:
            int amount = 2500;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            int n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            default :
            amount = 500;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("MOBILE WILL BE RECHARGED FOR 3 MONTHS");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
    }
}
    private static void miniStatement(int totalAmount, Scanner sc, int password) {

        System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
        int n = sc.nextInt();
            //}
        if(password == n){
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nCURRENT DATE & TIME: "+dateTime.format(now)+"\n");
        System.out.println("----------------------------------------------------------");
        System.out.println("ACCOUNT NUMBER :     **********6222");
        System.out.println("TRANSACTION    :      MINISTATEMENT\n");
        System.out.println("DATE / REMARKS"+"              AMOUNT"+"\n---------------------------------------\n");
        System.out.println("2023/10/7                   Rs. 2500.00 - TO TRANSFER");
        System.out.println("2023/10/1                   Rs. 500.00 - TO TRANSFER");
        System.out.println("2023/09/7                   Rs. 2000.00 - ATM WDL");
        System.out.println("2023/07/3                   Rs. 2500.00 - TO TRANSFER");
        System.out.println("AVAIL BALANCE               Rs. "+(totalAmount - 3467)); 
        }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }   

    }
    private static void balanceInqu(int totalAmount, Scanner sc, int password) {
        System.out.print("\nENTER PIN NUMBER: ");
        //for(int i = 0;i<4;i++){
        int n = sc.nextInt();
        //}
        if(password == n){
        System.out.println("YOUR AVAILABLE BALANCE IS : "+totalAmount);
        }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
    }
    private static void deposite(int totalAmount, Scanner sc, int password) {
        System.out.print("ENTER AMOUNT TO BE DEPOSITED(AT LEAST Rs.1000): Rs.");
            int amount=sc.nextInt();
            if(amount >= 1000){
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            int  n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount + amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR AMOUNT HAS BEEN SUCCESSFULLY DEPOSITED");
            System.out.println("YOUR CURRENT AMOUNT IS :Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
        }else{
            System.out.println("YOUR AMOUNT IS NOT SUFFICIENT:");
        }
    }
    private static void withdrawal(int totalAmount, Scanner sc, int password) {
        System.out.println("                                       CURRENT BALANCE: Rs."+totalAmount+"\n\n");
        System.out.println("     ---- SELECT YOUR DESIRED AMOUNT ----\n");
        System.out.print("[1] Rs. 2500"+"\t\t\t\t[4] Rs. 5000"+"\n\n[2] Rs. 7000"+"\t\t\t\t[5] Rs. 10000"+"\n\n[3] Rs. 15000"+"\t\t\t\t[6] OTHER AMOUNT\n");
        System.out.print("\nPRESS THE NUMBER WHAT YOU WANT:");
        int number = sc.nextInt();
        switch(number){
            case 1:
            int amount = 2500;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            int n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("PLEASE COLLECT YOUR CASH");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            case 2:
            amount = 7000;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("PLEASE COLLECT YOUR CASH");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            case 3:
            amount = 15000;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("PLEASE COLLECT YOUR CASH");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            case 4:
            amount = 5000;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("PLEASE COLLECT YOUR CASH");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            case 5:
            amount = 10000;
            System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            n = sc.nextInt();
            //}
            if(password == n){
            totalAmount = totalAmount - amount;
            System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
            System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");
            System.out.println("PLEASE COLLECT YOUR CASH");
            System.out.println("CURRENT AMOUNT IS: Rs."+totalAmount);
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
            break;
            default:
            other(totalAmount,sc,password);
        }
    }
    private static void other(int totalAmount, Scanner sc, int password) {
        System.out.print("PLEASE ENTER YOUR AMOUNT (AT LEAST Rs. 500): ");
        int amount = sc.nextInt();
        if(amount >= 500){
            if(amount <= totalAmount){
        System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
            int n = sc.nextInt();
            //}
            if(password == n){
        totalAmount = totalAmount - amount;
        System.out.println("        WAIT!  \nWHILE YOUR TRANSACTION IS BEING PROCESSED....");
        System.out.println("YOUR TANSACTION HAS BEEN SUCCESFUL...");  
        System.out.println("PLEASE COLLECT YOUR CASH");
        System.out.println("CURRENT AMOUNT IS: "+totalAmount); 
            }else{
                System.out.println("YOU ENTER WRONG PASSWORD");
            }
        }else{
            System.out.println("YOUR WITHDRAWAL AMOUNT Rs. IS MORE THAN THE TOTAL AMOUNT");
        }
        }else{
            System.out.println("YOUR WITHDRAWAL AMOUNT Rs. IS LESS THAN Rs. 500");
            return;
        }    
    }
    private static void pinChange(Scanner sc, int password) {
        System.out.print("\nENTER PIN NUMBER: ");
            //for(int i = 0;i<4;i++){
        int n = sc.nextInt();
            //}
        if(password == n){
        System.out.println("[1] YES"+"\t\t\t\t[2] NO");
        System.out.print("CAHNGE PIN THEN PRESS(1) ELSE PRESS(2): ");
        int s = sc.nextInt();
        if(s == 1){
        int store = 0,rem,autoGenerated;
        //int pin = 1;
        int[] num = new int[10];
            System.out.println("PLEASE ENTER YOUR 10 DIGIT MOBILE NUMBER");
            for(int i = 0 ;i<num.length;i++){
                //  num[i] = sc.next().charAt(0);
                num[i] = sc.nextInt();
            }
            System.out.print("YOUR PHONE NUMBER IS: ");
            numPrint(num);
            System.out.print("\nIF YOUR PHONE NUMBER IS CORRECT PRESS(1) OTHERWISE PRESS ANY NUMBER: ");
            if(sc.nextInt() == 1){
                System.out.println();
            Random randome =new Random();
            for(int  i = 0;i<4;i++){
            autoGenerated = randome.nextInt(1000,9999);
            rem = autoGenerated%10;
            store  = store*10 +rem;
            autoGenerated = autoGenerated/10;
            }
            System.out.println("\nYOUR ONE TIME PASSWORD: "+store);
            System.out.print("ENTER THE ONE TIME PASSWORD: ");
            int userNumber = sc.nextInt();
            if(store == userNumber){
            while(password != 0){
                System.out.print("ENTER YOUR NEW PASSWORD: ");
                for(int i = 0;i<4;i++){
                    password = sc.nextInt();
                    password = password/10;
                }
                System.out.println("PASSWORD HAS BEEN CHANGED.");
            }
        }else{
            System.out.println("YOU ENTER WRONG ONE TIME PASSWORD");
        }
        }else{
            System.out.println("YOU ENTER WRONG PHONE NUMBER");
        }
        }else{
            System.out.println("YOUR PASSWORD HAS NOT CHANGED");
        }
    }else{
            System.out.println("YOU ENTER WRONG PASSWORD");
        }
    }
    private static void numPrint(int[] num) {
        for(int i = 0;i<num.length;i++){
            System.out.print(num[i]);
        }
    }
    private static void card() {
        System.out.println("          PLEASE INSERT YOUR ATM CARD ");
        System.out.println("                  PROCESSING....");
    }
    public static void main(String args[]) {
        welcome();

    }

}