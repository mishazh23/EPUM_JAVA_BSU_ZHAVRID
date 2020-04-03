package create;

import entity.Client;
import entity.Dish;
import reader.InfoReader;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayClient {
    public static Client[] createArrayClient(int n) throws Exception{
        Client[] array = new Client[n];
        try {
            for (int i = 0; i < n; i++) {
                System.out.println("Enter the client's name:");
                InfoReader reader = new InfoReader();
                String str = reader.readString(System.in);
                System.out.println("Enter the clint's location: ");
                String location = reader.readString(System.in);
                array[i] = new Client(str, location);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return array;
    }
}
