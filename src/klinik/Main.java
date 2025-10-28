package klinik;

// File: Animal.java
class Animal {
    private String petName;
    private String species; // contoh: "Cat", "Dog"
    private int age;
    private Owner owner;

    public Animal(PetData petData, Owner owner) {
        this.petName = petData.petName();
        this.species = petData.species();
        this.age = petData.age();
        this.owner = owner;
    }

    public String getPetName() {
        return petName;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Owner getOwner() {
        return owner;
    }

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

// File: Owner.java
class Owner {
    public String ownerName;
    public String contact;

    public Owner(String ownerName, String contact) {
        this.ownerName = ownerName;
        this.contact = contact;
    }
}

// File: Clinic.java
class Clinic {
    public static final double TAX_RATE = 0.11;
    public Animal animal;

    public Clinic(Animal animal) {
        this.animal = animal;
    }

    static int displayRegistrationDetails() {
        return 50000;
    }
}

// File: Main.java
public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Budi Santoso", "081234567890");
        Animal animal = new Animal(new PetData("Milo", "Cat", 3), owner);
        Clinic clinicSession = new Clinic(animal);

        clinicSession.animal.printAllDetailsAndBill();
    }
}
