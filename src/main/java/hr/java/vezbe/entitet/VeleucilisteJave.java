package hr.java.vezbe.entitet;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VeleucilisteJave extends ObrazovnaUstanova implements Visokoskolska{


    public VeleucilisteJave(String nazivUstanove, ArrayList<Predmet> listaPredmeta, ArrayList<Profesor> listaProfesora, ArrayList<Student> listaStudenata, ArrayList<Ispit> listaIspita){
        super(nazivUstanove,listaPredmeta,listaProfesora,listaStudenata,listaIspita);
    }

    @Override
    public Student odrediNajuspesnijegStudentaNaGodini(int godina) {
        Student najbolji = null;
        double najveciProsek = 0;
        for (Student student: super.getStudenti()) {
            ArrayList<Ispit> ispiti = filtrirajIspitePoStudentu(super.getIspiti(), student);
            Double prosek = odrediProsekOceneNaIspitima(ispiti).doubleValue();
            if (prosek > najveciProsek) {
                najveciProsek = prosek;
                najbolji = student;
            }
        }
        return najbolji;
    }

    @Override
    public BigDecimal izracunajKonacnuOcenuStudijaZaStudenta(ArrayList<Ispit> listaIspita,int ocenaZavrsnogRada, int ocenaOdbraneZavrsnogRada) {

        BigDecimal polozeni = odrediProsekOceneNaIspitima(listaIspita);
        BigDecimal dva = new BigDecimal(2);
        BigDecimal cetiri = new BigDecimal(4);
        BigDecimal ocenaZ = new BigDecimal(ocenaZavrsnogRada);
        BigDecimal ocenaO = new BigDecimal(ocenaOdbraneZavrsnogRada);
        BigDecimal konacna = ((dva.multiply(polozeni)).add(ocenaZ).add(ocenaO)).divide(cetiri);





        return konacna;
        // konacna ocena = (2* prosek ocena + ocenaZavrsnogRada + ocenaOdbraneZavrsnogRada)/4
    }

    @Override
    public BigDecimal odrediProsekOceneNaIspitima(ArrayList<Ispit> listaIspita) {
        ArrayList<Ispit> polozeni = filtrirajPolozeneIspite(listaIspita);
        int zbirPolozenih = 0;
        for (Ispit ispit : polozeni) {
            zbirPolozenih = zbirPolozenih + ispit.getOcena();

        }
        double prosecnaOcena = (double) zbirPolozenih / polozeni.size();
        return BigDecimal.valueOf(prosecnaOcena);
    }

    @Override
    public ArrayList<Ispit> filtrirajPolozeneIspite(ArrayList<Ispit> listaIspita){
        ArrayList<Ispit> polozeni = new ArrayList<>();
        for (Ispit ispit: listaIspita) {
            if (ispit.getOcena() > 1) {
                polozeni.add(ispit);
            }

        }
        return polozeni;
    }

    @Override
    public ArrayList<Ispit> filtrirajIspitePoStudentu(ArrayList<Ispit> listaIspita, Student student){
        ArrayList<Ispit> listaIspitaPoStudentu = new ArrayList<>();
        for (Ispit ispit: listaIspita) {
            if (ispit.getStudent().getJmbg().equals(student.getJmbg())) {
                listaIspitaPoStudentu.add(ispit);

            }

        }
        return listaIspitaPoStudentu;
    }
}
