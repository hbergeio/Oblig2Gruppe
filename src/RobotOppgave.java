// Klasse for å representere omgivelsene
class Verden {
    boolean regner;
    int dag; // 1 er Mandag, 2 er Tirsdag, ..., 7 for Søndag, 8 er Mandag...

    // endre metoden for å returnere true hvis det er søndag (hint: Modulo %)
    public boolean erSondag(int dag) {
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
        System.out.print("Dette er bot " + this.navn + " av type " + this.botType + "\nDenne enheten har " + this.batteriNivaa + " batterikapasitet igjen og bor " + this.avstandTilParken + " meter fra parken.");
    }

    // Metode for å sjekke om roboten kan gå til parken basert på omgivelsene
    public boolean gaaTilParken(Verden verden) {
        // System.out.println(navn + " sjekker om det er mulig å gå til parken...");
        // Sjekk om det regner
        if ((verden.regner || !verden.erSondag()) && sjekkOmNokBatteri(this.batteriNivaa, this.avstandTilParken) ){
            // skriv ut hvorfor boten ikke kan gå i parken med System.out.println
            return false;
        }

        public boolean sjekkOmNokBatteri(this.batteriNivaa, this.avstandTilParken) {
            this.avstandTilParken = this.avstandTilParken / 100;
            if (this.batteriNivaa > this.avstandTilParken) {
                return true;
            }
            return false;
        }
        

        // Sjekk om det er søndag. Kan bare gå i parken på søndager.

        // Sjekk batterinivå. En bot trenger 1% batterinivå per 100 meter for å gå til parken.


        return true;
    }

    // lag en metode som sjekker om boten kan være med på danseklubben
    // bottypen må være av type B-Bot (hint .equals)
    // En bot trenger minimum 50% batterikapasitet for å være med
    // Det kan ikke være mandag. Da er danseklubben stengt.

}



public class RobotOppgave {
    public static void main(String[] args) {
        // Oppretter en Verden-objekt (omgivelsene)
        Verden dagensVerden = new Verden();
        dagensVerden.regner = false;
        dagensVerden.dag = 122;

        // Oppretter to Robot-objekter
        // med navn, f.eks. Dancatron 4000 og Spark-E
        // med botType "B-Bot" og "Toaster"
        // med forskjellig batterinivå
        // med forskjellig avstand til parken
        // print ut statusen til begge robottene

        // Sjekker om robotene kan gå til danseklubben
        // Sjekker om robotene kan gå til parken
        
    }
}
