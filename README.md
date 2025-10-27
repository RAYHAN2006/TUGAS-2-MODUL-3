# Proyek Registrasi Klinik Hewan Sederhana

## Deskripsi
Proyek ini adalah sebuah aplikasi konsol sederhana dalam bahasa Java yang mensimulasikan proses registrasi hewan di sebuah klinik. Aplikasi ini akan mencatat detail hewan peliharaan beserta pemiliknya, kemudian menghitung total biaya registrasi yang mencakup biaya dasar, biaya tambahan berdasarkan spesies, dan pajak.

## Struktur Proyek
Proyek ini terdiri dari beberapa kelas yang saling berinteraksi:
* **`Main.java`**: Kelas utama yang berfungsi sebagai titik masuk (*entry point*) untuk menjalankan aplikasi.
* **`Animal.java`**: Merepresentasikan data hewan yang didaftarkan, seperti nama, spesies, dan umur, serta informasi pemiliknya. Kelas ini juga memiliki metode untuk mencetak detail lengkap dan rincian tagihan.
* **`Owner.java`**: Kelas sederhana untuk menyimpan data pemilik hewan, yaitu nama dan kontak.
* **`Clinic.java`**: Mensimulasikan sesi klinik, menyimpan data hewan yang terdaftar, dan menyediakan konstanta serta metode statis terkait biaya (seperti biaya pendaftaran dasar dan tarif pajak).
* **`PetData.java`**: Sebuah `record` Java yang digunakan sebagai objek transfer data (DTO) untuk menginisialisasi data hewan secara ringkas dan *immutable*.

## Fitur
- **Registrasi Hewan**: Mendaftarkan hewan baru dengan detail spesifik (nama, spesies, umur) dan data pemiliknya.
- **Perhitungan Biaya Otomatis**: Secara otomatis menghitung total tagihan dengan rincian sebagai berikut:
    - Biaya registrasi dasar.
    - Biaya tambahan yang spesifik untuk setiap spesies (contoh: anjing dan kucing memiliki biaya berbeda).
    - Pajak Pertambahan Nilai (PPN) sebesar 11%.
- **Cetak Detail dan Tagihan**: Menampilkan ringkasan informasi hewan, data pemilik, dan rincian lengkap tagihan dalam format yang mudah dibaca di konsol.

## Cara Menjalankan Program

### Prasyarat
- Java Development Kit (JDK) versi 14 atau yang lebih baru (karena menggunakan fitur `record`).

### Langkah-langkah Menjalankan di IntelliJ IDEA
1.  Pastikan semua file (`Main.java`, `PetData.java`, dan kelas-kelas lainnya) berada dalam package yang sama, yaitu `klinik`.
2.  Buka file `Main.java`.
3.  Klik kanan di dalam area editor kode.
4.  Pilih **Run 'Main.main()'** atau tekan tombol pintas `Ctrl+Shift+F10`.

### Contoh Output
Setelah dijalankan, program akan menghasilkan output seperti berikut di konsol:
```
--- Detail Registrasi Hewan ---
Nama Hewan: Milo
Spesies: Cat
Umur: 3 tahun
Pemilik: Budi Santoso
Kontak: 081234567890
--------------------------------
--- Detail Tagihan ---
Biaya Registrasi Dasar: Rp50000.0
Biaya Tambahan Spesies: Rp20000.0
Pajak (11%): Rp7700.0
Total Tagihan: Rp77700.0
-----------------------
```