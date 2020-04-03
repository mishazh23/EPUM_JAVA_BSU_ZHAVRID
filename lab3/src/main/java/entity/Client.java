package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private ArrayList<Dish> lunch;
    private String location;
    public void setClientName(String name) {
        this.name = name;
    }
    public void setClientLocation(String location) {
        this.name = location;
    }
    public void setLunch(ArrayList<Dish> lunch) {
        this.lunch = lunch;
    }
    public Client (String name, String location){
        this.name=name;
        this.location=location;
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
    //заполнение списка
    public ArrayList<Dish> addListDish(Dish[] lunch){
        ArrayList<Dish> clientArrayList = new ArrayList<Dish>(Arrays.asList(lunch));
        return clientArrayList;
    }
    //печать списка
    public void printArrayList(List<Client> clientArrayList){
        for(int i=0;i<clientArrayList.size();i++){
            System.out.println(clientArrayList.get(i));
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(location, client.location);
    }

}
