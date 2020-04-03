package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private ArrayList<Dish> lunch;
    private String location;
    public Client (String name, String location){
        this.name=name;
        this.location=location;
    }
    public void setClientName(String name) {
        this.name = name;
    }
    public void setClientLocation(String location) {
        this.name = location;
    }
    public void setLunch(ArrayList<Dish> lunch) {
        this.lunch = lunch;
    }

    public ArrayList<Dish> getLunch() {
        return lunch;
    }
    public String getClientName(){
        return name;
    }
    public String getClientLocation(){
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) &&
                location.equals(client.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
