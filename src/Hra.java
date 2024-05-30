import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hra {
    public static void SpustHru() throws Exception {
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
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
        } catch (IOException e) {
            System.out.println("Soubor je poskozeny");
        } catch (Exception e) {
            System.out.println("Nekde je chyba");
        }
        seznamPratel.add(new Pritel("Zombie", "", false, true, 8, 110));
        seznamPratel.add(new Pritel("Vlkodlak", "", false, true, 0, 50));
        seznamVeci.add(new LecivyPredmet("Oko", "", true, 6, 30));
        seznamVeci.add(new LecivyPredmet("krev", "",true,1,20));
        seznamVeci.add(new Veci("Poklad","",true, 8,20,0));

        GUI gui = new GUI(herniMapa.get(0).getJmeno(), herniMapa.get(1).getJmeno(), herniMapa.get(2).getJmeno(), herniMapa.get(3).getJmeno(), herniMapa.get(4).getJmeno(), herniMapa.get(5).getJmeno(), herniMapa.get(6).getJmeno(), herniMapa.get(7).getJmeno(), herniMapa.get(8).getJmeno());
        zobrazSachovnici(herniMapa);
        gui.settaText("\nPouzij tyhle pro prikazy pro hrani hry:" +
                "\n-Smery: sever, jih, vychod, zapad\n-zvedni a vypit\n------------------------------------");

        do {
            String prikaz = "";
            while (gui.isZmacknutetlacitko()) {
                prikaz = gui.getZadanyText();
                gui.settaText("----------------");
            }
            //Hlavni logika programu, ktera vyuziva ruzne objekty na zaklade spolecneho indexu v sachovnici
            switch (prikaz) {
                case "sever":
                    if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 1 || hrac.getvJakejeMistnosti() == 2) {
                        gui.settaText("Vylezl jsi mimo mapu");
                    } else {
                        if (herniMapa.get(hrac.getvJakejeMistnosti()).isSever()) {
                            hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 3);
                            gui.settaText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                            vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                        } else {
                            gui.settaText("Nemůžeš jít nahoru");
                        }
                    }
                    break;
                case "jih":
                    if (hrac.getvJakejeMistnosti() == 6 || hrac.getvJakejeMistnosti() == 7 || hrac.getvJakejeMistnosti() == 8) {
                        gui.settaText("Vylezl jsi mimo mapu");
                    } else {
                        if (herniMapa.get(hrac.getvJakejeMistnosti()).isJich()) {
                            hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 3);
                            gui.settaText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                            vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                        } else {
                            gui.settaText("Nemůžeš jít dolů");
                        }
                    }
                    break;
                case "vychod":
                    if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 3 || hrac.getvJakejeMistnosti() == 6) {
                        gui.settaText("Vylezl jsi mimo mapu");
                    } else {
                        if (herniMapa.get(hrac.getvJakejeMistnosti()).isVychod()) {
                            hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 1);
                            gui.settaText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                            vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                        } else {
                            gui.settaText("Nemůžeš jít východně");
                        }
                    }
                    break;
                case "zapad":
                    if (hrac.getvJakejeMistnosti() == 2 || hrac.getvJakejeMistnosti() == 5 || hrac.getvJakejeMistnosti() == 8) {
                         gui.settaText("Vylezl jsi mimo mapu");
                    } else {
                        if (herniMapa.get(hrac.getvJakejeMistnosti()).isZapad()) {
                            hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 1);
                            gui.settaText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                            vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                        } else {
                            gui.settaText("Nemůžeš jít západně");
                        }
                    }
                    break;
                case "zvedni":
                    gui.settaText("Zadej jmeno objektu co chces zvednout:");
                    String jmeno = scaner.nextLine();
                    for (int i = 0; i < seznamVeci.size(); i++) {
                        if (batoh.isJePlny()) {
                            gui.settaText("Mate plny batoh");
                        } else {
                            if (seznamVeci.get(i).getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                                if (seznamVeci.get(i).getJmeno().equals(jmeno)) {
                                    if (seznamVeci.get(i).isJeSebratelny()) {
                                        Veci v = seznamVeci.get(i);
                                        batoh.pridejDoBatohu(v);
                                        seznamVeci.remove(i);
                                        batoh.vypisObsah();
                                        if (v.getJmeno().equals("Poklad")) {
                                            gui.settaText("Sebral jsi poklad! Vyhrál jsi hru!");
                                            scaner.close();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "vypit":
                    gui.settaText("Zadej název předmětu, který chceš vypít:");
                    String predmet = scaner.nextLine();
                    pouzitPredmet(batoh, hrac, predmet);
                    hrac.zobrazZivoty(); // Zde přidáme volání metody pro zobrazení životů hráče po vypití předmětu
                    break;
                default:
                    gui.settaText("Neplatný prikaz.");

            }
            if (hrac.getZivoty() <= 0) {
                gui.settaText("Byl jsi zabit! Hra končí.");
                scaner.close();
                return;
            }
        } while (true);
    }
    public static void pouzitPredmet(Batoh batoh, Hrac hrac, String jmeno) {
        for (Veci vec : batoh.getBatoh()) {
            if (vec.getJmeno().equalsIgnoreCase(jmeno)) {
                if (vec instanceof LecivyPredmet) {
                    ((LecivyPredmet) vec).lecit(hrac);
                    System.out.println("Použil jsi " + jmeno + " a doplnil jsi 40 životů.");
                    hrac.zobrazZivoty(); // Zobrazuje celkový počet životů hráče po přidání životů z léčivého předmětu
                    batoh.odeberZBatohu(vec);
                    break;
                } else if (vec instanceof StitPredmet) {
                    ((StitPredmet) vec).aktivovatStit(hrac);
                    System.out.println("Použil jsi " + jmeno + " a doplnil jsi 50 životů.");
                    hrac.zobrazZivoty(); // Zobrazuje celkový počet životů hráče po přidání životů ze stitového předmětu
                    batoh.odeberZBatohu(vec);
                    break;
                } else {
                    // Přidání zdraví hráči na základě typu předmětu
                    hrac.pridatZivoty(vec.getPocetZivotu());
                    System.out.println("Použil jsi " + jmeno + " a doplnil jsi " + vec.getPocetZivotu() + " životů.");
                    hrac.zobrazZivoty(); // Zobrazuje celkový počet životů hráče po přidání životů z předmětu
                    batoh.odeberZBatohu(vec);
                    break;
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
    //prevadi 0 a 1 z textoveho souboru na true a false
    public static boolean prevedStringNaBoolean(String hodnota){
        if (hodnota.equals("1")) {
            return true;
        } else return false;
    }
    // vypisuje obsah mistnosti
    public static void vypisObsahMistnosti(ArrayList<Veci> veci, ArrayList<Pritel> pratele, Hrac hrac, Scanner scanner) {
        for (Veci vec : veci) {
            if (vec.getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                System.out.println("V místnosti se nachází " + vec.getJmeno());
            }
        }
        for (Pritel pritel : pratele) {
            if (pritel.getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                if (hrac.getvJakejeMistnosti() == 8) { // Speciální podmínka pro místnost 8
                    System.out.println("V místnosti je " + pritel.getJmeno() + ". Musíš ho porazit, než získáš poklad.");
                    System.out.println("Chceš zaútočit? (ano/ne)");
                    String odpoved = scanner.nextLine();
                    if (odpoved.equalsIgnoreCase("ano")) {
                        boolean vyhra = pritel.bojSNepritelem(scanner, hrac);
                        if (vyhra) {
                            System.out.println("Porazil jsi " + pritel.getJmeno() + "!");
                            pratele.remove(pritel);
                        } else {
                            System.out.println("Boj s " + pritel.getJmeno() + " skončil neúspěšně. Ztratil jsi hru.");
                            System.exit(0);
                        }
                        break;
                    } else {
                        hrac.setZivoty(hrac.getZivoty() - 30);
                        System.out.println("Utekl jsi a ztratil 30 životů. Aktuální životy: " + hrac.getZivoty());
                        if (hrac.getZivoty() <= 0) {
                            System.out.println("Byl jsi zabit! Hra končí.");
                            scanner.close();
                            System.exit(0);
                        }
                    }
                } else if (hrac.getvJakejeMistnosti() == 0) { // Speciální podmínka pro místnost 0
                    System.out.println("V místnosti je " + pritel.getJmeno() + ". Musíš ho porazit, než budeš moci pokračovat.");
                    System.out.println("Chceš zaútočit? (ano/ne)");
                    String odpoved = scanner.nextLine();
                    if (odpoved.equalsIgnoreCase("ano")) {
                        boolean vyhra = pritel.bojSNepritelem(scanner, hrac);
                        if (vyhra) {
                            System.out.println("Porazil jsi " + pritel.getJmeno() + "!");
                            pratele.remove(pritel);
                        } else {
                            System.out.println("Boj s " + pritel.getJmeno() + " skončil neúspěšně. Ztratil jsi hru.");
                            System.exit(0);
                        }
                        break;
                    } else {
                        hrac.setZivoty(hrac.getZivoty() - 30);
                        System.out.println("Utekl jsi a ztratil 30 životů. Aktuální životy: " + hrac.getZivoty());
                        if (hrac.getZivoty() <= 0) {
                            System.out.println("Byl jsi zabit! Hra končí.");
                            scanner.close();
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("V místnosti je " + pritel.getJmeno());
                }
            }
        }
    }
}
