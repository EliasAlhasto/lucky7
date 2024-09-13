import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Syötä alkuraha.");
        double raha = in.nextDouble();


        do{
            System.out.println("Syötä haluttu rahamäärä " + "(Sinulla on " + raha + " euroa)");
            double bet = in.nextDouble();
        

            if(bet <= raha && bet > 0)
            {
                System.out.println("Hyväksytty rahasumma.");
            }
            else
            {
                System.out.println("Syötit liian ison tai pienen summan.");
                continue;
            }

            int n1 = r.nextInt(10)+1;
            int n2 = r.nextInt(10)+1;
            int n3 = r.nextInt(10)+1;

            int seiskat = 0;
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);

            if(n1 == 7)
            {
                ++seiskat;
            }
            if(n2 == 7)
            {
                ++seiskat;
            }
            if(n3 == 7)
            {
                ++seiskat;
            }

            System.out.println("Sait " + seiskat + " seiskaa.");
            
            if(seiskat > 0)
            {
                double voitot = bet * seiskat;
                System.out.println("Voitit " + voitot + "€");
                raha += voitot;
            }
            else
            {
                System.out.println("Hävisit");
                raha -= bet;
            }

            System.out.println("Sinulla on " + raha + "€");
            in.nextLine();

            System.out.println("Haluatko pelata uudestaan? (voit lopettaa kirjoittamalla n)");

        
            String vastaus = in.nextLine();

            if(vastaus.equals("n"))
            {
                break;
            }
            

        }
        while(raha > 0.01);




    }
}
