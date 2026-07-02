# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi sistem manajemen crew dan panitia konser menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data diri panitia seperti nama, ID, divisi, dan daftar tugas (jobdesk) yang harus dikerjakan, lalu memberikan output berupa rincian penugasan dari masing-masing panitia atau crew konser secara terstruktur.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading/Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Person`, `ConcertCommittee`, dan `Main` adalah contoh dari class.

```java
public class Person {
    // ...
}

public class ConcertCommittee extends Person {
    // ...
}

public class Main {
    // ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `newCommittee` adalah contoh pembuatan object dari class `ConcertCommittee`.

```java
ConcertCommittee newCommittee = new ConcertCommittee(name, id, division, jobdeskList);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `name`, `id`, dan `division` adalah contoh atribut.

```java
private String name;
private String id;
private String division;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Person` dan `ConcertCommittee`.

```java
public Person(String name, String id, String role) {
    this.name = name;
    this.id = id;
    this.role = role;
}

public ConcertCommittee(String name, String id, String division, String[] jobdesk) {
    super(name, id, "Committee");
    this.division = division;
    this.jobdeskList = jobdesk;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setName` dan `setId` adalah contoh method mutator.

```java
public void setName(String name) {
    this.name = name;
}

public void setId(String id) {
    this.id = id;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getName` dan `getId` adalah contoh method accessor.

```java
public String getName() {
    return name;
}

public String getId() {
    return id;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `name`, `id`, dan `role` dienkapsulasi sehingga terlindungi dari modifikasi luar secara langsung.

```java
private String name;
private String id;
private String role;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `ConcertCommittee` mewarisi sifat dari `Person` dengan sintaks `extends`.

```java
public class ConcertCommittee extends Person {
    // ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Pada kode ini, method `showTask()` di `ConcertCommittee` merupakan bentuk dari *Method Overriding* yang menimpa method `showTask()` milik superclass `Person`.

```java
// Inside Person class
public void showTask() {
    System.out.println(name + " is a general concert staff.");
}

// Inside ConcertCommittee class
@Override
public void showTask() {
    System.out.println("=== Concert Committee Task ===");
    // ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if-else` dalam method mutator untuk memvalidasi apakah peran yang dimasukkan sesuai ketentuan.

```java
public void setRole(String role) {
    if (role.equalsIgnoreCase("Committee") || role.equalsIgnoreCase("Crew")) {
        this.role = role;
    } else {
        this.role = "General Staff";
    }
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` biasa untuk meminta input data array, dan `for-each` loop untuk menampilkannya.

```java
for (int i = 0; i < jobCount; i++) {
    System.out.print("Jobdesk " + (i + 1) + ": ");
    jobdeskList[i] = input.nextLine();
}

for (String task : jobdeskList) {
    System.out.println("- " + task);
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima data masukan lewat terminal dan method `System.out.println` untuk mencetak informasi ke layar.

```java
Scanner input = new Scanner(System.in);
System.out.print("Enter Committee Name: ");
String name = input.nextLine();

System.out.println("\nProcessing Data...");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai bertipe sama dalam satu variabel. Pada kode ini, array `jobdeskList` digunakan untuk menampung rentetan string tugas.

```java
String[] jobdeskList = new String[jobCount];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan blok `try-catch-finally` untuk memastikan program tidak crash (misalnya terkena Input Mismatch Exception) ketika pengguna tidak sengaja memasukkan huruf saat diminta memasukkan angka.

```java
try {
    // Code block for numeric input processing and instantiation
    int jobCount = input.nextInt();
} catch (Exception e) {
    System.out.println("\n[ERROR] Input data error! Ensure jobdesk count is a number.");
} finally {
    input.close();
    System.out.println("\n=== Program Finished ===");
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Nadia Iqlimah  
NPM: 2410010215
