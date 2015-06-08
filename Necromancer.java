import java.util.*;
import java.io.*;

public class Necromancer extends Mage{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,dexterity,defense,luck,charisma;
    private String name;
    private boolean Mage=true,Thief=false,Warrior=false;
    private boolean Archer=false,Cleric=false;
    
    public Necromancer(){
	health = 40; mana = 75; maxhealth = 40; maxmana = 75;
	level = 1; exp = 0; maxexp = 20;
	strength = 8; intelligence = 15; dexterity = 10; defense = 7;
	luck = 10; charisma = 10;
    }
    public Necromancer(BaseChar bc){
        this.name = bc.getName();
    	maxhealth = bc.getmaxhealth() + 15;
    	health = maxhealth;
    	maxmana = bc.getmaxmana() + 30;
    	mana = maxmana;
    	strength = bc.getstrength(); 
    	intelligence = bc.getint() + 30;
    	dexterity = bc.getdex() + 15;
    	defense = bc.getdef();
    	luck = bc.getluck();
    	charisma = bc.getchar(); 
    }
    public Necromancer(Mage bc){
        this.name = bc.getName();
    	maxhealth = bc.getmaxhealth() + 15;
    	health = maxhealth;
    	maxmana = bc.getmaxmana() + 30;
    	mana = maxmana;
    	strength = bc.getstrength(); 
    	intelligence = bc.getint() + 30;
    	dexterity = bc.getdex() + 15;
    	defense = bc.getdef();
    	luck = bc.getluck();
    	charisma = bc.getchar(); 
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
    public void losehealth(int n){
        if (health-n <= 0){
            health = 0;
            System.out.println(this.getName() + " has died!");
        } else{
            health -= n;
        }
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
    public boolean losemana(int n){
        if (mana-n < 0){
            System.out.println("Not enough mana!");
            return false;
        } else{
            mana -= n;
            return true;
        }
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
	if (exp + n < maxexp){
	    exp += n;
	} else{
	    exp = n;
	    while (exp > maxexp){
	        exp = exp - maxexp;
	        level++;
	        maxexp = maxexp + maxexp/4;
	        maxhealth += maxhealth/4;
	        health = maxhealth;
	        maxmana += maxmana/3;
	        mana = maxmana;
	        strength += 2;
	        intelligence += 5;
	        dexterity += 3;
	        defense += 2;
	        luck += 3;
	        charisma += 3;
	    }
    }
    }
    public String getexpS(){
	return "" + exp + "/" + maxexp;
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
    
    //Skills
    public void Zombie(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 4;
            int atk = str + r.nextInt(str/4) - str/4;
            if (this.losemana(15)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " summons a zombie to attack " + other.getName() + "!");
                if (other.dodge()){
                    System.out.println(other.getName() + " dodged the attack!");
                } else{
                    if (crit){
                        System.out.println("Critical hit!");
                    } System.out.println(other.getName() + " has lost " + atk + " health.");
                    other.losehealth(atk);
                    System.out.println(other.getName() + " now has " + other.gethealth() + " HP.");
                }
            }
        }
    }
    public void Skeleton(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 6;
            int atk = str + r.nextInt(str/4) - str/5;
            if (this.losemana(20)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " summons a skeleton to attack " + other.getName() + "!");
                if (other.dodge()){
                    System.out.println(other.getName() + " dodged the attack!");
                } else{
                    if (crit){
                        System.out.println("Critical hit!");
                    } System.out.println(other.getName() + " has lost " + atk + " health.");
                    other.losehealth(atk);
                    System.out.println(other.getName() + " now has " + other.gethealth() + " HP.");
                }
            }
        }
    }
    public void Reaper(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 6;
            int atk = str + r.nextInt(str/4) - str/6;
            if (this.losemana(20)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " summons a grim reaper to attack " + other.getName() + "!");
                if (other.dodge()){
                    System.out.println(other.getName() + " dodged the attack!");
                } else{
                    if (crit){
                        System.out.println("Critical hit!");
                    } System.out.println(other.getName() + " has lost " + atk + " health.");
                    other.losehealth(atk);
                    System.out.println(other.getName() + " now has " + other.gethealth() + " HP.");
                }
            }
        }
    }
}