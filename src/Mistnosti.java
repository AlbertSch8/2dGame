public class Mistnosti {

    private String jmeno;

    boolean sever;
    boolean jich;
    boolean vychod;
    boolean zapad;

    /**
     * Konstruktor pro vytvoření instance třídy Mistnosti.
     *
     * @param jmeno Jméno místnosti.
     * @param sever Určuje, zda je možné se pohybovat směrem na sever.
     * @param jich Určuje, zda je možné se pohybovat směrem na jih.
     * @param vychod Určuje, zda je možné se pohybovat směrem na východ.
     * @param zapad Určuje, zda je možné se pohybovat směrem na západ.
     */

    public Mistnosti(String jmeno, boolean sever, boolean jich, boolean vychod, boolean zapad) {
        this.jmeno = jmeno;
        this.sever = sever;
        this.jich = jich;
        this.vychod = vychod;
        this.zapad = zapad;
    }

    /**
     * Vrací jméno místnosti.
     *
     * @return Jméno místnosti.
     */

    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastavuje jméno místnosti.
     *
     * @param jmeno Nové jméno místnosti.
     */

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrací informaci, zda je možné se z místnosti pohybovat směrem na sever.
     *
     * @return True, pokud je možné se pohybovat na sever, jinak false.
     */

    public boolean isSever() {
        return sever;
    }

    /**
     * Nastavuje, zda je možné se z místnosti pohybovat směrem na sever.
     *
     * @param sever Nová hodnota indikující, zda je možné se pohybovat na sever.
     */

    public void setSever(boolean sever) {
        this.sever = sever;
    }

    /**
     * Vrací informaci, zda je možné se z místnosti pohybovat směrem na jih.
     *
     * @return True, pokud je možné se pohybovat na jih, jinak false.
     */

    public boolean isJich() {
        return jich;
    }

    /**
     * Nastavuje, zda je možné se z místnosti pohybovat směrem na jih.
     *
     * @param jich Nová hodnota indikující, zda je možné se pohybovat na jih.
     */

    public void setJich(boolean jich) {
        this.jich = jich;
    }

    /**
     * Vrací informaci, zda je možné se z místnosti pohybovat směrem na východ.
     *
     * @return True, pokud je možné se pohybovat na východ, jinak false.
     */

    public boolean isVychod() {
        return vychod;
    }

    /**
     * Nastavuje, zda je možné se z místnosti pohybovat směrem na východ.
     *
     * @param vychod Nová hodnota indikující, zda je možné se pohybovat na východ.
     */

    public void setVychod(boolean vychod) {
        this.vychod = vychod;
    }

    /**
     * Vrací informaci, zda je možné se z místnosti pohybovat směrem na západ.
     *
     * @return True, pokud je možné se pohybovat na západ, jinak false.
     */

    public boolean isZapad() {
        return zapad;
    }

    /**
     * Nastavuje, zda je možné se z místnosti pohybovat směrem na západ.
     *
     * @param zapad Nová hodnota indikující, zda je možné se pohybovat na západ.
     */

    public void setZapad(boolean zapad) {
        this.zapad = zapad;
    }

}
