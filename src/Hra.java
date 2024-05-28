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
                 herniMapa.add(new Mistnosti(nacteniPolozky[0], prevedStringNaBoolean(nacteniPolozky[1]), prevedStringNaBoolean(nacteniPolozky[2]), prevedStringNaBoolean(nacteniPolozky[3]), prevedStringNaBoolean(nacteniPolozky[4])));
             }
             GUI gui = new GUI("Divoka reka","Virivka","Sauna","Vnitrni bazen","Recepce","Bufet","Vnitrni tobogan","Sprchy","Vnejsi bazen");
             reader.close();
         } catch (FileNotFoundException e) {
             System.out.println("Soubor nenalezen");
         } catch (IOException e) {
             System.out.println("Soubor je poskozeny");
         } catch (Exception e) {
             System.out.println("Nekde je chyba");
         }

         seznamVeci.add(new Veci("Kokteil", "", true,4,20));
         seznamVeci.add(new Veci("Člun", "", true, 6,10));
         seznamVeci.add(new Veci("Kačenka", "", true, 2,30));
         seznamVeci.add(new Veci("Slunečník", "", false, 5, 10));

         seznamPratel.add(new Pritel("Plavcik", "", true, false, 1, 10));
         seznamPratel.add(new Pritel("Kuchar", "", true, false, 1, 20));
         seznamPratel.add(new Pritel("Krokodyl", "", false, true, 8, 30 ));

         zobrazSachovnici(herniMapa);
         System.out.println(" ");
         System.out.println("                ------Nachazite se v mistnosti recepce-----");
         System.out.println("Herni svet pocita s 3x3 mapou, ktera je na zacatku hry vykreslena");
         System.out.println("");
         System.out.println("----------------------------------------------------------------------");

         do {
             GUI gui = new GUI(herniMapa.get(0).getJmeno(),herniMapa.get(1).getJmeno(),herniMapa.get(2).getJmeno(),herniMapa.get(3).getJmeno(),herniMapa.get(4).getJmeno(),herniMapa.get(5).getJmeno(),herniMapa.get(6).getJmeno(),herniMapa.get(7).getJmeno(),herniMapa.get(8).getJmeno());
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
                             hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 3);
                             System.out.println("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                             vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                         } else {
                             System.out.println("Nemůžeš jít nahoru");
                         }
                     }
                     break;
                 case "jih":
                     if (hrac.getvJakejeMistnosti() == 6 || hrac.getvJakejeMistnosti() == 7 || hrac.getvJakejeMistnosti() == 8) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isJich()) {
                             hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 3);
                             System.out.println("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                             vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                         } else {
                             System.out.println("Nemůžeš jít dolů");
                         }
                     }
                     break;
                 case "vychod":
                     if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 3 || hrac.getvJakejeMistnosti() == 6) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isVychod()) {
                             hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 1);
                             System.out.println("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                             vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                         } else {
                             System.out.println("Nemůžeš jít východně");
                         }
                     }
                     break;
                 case "zapad":
                     if (hrac.getvJakejeMistnosti() == 2 || hrac.getvJakejeMistnosti() == 5 || hrac.getvJakejeMistnosti() == 8) {
                         System.out.println("Vylezl jsi mimo mapu");
                     } else {
                         if (herniMapa.get(hrac.getvJakejeMistnosti()).isZapad()) {
                             hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 1);
                             System.out.println("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                             vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                         } else {
                             System.out.println("Nemůžeš jít západně");
                         }
                     }
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
                 default:
                     System.out.println("Neplatný prikaz.");

             }
         } while (true);
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
            if (seznamPratel.get(i).getCisloMistnosti() == cisloMistnosti && seznamPratel.get(i).isJeNepritel()) {
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
    // vypisuje obsah mistnosti
    public static void vypisObsahMistnosti(ArrayList<Veci> seznamVeci, ArrayList<Pritel> seznamPratel, Hrac hrac, Scanner scanner) {
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

        if (nepritelVmistnosti(seznamPratel, hrac.getvJakejeMistnosti())) {
            Pritel nepritel = null;
            for (Pritel pritel : seznamPratel) {
                if (pritel.getCisloMistnosti() == hrac.getvJakejeMistnosti() && pritel.isJeNepritel()) {
                    nepritel = pritel;
                    break;
                }
            }
            if (nepritel != null) {
                System.out.println("V místnosti je nepřítel " + nepritel.getJmeno() + ". Chcete s ním bojovat? (ano/ne)");
                String odpoved = scanner.nextLine().toLowerCase();
                if (odpoved.equals("ano")) {
                    boolean vyhralHrac = nepritel.bojSNepritelem(scanner, hrac);
                    if (vyhralHrac) {
                        System.out.println("Gratuluji, vyhrál jsi!");
                    } else {
                        System.out.println("Bohužel, prohrál jsi.");
                    }
                } else if (odpoved.equals("ne")) {
                    System.out.println("Rozhodl jste se utéct, ale nebylo to dostatečně rychlé!");
                    hrac.ubratZivoty(30);
                    System.out.println("Hráč ztrácí 30 životů a zbývá mu " + hrac.getZivoty() + " životů.");
                } else {
                    System.out.println("Nerozumím, zopakujte prosím vaši odpověď.");
                }
            }
        }
    }
}
