package sistempanitiakonser;

// ======================================================
// FILE: Konser.java
// Poin: Seleksi(10), Perulangan(11), IO(12),
//       Array(13), Error Handling(14)
// ======================================================

import java.util.Scanner;

// === POIN 14: ERROR HANDLING - Custom Exception ===
class CrewTidakDitemukanException extends Exception {
    public CrewTidakDitemukanException(String pesan) {
        super(pesan);
    }
}

class KapasitasPenuhException extends Exception {
    public KapasitasPenuhException(String pesan) {
        super(pesan);
    }
}


// === POIN 1: CLASS Konser ===
public class Konser {

    // === POIN 3: ATRIBUT ===
    private String namaKonser;
    private String tanggal;
    private String venue;

    // === POIN 13: ARRAY ===
    private Person[] daftarCrew;
    private int jumlahCrew;
    private static final int KAPASITAS_MAKS = 10;

    // === POIN 4: CONSTRUCTOR ===
    public Konser(String namaKonser, String tanggal, String venue) {
        this.namaKonser = namaKonser;
        this.tanggal    = tanggal;
        this.venue      = venue;
        this.daftarCrew = new Person[KAPASITAS_MAKS];
        this.jumlahCrew = 0;
    }

    // === POIN 5: MUTATOR ===
    public void setNamaKonser(String namaKonser) { this.namaKonser = namaKonser; }
    public void setTanggal(String tanggal)       { this.tanggal    = tanggal;    }
    public void setVenue(String venue)           { this.venue      = venue;      }

    // === POIN 6: ACCESSOR ===
    public String getNamaKonser() { return namaKonser; }
    public String getTanggal()    { return tanggal;    }
    public String getVenue()      { return venue;      }
    public int getJumlahCrew()    { return jumlahCrew; }


    // === POIN 13: ARRAY + POIN 14: ERROR HANDLING + POIN 10: SELEKSI ===
    public void tambahCrew(Person crew) throws KapasitasPenuhException {
        try {
            if (jumlahCrew >= KAPASITAS_MAKS) {
                throw new KapasitasPenuhException(
                    "Kapasitas penuh! Maks " + KAPASITAS_MAKS + " crew."
                );
            }
            daftarCrew[jumlahCrew] = crew;
            jumlahCrew++;
            System.out.println("Crew '" + crew.getNama() + "' berhasil ditambahkan.");
        } catch (KapasitasPenuhException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // === POIN 11: PERULANGAN + POIN 10: SELEKSI + POIN 14: ERROR HANDLING ===
    public Person cariCrewById(String id) throws CrewTidakDitemukanException {
        for (int i = 0; i < jumlahCrew; i++) {
            if (daftarCrew[i].getId().equalsIgnoreCase(id)) {
                return daftarCrew[i];
            }
        }
        throw new CrewTidakDitemukanException(
            "Crew dengan ID '" + id + "' tidak ditemukan!"
        );
    }


    // === POIN 11: PERULANGAN + POIN 10: SELEKSI ===
    public void tampilSemuaCrew() {
        System.out.println("\n========================================");
        System.out.println(" KONSER  : " + namaKonser);
        System.out.println(" Venue   : " + venue);
        System.out.println(" Tanggal : " + tanggal);
        System.out.println("========================================");

        if (jumlahCrew == 0) {
            System.out.println("  Belum ada crew terdaftar.");
            return;
        }

        for (int i = 0; i < jumlahCrew; i++) {
            System.out.print("\n[" + (i + 1) + "]");
            daftarCrew[i].tampilInfo(); // polymorphism aktif!
        }
        System.out.println("------------------------------");
        System.out.println("Total Crew: " + jumlahCrew + "/" + KAPASITAS_MAKS);
    }


    // === POIN 11: PERULANGAN + POIN 10: SELEKSI ===
    public void rekap() {
        int hadir = 0;
        int belum = 0;
        for (int i = 0; i < jumlahCrew; i++) {
            if (daftarCrew[i].isSudahHadir()) hadir++;
            else belum++;
        }
        System.out.println("\n=== REKAP KEHADIRAN ===");
        System.out.println("Sudah Hadir : " + hadir + " orang");
        System.out.println("Belum Hadir : " + belum + " orang");
        System.out.println("Total       : " + jumlahCrew + " orang");
    }


    // === POIN 12: IO SEDERHANA ===
    public static Person inputCrewBaru(Scanner sc) {
        System.out.println("\n--- Tambah Crew Baru ---");
        System.out.println("1. Crew Umum");
        System.out.println("2. Crew Teknis");
        System.out.println("3. Crew Keamanan");
        System.out.print("Pilih tipe: ");
        int tipe = sc.nextInt();
        sc.nextLine();

        System.out.print("Nama : ");
        String nama = sc.nextLine();
        System.out.print("ID   : ");
        String id = sc.nextLine();

        if (tipe == 2) {
            System.out.print("Keahlian (Sound/Lighting/Stage): ");
            String keahlian = sc.nextLine();
            return new CrewTeknis(nama, id, keahlian);
        } else if (tipe == 3) {
            System.out.print("Posisi Jaga (Pintu/Panggung/Parkir): ");
            String posisi = sc.nextLine();
            return new CrewKeamanan(nama, id, posisi);
        } else {
            System.out.print("Divisi/Peran: ");
            String peran = sc.nextLine();
            return new Person(nama, id, peran);
        }
    }
}