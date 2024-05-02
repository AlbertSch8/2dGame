public class Mistnosti {

    private String jmeno;

    boolean sever;
    boolean jich;
    boolean vychod;
    boolean zapad;

    public Mistnosti(String jmeno, boolean sever, boolean jich, boolean vychod, boolean zapad) {
        this.jmeno = jmeno;
        this.sever = sever;
        this.jich = jich;
        this.vychod = vychod;
        this.zapad = zapad;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public boolean isSever() {
        return sever;
    }

    public void setSever(boolean sever) {
        this.sever = sever;
    }

    public boolean isJich() {
        return jich;
    }

    public void setJich(boolean jich) {
        this.jich = jich;
    }

    public boolean isVychod() {
        return vychod;
    }

    public void setVychod(boolean vychod) {
        this.vychod = vychod;
    }

    public boolean isZapad() {
        return zapad;
    }

    public void setZapad(boolean zapad) {
        this.zapad = zapad;
    }

}
