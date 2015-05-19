import java.util.*;
import java.io.*;

public class BaseChar{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,dexterity,defense,luck,charisma;
    private String name;
    private boolean Mage,Thief,Warrior,Archer,Cleric;

    public BaseChar(){
	health = 50; mana = 50; maxhealth = 50; maxmana = 50;
	level = 1; exp = 0; maxexp = 20;
	strength = 10; intelligence = 10; dexterity = 10; defense = 10;
	luck = 10; charisma = 10;
    }
    public BaseChar(String s){
	health = 50; mana = 50; maxhealth = 50; maxmana = 50;
	level = 1; exp = 0; maxexp = 20;
	strength = 10; intelligence = 10; dexterity = 10; defense = 10;
	luck = 10; charisma = 10;
	name = s;
    }

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
    public void addhealth(int n){
	health = health + n;
    }
    public int gethealth(){
	return health;
    }

    //MaxHealth
    public void setmaxhealth(int n){
	maxhealth = n;
    }
    public void addmaxhealth(int n){
	health = health + n;
    }
    public int getmaxhealth(){
	return maxhealth;
    }

    //Mana
    public void setmana(int n){
	mana = n;
    }
    public void addmana(int n){
	mana = mana + n;
    }
    public int getmana(){
	return mana;
    }
    
    //MaxMana
    public void setmaxmana(int n){
	maxmana = n;
    }
    public void addmaxmana(int n){
	maxmana = maxmana + n;
    }
    public int getmaxmana(){
	return maxmana;
    }

    //Level
    public void setuplevel(int n){
	level = 1;
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
	    level++;
	}
    }
    public int getexp(){
	return exp;
    }

    //MaxExp
    public void setupmaxexp(int n){
	maxexp = n;
    }
    public void addmaxexp(int n){
	maxexp += n;
    }
    public int getmaxexp(){
	return maxexp;
    }

    //Strength
    public void setstrength(int n){
	strength = n;
    }
    public void addstrength(int n){
	strength = strength + n;
    }
    public int getstrength(){
	return strength;
    }

    //Intelligence
    public void setint(int n){
	intelligence = n;
    }
    public void addint(int n){
	intelligence = intelligence + n;
    }
    public int getint(){
	return intelligence;
    }

    //Dexterity
    public void setdex(int n){
	dexterity = n;
    }
    public void adddex(int n){
	dexterity = dexterity + n;
    }
    public int getdex(){
	return dexterity;
    }

    //Defense
    public void setdef(int n){
	defense = n;
    }
    public void adddef(int n){
	defense = defense + n;
    }
    public int getdef(){
	return defense;
    }

    //Luck
    public void setluck(int n){
	luck = n;
    }
    public void addluck(int n){
	luck = luck + n;
    }
    public int getluck(){
	return luck;
    }

    //Charisma
    public void setchar(int n){
	charisma = n;
    }
    public void addchar(int n){
	charisma = charisma + n;
    }
    public int getchar(){
	return charisma;
    }

    //Check class
    public boolean isMage(){
	return Mage;
    }
    public boolean isThief(){
	return Thief;
    }
    public boolean isWarrior(){
	return Warrior;
    }
    public boolean isArcher(){
	return Archer;
    }
    public boolean isCleric(){
	return Cleric;
    }
}
