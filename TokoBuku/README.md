# Sistem Manajemen Toko Buku
### UAS Pemrograman Berbasis Objek 1
**Nama:** [Muhammad Andiansyah]  
**NPM:** [2410010293]
**Kelas:** [4E]  

---

## Deskripsi Program

**Sistem Manajemen Toko Buku** adalah aplikasi berbasis konsol (CLI) yang dibuat menggunakan bahasa pemrograman Java dengan pendekatan Object-Oriented Programming (OOP). Program ini mensimulasikan pengelolaan data buku pada sebuah toko buku, mencakup fitur tambah, cari, update stok, hapus buku, dan kalkulasi nilai inventaris.

---

## Struktur Class

```
Buku (Parent Class)
├── BukuFiksi   (extends Buku)
└── BukuNonFiksi (extends Buku)

TokoBuku (Class pengelola data Array Buku)
Main     (Entry point / Program Utama)
```

---

## Fitur Program

| No | Fitur | Keterangan |
|----|-------|------------|
| 1  | Tampil Semua Buku | Menampilkan seluruh buku di toko |
| 2  | Tambah Buku Baru | Menambah buku fiksi atau non-fiksi |
| 3  | Cari Buku (ISBN) | Pencarian tepat berdasarkan ISBN |
| 4  | Cari Buku (Judul) | Pencarian parsial berdasarkan kata kunci judul |
| 5  | Update Stok Buku | Memperbarui jumlah stok buku |
| 6  | Hapus Buku | Menghapus buku dari daftar |
| 7  | Total Nilai Inventaris | Menghitung total nilai seluruh stok buku |

---

## Tabel Penilaian

| No | Materi | Nilai Maks | Implementasi dalam Program | Nilai |
|----|--------|:----------:|---------------------------|:-----:|
| 1  | **Class** | 5 | `Buku`, `BukuFiksi`, `BukuNonFiksi`, `TokoBuku`, `Main` — terdapat 5 class | 5 |
| 2  | **Object** | 5 | `TokoBuku toko = new TokoBuku(...)`, `new BukuFiksi(...)`, `new BukuNonFiksi(...)` | 5 |
| 3  | **Atribut** | 5 | `private String judul`, `pengarang`, `harga`, `stok`, `isbn`, `genre`, `bidangIlmu` | 5 |
| 4  | **Constructor** | 5 | Constructor default dan berparameter di class `Buku`; konstruktor di `BukuFiksi`, `BukuNonFiksi`, `TokoBuku` | 5 |
| 5  | **Mutator** | 5 | `setJudul()`, `setPengarang()`, `setHarga()`, `setStok()`, `setIsbn()`, `setGenre()`, `setBidangIlmu()` | 5 |
| 6  | **Accessor** | 5 | `getJudul()`, `getPengarang()`, `getHarga()`, `getStok()`, `getIsbn()`, `getGenre()`, `getBidangIlmu()` | 5 |
| 7  | **Encapsulation** | 5 | Semua atribut `private`, hanya bisa diakses melalui getter/setter | 5 |
| 8  | **Inheritance** | 5 | `BukuFiksi extends Buku`, `BukuNonFiksi extends Buku`, penggunaan `super()` | 5 |
| 9  | **Polymorphism** | 10 | Override `tampilInfo()` di `BukuFiksi` & `BukuNonFiksi`; Array `Buku[]` menyimpan objek subclass | 10 |
| 10 | **Seleksi** | 5 | `switch(pilihan)` di Main, `if-else` pada validasi input dan cek jenis buku | 5 |
| 11 | **Perulangan** | 5 | `while(running)` loop menu, `for` di `tampilSemuaBuku`, `cariBukuIsbn`, `cariBukuJudul`, dll. | 5 |
| 12 | **IO Sederhana** | 10 | `Scanner scanner = new Scanner(System.in)`, `System.out.println`, `System.out.printf` | 10 |
| 13 | **Array** | 15 | `Buku[] daftarBuku = new Buku[100]` di TokoBuku; Array hasil pencarian `Buku[] hasil` | 15 |
| 14 | **Error Handling** | 15 | `try-catch NumberFormatException` pada input angka, `catch IllegalArgumentException` untuk stok negatif | 15 |
| | **TOTAL** | **100** | | **100** |

---

## Penjelasan Konsep OOP dalam Program

### 1. Class
Lima class dibuat: `Buku` (parent), `BukuFiksi` (subclass), `BukuNonFiksi` (subclass), `TokoBuku` (manajer data), dan `Main` (program utama).

### 2. Object
Objek dibuat menggunakan keyword `new`:
```java
TokoBuku toko = new TokoBuku("Toko Buku Nusantara");
BukuFiksi bf  = new BukuFiksi("Laskar Pelangi", "Andrea Hirata", 85000, 15, "978-...", "Novel");
```

### 3. Atribut
Atribut didefinisikan sebagai variabel instance di dalam class:
```java
private String judul;
private String pengarang;
private double harga;
private int    stok;
private String isbn;
```

### 4. Constructor
```java
// Constructor default
public Buku() { this.judul = "Tidak Diketahui"; ... }

// Constructor berparameter
public Buku(String judul, String pengarang, double harga, int stok, String isbn) { ... }

// Subclass memanggil super()
public BukuFiksi(..., String genre) {
    super(judul, pengarang, harga, stok, isbn);
    this.genre = genre;
}
```

### 5. Mutator (Setter)
```java
public void setJudul(String judul)   { this.judul = judul; }
public void setHarga(double harga)   { this.harga = harga; }
```

### 6. Accessor (Getter)
```java
public String getJudul() { return judul; }
public double getHarga() { return harga; }
```

### 7. Encapsulation
Semua atribut bersifat `private`. Akses hanya melalui getter/setter, sehingga data terlindungi dari modifikasi langsung dari luar class.

### 8. Inheritance
```java
public class BukuFiksi extends Buku { ... }    // BukuFiksi mewarisi Buku
public class BukuNonFiksi extends Buku { ... } // BukuNonFiksi mewarisi Buku
```

### 9. Polymorphism
```java
// Override method tampilInfo() di setiap subclass
@Override
public String tampilInfo() {
    return "[FIKSI] " + super.tampilInfo() + " | Genre: " + genre;
}

// Array Buku[] menyimpan BukuFiksi dan BukuNonFiksi sekaligus
Buku[] daftarBuku = new Buku[100];
daftarBuku[0] = new BukuFiksi(...);     // Polymorphism
daftarBuku[1] = new BukuNonFiksi(...);  // Polymorphism
```

### 10. Seleksi
```java
switch (pilihan) {
    case 1 -> toko.tampilSemuaBuku();
    case 2 -> menuTambahBuku(toko);
    ...
}

if (jenis == 1) { /* Buku Fiksi */ } else { /* Buku Non-Fiksi */ }
```

### 11. Perulangan
```java
while (running) { /* loop menu utama */ }

for (int i = 0; i < jumlahBuku; i++) {
    System.out.println(daftarBuku[i].tampilInfo());
}
```

### 12. IO Sederhana
```java
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();         // Membaca input
System.out.println("Teks output");         // Menampilkan output
System.out.printf("Rp%,.0f%n", harga);    // Format output
```

### 13. Array
```java
// Array berukuran tetap di TokoBuku
private Buku[] daftarBuku = new Buku[100];

// Array hasil pencarian
Buku[] hasil = new Buku[jumlahBuku];
```

### 14. Error Handling
```java
try {
    pilihan = Integer.parseInt(scanner.nextLine().trim());
} catch (NumberFormatException e) {
    System.out.println("⚠  Input tidak valid!");
}

try {
    if (stokBaru < 0) throw new IllegalArgumentException("Stok tidak boleh negatif");
} catch (IllegalArgumentException e) {
    System.out.println("⚠  " + e.getMessage());
}
```

---

## Cara Menjalankan

```bash
# 1. Kompilasi
javac src/*.java -d out/

# 2. Jalankan
java -cp out/ Main
```

---

## Tautan
- **GitHub:** [ISI TAUTAN REPOSITORI]
- **YouTube:** [ISI TAUTAN VIDEO PENJELASAN]
