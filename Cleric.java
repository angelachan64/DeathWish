import java.util.*;
import java.io.*;

public class Cleric extends BaseChar{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,dexterity,defense,luck,charisma;
    private String name;
    private boolean Mage=false,Thief=false,Warrior=false;
    private boolean Archer=false,Cleric=true;
    
    public Cleric(){
	health = 50; mana = 50; maxhealth = 50; maxmana = 50;
	level = 1; exp = 0; maxexp = 20;
	strength = 10; intelligence = 10; dexterity = 10; defense = 10;
	luck = 10; charisma = 10;
    }
    public Cleric(BaseChar bc){
        name = bc.getName();
    	maxhealth = bc.getmaxhealth() + 10;
    	health = maxhealth;
    	maxmana = bc.getmaxmana() + 25;
    	mana = maxmana;
    	strength = bc.getstrength(); 
    	intelligence = bc.getint() + 25;
    	dexterity = bc.getdex();
    	defense = bc.getdef();
    	luck = bc.getluck();
    	charisma = bc.getchar() + 10; 
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
    public void gainhealth(int n){
        if (health+n >= maxhealth){
            health = maxhealth;
        } else{
            health += n;
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
	        System.out.println(getexp());
	        exp = exp - maxexp;
	        level++;
	        maxexp = maxexp + maxexp/4;
	        maxhealth += maxhealth/4;
	        health = maxhealth;
	        maxmana += maxmana/3;
	        mana = maxmana;
	        strength += 2;
	        intelligence += 4;
	        dexterity += 2;
	        defense += 2;
	        luck += 2;
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
    public void LightBall(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int str = this.getint()/2;
            int atk = str + r.nextInt(str/4) - str/3;
            if (this.isCrit()){
                atk = atk * 2;
                crit = true;
            } System.out.println(this.getName() + " shoots a ball of light at " + other.getName() + "!");
            if (other.dodge()){
                System.out.println(other.getName() + " dodged the attack!");
            } else{
                if (crit){
                    System.out.println("Critical hit!");
                } System.out.println(other.getName() + " has lost " + atk + " health.");
                other.losehealth(atk - other.defProtect());
                System.out.println(other.getName() + " now has " + other.gethealth() + " HP.");
            }
        }
    }
    public void Heal(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 2;
            int atk = str + r.nextInt(str/4) - str/4;
            if (this.losemana(10)){
                System.out.println(this.getName() + " heals " + other.getName() + "!");
                System.out.println(other.getName() + " has regained " + atk + " health.");
            }
        }
    }
    public void SuperHeal(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 4;
            int atk = (str + r.nextInt(str/4) - str/5) * 7/3;
            if (this.losemana(15)){
                System.out.println(this.getName() + " heals " + other.getName() + "!");
                other.addhealth(atk);
                System.out.println(other.getName() + " has regained " + atk + " health.");
            }
        }
    }
    public void Exorcism(BaseChar other){
        return;
    }
    public void Confession(BaseChar other){
        return;
    }
    public void Blessing(BaseChar other){
        return;
    }
}