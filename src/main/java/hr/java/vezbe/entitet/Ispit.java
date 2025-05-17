package hr.java.vezbe.entitet;

import java.time.LocalDateTime;

public class Ispit {

    private Predmet predmet;
    private Student student;
    private int ocena;
    private LocalDateTime datumIVreme;

    public Ispit(Predmet predmet, Student student, int ocena, LocalDateTime datumIVreme) {
        this.predmet = predmet;
        this.student = student;
        this.ocena = ocena;
        this.datumIVreme = datumIVreme;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public Student getStudent() {
        return student;
    }

    public int getOcena() {
        return ocena;
    }

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }
    public String toString(){
        return getPredmet() + ", " + getStudent() + ", " +getOcena() + ", " + getDatumIVreme();
    }
}
