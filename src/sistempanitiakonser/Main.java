package sistempanitiakonser;


import java.util.Scanner;
import java.util.InputMismatchException; // Tambahkan import ini

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // === POIN 2: OBJECT ===
        Konser konser = new Konser(
            "Soundwave Festival 2025",
            "29 Juni 2025",
            "GBK Jakarta"
        );

        // Data awal
        try {
            konser.tambahCrew(new Person("Andi Saputra",      "P001", "Koordinator"));
            konser.tambahCrew(new CrewTeknis("Budi Santoso",  "T001", "Sound System"));
            konser.tambahCrew(new CrewTeknis("Citra Dewi",    "T002", "Lighting"));
            konser.tambahCrew(new CrewKeamanan("Doni Firman", "K001", "Pintu Masuk"));
            konser.tambahCrew(new CrewKeamanan("Eka Putri",   "K002", "Area Panggung"));
        } catch (KapasitasPenuhException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === POIN 11: PERULANGAN - menu utama ===
        boolean jalan = true;
        while (jalan) {

            // === POIN 12: IO ===
            System.out.println("\n==============================");
            System.out.println("  SISTEM PANITIA KONSER");
            System.out.println("  " + konser.getNamaKonser());
            System.out.println("==============================");
            System.out.println("1. Tampil Semua Crew");
            System.out.println("2. Tambah Crew Baru");
            System.out.println("3. Cari Crew by ID");
            System.out.println("4. Rekap Kehadiran");
            System.out.println("5. Update Info Konser");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = -1; // Set default nilai pilihan

            // === PERBAIKAN: Menangani input selain angka ===
            try {
                pilihan = sc.nextInt();
                sc.nextLine(); // bersihkan buffer enter
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input tidak valid! Harap masukkan angka.");
                sc.nextLine(); // bersihkan input huruf yang nyangkut di scanner
                continue; // kembali ke awal perulangan while
            }

            // === POIN 10: SELEKSI ===
            switch (pilihan) {

                case 1:
                    konser.tampilSemuaCrew();
                    break;

                case 2:
                    // === POIN 14: ERROR HANDLING ===
                    try {
                        Person crewBaru = Konser.inputCrewBaru(sc);
                        konser.tambahCrew(crewBaru);
                    } catch (KapasitasPenuhException e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Crew: ");
                    String idCari = sc.nextLine();
                    try {
                        Person hasil = konser.cariCrewById(idCari);
                        System.out.println("\nCrew ditemukan:");
                        hasil.tampilInfo();
                    } catch (CrewTidakDitemukanException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    konser.rekap();
                    break;

                case 5:
                    System.out.print("Nama Konser Baru : ");
                    String namaBaru  = sc.nextLine();
                    System.out.print("Venue Baru       : ");
                    String venueBaru = sc.nextLine();
                    konser.setNamaKonser(namaBaru);
                    konser.setVenue(venueBaru);
                    System.out.println("Info konser berhasil diperbarui.");
                    break;

                case 0:
                    System.out.println("Program selesai. Sampai jumpa!");
                    jalan = false;
                    break;

                default:
                    System.out.println("\nPilihan tidak valid! Pilih angka 0-5.");
            }
        }

        sc.close();
    }
}