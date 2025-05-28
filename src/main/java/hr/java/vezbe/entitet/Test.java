package hr.java.vezbe.entitet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Profesor> listaProfesora = new ArrayList();
        ArrayList<Predmet> listaPredmeta = new ArrayList<>();
        ArrayList<Student> listaStudenata = new ArrayList<>();
        ArrayList<Ispit> listaIspita = new ArrayList<>();

        Profesor profesor1 = new Profesor("01","Marko", "Markovic","Legenda");
        Profesor profesor2 = new Profesor("02","Ranko", "Rankovic","Legenda");
        listaProfesora.add(profesor1);
        listaProfesora.add(profesor2);

        Student student1 = new Student("Ivan","Djurdjevic","0612991710294", LocalDate.of(1983, 06, 12));
        Student student2 = new Student("Ivana","Pavlovic","1010988715222", LocalDate.of(1988, 10, 10));
        listaStudenata.add(student1);
        listaStudenata.add(student2);

        Student[] studenti = new  Student[2];
        studenti[0] = student1;
        studenti[1] = student2;

        Predmet predmet1 = new Predmet("01","Java",2,profesor1,studenti);
        Predmet predmet2 = new Predmet("02","C#",2,profesor2,studenti);
        listaPredmeta.add(predmet1);
        listaPredmeta.add(predmet2);

        Ispit ispit1 = new Ispit(predmet1, student1, 5, LocalDateTime.of(2025,5, 6, 15, 30));
        Ispit ispit2 = new Ispit(predmet2, student2, 5, LocalDateTime.of(2025,5, 6, 15, 30));
        Ispit ispit3 = new Ispit(predmet1, student1, 5, LocalDateTime.of(2025,5, 6, 15, 30));
        Ispit ispit4 = new Ispit(predmet1, student2, 5, LocalDateTime.of(2025,5, 6, 15, 30));
        listaIspita.add(ispit1);
        listaIspita.add(ispit2);
        listaIspita.add(ispit3);
        listaIspita.add(ispit4);

        VeleucilisteJave vj = new VeleucilisteJave("Vele", listaPredmeta, listaProfesora, listaStudenata, listaIspita);
        System.out.println(vj.odrediProsekOceneNaIspitima(listaIspita));



    }
}
