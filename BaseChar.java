import java.util.*;
import java.io.*;

public class BaseChar{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,defense,luck,charisma;
    private String name;

    //Name
    public void setName(String s){
	name = s;
    }
    public String getName(){
	return name;
    }

    //Health
    public void sethealth(int n){
	health = n;
    }
    public int gethealth(){
	return health;
    }

    //MaxHealth
    public void setmaxhealth(int n){
	maxhealth = n;
    }
    public int getmaxhealth(){
	return maxhealth;
    }

    //Mana
    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }
    
    //MaxMana
    public void setmaxmana(int n){
	maxmana = n;
    }
    public int getmaxmana(){
	return maxmana;
    }

    //Level
    public void setlevel(int n){
	level = n;
    }
    public int getlevel(){
	return level;
    }

    //Exp
    public void setupexp(){
	exp = 0;
    }
    public void addexp(int n){
	if (exp + n > maxexp){
	    exp += n;
	} else{
	    exp = n - (maxexp - exp)
	}
    }
    public int getexp(){
	return exp;
    }

    //MaxExp
    public void setupmaxexp(int n){
	maxexp = n;
    }
    public void setmaxexp(int n){
	maxexp += n;
    }
    public int getmaxexp(){
	return maxexp;
    }

    //Strength
    public void setstrength(int n){
	strength = n;
    }
    public int getmana(){
	return mana;
    }

    //Intelligence
    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }

    //Defense
    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }

    //Luck
    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }

    //Charisma
    public void setmana(int n){
	mana = n;
    }
    public int getmana(){
	return mana;
    }

}
