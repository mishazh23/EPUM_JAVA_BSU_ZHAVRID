package run;

import create.ArrayDish;
import entity.Client;
import entity.Dish;
import filter.StringFilter;
import reader.InfoReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the size of Dish array: ");
            InfoReader reader = new InfoReader();
            StringFilter filter = new StringFilter();
            String str= "";
            do{
               str = reader.readString(System.in);
            }   while (!filter.filterInt(str));
            int n = Integer.parseInt(str);
            Dish[] array= new Dish[n];
            array = ArrayDish.createArrayDish(n);


            System.out.println("\n"+"Dishes that costs more than 10: ");
            findDish(array);


            System.out.println("\n"+"Dishes that have only one client: ");
            filterDishWishOneClient(array);

            System.out.println("\n"+"Dish with minimal price: "+"\n"+ getMinPrice(array));
            System.out.println("\n"+"Dish with maximal price: "+"\n"+ getMaxPrice(array));

            System.out.println("\n"+"Sorting dishes according to their popularity: ");
            sortDish(array);

            System.out.println("\n"+"Getting the List of Clients: ");
            getClientsList(array);

            System.out.println("\n"+"Getting the List of Clients without duplicates: ");
            getClientsWithoutDuplicates(array);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void findDish(Dish[] array){
        Stream<Dish> dishes = Arrays.stream(array);
        dishes
                .filter(d->d.getDishPrice()>10)
                .peek(d -> System.out.println("Filtered dish: " + d.getDishName()))
                .forEach(d->System.out.println(d.getDishName()));
    }
    public static void filterDishWishOneClient(Dish[] array){
        Stream<Dish> dishes3 = Arrays.stream(array);
        dishes3
                .parallel()
                .filter(d->d.getClientArrayList().size()==1)
                .peek(d -> System.out.println("Filtered dish: " + d.getDishName()))
                .forEach(d->System.out.println(d.getDishName()));
    }

    public static String getMinPrice(Dish[] array)  {
        Stream<Dish> dishStream= Arrays.stream(array);
        Optional<Dish> min = dishStream
                .min(Dish::compare);
        try{
            Dish result = min.orElseThrow(() -> new Exception("There is no dish. "));
            return "Name of the Dish: " + result.getDishName()+"  MIN price: "+ result.getDishPrice();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    public static String getMaxPrice(Dish[] array)  {
        Stream<Dish> dishStream= Arrays.stream(array);
        Optional<Dish> max = dishStream
                .max(Dish::compare);
        try{
            Dish result = max.orElseThrow(() -> new Exception("There is no dish. "));
            return "Name of the Dish: " + result.getDishName()+"  MAX price: "+ result.getDishPrice();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public static void sortDish(Dish[] array){
        Stream<Dish> dishes = Arrays.stream(array);
        dishes
                .sorted(Comparator.comparingInt(Dish::getListSize))
                .forEach(d->System.out.println("Dish name: "+ d.getDishName()+", "+"Number of clients: "+d.getListSize()));
    }
    public static void getClientsList(Dish[] array){
        ArrayList<Dish> dishes = new ArrayList<Dish>(Arrays.asList(array));
        ArrayList<Client> clients = new ArrayList<>();
        dishes.forEach(d -> clients.addAll(d.getClientArrayList()));
        clients.forEach(c->System.out.println("Client's name: "+ c.getClientName()+", "+"Client's location: "+c.getClientLocation()));

    }
    public static void getClientsWithoutDuplicates(Dish[] array){
        Stream<Dish> dishes = Arrays.stream(array);
        ArrayList<Client> clients = new ArrayList<>();
        dishes.forEach(d -> clients.addAll(d.getClientArrayList()));

        clients.stream()
                .distinct()
                .forEach(c ->System.out.println("Client's name: "+ c.getClientName()+", "+"Client's location: "+c.getClientLocation()));
    }
}
