package com.acorn.day01Hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PracTaskService {

    static ArrayList<Player> list = new ArrayList<>();

    static{
        list.add(new Player("Lionel Messi",37,"Inter Miami"));
        list.add(new Player("Lamin Yamal",17,"FC Barcelona"));
        list.add(new Player("Cristiano Ronaldo", 39, "Al Nassr"));
        list.add(new Player("Kylian Mbappé", 25, "Paris Saint-Germain"));
        list.add(new Player("Erling Haaland", 24, "Manchester City"));
        list.add(new Player("Son Heung-min", 32, "Tottenham Hotspur"));
    }

    public ArrayList<Player> showAll(){
        list.forEach(System.out::println);
        return list;
    }

    public Player showOne(String name){
        for(Player p : list){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public void insert(Player p){
        list.add(p);
    }

    public boolean delete(String name){
        for(Player p : list) {
            if (p.getName().equals(name)) list.remove(p);
            return true;
        }
        return false;
    }
}
