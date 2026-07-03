// ============================================================
// Class: BukuFiksi (Subclass dari Buku)
// Memuat: Inheritance, Polymorphism (Override tampilInfo)
// ============================================================
package TokoBuku;

public class BukuFiksi extends Buku {

    // Atribut tambahan khusus Buku Fiksi
    private String genre;

    // Constructor
    public BukuFiksi(String judul, String pengarang, double harga,
                     int stok, String isbn, String genre) {
        super(judul, pengarang, harga, stok, isbn); // memanggil constructor parent
        this.genre = genre;
    }

    // Mutator dan Accessor
    public void   setGenre(String genre) { this.genre = genre; }
    public String getGenre()             { return genre; }

    // Polymorphism: Override method tampilInfo() dari parent class Buku
    @Override
    public String tampilInfo() {
        return "[FIKSI]    " + super.tampilInfo() + " | Genre: " + genre;
    }
}