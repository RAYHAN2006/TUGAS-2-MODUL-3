package klinik;

/**
 * Sebuah {@code record} yang berfungsi sebagai pembawa data sederhana dan <i>immutable</i>
 * (tidak bisa diubah) untuk informasi dasar hewan peliharaan.
 * Ini digunakan untuk memberikan data hewan dengan mudah saat membuat objek Animal.
 *
 * @param petName Nama hewan peliharaan.
 * @param species Spesies hewan peliharaan (contoh: "Kucing", "Anjing").
 * @param age     Umur hewan peliharaan dalam tahun.
 */
public record PetData(String petName, String species, int age) {
}