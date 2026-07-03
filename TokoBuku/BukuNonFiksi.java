// ============================================================
// Class: BukuNonFiksi (Subclass dari Buku)
// Memuat: Inheritance, Polymorphism (Override tampilInfo)
// ============================================================
package TokoBuku;

public class BukuNonFiksi extends Buku {

    // Atribut tambahan khusus Buku Non-Fiksi
    private String bidangIlmu;

    // Constructor
    public BukuNonFiksi(String judul, String pengarang, double harga,
                        int stok, String isbn, String bidangIlmu) {
        super(judul, pengarang, harga, stok, isbn); // memanggil constructor parent
        this.bidangIlmu = bidangIlmu;
    }

    // Mutator dan Accessor
    public void   setBidangIlmu(String bidangIlmu) { this.bidangIlmu = bidangIlmu; }
    public String getBidangIlmu()                  { return bidangIlmu; }

    // Polymorphism: Override method tampilInfo() dari parent class Buku
    @Override
    public String tampilInfo() {
        return "[NON-FIKSI] " + super.tampilInfo() + " | Bidang: " + bidangIlmu;
    }
}