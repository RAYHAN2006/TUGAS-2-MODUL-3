package klinik;

/**
 * Mewakili seekor hewan yang sedang didaftarkan di klinik.
 * Kelas ini menyimpan detail tentang hewan peliharaan dan pemiliknya, serta menyertakan metode
 * untuk menghitung dan menampilkan informasi pendaftaran dan tagihan.
 */
class Animal {
    private String petName;
    private String species; // contoh: "Cat", "Dog"
    private int age;
    private Owner owner;

    /**
     * Membuat objek Animal baru menggunakan data dari PetData dan objek Owner.
     * @param petData Sebuah {@code record} yang berisi nama, spesies, dan umur hewan.
     * @param owner   Objek Owner yang mewakili pemilik hewan.
     */
    public Animal(PetData petData, Owner owner) {
        this.petName = petData.petName();
        this.species = petData.species();
        this.age = petData.age();
        this.owner = owner;
    }

    /**
     * Mendapatkan nama hewan peliharaan.
     * @return Sebuah {@code string} yang merepresentasikan nama hewan.
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Mendapatkan spesies hewan peliharaan.
     * @return Sebuah {@code string} yang merepresentasikan spesies hewan.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Mendapatkan umur hewan peliharaan.
     * @return Sebuah {@code integer} yang merepresentasikan umur hewan.
     */
    public int getAge() {
        return age;
    }

    /**
     * Mendapatkan pemilik hewan peliharaan.
     * @return Objek Owner yang terkait dengan hewan ini.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Mencetak ringkasan lengkap detail pendaftaran hewan ke konsol.
     * Metode ini kemudian menghitung dan mencetak tagihan terperinci, termasuk biaya dasar,
     * biaya spesifik spesies, dan pajak.
     */
    // Method untuk menampilkan semua detail dan menghitung biaya
    public void printAllDetailsAndBill() {
        System.out.println("--- Detail Registrasi Hewan ---");
        System.out.println("Nama Hewan: " + getPetName());
        System.out.println("Spesies: " + getSpecies());
        System.out.println("Umur: " + getAge() + " tahun");
        System.out.println("Pemilik: " + getOwner().ownerName);
        System.out.println("Kontak: " + getOwner().contact);
        System.out.println("--------------------------------");

        // Perhitungan biaya
        double baseRegistrationFee = Clinic.displayRegistrationDetails(); // Biaya pendaftaran dasar
        double speciesSpecificFee = 0;
        if (getSpecies().equalsIgnoreCase("Dog")) {
            speciesSpecificFee = 25000; // Biaya tambahan untuk anjing
        } else if (getSpecies().equalsIgnoreCase("Cat")) {
            speciesSpecificFee = 20000; // Biaya tambahan untuk kucing
        }

        double total = baseRegistrationFee + speciesSpecificFee;
        double tax = total * Clinic.TAX_RATE; // PPN 11%
        double finalBill = total + tax;

        System.out.println("--- Detail Tagihan ---");
        System.out.println("Biaya Registrasi Dasar: Rp" + baseRegistrationFee);
        System.out.println("Biaya Tambahan Spesies: Rp" + speciesSpecificFee);
        System.out.println("Pajak (11%): Rp" + tax);
        System.out.println("Total Tagihan: Rp" + finalBill);

        // --- KODE FITUR BARU DIMULAI ---
        double totalSebelumDiskon = total + tax;
        finalBill = totalSebelumDiskon;

        if (totalSebelumDiskon > 100000) {
            double diskon = totalSebelumDiskon * 0.10; // Diskon 10%
            finalBill = totalSebelumDiskon - diskon; // Kurangi total tagihan dengan diskon
            System.out.println("Diskon (10%): -Rp" + diskon);
        }

        // --- KODE FITUR BARU SELESAI ---
        System.out.println("Total Tagihan: Rp" + finalBill);
        System.out.println("-----------------------");

    }
}

/**
 * Mewakili pemilik dari seekor hewan peliharaan.
 * Berisi informasi dasar tentang nama dan detail kontak pemilik.
 */
// File: Owner.java
class Owner {
    public String ownerName;
    public String contact;

    /**
     * Membuat objek Owner baru.
     * @param ownerName Nama lengkap pemilik.
     * @param contact   Nomor kontak pemilik.
     */
    public Owner(String ownerName, String contact) {
        this.ownerName = ownerName;
        this.contact = contact;
    }
}

// File: Clinic.java
/**
 * Mensimulasikan sesi klinik untuk pendaftaran hewan.
 * Kelas ini menyimpan konstanta untuk klinik seperti tarif pajak dan menyediakan
 * metode statis untuk informasi klinik.
 */
class Clinic {
    /**
     * Tarif pajak standar (PPN) yang diterapkan pada semua tagihan, ditetapkan sebesar 11%.
     */
    public static final double TAX_RATE = 0.11;
    public Animal animal;

    /**
     * Membuat sesi klinik baru untuk hewan tertentu.
     * @param animal Hewan yang didaftarkan dalam sesi ini.
     */
    public Clinic(Animal animal) {
        this.animal = animal;
    }

    /**
     * Menyediakan biaya pendaftaran dasar untuk klinik.
     * @return Sebuah {@code integer} yang merepresentasikan biaya pendaftaran dasar.
     */
    static int displayRegistrationDetails() {
        return 80000;
    }
}

// File: Main.java
/**
 * Kelas utama yang berfungsi sebagai titik masuk (<i>entry point</i>) untuk aplikasi.
 * Kelas ini mendemonstrasikan pembuatan sesi Owner, Animal, dan Clinic,
 * lalu mencetak detail pendaftaran akhir dan tagihan.
 */
public class Main {
    /**
     * Metode utama yang menjalankan simulasi pendaftaran klinik.
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        Owner owner = new Owner("Budi Santoso", "081234567890");
        Animal animal = new Animal(new PetData("Milo", "Cat", 3), owner);
        Clinic clinicSession = new Clinic(animal);

        clinicSession.animal.printAllDetailsAndBill();
    }
}