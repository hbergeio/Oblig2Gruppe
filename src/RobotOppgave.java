// Klasse for å representere omgivelsene
class Verden {
    boolean regner;
    int dag; // 1 er Mandag, 2 er Tirsdag, ..., 7 for Søndag, 8 er Mandag...

    public Verden(boolean regner, int dag) {
        this.regner = regner;
        this.dag = dag;
    }    

    // endre metoden for å returnere true hvis det er søndag (hint: Modulo %)
    public boolean erSondag() {
        return dag % 7 == 0;
    }
}

class Robot {
    // gi robotten 4 attributter: navn, batteriNivaa, avstandTilParken og botType
    String navn, botType;
    double batteriNivaa;
    int avstandTilParken;

    public Robot (String navn, String botType, double batteriNivaa, int avstandTilParken) {
        this.navn = navn;
        this.botType = botType;
        this.batteriNivaa = batteriNivaa;
        this.avstandTilParken = avstandTilParken;
    }
    // ENdre metoden slik at den retunerer en tekst streng som forklarer statusen til roboten
    // eksempel: Dette er bot Dancatron 4000 av type B-Bot.
    // Denne enheten har 80.0 batterikapasitet igjen og bor 1500 meter fra parken.

    public void giStatus() {
        System.out.print("Dette er bot " + this.navn + " av type " + this.botType + "\nDenne enheten har " + this.batteriNivaa + " batterikapasitet igjen og bor " + this.avstandTilParken + " meter fra parken.\n\n");
    }

    // Metode for å sjekke om roboten kan gå til parken basert på omgivelsene
    public boolean gaaTilParken(Verden verden) {
        System.out.println(this.navn + " sjekker om det er mulig aa gaa til parken...\n");
        // Sjekker om det regner
        if (verden.regner) {
            System.out.println(this.navn + " kan ikke gaa til parken fordi det regner.\n");
            return false;
        }
    
       // Sjekk om det er søndag. Kan bare gå i parken på søndager.
        if (!verden.erSondag()) {
            System.out.println(this.navn + " kan ikke gaa til parken fordi det ikke er sondag.\n");
            return false;
        }
    
        // Sjekk batterinivå. En bot trenger 1% batterinivå per 100 meter for å gå til parken.
        if (!sjekkOmNokBatteri(this.batteriNivaa, this.avstandTilParken)) {
            System.out.println(this.navn + " kan ikke gaa til parken fordi det ikke er nok batteri.\n");
            return false;
        }
    

        System.out.println(this.navn + " kan gaa til parken!\n");


        return true;
    }

    public boolean sjekkOmNokBatteri(double batteriNivaa, int avstandTilParken) {
        return batteriNivaa > (avstandTilParken / 100);
    }
    

    // lag en metode som sjekker om boten kan være med på danseklubben
    // bottypen må være av type B-Bot (hint .equals)
    // En bot trenger minimum 50% batterikapasitet for å være med
    // Det kan ikke være mandag. Da er danseklubben stengt.
   public boolean kanDanse(Verden verden) {
    String message;
    if (verden.dag % 7 == 1) {
        System.out.println(navn + " kan ikke delta i danseklubben fordi det er mandag");
        return false;
    }

    if (!this.botType.equals("B-Bot")) {
        System.out.println(navn + " kan ikke delta i danseklubben fordi det ikke er en B-Bot.");
        return false;
    }

    if (this.batteriNivaa <= 50) {
        System.out.println(navn + " har ikke energi til å danse...");
        return false;
    }

    System.out.println(navn + " kan delta i danseklubben!");
    return true;
    }
}


public class RobotOppgave {
    public static void main(String[] args) {
        // Oppretter en Verden-objekt (omgivelsene)
        Verden dagensVerden = new Verden(false, 122);

        // Oppretter to Robot-objekter
        Robot rob1 = new Robot("Dancatom 1400", "B-Bot", 80.7, 1500);
        Robot rob2 = new Robot("notDancatom -1400", "Toaster", 14.5, 14583);

        // print ut statusen til begge robottene
        rob1.giStatus();
        rob2.giStatus();

        // Sjekker om robotene kan gå til parken

        rob1.gaaTilParken(dagensVerden);
        rob2.gaaTilParken(dagensVerden);

        // Sjekker om robotene kan gå til danseklubben

        rob1.kanDanse(dagensVerden);
        rob2.kanDanse(dagensVerden);
        
    }
}
