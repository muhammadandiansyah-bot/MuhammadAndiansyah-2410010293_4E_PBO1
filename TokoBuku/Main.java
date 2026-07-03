// ============================================================
// Class: Main (Entry Point / Program Utama)
// Memuat: IO Sederhana, Error Handling (try-catch),
//         Seleksi (switch-case, if-else), Perulangan (while)
// ============================================================
package TokoBuku;

import java.util.Scanner;

public class Main {

    // ── Scanner untuk IO Sederhana ────────────────────────────
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // ── Object: membuat objek TokoBuku ────────────────────
        TokoBuku toko = new TokoBuku("Toko Buku Nusantara");

        // Isi data awal menggunakan Array + Polymorphism
        inisialisasiData(toko);

        boolean running = true;

        // ── Perulangan: loop menu utama ───────────────────────
        while (running) {
            tampilMenu(toko.getNamaToko());

            int pilihan ;

            // ── Error Handling: input menu ────────────────────
            try {
                System.out.print("Masukkan pilihan [1-8]: ");
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠  Input tidak valid! Harap masukkan angka.");
                continue;
            }

            // ── Seleksi: switch-case ──────────────────────────
            switch (pilihan) {
                case 1 -> toko.tampilSemuaBuku();
                case 2 -> menuTambahBuku(toko);
                case 3 -> menuCariBukuIsbn(toko);
                case 4 -> menuCariBukuJudul(toko);
                case 5 -> menuUpdateStok(toko);
                case 6 -> menuHapusBuku(toko);
                case 7 -> tampilInventaris(toko);
                case 8 -> {
                    System.out.println("\nTerima kasih telah menggunakan sistem " + toko.getNamaToko());
                    System.out.println("Sampai jumpa!");
                    running = false;
                }
                default -> System.out.println("⚠  Pilihan tidak tersedia. Silakan pilih 1-8.");
            }
        }

        scanner.close();
    }

    // ══════════════════════════════════════════════════════════
    //  Tampil Menu Utama
    // ══════════════════════════════════════════════════════════
    static void tampilMenu(String namaToko) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   SISTEM MANAJEMEN " + namaToko);
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Tampil Semua Buku                ║");
        System.out.println("║  2. Tambah Buku Baru                 ║");
        System.out.println("║  3. Cari Buku (ISBN)                 ║");
        System.out.println("║  4. Cari Buku (Judul)                ║");
        System.out.println("║  5. Update Stok Buku                 ║");
        System.out.println("║  6. Hapus Buku                       ║");
        System.out.println("║  7. Total Nilai Inventaris           ║");
        System.out.println("║  8. Keluar                           ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 2: Tambah Buku Baru  (IO + Error Handling + Seleksi)
    // ══════════════════════════════════════════════════════════
    static void menuTambahBuku(TokoBuku toko) {
        System.out.println("\n── TAMBAH BUKU BARU ──");
        System.out.println("Jenis buku:");
        System.out.println("  1. Fiksi");
        System.out.println("  2. Non-Fiksi");

        int jenis ;
        // Error Handling input jenis
        try {
            System.out.print("Pilih jenis [1/2]: ");
            jenis = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠  Input tidak valid!");
            return;
        }

        // ── Seleksi: if-else ──────────────────────────────────
        if (jenis != 1 && jenis != 2) {
            System.out.println("⚠  Pilihan jenis tidak valid.");
            return;
        }

        // IO Sederhana: membaca input teks
        System.out.print("ISBN        : ");
        String isbn = scanner.nextLine().trim();

        System.out.print("Judul       : ");
        String judul = scanner.nextLine().trim();

        System.out.print("Pengarang   : ");
        String pengarang = scanner.nextLine().trim();

        double harga ;
        int    stok  ;

        // Error Handling: input harga
        try {
            System.out.print("Harga (Rp)  : ");
            harga = Double.parseDouble(scanner.nextLine().trim().replace(",", ""));
        } catch (NumberFormatException e) {
            System.out.println("⚠  Format harga tidak valid!");
            return;
        }

        // Error Handling: input stok
        try {
            System.out.print("Stok        : ");
            stok = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠  Format stok tidak valid!");
            return;
        }

        // Seleksi berdasarkan jenis buku
        if (jenis == 1) {
            System.out.print("Genre       : ");
            String genre = scanner.nextLine().trim();
            BukuFiksi bf = new BukuFiksi(judul, pengarang, harga, stok, isbn, genre);
            if (toko.tambahBuku(bf)) {
                System.out.println("✔  Buku Fiksi berhasil ditambahkan!");
            }
        } else {
            System.out.print("Bidang Ilmu : ");
            String bidang = scanner.nextLine().trim();
            BukuNonFiksi bnf = new BukuNonFiksi(judul, pengarang, harga, stok, isbn, bidang);
            if (toko.tambahBuku(bnf)) {
                System.out.println("✔  Buku Non-Fiksi berhasil ditambahkan!");
            }
        }
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 3: Cari Buku berdasarkan ISBN
    // ══════════════════════════════════════════════════════════
    static void menuCariBukuIsbn(TokoBuku toko) {
        System.out.println("\n── CARI BUKU BERDASARKAN ISBN ──");
        System.out.print("Masukkan ISBN: ");
        String isbn = scanner.nextLine().trim();

        // Error Handling: cek input kosong
        if (isbn.isEmpty()) {
            System.out.println("⚠  ISBN tidak boleh kosong!");
            return;
        }

        Buku hasil = toko.cariBukuIsbn(isbn);

        // Seleksi: if-else
        if (hasil != null) {
            System.out.println("\nBuku ditemukan:");
            System.out.println(hasil.tampilInfo()); // Polymorphism
        } else {
            System.out.println("✘  Buku dengan ISBN \"" + isbn + "\" tidak ditemukan.");
        }
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 4: Cari Buku berdasarkan Judul
    // ══════════════════════════════════════════════════════════
    static void menuCariBukuJudul(TokoBuku toko) {
        System.out.println("\n── CARI BUKU BERDASARKAN JUDUL ──");
        System.out.print("Kata kunci judul: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("⚠  Kata kunci tidak boleh kosong!");
            return;
        }

        Buku[] hasil = toko.cariBukuJudul(keyword);

        if (hasil.length == 0) {
            System.out.println("✘  Tidak ditemukan buku dengan judul mengandung \"" + keyword + "\".");
        } else {
            System.out.println("\nDitemukan " + hasil.length + " buku:");
            for (int i = 0; i < hasil.length; i++) {  // Perulangan
                System.out.println((i + 1) + ". " + hasil[i].tampilInfo());
            }
        }
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 5: Update Stok Buku
    // ══════════════════════════════════════════════════════════
    static void menuUpdateStok(TokoBuku toko) {
        System.out.println("\n── UPDATE STOK BUKU ──");
        System.out.print("Masukkan ISBN buku: ");
        String isbn = scanner.nextLine().trim();

        int stokBaru ;
        // Error Handling: input stok baru
        try {
            System.out.print("Stok baru: ");
            stokBaru = Integer.parseInt(scanner.nextLine().trim());
            if (stokBaru < 0) throw new IllegalArgumentException("Stok tidak boleh negatif");
        } catch (NumberFormatException e) {
            System.out.println("⚠  Format stok tidak valid!");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("⚠  " + e.getMessage());
            return;
        }

        if (toko.updateStok(isbn, stokBaru)) {
            System.out.println("✔  Stok berhasil diperbarui menjadi " + stokBaru);
        } else {
            System.out.println("✘  Buku dengan ISBN \"" + isbn + "\" tidak ditemukan.");
        }
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 6: Hapus Buku
    // ══════════════════════════════════════════════════════════
    static void menuHapusBuku(TokoBuku toko) {
        System.out.println("\n── HAPUS BUKU ──");
        System.out.print("Masukkan ISBN buku yang akan dihapus: ");
        String isbn = scanner.nextLine().trim();

        if (isbn.isEmpty()) {
            System.out.println("⚠  ISBN tidak boleh kosong!");
            return;
        }

        // Konfirmasi penghapusan (IO Sederhana + Seleksi)
        System.out.print("Apakah Anda yakin ingin menghapus? [y/n]: ");
        String konfirmasi = scanner.nextLine().trim();

        if (konfirmasi.equalsIgnoreCase("y")) {
            if (toko.hapusBuku(isbn)) {
                System.out.println("✔  Buku berhasil dihapus.");
            } else {
                System.out.println("✘  Buku dengan ISBN \"" + isbn + "\" tidak ditemukan.");
            }
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // ══════════════════════════════════════════════════════════
    //  Menu 7: Total Nilai Inventaris
    // ══════════════════════════════════════════════════════════
    static void tampilInventaris(TokoBuku toko) {
        double total = toko.hitungTotalInventaris();
        System.out.println("\n── TOTAL NILAI INVENTARIS ──");
        System.out.printf("Toko       : %s%n", toko.getNamaToko());
        System.out.printf("Jumlah buku: %d judul%n", toko.getJumlahBuku());
        System.out.printf("Total nilai: Rp%,.0f%n", total);
    }

    // ══════════════════════════════════════════════════════════
    //  Inisialisasi Data Awal
    // ══════════════════════════════════════════════════════════
    static void inisialisasiData(TokoBuku toko) {
        // Polymorphism: Array Buku menyimpan BukuFiksi dan BukuNonFiksi
        toko.tambahBuku(new BukuFiksi("Laskar Pelangi",
                "Andrea Hirata", 85000, 15, "978-9793062792", "Novel"));
        toko.tambahBuku(new BukuFiksi("Bumi Manusia",
                "Pramoedya Ananta Toer", 95000, 10, "978-9799731234", "Novel Sejarah"));
        toko.tambahBuku(new BukuFiksi("Harry Potter Sorcerer",
                "J.K. Rowling", 120000, 8, "978-0439708180", "Fantasy"));
        toko.tambahBuku(new BukuNonFiksi("Clean Code",
                "Robert C. Martin", 180000, 5, "978-0132350884", "Pemrograman"));
        toko.tambahBuku(new BukuNonFiksi("Sapiens",
                "Yuval Noah Harari", 150000, 12, "978-0062316110", "Sejarah"));
        toko.tambahBuku(new BukuNonFiksi("Pemrograman Java OOP",
                "Muhammad Edya Rosadi", 75000, 20, "978-1234567890", "Informatika"));
    }
}