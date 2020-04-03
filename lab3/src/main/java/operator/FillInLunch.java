package operator;

import entity.Client;
import entity.Dish;

import java.util.ArrayList;

public class FillInLunch {
    public void fillingIn(Dish[] dishes, Client[] clients){
        ArrayList<Dish> lunch = new ArrayList<Dish>();
        for(int i=0;i<clients.length;i++){
            for(int j=0;j<dishes.length;j++){
                ArrayList<Client> array = new ArrayList<Client>(dishes[j].getClientArrayList());
                for(int k=0;k<dishes[j].getClientArrayList().size();k++)
                    if(clients[i].getClientName().equals(array.get(k).getClientName())){
                        lunch.add(dishes[j]);
                    }
            }
            clients[i].setLunch(lunch);
        }

    }
}
