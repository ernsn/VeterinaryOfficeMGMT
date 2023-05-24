package VeterinaryOfficeMGMT;


import static VeterinaryOfficeMGMT.Animal.backupDataAnimal;
import static VeterinaryOfficeMGMT.Animal.restoreDataAnimal;
import static VeterinaryOfficeMGMT.Appointment.backupDataAppointment;
import static VeterinaryOfficeMGMT.Appointment.restoreDataAppointment;
import static VeterinaryOfficeMGMT.Price.backupDataPrice;
import static VeterinaryOfficeMGMT.Price.restoreDataPrice;
import static VeterinaryOfficeMGMT.Veterinarian.backupDataVeterinarian;
import static VeterinaryOfficeMGMT.Veterinarian.restoreDataVeterinarian;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author erens
 */
public class VeterinaryOfficeMGMT {
    
    private static ArrayList<Animal> animals;
    private static ArrayList<Veterinarian> veterinarians;
    private static ArrayList<Appointment> appointments;
    private static ArrayList<Price> prices;
    private static Map<String, Double> products;
    private static Map<String, Integer> quantities;
    private static Map<String, Double> backupProducts;
    private static Map<String, Integer> backupQuantities;
   
    public static void main(String[] args) {
     animals = new ArrayList<>();
     veterinarians = new ArrayList<>();
     appointments = new ArrayList<>();
     prices = new ArrayList<>();
     products = new HashMap<>();
     quantities = new HashMap<>();
     backupProducts = new HashMap<>();
     backupQuantities = new HashMap<>();
     
     testAnimal();
     testVeterinarian();
     testAppointment();
     testPrice();
     testInventory();
    }
    
    private static void testInventory(){
        addProduct("Dog Food", 10,5.99);
        addProduct("Cat Food", 5,3.99);
        addProduct("Pet Toys", 20,10);

        listAllProducts();

        editProduct("Cat Food", 5,4.99);

        listProduct("Cat Food");
        
        backupInventory();
        
        deleteProduct("Pet Toys");

        listAllProducts();
        
        System.out.printf("\n");
        
        restoreInventory();
        
        listAllProducts();
        
    }
    
    private static void testAnimal(){
 
        addAnimal(1, "Max", 3, "Dog");
        addAnimal(2, "Whiskers", 2, "Cat");
        addAnimal(3, "Buddy", 5, "Dog");

        listAllAnimals();

        editAnimal(2, "Whiskers", 3, "Cat");

        listAnimal(2);
        
        Iterator<Animal> iterator = animals.iterator();
        
        ArrayList<Animal> backupList = backupDataAnimal(iterator);
        
        deleteAnimal(3);

        listAllAnimals();
        
        System.out.printf("\n");
        
        animals = restoreDataAnimal(backupList);
        
        listAllAnimals();
    }
    
    private static void testVeterinarian(){
 
        addVeterinarian(1, "Eren", "Surgeon");
        addVeterinarian(2, "Kadir",  "Dermatologist");
        addVeterinarian(3, "Eko",  "Cardiologist");

        listAllVeterinarians();

        editVeterinarian(2, "Ali", "Dentist");

        listVeterinarian(2);
        
        Iterator<Veterinarian> iterator = veterinarians.iterator();
        
        ArrayList<Veterinarian> backupList = backupDataVeterinarian(iterator);
        
        deleteVeterinarian(3);

        listAllVeterinarians();
        
        System.out.printf("\n");
        
        veterinarians = restoreDataVeterinarian(backupList);
        
        listAllVeterinarians();

    }
    
    private static void testAppointment(){
 
        addAppointment(1, "Max (Leg Operation)", 3, 1);
        addAppointment(2, "Whiskers (Skin infection)", 2, 2);
        addAppointment(3, "Buddy (Teeth Operation)", 1, 3);

        listAllAppointments();

        editAppointment(2, "Whiskers", 3, 2);

        listAppointment(2);
        
        Iterator<Appointment> iterator = appointments.iterator();
        
        ArrayList<Appointment> backupList = backupDataAppointment(iterator);
        
        deleteAppointment(3);

        listAllAppointments();
        
        System.out.printf("\n");
        
        appointments = restoreDataAppointment(backupList);
        
        listAllAppointments();

    }
    
    private static void testPrice(){
 
        addPrice("Surgeon", 1000, 1);
        addPrice("Dermatologist", 400, 2);
        addPrice("Cardiology", 600, 3);

        listAllPrice();

        editPrice("Dentist", 500, 3);

        listPrice(2);
        
        Iterator<Price> iterator = prices.iterator();
        
        ArrayList<Price> backupList = backupDataPrice(iterator);
        
        deletePrice(3);

        listAllPrice();
        
        System.out.printf("\n");
        
        prices = restoreDataPrice(backupList);
        
        listAllPrice();

    }
    
    public static void addAnimal(int animalId, String name, int age, String species) {
        Animal animal = new Animal();
        animal.setAnimalId(animalId);
        animal.setName(name);
        animal.setAge(age);
        animal.setSpecies(species);
        animals.add(animal);
    }

    public static void editAnimal(int animalId, String name, int age, String species) {
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                animal.setName(name);
                animal.setAge(age);
                animal.setSpecies(species);
                break;
            }
        }
    }

    public static void deleteAnimal(int animalId) {
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                animals.remove(animal);
                break;
            }
        }
    }

    public static void listAnimal(int animalId) {
        for (Animal animal : animals) {
            if (animal.getAnimalId() == animalId) {
                System.out.println("Animal ID: " + animal.getAnimalId());
                System.out.println("Name: " + animal.getName());
                System.out.println("Age: " + animal.getAge());
                System.out.println("Species: " + animal.getSpecies());
                System.out.println("--------------------");
                break;
            }
        }
    }

    public static void listAllAnimals() {
        for (Animal animal : animals) {
            System.out.println("Animal ID: " + animal.getAnimalId());
            System.out.println("Name: " + animal.getName());
            System.out.println("Age: " + animal.getAge());
            System.out.println("Species: " + animal.getSpecies());
            System.out.println("--------------------");
        }
    }

    public static void addVeterinarian(int vetId, String name, String specialization) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setVetId(vetId);
        veterinarian.setName(name);
        veterinarian.setSpecialization(specialization);
        veterinarians.add(veterinarian);
    }

    public static void editVeterinarian(int vetId, String name, String specialization) {
        for (Veterinarian veterinarian : veterinarians) {
            if (veterinarian.getVetId() == vetId) {
                veterinarian.setName(name);
                veterinarian.setSpecialization(specialization);
                break;
            }
        }
    }

    public static void deleteVeterinarian(int vetId) {
        for (Veterinarian veterinarian : veterinarians) {
            if (veterinarian.getVetId() == vetId) {
                veterinarians.remove(veterinarian);
                break;
            }
        }
    }

    public static void listVeterinarian(int vetId) {
        for (Veterinarian veterinarian : veterinarians) {
            if (veterinarian.getVetId() == vetId) {
                System.out.println("Veterinarian ID: " + veterinarian.getVetId());
                System.out.println("Name: " + veterinarian.getName());
                System.out.println("Specialization: " + veterinarian.getSpecialization());
                System.out.println("--------------------");
                break;
            }
        }
    }

    public static void listAllVeterinarians() {
        for (Veterinarian veterinarian : veterinarians) {
            System.out.println("Veterinarian ID: " + veterinarian.getVetId());
            System.out.println("Name: " + veterinarian.getName());
            System.out.println("Specialization: " + veterinarian.getSpecialization());
            System.out.println("--------------------");
        }
    }

    public static void addAppointment(int appointmentId, String date, int animalId, int vetId) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentId);
        appointment.setDate(date);
        appointment.setAnimalId(animalId);
        appointment.setVetId(vetId);
        appointments.add(appointment);
    }

    public static void editAppointment(int appointmentId, String date, int animalId, int vetId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                appointment.setDate(date);
                appointment.setAnimalId(animalId);
                appointment.setVetId(vetId);
                break;
            }
        }
    }

    public static void deleteAppointment(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                appointments.remove(appointment);
                break;
            }
        }
    }

    public static void listAppointment(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Date: " + appointment.getDate());
                System.out.println("Animal ID: " + appointment.getAnimalId());
                System.out.println("Veterinarian ID: " + appointment.getVetId());
                System.out.println("--------------------");
                break;
            }
        }
    }

    public static void listAllAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId());
            System.out.println("Date: " + appointment.getDate());
            System.out.println("Animal ID: " + appointment.getAnimalId());
            System.out.println("Veterinarian ID: " + appointment.getVetId());
            System.out.println("--------------------");
        }
    }
    
    public static void addPrice(String service, double amount, int priceId){
        Price price = new Price();
        price.setService(service);
        price.setAmount(amount);
        price.setPriceId(priceId);
        prices.add(price);
    }
    
    public static void editPrice(String service, double amount, int priceId) {
        for (Price price : prices) {
            if (price.getPriceId() == priceId) {
                price.setService(service);
                price.setAmount(amount);
                break;
            }
        }
    }
    
    public static void deletePrice(int priceId) {
        for (Price price : prices) {
            if (price.getPriceId() == priceId) {
                prices.remove(price);
                break;
            }
        }
    }
    
    public static void listPrice(int priceId) {
        for (Price price : prices) {
            if (price.getPriceId() == priceId) {
                System.out.println("Price ID: " + price.getPriceId());
                System.out.println("Name of Service: " + price.getService());
                System.out.println("Amount: " + price.getAmount());
                System.out.println("--------------------");
                break;
            }
        }
    }
    
    public static void listAllPrice() {
        for (Price price : prices) {
                System.out.println("Price ID: " + price.getPriceId());
                System.out.println("Name of Service: " + price.getService());
                System.out.println("Amount: " + price.getAmount());
                System.out.println("--------------------");
                break;
            }
        }
    
    public static void addProduct(String product, int quantity, double price) {
        if (products.containsKey(product)) {
            double currentPrice = products.get(product);
            products.put(product, currentPrice + price);
            int currentQuantity = quantities.get(product);
            quantities.put(product, currentQuantity + quantity);
        } else {
            products.put(product, price);
            quantities.put(product, quantity);
        }
    }
    
    public static void editProduct(String product, int quantity, double price) {
        if (products.containsKey(product)) {
            products.put(product, price);
            quantities.put(product, quantity);
        }
    }

    public static void deleteProduct(String product) {
        if (products.containsKey(product)) {
            products.remove(product);
            quantities.remove(product);
        }
    }
    
    public static void listProduct(String product) {
        if (products.containsKey(product)) {
            double price = products.get(product);
            int quantity = quantities.get(product);
            System.out.println(product + " - Price: $" + price + ", Quantity: " + quantity);
            System.out.println("--------------------");
        }
    }
    
public static void listAllProducts() {
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            String product = entry.getKey();
            double price = entry.getValue();
            int quantity = quantities.get(product);
            System.out.println(product + " - Price: $" + price + ", Quantity: " + quantity);
            System.out.println("--------------------");
        }
    }

public static void backupInventory() {
        backupProducts = new HashMap<>(products);
        backupQuantities = new HashMap<>(quantities);

    }

    public static void restoreInventory() {
        products.clear();
        quantities.clear();

        products.putAll(backupProducts);
        quantities.putAll(backupQuantities);
    }
    }