import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hra {


     public static void SpustHru() throws Exception {
         boolean pokracuj = true;
         Hrac hrac = new Hrac("Albert", "Rychlik", 4, 100);

         ArrayList<Veci> seznamVeci = new ArrayList<>();

         Batoh batoh = new Batoh();
         ArrayList<Pritel> seznamPratel = new ArrayList<>();

         Scanner scaner = new Scanner(System.in);
         String[] nacteniPolozky;
         ArrayList<Mistnosti> herniMapa = new ArrayList<>();
         String filePath = "Hernisvet.txt";
         try {
             BufferedReader reader = new BufferedReader(new FileReader(filePath));
             String line;

             while ((line = reader.readLine()) != null) {
                 //System.out.println(line);
                 nacteniPolozky = line.split(",");
                 herniMapa.add(new Mistnosti(nacteniPolozky[0], prevedStringNaBoolean(nacteniPolozky[1]) , prevedStringNaBoolean(nacteniPolozky[2]), prevedStringNaBoolean(nacteniPolozky[3]),prevedStringNaBoolean(nacteniPolozky[4]) ));
             }
             reader.close();
         } catch (FileNotFoundException e) {
             System.out.println("Soubor nenalezen");
         } catch (IOException e) {
             System.out.println("Soubor je poskozeny");
         } catch (Exception e) {
             System.out.println("Nekde je chyba");
         }

         seznamVeci.add(new Veci("Kokteil", "", true,4,false,20));
         seznamVeci.add(new Veci("Člun", "", true, 6,false,10));
         seznamVeci.add(new Veci("Kačenka", "", true, 2,true,30));
         seznamVeci.add(new Veci("Slunečník", "", false, 5, false,10));

         seznamPratel.add(new Pritel("Plavcik", "", true, false, 1));
         seznamPratel.add(new Pritel("Kuchar", "", true, false, 1));
         seznamPratel.add(new Pritel("Krokodyl", "", false, true, 8));

         do {
             System.out.println("Pouzij tyhle pro prikazy pro hrani hry: ");
             System.out.println("-Smery: sever, jih, vychod, zapad");
             System.out.println("-zvedni");
             System.out.println("-co je v mistnosti?");
             System.out.println("-konec = ukonceni hry");
             System.out.println("------------------------------------");


             //Hlavni logika programu, ktera vyuziva ruzne objekty na zaklade spolecneho indexu v sachovnici
             String prikaz = scaner.nextLine();
             switch (prikaz) {
                 case "sever":
                     if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 1 || hrac.getvJakejeMistnosti() == 2) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isSever()) {
                             if (nepritelVmistnosti(seznamPratel, hrac.getvJakejeMistnosti() - 3)) {
                                 System.out.println("Konec hry. Zabil vas nepritel");
                             } else {
                                 hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 3);
                                 System.out.println(" Presel si do mistnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                                 overUkonceniHry(seznamVeci, hrac);
                             }
                         } else {
                             System.out.println("Nemuzes jit nahoru");
                         }
                     }
                     break;
                 case "jih":
                     if (hrac.getvJakejeMistnosti() == 6 || hrac.getvJakejeMistnosti() == 7 || hrac.getvJakejeMistnosti() == 8) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isJich()) {
                             if (nepritelVmistnosti(seznamPratel, hrac.getvJakejeMistnosti() + 3)) {
                                 System.out.println("Konec hry. Zabil vas nepritel");
                             } else {
                                 hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 3);
                                 System.out.println(" Presel si do mistnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                                 overUkonceniHry(seznamVeci, hrac);
                             }
                         } else {
                             System.out.println("Nemuzes jit dolu");
                         }
                     }
                     break;
                 case "vychod":
                     if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 3 || hrac.getvJakejeMistnosti() == 6) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isVychod()) {
                             if (nepritelVmistnosti(seznamPratel, hrac.getvJakejeMistnosti() - 1)) {
                                 System.out.println("Konec hry. Zabil vas nepritel");
                             } else {
                                 hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 1);
                                 System.out.println(" Presel si do mistnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                                 overUkonceniHry(seznamVeci, hrac);
                             }
                         } else {
                             System.out.println("Nemuzes jit dolu");
                         }
                     }
                     break;
                 case "zapad":
                     if (hrac.getvJakejeMistnosti() == 2 || hrac.getvJakejeMistnosti() == 5 || hrac.getvJakejeMistnosti() == 8) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isZapad()) {
                             if (nepritelVmistnosti(seznamPratel, hrac.getvJakejeMistnosti() + 1)) {
                                 System.out.println("Konec hry. Zabil vas nepritel");
                             } else {
                                 hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 1);
                                 System.out.println(" Presel si do mistnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                                 overUkonceniHry(seznamVeci, hrac);
                             }
                         } else {
                             System.out.println("Nemuzes jit dolu");
                         }
                     }
                     break;
                 case "útok":
                     utok();
                     break;

                 case "konec":
                     System.out.println("Konec hry.");
                     scaner.close();
                     return;
                 case "zvedni":
                     System.out.println("Zadej jmeno objektu co chces zvednout:");
                     String jmeno = scaner.nextLine();
                     for (int i = 0; i < seznamVeci.size(); i++) {
                         if (batoh.isJePlny()) {
                             System.out.println("Mate plny batoh");
                         } else {
                             if (seznamVeci.get(i).getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                                 if (seznamVeci.get(i).getJmeno().equals(jmeno)) {
                                     if (seznamVeci.get(i).isJeSebratelny()) {
                                         Veci v = seznamVeci.get(i);
                                         batoh.pridejDoBatohu(v);
                                         seznamVeci.remove(i);
                                         batoh.vypisObsah();
                                     }
                                 }
                             }
                         }
                     }
                     break;
                 case "co je v mistnosti?":
                     boolean jePredmetvmistnosti = false;
                     String seznamPredmetu = "  ";
                     for (int i = 0; i < seznamVeci.size(); i++) {
                         if (seznamVeci.get(i).getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                             jePredmetvmistnosti = true;
                             seznamPredmetu += seznamVeci.get(i).getJmeno() + " , ";
                         }
                     }
                     if (jePredmetvmistnosti) {
                         System.out.println("V mistnosti jsou predmety: " + seznamPredmetu);
                     } else {
                         System.out.println("V mistnosti nejsou zadne predmety");
                     }
                     boolean jePritelvmistnosti = false;
                     String seznamPrateli = " ";
                     for (int i = 0; i < seznamPratel.size(); i++) {
                         if (seznamPratel.get(i).getCisloMistnosti() == hrac.getvJakejeMistnosti() && seznamPratel.get(i).isJePratelsky()) {
                             jePritelvmistnosti = true;
                             seznamPrateli += seznamPratel.get(i).getJmeno() + " ";
                         }
                     }
                     if (jePritelvmistnosti) {
                         System.out.println("V mistnosti jsou pratele: " + seznamPrateli);
                     } else {
                         System.out.println("V mistnosti nejsou zadne pratele ");
                     }
                     break;
                 default:
                     System.out.println("Neplatný prikaz.");

             }
         } while (true);
     }

    private int zivotyNepřítele = 100;

    private static void utok() {
        int zivotyNepřítele = 100;
        System.out.println("Útočíte a ubíráte nepříteli 10 životů.");
        zivotyNepřítele -= 10;
        if (zivotyNepřítele > 0) {
            System.out.println("Nepřítel nyní má " + zivotyNepřítele + " životů. Pokračujte v útoku nebo zkuste jinou akci.");
        }
    }
    //hleda vyherni predmet a pokud ho najde tak hra skonci
    public static void overUkonceniHry(ArrayList<Veci> seznamVeciK, Hrac hracK) {
        for(int i = 0; i < seznamVeciK.size(); i++){
            if (seznamVeciK.get(i).getCisloMistnosti() == hracK.getvJakejeMistnosti()){
                if (seznamVeciK.get(i).isUkoncujici()){
                    System.out.println("--------- V mistnosti je predmet, ktery ukoncuje hru vyhrou! ---------");
                    System.exit(0);
                }
            }
        }
    }

    //zobrazi herni svet, ktery existuje v objektu, ktery byl inicializovan z textoveho souboru
    public static void zobrazSachovnici(ArrayList<Mistnosti> herniMapa) {

        int radek = 0;
        int sloupec = 0;

        String[][] pole = new String[3][3];

        for (int i = 0; i < herniMapa.size(); i++) {
            pole[radek][sloupec] = herniMapa.get(i).getJmeno();

            sloupec++;
            if (sloupec == 3) {
                sloupec = 0;
                radek++;
            }
        }

        System.out.println("Sachovnice:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("+--------------------+");
                if (j < 2) {
                    System.out.print("    ");
                }
            }
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.printf("| %-18s |", pole[i][j]);
                if (j < 2) {
                    System.out.print("    ");
                }
            }
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print("+--------------------+");
                if (j < 2) {
                    System.out.print("    ");
                }
            }
            if (i < 2) {
                System.out.println("\n");
            }
        }
    }

    // vraci true, pokud je v mistnosti nepritel
    public static boolean nepritelVmistnosti(ArrayList<Pritel> seznamPratel, int cisloMistnosti) {
        boolean jeNepritelVMistnosti = false;
        String seznamNepritelu = " ";
        for (int i = 0; i < seznamPratel.size(); i++) {
            if (seznamPratel.get(i).getCisloMistnosti() == cisloMistnosti  && seznamPratel.get(i).isJeNepritel()) {
                jeNepritelVMistnosti = true;
                seznamNepritelu += seznamPratel.get(i).getJmeno() + " ";
            }
        }
        if (jeNepritelVMistnosti) {
            System.out.println("V mistnosti jsou nepřátelé: " + seznamNepritelu);
            return true;
        } else {
            return false;
        }
    }

    //prevadi 0 a 1 z textoveho souboru na true a false
    public static boolean prevedStringNaBoolean(String hodnota){
        if (hodnota.equals("1")) {
            return true;
        } else return false;
    }
}
