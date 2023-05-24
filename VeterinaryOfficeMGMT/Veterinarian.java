package VeterinaryOfficeMGMT;

import java.util.ArrayList;
import java.util.Iterator;

class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public static ArrayList<Veterinarian> backupDataVeterinarian(Iterator<Veterinarian> iterator) {
        ArrayList<Veterinarian> backupList = new ArrayList<>();
        while (iterator.hasNext()) {
            Veterinarian veterinarian = iterator.next();
            backupList.add(veterinarian);
        }
        return backupList;
    }
    
    public static ArrayList<Veterinarian> restoreDataVeterinarian(ArrayList<Veterinarian> backupList) {
        ArrayList<Veterinarian> restoredList = new ArrayList<>();
        restoredList.addAll(backupList);
        return restoredList;
    }
}
