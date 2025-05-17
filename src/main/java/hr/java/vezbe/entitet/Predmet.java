package hr.java.vezbe.entitet;

import java.util.Arrays;

public class Predmet {

    private String sifra;
    private String naziv;
    private int brojEctsBodova;
    private Profesor nositelj;
    private Student[] studenti;

    public Predmet(String sifra, String naziv, int brojEctsBodova, Profesor nositelj, Student[] studenti) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.brojEctsBodova = brojEctsBodova;
        this.nositelj = nositelj;
        this.studenti = studenti;
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrojEctsBodova() {
        return brojEctsBodova;
    }

    public Profesor getNositelj() {
        return nositelj;
    }

    public Student[] getStudenti() {
        return studenti;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setBrojEctsBodova(int brojEctsBodova) {
        this.brojEctsBodova = brojEctsBodova;
    }

    public void setNositelj(Profesor nositelj) {
        this.nositelj = nositelj;
    }

    public void setStudenti(Student[] studenti) {
        this.studenti = studenti;
    }
    public String toString(){
        return getNaziv();
    }
}
