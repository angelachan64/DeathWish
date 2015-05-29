import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	//Game g = new Game();
    BaseChar bc = new BaseChar("Diddlysquat");
    BaseChar other = new BaseChar("Opponent");
    bc = new Mage(bc);
    other = new Cleric(other);
    //bc.Throw(other);
    //bc.Throw(other);
    //bc.Throw(other);
    //bc.Throw(other);
    //bc.Throw(other);
    //bc.Slash(other);
    //bc.Slash(other);
    bc.ArcBall(other);
    bc.Lightning(other);
    bc.Tornado(other);
    //bc.Lunge(other);
    //bc.Slash(other);
    //bc.Lunge(other);
    //bc.Lunge(other);
    //bc.Lunge(other);
    }
}
