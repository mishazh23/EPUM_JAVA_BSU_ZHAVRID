package entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dish{
    private String name;
    private int price;
    private List<String> componentList;
    private List<Client> clientArrayList;

    public void setComponentList(List<String> componentList) {
        this.componentList = componentList;
    }
    public Dish (String name, int price){
        this.name = name;
        this.price = price;
    }
    public void setClientList(Client[] clients) {
        this.clientArrayList = new ArrayList<>(Arrays.asList(clients));
    }
    public String getDishName(){
        return name;
    }
    public int getDishPrice(){
        return price;
    }
    public List<Client> getClientArrayList() {
        return new ArrayList<>(clientArrayList);
    }

    public List<String> getComponentList() {
        return componentList;
    }
    public int getListSize() {
        return clientArrayList.size();
    }

    public static int compare (Dish p1, Dish p2){
        if(p1.getDishPrice() > p2.getDishPrice())
            return 1;
        return -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, price);
    }
}
