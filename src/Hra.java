import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hra implements ActionListener {

    static boolean zadanPrikaz = false;
    static GUI gui;
    static Hrac hrac;
    static ArrayList<Mistnosti> herniMapa;
    static Batoh batoh;
    static ArrayList<Veci> seznamVeci;
    static ArrayList<Pritel> seznamPratel;

    public  boolean isZadanPrikaz() {
        return zadanPrikaz;
    }

    public static void HerniTah(){
        gui.getZadanyPrikaz();
        System.out.print("zadan prikaz: "+gui.getZadanyPrikaz());

    }

    public static void Hra() throws Exception {
        hrac = new Hrac("Albert", "Rychlik", 4, 100);
        seznamVeci = new ArrayList<>();
        batoh = new Batoh();
        seznamPratel = new ArrayList<>();
        Scanner scaner = new Scanner(System.in);
        String[] nacteniPolozky;
        herniMapa = new ArrayList<>();
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
        seznamVeci.add(new LecivyPredmet("Krev", "",true,1,20));
        seznamVeci.add(new Veci("Poklad","",true, 8,20,0));
        seznamPratel.add(new Pritel("Houba", "", true, false, 1, 110));

        gui = new GUI(herniMapa.get(0).getJmeno(), herniMapa.get(1).getJmeno(), herniMapa.get(2).getJmeno(), herniMapa.get(3).getJmeno(), herniMapa.get(4).getJmeno(), herniMapa.get(5).getJmeno(), herniMapa.get(6).getJmeno(), herniMapa.get(7).getJmeno(), herniMapa.get(8).getJmeno());
        zobrazSachovnici(herniMapa);
    }

    /**
     * Použije předmět z batohu na hráče.
     *
     * @param batoh Batoh obsahující předměty, které lze použít
     * @param hrac Hráč, na kterého bude předmět použit
     * @param jmeno Jméno předmětu, který má být použit
     */

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

    /**
     * Zobrazí herní svět ve formě šachovnice.
     *
     * @param herniMapa Seznam místností herní mapy
     */

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

    /**
     * Převede textovou hodnotu na boolean hodnotu.
     *
     * @param hodnota Textová hodnota, která má být převedena na boolean
     * @return true, pokud je vstupní hodnota "1", jinak false
     */
    //prevadi 0 a 1 z textoveho souboru na true a false
    public static boolean prevedStringNaBoolean(String hodnota){
        if (hodnota.equals("1")) {
            return true;
        } else return false;
    }

    /**
     * Vypíše obsah místnosti, včetně předmětů a přátel, které hráč může potkat.
     * Pokud hráč narazí na nepřítele, je mu nabídnuta možnost útoku.
     *
     * @param veci    Seznam věcí ve hře
     * @param pratele Seznam přátel ve hře
     * @param hrac    Instance hráče
     * @param scanner Scanner pro načítání vstupu od hráče
     */
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

    /**
     * Vrátí textový seznam obsahu místnosti na základě zadaného seznamu věcí.
     *
     * @param veci Seznam věcí ve hře
     * @return Textový seznam obsahu místnosti
     */

    public static String getObsahMistnosti(ArrayList<Veci> veci) {

        String txtSeznam="";
        for (Veci vec : veci) {
            if (vec.getCisloMistnosti() == hrac.getvJakejeMistnosti()) {
                System.out.println("V místnosti se nachází " + vec.getJmeno());
                txtSeznam = txtSeznam + vec.getJmeno() + "\n";
            }
        }
        return txtSeznam;
    }

    /**
     * Obsluhuje události akcí vyvolané uživatelem, jako je stisknutí tlačítka.
     *
     * @param e Událost akce, která byla vyvolána
     */

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        zadanPrikaz = true; // pushed submit button
        //System.out.println("Zadan prikaz!"+zadanPrikaz);
        //System.out.print("zadan prikaz: "+gui.getZadanyPrikaz());

        //Game move
        switch (gui.getZadanyPrikaz()) {
            case "sever":
                if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 1 || hrac.getvJakejeMistnosti() == 2) {
                    gui.setInfoText("Vylezl jsi mimo mapu");
                } else {
                    if (herniMapa.get(hrac.getvJakejeMistnosti()).isSever()) {
                        hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 3);
                        gui.setInfoText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setMistnostText(herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setTaMistnostText(getObsahMistnosti(seznamVeci));
                        //vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                        //gui.setInfoText(getObsahMistnosti(seznamVeci));

                    } else {
                        gui.setInfoText("Nemůžeš jít nahoru");
                    }
                }
                break;
            case "jih":
                if (hrac.getvJakejeMistnosti() == 6 || hrac.getvJakejeMistnosti() == 7 || hrac.getvJakejeMistnosti() == 8) {
                    gui.setInfoText("Vylezl jsi mimo mapu");
                } else {
                    if (herniMapa.get(hrac.getvJakejeMistnosti()).isJich()) {
                        hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 3);
                        gui.setMistnostText(herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setInfoText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setTaMistnostText(getObsahMistnosti(seznamVeci));
                        //vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                    } else {
                        gui.setInfoText("Nemůžeš jít dolů");
                    }
                }
                break;
            case "vychod":
                if (hrac.getvJakejeMistnosti() == 0 || hrac.getvJakejeMistnosti() == 3 || hrac.getvJakejeMistnosti() == 6) {
                    gui.setInfoText("Vylezl jsi mimo mapu");
                } else {
                    if (herniMapa.get(hrac.getvJakejeMistnosti()).isVychod()) {
                        hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() - 1);
                        gui.setMistnostText(herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setInfoText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setTaMistnostText(getObsahMistnosti(seznamVeci));
                        //vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                    } else {
                        gui.setInfoText("Nemůžeš jít východně");
                    }
                }
                break;
            case "zapad":
                if (hrac.getvJakejeMistnosti() == 2 || hrac.getvJakejeMistnosti() == 5 || hrac.getvJakejeMistnosti() == 8) {
                    gui.setInfoText("Vylezl jsi mimo mapu");
                } else {
                    if (herniMapa.get(hrac.getvJakejeMistnosti()).isZapad()) {
                        hrac.setvJakejeMistnosti(hrac.getvJakejeMistnosti() + 1);
                        gui.setMistnostText(herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setInfoText("Přešel jsi do místnosti " + herniMapa.get(hrac.getvJakejeMistnosti()).getJmeno());
                        gui.setTaMistnostText(getObsahMistnosti(seznamVeci));
                        //vypisObsahMistnosti(seznamVeci, seznamPratel, hrac, scaner);
                    } else {
                        gui.setInfoText("Nemůžeš jít západně");
                    }
                }
                break;
            case "zvedni":
                gui.setInfoText("Zadej jmeno objektu co chces zvednout:");


                break;
            case "vypit":
                gui.setInfoText("Zadej název předmětu, který chceš vypít:");

                //pouzitPredmet(batoh, hrac, predmet);
                hrac.zobrazZivoty(); // Zde přidáme volání metody pro zobrazení životů hráče po vypití předmětu
                break;
            default:
                gui.setInfoText("Neplatný prikaz.");

        }
        if (hrac.getZivoty() <= 0) {
            gui.setInfoText("Byl jsi zabit! Hra končí.");
            return;
        }
    }
}