package VeterinaryOfficeMGMT;

import java.util.ArrayList;
import java.util.Iterator;

class Appointment {
    private int appointmentId;
    private String date;
    private int animalId;
    private int vetId;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }
    
    public static ArrayList<Appointment> backupDataAppointment(Iterator<Appointment> iterator) {
        ArrayList<Appointment> backupList = new ArrayList<>();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            backupList.add(appointment);
        }
        return backupList;
    }
    
    public static ArrayList<Appointment> restoreDataAppointment(ArrayList<Appointment> backupList) {
        ArrayList<Appointment> restoredList = new ArrayList<>();
        restoredList.addAll(backupList);
        return restoredList;
    }
}