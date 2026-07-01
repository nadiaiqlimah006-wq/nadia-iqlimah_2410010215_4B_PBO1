package sistempanitiakonser;

// ======================================================
// FILE: Person.java
// Poin: Class(1), Object(2), Atribut(3), Constructor(4),
//       Mutator(5), Accessor(6), Encapsulation(7),
//       Inheritance(8), Polymorphism(9)
// ======================================================

// === POIN 1: CLASS | POIN 7: ENCAPSULATION ===
public class Person {

    // === POIN 3: ATRIBUT (private = encapsulation) ===
    private String nama;
    private String id;
    private String peran;
    private boolean sudahHadir;

    // === POIN 4: CONSTRUCTOR ===
    public Person(String nama, String id, String peran) {
        this.nama       = nama;
        this.id         = id;
        this.peran      = peran;
        this.sudahHadir = false;
    }

    // === POIN 6: ACCESSOR (Getter) ===
    public String getNama()       { return nama;       }
    public String getId()         { return id;         }
    public String getPeran()      { return peran;      }
    public boolean isSudahHadir() { return sudahHadir; }

    // === POIN 5: MUTATOR (Setter) ===
    public void setNama(String nama)         { this.nama       = nama;  }
    public void setId(String id)             { this.id         = id;    }
    public void setPeran(String peran)       { this.peran      = peran; }
    public void setSudahHadir(boolean hadir) { this.sudahHadir = hadir; }

    // === POIN 9: POLYMORPHISM - di-override subclass ===
    public String getTugas() {
        return "Tugas umum anggota konser";
    }

    public void tampilInfo() {
        System.out.println("------------------------------");
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Peran  : " + peran);
        System.out.println("Tugas  : " + getTugas());
        System.out.println("Hadir  : " + (sudahHadir ? "Sudah" : "Belum"));
    }
}


// === POIN 8: INHERITANCE - CrewTeknis extends Person ===
class CrewTeknis extends Person {

    private String keahlian;

    public CrewTeknis(String nama, String id, String keahlian) {
        super(nama, id, "Crew Teknis");
        this.keahlian = keahlian;
    }

    public String getKeahlian()              { return keahlian; }
    public void setKeahlian(String keahlian) { this.keahlian = keahlian; }

    // === POIN 9: POLYMORPHISM - override ===
    @Override
    public String getTugas() {
        return "Menangani " + keahlian + " di area panggung";
    }
}


// === POIN 8: INHERITANCE - CrewKeamanan extends Person ===
class CrewKeamanan extends Person {

    private String posisiJaga;

    public CrewKeamanan(String nama, String id, String posisiJaga) {
        super(nama, id, "Crew Keamanan");
        this.posisiJaga = posisiJaga;
    }

    public String getPosisiJaga()                { return posisiJaga; }
    public void setPosisiJaga(String posisiJaga) { this.posisiJaga = posisiJaga; }

    // === POIN 9: POLYMORPHISM - override ===
    @Override
    public String getTugas() {
        return "Menjaga keamanan di pos: " + posisiJaga;
    }
}