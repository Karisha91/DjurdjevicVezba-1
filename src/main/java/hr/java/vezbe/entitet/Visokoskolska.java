package hr.java.vezbe.entitet;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface Visokoskolska {

    BigDecimal izracunajKonacnuOcenuStudijaZaStudenta(ArrayList<Ispit> listaIspita, int ocena1, int ocena2);

    BigDecimal odrediProsekOceneNaIspitima(ArrayList<Ispit> listaIspita);

    ArrayList<Ispit> filtrirajPolozeneIspite(ArrayList<Ispit> listaIspita);

    ArrayList<Ispit> filtrirajIspitePoStudentu(ArrayList<Ispit> listaIspita, Student student);

}
