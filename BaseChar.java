import java.util.*;
import java.io.*;

public class BaseChar{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,defense,luck,charisma;
    private String name;

    public void setName(String s){
	name = s;
    }
    public String getName(){
	return name;
    }

    public void sethealth(int n){
	health = n;
    }
    public int gethealth(){
	return health;
    }

    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }

}
