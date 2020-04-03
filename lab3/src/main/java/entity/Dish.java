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

    public void setDishName(String name) {
        this.name = name;
    }
    public void setDishPrice(int price) {
        this.price = price;
    }
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
        return clientArrayList;
    }

    public List<String> getComponentList() {
        return componentList;
    }
    public int getListSize() {
        return clientArrayList.size();
    }

    //печать списка
    public void printArrayList(List<Client> clientArrayList, Dish d){
        System.out.println("\n"+"The Dish: "+ d.getDishName());
        for(int i=0;i<clientArrayList.size();i++){
            System.out.println("Client's name: "+ clientArrayList.get(i).getClientName()+", " + "client's location: "+
                    clientArrayList.get(i).getClientLocation());
        }
    }
    public static int compare (Dish p1, Dish p2){
        if(p1.getDishPrice() > p2.getDishPrice())
            return 1;
        return -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price);
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
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) && Objects.equals(price, dish.price);
    }


}
