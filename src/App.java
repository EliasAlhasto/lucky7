import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        //Aluksi syötetään haluttu alkurahasumma pelaamiseen

        System.out.println("Syötä alkuraha.");
        double raha = in.nextDouble();
        int pelimaara = 0;
        double totalVoitot = 0;
        double totalHaviot = 0;


        //Aloitetaan loop

        do{

            //Käyttäjä valitsee paljon rahaa haluaa pelata alkurahasta (max 5)

            System.out.println("Syötä haluttu rahamäärä " + "(Sinulla on " + raha + " euroa)");
            double bet = in.nextDouble();
        
            //Tarkistetaan meneekö raha yli tai ali maksimi/minimi summan

            if(bet <= raha && bet > 0)
            {
                System.out.println("Hyväksytty rahasumma.");
            }
            else
            {
                System.out.println("Syötit liian ison tai pienen summan.");
                continue;
            }

            //Tulostetaan 3 random lukua ja tulostetaan ne

            int n1 = r.nextInt(10)+1;
            int n2 = r.nextInt(10)+1;
            int n3 = r.nextInt(10)+1;

            int seiskat = 0;
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);

            //Lasketaan random numeroista saadut seiskat ja tulostetaan se näkyviin käyttäjälle

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

            //Jos seiskoja on enemmän kuin nolla niin voitat, mutta jos niitä on 0 niin häviät
            
            if(seiskat > 0)
            {
                double voitot = bet * seiskat;
                System.out.println("Voitit " + voitot + "€");
                raha += voitot;
                totalVoitot += voitot;
            }
            else
            {
                System.out.println("Hävisit");
                raha -= bet;
                totalHaviot += bet;

            }

            //Tulostetaan jäljellä oleva rahasumma voiton tai häviön jälkeen

            System.out.println("Sinulla on " + raha + "€");
            in.nextLine();
            ++pelimaara;

            //Kysytään haluaako käyttäjä pelata uudestaan, jos hän vastaa ei ("n") niin loop loppuu

            System.out.println("Haluatko pelata uudestaan? (voit lopettaa kirjoittamalla n)");

            String vastaus = in.nextLine();

            if(vastaus.equals("n"))
            {
                break;
            }
            

        }

        //Jos käyttäjä vastaa mitään muuta kuin n niin peli jatkuu niin kauan kun rahaa on enemmän kuin 0,01

        while(raha > 0.01);

        System.out.println("Voitit yhteensä " + totalVoitot + "euroa.");
        System.out.println("Hävisit yhteensä " + totalHaviot + "euroa.");
        System.out.println("Pelasit " + pelimaara + " kertaa.");

    }
}
