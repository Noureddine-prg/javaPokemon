package sidiabed.INTERFACES;

import java.util.Random;
import sidiabed.POKEMON.Pokemon;


public interface Attackable {
    public default int flameBlast(Pokemon p){
        Random R = new Random();
        int attackPower = R.nextInt(3);
                
        return attackPower;
    }
    public default int fireStream(Pokemon p){
        Random R = new Random();
        int attackPower = R.nextInt(2);
                
        return attackPower;
    }
    public default int waterSpray(Pokemon p){
        Random R = new Random();
        int attackPower = R.nextInt(3);
                
        return attackPower;
    }  
    public default int hydroFlood(Pokemon p){
        Random R = new Random();
        int attackPower = R.nextInt(2);
                
        return attackPower;
    }
}
