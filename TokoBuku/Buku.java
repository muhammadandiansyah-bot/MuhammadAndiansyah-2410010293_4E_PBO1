// ============================================================
// Class: Buku (Base Class / Parent Class)
// Memuat: Class, Atribut, Constructor, Mutator, Accessor,
//         Encapsulation
// ============================================================
package TokoBuku;

public class Buku {

    // Atribut (private = Encapsulation)
    private String judul;
    private String pengarang;
    private double harga;
    private int stok;
    private String isbn;

    // Constructor default (no-argument constructor)
    public Buku() {
        this.judul     = "Tidak Diketahui";
        this.pengarang = "Tidak Diketahui";
        this.harga     = 0.0;
        this.stok      = 0;
        this.isbn      = "000-0000000000";
    }

    // Constructor berparameter
    public Buku(String judul, String pengarang, double harga, int stok, String isbn) {
        this.judul     = judul;
        this.pengarang = pengarang;
        this.harga     = harga;
        this.stok      = stok;
        this.isbn      = isbn;
    }

    // ── Mutator (Setter) ──────────────────────────────────────
    public void setJudul(String judul)         { this.judul     = judul; }
    public void setPengarang(String pengarang) { this.pengarang = pengarang; }
    public void setHarga(double harga)         { this.harga     = harga; }
    public void setStok(int stok)              { this.stok      = stok; }
    public void setIsbn(String isbn)           { this.isbn      = isbn; }

    // ── Accessor (Getter) ─────────────────────────────────────
    public String getJudul()     { return judul; }
    public String getPengarang() { return pengarang; }
    public double getHarga()     { return harga; }
    public int    getStok()      { return stok; }
    public String getIsbn()      { return isbn; }

    // Method tampilInfo – akan di-override oleh subclass (Polymorphism)
    public String tampilInfo() {
        return String.format(
            "ISBN: %s | Judul: %-30s | Pengarang: %-20s | Harga: Rp%,.0f | Stok: %d",
            isbn, judul, pengarang, harga, stok
        );
    }

    // Override toString()
    @Override
    public String toString() {
        return tampilInfo();
    }
}