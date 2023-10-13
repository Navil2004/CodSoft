import java.util.Random;
import java.util.Scanner;
    public class GuessingNumber {
        private static int againPlayOption(){
            Scanner sc = new Scanner(System.in);
            boolean againPlayOption = true;
            while(againPlayOption == true){
                System.out.print("\n\tIF YOU PRESS(1) THEN PLAY ONE PLAYER \n\tOTHERWISE PRESS(2) THEN PLAY TWO PLAYER)\nNOT PLAY AGAIN THEN YOU HAVE TO PRESS ANY NUMBER EXCEPT (1,2): ");
                int number = sc.nextInt();
                if(number == 1){
					System.out.println("YOU ENTER THE ONE PLAYER GUESSING GAME");
                    onePlayer();
                }else if(number == 2){
					System.out.println("YOU ENTER THE TWO PLAYER GUESSING GAME");
                    twoPlayer();
                }
                else{
                    System.out.println("------------- EXIT GAME -------------");
                    //againPlayOption = false;
					//System.exit(0);
                }
				againPlayOption = false;
                
            }
           // main(null);  
            return 0;      

        }
        private static void twoPlayer(){
            Scanner sc = new Scanner(System.in);
            String name1,name2;
            System.out.println();
            System.out.print("ENTER NAME FIRST PLAYER PLEASE : ");
            name1 = sc.nextLine();
            System.out.print("ENTER YOUR ATTEMPT NUMBER TO GUESS THE CORRECT NUMBER (1 TO 10)? : ");
            int conf = confident();
            int player1 = twoPlayerFormate();
            System.out.println("-----------------------------------------------------");
            System.out.print("ENTER NAME SECOND PLAYER PLEASE : ");
            name2 = sc.nextLine();
            System.out.print("ENTER YOUR ATTEMPT NUMBER TO GUESS THE CORRECT NUMBER (1 TO 10) ? : ");
            int conf1 = confident();
            int player2 = twoPlayerFormate();

            if(player1 < player2 ){
                System.out.println("------ CONGRATULATIONS ------- \n------ "+name1+" -------");
                System.out.println("YOUR PREDICT CORRECT NUMBER IN: ("+ player1 +") ATTEMPTS");
        }
            else if(player1 > player2){
                System.out.println("------- CONGRATULATIONS -------\n------- "+name2+" -------");
                System.out.println("YOUR PREDICT CORRECT NUMBER IN: ("+ player2 +") ATTEMPTS");
            }
            else if(player1 != player2 || conf1 == conf){
                System.out.println();
                System.out.println("BOTH CONFIDENT IS GOOD ,BUT OVER CONFIDENT IS NOT GOOD");
                System.out.println("ENTER YOUR PRIDICT NUMBER WILL BE SAME , BUT NOT GUESS THE CURRECT ANSWER");
                System.out.println("------------- TRY-AGAIN -------------");
                System.out.println();
             }else if(player1 == player2){
                System.out.println(" -- CONGRATULATION --\n---- TIE GAME ---");
             }
            else{
                
                System.out.println(name1 + " AND "+ name2 +"\n NO! ONE WON ,GAME IS TIE.\n\t"+ name1 +" CONFIDENT NUMBER IS: "+ conf +"\n\t\t"+ name2 +" CONFIDENT NUMBER IS : "+ conf1);
            }
            againPlayOption();
        }
        private static int twoPlayerFormate(){
            Random randome =new Random();
            int autoGenerated = randome.nextInt(1,101);

            //System.out.println(autoGenerated+" : Correct Answer");
            
            System.out.println("\t\tAGAIN ENTER YOUR PRIVIOUS,");
            System.out.print("ENTER YOUR ATTEMPT NUMBER TO GUESS THE CORRECT NUMBER (1 TO 10) ? : ");
            int conf = confident();
            System.out.println();

            int count = 0;
           
            boolean navil = false;
            while(navil == false){
                if(count == conf){
                    break;
                }
                System.out.print("ENTER YOUR GUESS NUMBER (1 TO 100): ");
                int guess = enterTheGameNumber();
                count++;

                if(guess == autoGenerated){
                    navil = true;
                }
                else if(guess > autoGenerated){
                    System.out.println("YOUR NUMBER IS ( TOO HIGH ) PLEASE REDUCE YOUR PREDICT NUMBER");
                }
                else if(guess < autoGenerated){
                    System.out.println("YOUR NUMBER IS ( TOO LOW ) PLEASE INCREASE YOUR PREDICT NUMBER");
                }

            }
             if(navil == true){
				 System.out.println();
                System.out.println("-------- GREAT GOOD CONFIDENT --------");
                System.out.println("CORRECT ANSWER IN ("+count+") ATTEMPTS.\nYOUR TOTAL ATTEMPT NUMBER IS ("+conf+") AFTER PLAYED REMAIN YOUR ATTEMPT NUMBER IS: ("+(conf-count)+").");
            }
            else if(count > conf){
                System.out.println();
                System.out.println("BOTH OF YOU LOST THE GAME !!.\nBECAUSE YOUR NUMBER OF ATTEMPTS ("+ count +") IS NOT EQUAL FROM THE GIVEN ("+conf+") NUMBER");

                System.out.println("\t\t\t\tTHE CORRECT ANSWER IS: "+autoGenerated);
            }
            System.out.println();
            return count;
        
    } 
        private static void enterTheGame(int num) {
                if(num == 1){
                Scanner sc = new Scanner(System.in);
                System.out.println("\n\n-------------- WELCOME TO MY NUMBER GUESSING GAME ----------------");
                System.out.print("\n\nSELECT THE NUMBER OF PLAYERS PALYING THIS GAME (1 OR 2): ");
                int numberOfPlayers = sc.nextInt();
                selection(numberOfPlayers); 
                }else{
                    
                    System.out.println("------------- THANK YOU -------------");
                }
        }
        private static int selection(int numberOfPlayers) {
            if(numberOfPlayers <= 0 || numberOfPlayers >= 3){
               System.out.println();
               //main(null);
               return 0;
               
            }else if(numberOfPlayers == 1){
                onePlayer();
            }else{
                twoPlayer();
            }  
            return 0;
        }
        private static void onePlayer() {
            Scanner sc = new Scanner(System.in);
            String name;
            System.out.print("\nENTER NAME PLEASE: ");
            name = sc.nextLine();
            onePlayerFormate();
            System.out.println("--------- "+name+" --------- \n");
            againPlayOption();
        }
        private static int enterTheGameNumber() {
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            
            if(number >= 1 && number <= 100){
            }else{
                System.out.println("YOUR NUMBER IS NOT IN RANGE");
                return againPlayOption();         
            }  
            return number;
        }
        private static int confident() {
            Scanner sc = new Scanner(System.in);
            int number1 = sc.nextInt();
            if(number1 <= 10 && number1 >=1){
            }else{
                return againPlayOption();
            }
            return number1;
        }
        private static int onePlayerFormate() {
            Scanner sc=new Scanner(System.in);
            Random random = new Random();
            int autoGenerated = random.nextInt(1 ,101);
            //System.out.println(autoGenerated+" : Correct Answer");
            int count = 0;
            System.out.print("ENTER YOUR ATTEMPT NUMBER TO GUESS THE CORRECT NUMBER (1 to 10) ? : ");
            int conf = confident();
            boolean win = false;
            while(win == false){
                if(count == conf){
                    break;
                }
               System.out.print("ENTER YOUR GUESS NUMBER (1 TO 100): ");
               int guess = enterTheGameNumber();
                 count++;
                
                if(guess == autoGenerated){
                    win = true;
                }
                else if(guess > autoGenerated){
                    System.out.println("YOUR NUMBER IS ( TOO HIGH ) PLEASE REDUCE YOUR PREDICT NUMBER");
                }
                else if(guess < autoGenerated){
                    System.out.println("YOUR NUMBER IS ( TOO LOW ) PLEASE INCREASE YOUR PREDICT NUMBER");
                }
            }
            
            if(win == true){
                System.out.println();
                System.out.println("-------- GREAT GOOD CONFIDENT -------");
                System.out.println("--------- CONGRATULATIONS -------- ");
                System.out.print("CORRECT ANSWER IN ("+ count +") ATTEMPTS.\nYOUR TOTAL ATTEMPT NUMBER IS ("+ conf +") AFTER PLAYED REMAIN YOUR ATTEMPT NUMBER IS: ("+(conf-count)+").");
            }
            else{
                System.out.println();
                System.out.println("YOU LOST THE GAME --.\nBECAUSE YOUR NUMBER OF ATTEMPTS ("+ count +") IS EQUAL FROM THE GIVEN ("+conf+") NUMBER");
                System.out.println("CONFIDENT IS GOOD ,BUT OVER CONFIDENT IS NOT GOOD");
                System.out.println("------------- TRY-AGAIN -------------\n");

                System.out.print("THE CORRECT ANSWER IS: "+autoGenerated);
            }
            System.out.println();

             return count;
        }
        public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
				//System.out.println("\nIF YOU ARE NOT PLAY THEN PRESS ANY NUMBER (EXCEPT {1})");
                System.out.print("\n\tIF YOU PLAYING MY NUMBER GUESSING GAME,\n  YOU NEED TO PRESS(1) OTHERWISE PRESS ANY NUMBER: ");
                int num = sc.nextInt();
                enterTheGame(num);      
                sc.close();
        }

    }