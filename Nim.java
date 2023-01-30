import java.util.Scanner;
import java.util.Random;


public class Nim
{

    public int getComputerMove(int left)
    {
        if((left == 1) || (left == 2)){
            return left;
        } else if (left == 4){    
            return 1;
        } else {
            for (int i = 1; i < (left/2); i++) {
               if (  ( (left - i) % 2 != 0 ) && ( (left - i) % 4 != 0 ) ) {
                return i;
               }

            }
            return 1;
        }
        


    }
    

    public void play()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name");
        String n = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter The Computer's Name");
        String n2 = sc.nextLine();
        
        Random rand = new Random();
        int left = rand.nextInt((50-10) + 1) + 10;
        System.out.println(left+" elements to start with");
        System.out.println(n2 + " is Starting");
        while(left>0)
        {
            int computer=getComputerMove(left);
            System.out.println(n2 + " takes "+computer);
            left-=computer;
            System.out.println("Now there are "+left+" left.");
            if(left<=0)
            {
                System.out.println(n2 + " wins!");
                Scanner sc4 = new Scanner(System.in);
                System.out.println("Play Again(y or n): ");
                String n4 = sc4.nextLine();
                if (n4.equals("y")){
                    Nim nim=new Nim();
                    nim.play();
                }
                return;
            }

            System.out.println("What's your move " + n);
            int person=sc.nextInt();
            while(person >= ((left+1)/2))
            {
                System.out.println(person+" not allowed, choose less than half");
                person=sc.nextInt();
            }
            left-=person;
            System.out.println("Now there are "+left+" left.");
            if(left<=0)
            {
                System.out.println(n + " wins!");
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Play Again(y or n): ");
                String n3 = sc3.nextLine();
                if (n3.equals("y")){
                    Nim nim=new Nim();
                    nim.play();
                }

                
                return;
            }
        }
    }
    
    public static void main(String[] args)
    {
        Nim nim=new Nim();
        nim.play();
    }
}