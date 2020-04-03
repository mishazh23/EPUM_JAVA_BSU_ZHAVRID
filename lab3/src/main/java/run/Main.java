package run;

import create.ArrayDish;
import entity.Client;
import entity.Dish;
import filter.StringFilter;
import reader.InfoReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

            Stream<Dish> dishes1 = Arrays.stream(array);
            System.out.println("\n" + "Menu:");
            dishes1
                    .map(d->   "Name of the dish: " + d.getDishName() + "\n"+ "Price: " + d.getDishPrice()+"\n")
                    .forEach(System.out::println);
            Stream<Dish> dishes2 = Arrays.stream(array);
            System.out.println("\n"+"Dishes that costs more than 10: ");
            dishes2
                    .filter(d->d.getDishPrice()>10)
                    .peek(d -> System.out.println("Filtered dish: " + d.getDishName()))
                    .forEach(d->System.out.println(d.getDishName()));//есть ли блюда дороже 10

            ArrayList<Dish> dishArray = new ArrayList<Dish>(Arrays.asList(array));
            Dish min = dishArray.stream().min(Dish::compare).get();
            Dish max = dishArray.stream().max(Dish::compare).get();
            System.out.printf("MIN Name: %s Price: %d \n", min.getDishName(), min.getDishPrice());//min и max цены
            System.out.printf("MAX Name: %s Price: %d \n", max.getDishName(), max.getDishPrice());

            Stream<Dish> dishes3 = Arrays.stream(array);
            System.out.println("\n"+"Dishes that have only one client: ");
            dishes3
                    .filter(d->d.getClientArrayList().size()==1)//только один клиент
                    .peek(d -> System.out.println("Filtered dish: " + d.getDishName()))
                    .forEach(d->System.out.println(d.getDishName()));

            Stream<Dish> dishes4 = Arrays.stream(array);
            System.out.println("\n"+"Sorting dishes according to their popularity: ");//по возрастанию
            dishes4
                    .sorted(Comparator.comparingInt(Dish::getListSize))
                    .forEach(d->System.out.println(d.getDishName()));

            System.out.println("\n"+"Getting the List of Clients: ");
            ArrayList<Dish> dishes6 = new ArrayList<Dish>(Arrays.asList(array));
            ArrayList<Client> clients = new ArrayList<>();
            dishes6.forEach(d -> clients.addAll(d.getClientArrayList()));
            clients.forEach(c->System.out.println(c.getClientName()+" "+c.getClientLocation()));

            /*System.out.println("\n"+"Getting the List of Clients without Duplicates: ");
            ArrayList<Client> startClients = new ArrayList<>();
            dishes6.forEach(d -> startClients.addAll(d.getClientArrayList()));
            ArrayList<Client> clientsWithNoDuplicate =
                    startClients.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
            clientsWithNoDuplicate.forEach(c->System.out.println(c.getClientName()+" "+c.getClientLocation()));
             */

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
