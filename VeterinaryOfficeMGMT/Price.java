package VeterinaryOfficeMGMT;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author erens
 */
public class Price {
    
    private String service;
    private double amount;
    public int priceId;
  
    
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPriceId() {
        return priceId;
    }
    
    public void setPriceId(int priceId) {
        this.priceId=priceId;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static ArrayList<Price> backupDataPrice(Iterator<Price> iterator) {
        ArrayList<Price> backupList = new ArrayList<>();
        while (iterator.hasNext()) {
            Price price = iterator.next();
            backupList.add(price);
        }
        return backupList;
    }

    public static ArrayList<Price> restoreDataPrice(ArrayList<Price> backupList) {
        ArrayList<Price> restoredList = new ArrayList<>();
        restoredList.addAll(backupList);
        return restoredList;
    }
    
    @Override
    public String toString() {
        return "Service: " + service + ", Amount: " + amount;
    }
}

