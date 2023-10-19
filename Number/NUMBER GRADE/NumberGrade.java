import java.util.Scanner;
public class NumberGrade {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\tWELCOME TO\n\tSTUDENT GRADE CALCULATOR");
        System.out.print("PRESS(1) IF YOU USE OTHERWISE PRESS ANY NUMBER :");
        if(sc.nextInt() == 1){
        selectNumberOfSubject(sc);
        }else{
            System.out.println("\t\tTHANK YOU");
        }
        sc.close();
    }
    private static void selectNumberOfSubject(Scanner sc) {
        System.out.print("\nENTER THE NUMBER OF SUBJECTS : ");
        int sizeofArray = sc.nextInt();
        int marks[]=new int[sizeofArray];
        marks(marks,sc);

    }
    private static void marks(int[] marks, Scanner sc) {
        double totalMarks= 0;
        for(int i = 0;i < marks.length ; i++){
            // double totalMarks= 0;
            System.out.print("ENTER THE MARKS (BETWEEN 1 TO 100) OF SUBJECT "+ (i+1) +": ");
            marks[i]=sc.nextInt();
            totalMarks = totalMarks + marks[i];
            // System.out.print("YOUR TOTAL MARKS OBTAINED IN "+ marks.length + " SUBJECT IS : "+totalMarks);
        }
		System.out.println("\n\t\t\t\t\tFULL MARKS IN "+ marks.length+" SUBJECT'S IS :"+ marks.length*100);
        System.out.print("\nYOUR TOTAL MARKS OBTAINED IN "+ marks.length + " SUBJECT's IS : "+totalMarks);
         avgTotal(sc,totalMarks,marks);
    }
    private static void avgTotal(Scanner sc, double totalMarks, int[] marks) {
        float averageNumber = 0;
        int full = marks.length *100 ;
        averageNumber = (float)(totalMarks/full)*100;
        System.out.println();
        System.out.printf("\n\t\tPERCENTAGE IS : %.2f",averageNumber);System.out.print("%");
        System.out.println();
        grad(averageNumber,sc);
    }
    private static void grad(double averageNumber, Scanner sc) {
        /*
         * OUTSTANDING   {O}
         * EXCELLENT     {E}
         * VERY GOOD     {A}
         * GOOD          {B}
         * FAIR          {C}
         * BELOW AVERAGE {D}
         * FAILED        {F}
         */
        if(averageNumber >= 90){
            System.out.println("\t\t\tGRADE 'O'");
        }else if(averageNumber <= 89 && averageNumber >= 80){
            System.out.println("\t\t\tGRADE 'E'");
        }else if(averageNumber <= 79 && averageNumber >= 70){
            System.out.println("\t\t\tGRADE 'A'");
        }else if(averageNumber <= 69 && averageNumber >= 60){
            System.out.println("\t\t\tGRADE 'B'");
        }else if(averageNumber <= 59 && averageNumber >= 50){
            System.out.println("\t\t\tGRADE 'C'");
        }else if(averageNumber <= 49 && averageNumber >= 40){
            System.out.println("\t\t\tGRADE 'D'");      
        }else if(averageNumber <= 39){
            System.out.println("\t\t\tGRADE 'F'");    
        }
        System.out.println("\n\n\tOUTSTANDING   {O}\n\tEXCELLENT     {E}\n\tVERY GOOD     {A}\n\tGOOD          {B}\n\tFAIR          {C}\n\tBELOW AVERAGE {D}\n\tFAILED        {F}");
        System.out.print("IF YOU USE AGAIN PLEASE ENTER(1) OTHERWISE ENTER ANY NUMBER:");
        if(sc.nextInt() == 1){
            selectNumberOfSubject(sc);
        }else{
            System.exit(0);
        }    
    }
}