package hr.java.vezbe.entitet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Glavna {

    public static void main(String[] args) {


        ArrayList<ObrazovnaUstanova> listaObrazovnih = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite broj obrazovnih ustanova: ");
        int brojU = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < brojU; i++) {
            System.out.println("Unesite podatke za " + (i + 1) + ". obrazovnu ustanovu: ");

            ArrayList<Profesor> profesoriPoUstanovi = unosProfesora(scanner);
            ArrayList<Predmet> predmetiPoUstanovi = unosPredmeta(scanner, profesoriPoUstanovi);
            ArrayList<Student> studentiPoUstanovi = unosStudenta(scanner);
            ArrayList<Ispit> ispitiPoUstanovi = unosIspita(scanner, predmetiPoUstanovi, studentiPoUstanovi);

            System.out.println("Odaberite obrazovnu ustanovu za navedene podatke koju zelite uneti: " + '\n' +
                    "1 - Veleuciliste jave" + '\n' +
                    "2 - Fakultet racunarstva: ");

            int odabir = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Unesite naziv obrazovne ustanove: ");
            String naziv = scanner.nextLine();

            if (odabir == 1) {
                VeleucilisteJave vj = new VeleucilisteJave(naziv, predmetiPoUstanovi, profesoriPoUstanovi, studentiPoUstanovi, ispitiPoUstanovi);
                listaObrazovnih.add(vj);
                for (int j = 0; j < studentiPoUstanovi.size(); j++) {
                    System.out.print("Unesite ocenu zavrsnog rada za studenta " + studentiPoUstanovi.get(j) + ": ");
                    int ocenaZavrsnog = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Unesite ocenu odbrane zavrsnog rada za studenta " + studentiPoUstanovi.get(j) + ": ");
                    int ocenaOdbrane = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Konacna ocena studija za studenta " + studentiPoUstanovi.get(j) + " je " + vj.izracunajKonacnuOcenuStudijaZaStudenta(ispitiPoUstanovi, ocenaZavrsnog, ocenaOdbrane));


                }
                Student najbolji = vj.odrediNajuspesnijegStudentaNaGodini(2018);
                System.out.println("Najbolji student u 2018. godini je " + vj.odrediNajuspesnijegStudentaNaGodini(2018) + " JMBG: " + najbolji.getJmbg());

            }
            if (odabir == 2) {
                FakultetRacunarstva fr = new FakultetRacunarstva(naziv, predmetiPoUstanovi, profesoriPoUstanovi, studentiPoUstanovi, ispitiPoUstanovi);
                listaObrazovnih.add(fr);
                for (int j = 0; j < studentiPoUstanovi.size(); j++) {
                    System.out.print("Unesite ocenu zavrsnog rada za studenta " + studentiPoUstanovi.get(j) + ": ");
                    int ocenaZavrsnog = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Unesite ocenu odbrane zavrsnog rada za studenta " + studentiPoUstanovi.get(j) + ": ");
                    int ocenaOdbrane = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Konacna ocena studija za studenta " + studentiPoUstanovi.get(j) + " je " + fr.izracunajKonacnuOcenuStudijaZaStudenta(ispitiPoUstanovi, ocenaZavrsnog, ocenaOdbrane));
                }
            }
        }
    }

    public static String ocena(int ocena) {
        if (ocena >= 1 && ocena <= 5) {
            if (ocena == 1) {
                return "nedovoljan";
            }
            if (ocena == 2) {
                return "dovoljan";
            }
            if (ocena == 3) {
                return "dobar";
            }
            if (ocena == 4) {
                return "vrlo dobar";
            }
        }
        return "odlican";
    }
    public static ArrayList<Profesor> unosProfesora(Scanner scanner) {

        ArrayList<Profesor> profesoriPoUstanovi = new ArrayList<>();

        for (int j = 0; j < 2; j++) {
            System.out.print("Unesite " + (j + 1) + ". profesora: ");
            System.out.println("");

            System.out.print("Unesite sifru profesora: ");
            String sifra = scanner.nextLine();

            System.out.print("Unesite ime profesora: ");
            String ime = scanner.nextLine();

            System.out.print("Unesite prezime profesora: ");
            String prezime = scanner.nextLine();

            System.out.print("Unesite titulu profesora: ");
            String titula = scanner.nextLine();

            Profesor profesor = new Profesor(sifra, ime, prezime, titula);
            profesoriPoUstanovi.add(profesor);

        }
        return profesoriPoUstanovi;
    }
    public static ArrayList<Predmet> unosPredmeta(Scanner scanner, ArrayList<Profesor> profesoriPoUstanovi){

        ArrayList<Predmet> predmetiPoUstanovi = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Unesite " + (i + 1) + ". predmet: ");
            System.out.print("Unesite sifru predmeta: ");
            String sifra = scanner.nextLine();

            System.out.print("Unesite naziv predmeta: ");
            String naziv = scanner.nextLine();

            System.out.print("Unesite broj ECTS bodova za predmet " + naziv + ": ");
            int broj = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Odaberite profesora: ");
            for (int j = 0; j < profesoriPoUstanovi.size(); j++) {
                System.out.println((j + 1) + ". " + profesoriPoUstanovi.get(j));

            }
            int odabir = scanner.nextInt();

            Profesor profesor = profesoriPoUstanovi.get(odabir - 1);
            System.out.println("Odabir >> " + odabir);
            System.out.print("Unesite broj studenata za predmet " + naziv + ": ");
            int brojStudenata = scanner.nextInt();
            scanner.nextLine();
            Student[] studenti = new Student[broj];
            Predmet predmet = new Predmet(sifra, naziv, brojStudenata, profesor, studenti);
            predmetiPoUstanovi.add(predmet);


        }
        return predmetiPoUstanovi;
    }
    public static ArrayList<Student> unosStudenta(Scanner scanner) {

        ArrayList<Student> studentiPoUstanovi = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Unesite " + (i + 1) + ". studenta: ");
            System.out.print("Unesite ime studenta: ");
            String ime = scanner.nextLine();

            System.out.print("Unesite prezime studenta: ");
            String prezime = scanner.nextLine();

            System.out.print("Unesite datum rodjenja studenta " + ime + " " + prezime + " u formatu (dd.MM.yyyy): ");
            String datumRodjenja = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate datum = LocalDate.parse(datumRodjenja, formatter);

            System.out.print("Unesite JMBG studenta " + ime + " " + prezime + " : ");
            String jmbg = scanner.nextLine();

            Student student = new Student(ime, prezime, jmbg, datum);
            studentiPoUstanovi.add(student);


        }
        return studentiPoUstanovi;
    }
    public static ArrayList<Ispit> unosIspita(Scanner scanner, ArrayList<Predmet> predmetiPoUstanovi, ArrayList<Student> studentiPoUstanovi) {

        ArrayList<Ispit> ispitiPoUstanovi = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Unesite " + (i + 1) + ". ispitni rok ");
            System.out.println("Odaberite predmet");
            for (int j = 0; j < predmetiPoUstanovi.size(); j++) {
                System.out.println((j + 1) + ". " + predmetiPoUstanovi.get(j));

            }
            int odabirPredmeta = scanner.nextInt();
            System.out.println("Odabir >>" + odabirPredmeta);
            Predmet predmet = predmetiPoUstanovi.get(odabirPredmeta - 1);
            System.out.println("Odaberite studenta: ");
            for (int j = 0; j < studentiPoUstanovi.size(); j++) {
                System.out.println((j + 1) + ". " + studentiPoUstanovi.get(j));
            }
            int odabirStudenta = scanner.nextInt();
            Student student = studentiPoUstanovi.get(odabirStudenta - 1);
            System.out.println("Odabir >> " + odabirStudenta);

            System.out.print("Unesite ocenu na ispitu (1-5): ");
            int ocena = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Unesite datum i vreme ispita u formatu (dd.MM.yyyy.THH:mm): ");
            String datumIvreme = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.'T'HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(datumIvreme, formatter);
            Ispit ispit = new Ispit(predmet, student, ocena, dateTime);
            ispitiPoUstanovi.add(ispit);
            System.out.println("Student " + student + " je ostvario ocenu " + ocena(ocena) + " na predmetu " + predmet);

        }
        return ispitiPoUstanovi;
    }
}

