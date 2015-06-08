import java.util.*;
import java.io.*;

public class Warrior extends BaseChar{
    private int health, mana,maxhealth,maxmana;
    private int level,exp,maxexp;
    private int strength,intelligence,dexterity,defense,luck,charisma;
    private String name;
    private boolean Mage=false,Thief=false,Warrior=true;
    private boolean Archer=false,Cleric=false;
    
    public Warrior(){
	health = 75; mana = 40; maxhealth = 75; maxmana = 40;
	level = 1; exp = 0; maxexp = 20;
	strength = 15; intelligence = 7; dexterity = 10; defense = 10;
	luck = 8; charisma = 10;
    }
    public Warrior(BaseChar bc){
        this.name = bc.getName();
        maxhealth = bc.getmaxhealth() + 25;
    	health = maxhealth;
    	maxmana = bc.getmaxmana() + 10;
    	mana = maxmana;
    	strength = bc.getstrength() + 25;
    	intelligence = bc.getint();
    	dexterity = bc.getdex();
    	defense = bc.getdef() + 10;
    	luck = bc.getluck();
    	charisma = bc.getchar();
    	level = bc.getlevel();
    	exp = bc.getexp();
    	maxexp = bc.getmaxexp();
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
	        maxhealth += maxhealth/3;
	        health = maxhealth;
	        maxmana += maxmana/4;
	        mana = maxmana;
	        strength += 4;
	        intelligence += 2;
	        dexterity += 2;
	        defense += 3;
	        luck += 2;
	        charisma += 2;
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
    public void ArcBall(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int str = this.getint()/2;
            int atk = str + r.nextInt(2*(str/4) + 1) - str/4;
            if (this.isCrit()){
                atk = atk * 2;
                crit = true;
            } System.out.println(this.getName() + " shoots a ball of magic at " + other.getName() + "!");
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
    public void Lightning(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 2;
            int atk = str + r.nextInt(2*(str/3) + 1) - str/4;
            if (this.losemana(10)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " strikes at " + other.getName() + " with lightning!");
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
    public void Tornado(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getint()/2 + 4;
            int atk = str + r.nextInt(2*(str/2) + 1) - str/4;
            if (this.losemana(10)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " summons a tornado over " + other.getName() + "!");
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
