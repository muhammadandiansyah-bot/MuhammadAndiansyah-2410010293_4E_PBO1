// ============================================================
// Class: TokoBuku
// Memuat: Array, Encapsulation, method-method pengelolaan data
// ============================================================
package TokoBuku;

public class TokoBuku {

    private String namaToko;
    private Buku[] daftarBuku;      // Array of Buku (Polymorphism)
    private int    jumlahBuku;
    private static final int KAPASITAS_MAKS = 100;

    // Constructor
    public TokoBuku(String namaToko) {
        this.namaToko    = namaToko;
        this.daftarBuku  = new Buku[KAPASITAS_MAKS]; // Array
        this.jumlahBuku  = 0;
    }

    // Getter
    public String getNamaToko()  { return namaToko; }
    public int    getJumlahBuku() { return jumlahBuku; }

    // ── Tambah Buku ───────────────────────────────────────────
    public boolean tambahBuku(Buku buku) {
        if (jumlahBuku >= KAPASITAS_MAKS) {
            System.out.println("Kapasitas toko penuh!");
            return false;
        }
        // Cek duplikat ISBN
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIsbn().equalsIgnoreCase(buku.getIsbn())) {
                System.out.println("Buku dengan ISBN " + buku.getIsbn() + " sudah ada!");
                return false;
            }
        }
        daftarBuku[jumlahBuku] = buku;
        jumlahBuku++;
        return true;
    }

    // ── Cari Buku berdasarkan ISBN ────────────────────────────
    public Buku cariBukuIsbn(String isbn) {
        for (int i = 0; i < jumlahBuku; i++) {          // Perulangan
            if (daftarBuku[i].getIsbn().equalsIgnoreCase(isbn)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    // ── Cari Buku berdasarkan Judul (pencarian parsial) ───────
    public Buku[] cariBukuJudul(String keyword) {
        Buku[] hasil   = new Buku[jumlahBuku];
        int    counter = 0;
        for (int i = 0; i < jumlahBuku; i++) {           // Perulangan
            if (daftarBuku[i].getJudul()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {
                hasil[counter++] = daftarBuku[i];
            }
        }
        // Potong array sesuai jumlah hasil
        Buku[] hasilAkhir = new Buku[counter];
        for (int i = 0; i < counter; i++) hasilAkhir[i] = hasil[i];
        return hasilAkhir;
    }

    // ── Tampil Semua Buku ─────────────────────────────────────
    public void tampilSemuaBuku() {
        if (jumlahBuku == 0) {
            System.out.println("Belum ada buku di toko.");
            return;
        }
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║            DAFTAR BUKU " + namaToko);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        for (int i = 0; i < jumlahBuku; i++) {           // Perulangan
            System.out.println((i + 1) + ". " + daftarBuku[i].tampilInfo()); // Polymorphism
        }
        System.out.println("Total buku: " + jumlahBuku);
    }

    // ── Update Stok Buku ──────────────────────────────────────
    public boolean updateStok(String isbn, int stokBaru) {
        Buku b = cariBukuIsbn(isbn);
        if (b != null) {
            b.setStok(stokBaru);  // Mutator
            return true;
        }
        return false;
    }

    // ── Hapus Buku berdasarkan ISBN ───────────────────────────
    public boolean hapusBuku(String isbn) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIsbn().equalsIgnoreCase(isbn)) {
                // Geser elemen ke kiri (Seleksi + Perulangan)
                for (int j = i; j < jumlahBuku - 1; j++) {
                    daftarBuku[j] = daftarBuku[j + 1];
                }
                daftarBuku[jumlahBuku - 1] = null;
                jumlahBuku--;
                return true;
            }
        }
        return false;
    }

    // ── Hitung Total Nilai Inventaris ─────────────────────────
    public double hitungTotalInventaris() {
        double total = 0;
        for (int i = 0; i < jumlahBuku; i++) {           // Perulangan
            total += daftarBuku[i].getHarga() * daftarBuku[i].getStok();
        }
        return total;
    }
}