package create;

import entity.Client;
import entity.Dish;
import filter.StringFilter;
import reader.InfoReader;

import java.util.ArrayList;
import java.util.List;

public class ArrayDish {
    public static Dish[] createArrayDish(int n) throws Exception{
        Dish[] array = new Dish[n];
        try {
            for (int i = 0; i < n; i++) {
                StringFilter filter = new StringFilter();
                System.out.println("Enter the dish name:");
                InfoReader reader = new InfoReader();
                String str = "";
                do {
                    str = reader.readString(System.in);
                }while (!filter.filterString(str));

                System.out.println("How many components are in the Dish? ");
                String numberOfComponents= "";
                do {
                    numberOfComponents = reader.readString(System.in);
                }while (!filter.filterInt(numberOfComponents));
                int components = Integer.parseInt(numberOfComponents);
                System.out.println("Put in "+components + " components: ");
                List<String> componentsList = new ArrayList<>();
                for(int j=0;j<components;j++){
                    System.out.print(j+1+") ");
                    String s = "";
                    do {
                        s = reader.readString(System.in);
                    }while (!filter.filterString(s));
                    componentsList.add(s);
                }
                System.out.println("Enter the price of the dish:");
                String value= "";
                do {
                    value = reader.readString(System.in);
                }while (!filter.filterInt(value));
                int price = Integer.parseInt(value);
                array[i] = new Dish(str, price);

                System.out.println("Enter the number of clients:");
                String number= "";
                do {
                    number = reader.readString(System.in);
                }while (!filter.filterInt(number));
                int num = Integer.parseInt(number);
                Client[] clients = new Client[num];
                clients= ArrayClient.createArrayClient(num);
                array[i].setClientList(clients);
                array[i].setComponentList(componentsList);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return array;
    }
}
