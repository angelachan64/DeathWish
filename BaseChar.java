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
	this.health = n;
    }
    public int gethealth(){
	return this.health;
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
    /*public void setexp(int n){
        exp = n
	    while(exp > maxexp){
	        setexp(exp - n);
	        setlevel
	    }
    }*/
    public void setmaxexp(int n){
        maxexp = n;
    }
    
    public void addexp(int n){
	if (exp + n < maxexp){
	    exp += n;
	} else{
	    exp += n;
	    while (exp >= maxexp){
            exp = exp - maxexp;
	        level++;
	        maxexp = maxexp + maxexp/4;
	        this.statchange();
	    }
    }
    }
    
    public void statchange(){
        setmaxhealth(maxhealth + maxhealth/4);
        sethealth(maxhealth);
        setmaxmana(maxmana + maxmana/4);
        setmana(maxmana);
        setstrength(strength + 2);
        setint(intelligence + 2);
        setdex(dexterity + 2);
        setdef(defense + 2);
        setluck(luck + 2);
        setchar(charisma + 2);
    }
    
    public String getexpS(){
	return ""+exp + "/" + maxexp;
    }
    public int getexp(){
        return exp;
    }

    //MaxExp
    public void setupmaxexp(int n){
	maxexp = n;
    }
    public int getmaxexp(){
	return maxexp;
    }

    //Strength
    public void setstrength(int n){
	strength = n;
    }
    public int getstrength(){
	return strength;
    }

    //Intelligence
    public void setint(int n){
	intelligence = n;
    }
    public int getint(){
	return intelligence;
    }

    //Dexterity
    public void setdex(int n){
	dexterity = n;
    }
    public int getdex(){
	return dexterity;
    }

    //Defense
    public void setdef(int n){
	defense = n;
    }
    public int getdef(){
	return defense;
    }
    public void lowerDef(int n){
        setdef(getdef() - n);
    }

    //Luck
    public void setluck(int n){
	luck = n;
    }
    public int getluck(){
	return luck;
    }

    //Charisma
    public void setchar(int n){
	charisma = n;
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
    
    //Rates
    public boolean isCrit(){
        Random r = new Random();
        int rate = this.getluck();
        if (r.nextInt(1000) < (rate - (rate%10))){
            return true;
        } return false;
    }
    public boolean dodge(){
        Random r = new Random();
        int rate = this.getdex();
        if (r.nextInt(1000) < (rate - (rate%10))){
            return true;
        } return false;
    }
    public int defProtect(){
        int p = this.getdef()/10;
        return p;
    }
    
    //Skills
    public void Lunge(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int str = this.getstrength()/2;
            int atk = str + r.nextInt(str/4) - str/2;
            if (this.isCrit()){
                atk = atk * 2;
                crit = true;
            } System.out.println(this.getName() + " lunged at " + other.getName() + "!");
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
    public void Slash(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int str = this.getstrength()/2 + 2;
            int atk = str + r.nextInt(str/4) - str/3;
            if (this.losemana(5)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " slashed at " + other.getName() + "!");
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
    }
    public void Throw(BaseChar other){
        if (other.gethealth() == 0){
            //System.out.println(other.getName() + " is already dead!");
            return;
        } else{
            Random r = new Random();
            boolean crit = false;
            int mana = this.getmana();
            int str = this.getstrength()/2 + 4;
            int atk = str + r.nextInt(str/4) - str/4;
            if (this.losemana(10)){
                if (this.isCrit()){
                    atk = atk * 2;
                    crit = true;
                } System.out.println(this.getName() + " threw a dagger at " + other.getName() + "!");
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
    }
    public void ArcBall(BaseChar other){
        return;
    }
    public void Lightning(BaseChar other){
        return;
    }
    public void Tornado(BaseChar other){
        return;
    }
    public void Zombie(BaseChar other){
        return;
    }
    public void Skeleton(BaseChar other){
        return;
    }
    public void Reaper(BaseChar other){
        return;
    }
    public void Fireball(BaseChar other){
        return;
    }
    public void Incinerate(BaseChar other){
        return;
    }
    public void Phoenix(BaseChar other){
        return;
    }
    public void Falcon(BaseChar other){
        return;
    }
    public void Bear(BaseChar other){
        return;
    }
    public void Dragon(BaseChar other){
        return;
    }
    public void LightBall(BaseChar other){
        return;
    }
    public void Heal(BaseChar other){
        return;
    }
    public void SuperHeal(BaseChar other){
        return;
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
