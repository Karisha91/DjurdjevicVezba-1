package hr.java.vezbe.entitet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FakultetRacunarstva extends ObrazovnaUstanova implements Diplomski {

    public FakultetRacunarstva(String nazivUstanove, ArrayList<Predmet> predmeti, ArrayList<Profesor> profesori, ArrayList<Student> studenti, ArrayList<Ispit> ispiti) {
        super(nazivUstanove, predmeti, profesori, studenti, ispiti);
    }

    @Override
    public Student odrediStudentaZaRektorovuNagradu() {
        Student rektorovS = null;
        double prosekNajveci = 0;
        for (Student student : super.getStudenti()) {
            ArrayList<Ispit> listaIspita = filtrirajIspitePoStudentu(super.getIspiti(), student);
            BigDecimal prosekStudenta = odrediProsekOceneNaIspitima(listaIspita);
            if (prosekStudenta.doubleValue() > prosekNajveci) {
                prosekNajveci = prosekStudenta.doubleValue();
                rektorovS = student;
            }

        }
        return rektorovS;
    }

    @Override
    public Student odrediNajuspesnijegStudentaNaGodini(int godina) {
        Student najbolji = null;
        int najvisePetica = 0;
        LocalDate najmladjiDatum = null;
        for (Student student : super.getStudenti()) {
            ArrayList<Ispit> ispitiPoStudentu = filtrirajIspitePoStudentu(super.getIspiti(), student);
            int brojPetica = 0;
            for (Ispit ispit: ispitiPoStudentu) {
                if (ispit.getOcena() == 5) {
                    brojPetica++;
                }
                if (brojPetica > najvisePetica) {
                    najvisePetica = brojPetica;
                    najbolji = student;
                    najmladjiDatum = student.getDatumRodjenja();
                }
                else if (brojPetica == najvisePetica) {
                    if (student.getDatumRodjenja().isAfter(najmladjiDatum)) {
                        najbolji = student;
                        najmladjiDatum = student.getDatumRodjenja();
                    }

                }

            }

        }
        return najbolji;
    }


    @Override
    public BigDecimal izracunajKonacnuOcenuStudijaZaStudenta(ArrayList<Ispit> listaIspita, int ocenaDiplomskogRada, int ocenaOdbraneDiplomskogRada) {

        BigDecimal polozeni = odrediProsekOceneNaIspitima(listaIspita);
        BigDecimal tri = new BigDecimal(3);
        BigDecimal pet = new BigDecimal(5);
        BigDecimal ocenaDR = new BigDecimal(ocenaDiplomskogRada);
        BigDecimal ocenaODR = new BigDecimal(ocenaOdbraneDiplomskogRada);
        BigDecimal konacna = ((tri.multiply(polozeni)).add(ocenaDR).add(ocenaODR)).divide(pet);

        return konacna;
        // konacna ocena = (3* prosek ocena + ocenaDiplomskogRada + ocenaOdbraneDiplomskogRada)/5
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
    public ArrayList<Ispit> filtrirajPolozeneIspite(ArrayList<Ispit> listaIspita) {
        ArrayList<Ispit> polozeni = new ArrayList<>();
        for (Ispit ispit: listaIspita) {
            if (ispit.getOcena() > 1) {
                polozeni.add(ispit);
            }

        }
        return polozeni;
    }

    @Override
    public ArrayList<Ispit> filtrirajIspitePoStudentu(ArrayList<Ispit> listaIspita, Student student) {
        ArrayList<Ispit> listaIspitaPoStudentu = new ArrayList<>();
        for (Ispit ispit: listaIspita) {
            if (ispit.getStudent().getJmbg().equals(student.getJmbg())) {
                listaIspitaPoStudentu.add(ispit);

            }

        }
        return listaIspitaPoStudentu;
    }

}
