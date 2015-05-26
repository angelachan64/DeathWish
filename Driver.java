import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	//Game g = new Game();
    BaseChar bc = new BaseChar("Diddlysquat");
    bc.addexp(1000);
    System.out.println(bc.getlevel());
    System.out.println(bc.getexp());
    System.out.println(bc.getint());
    bc = new Mage(bc);
    System.out.println(bc.getName());
    System.out.println(bc.getint());
    }
}
