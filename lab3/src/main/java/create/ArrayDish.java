package create;

import entity.Client;
import entity.Dish;
import filter.StringFilter;
import reader.InfoReader;

import java.util.ArrayList;

public class ArrayDish {
    public static Dish[] createArrayDish(int n) throws Exception{
        Dish[] array = new Dish[n];
        try {
            for (int i = 0; i < n; i++) {
                //вводим название блюда
                System.out.println("Enter the dish name:");
                InfoReader reader = new InfoReader();
                String str = reader.readString(System.in);
                //вводим цену блюда
                System.out.println("Enter the price of the dish:");
                InfoReader priceReader = new InfoReader();
                StringFilter filter = new StringFilter();
                String value= "";
                do {
                    value = priceReader.readString(System.in);
                }while (!filter.filterInt(value));
                int price = Integer.parseInt(value);
                array[i] = new Dish(str, price);
                //вводим количество клиентов, купивших блюдо
                System.out.println("Enter the number of clients:");
                InfoReader numberOfClinetsReader = new InfoReader();
                StringFilter filt = new StringFilter();
                String number= "";
                do {
                    number = numberOfClinetsReader.readString(System.in);
                }while (!filter.filterInt(number));
                int num = Integer.parseInt(number);
                Client[] clients = new Client[num];
                clients= ArrayClient.createArrayClient(num);
                array[i].setClientList(clients);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return array;
    }
}
