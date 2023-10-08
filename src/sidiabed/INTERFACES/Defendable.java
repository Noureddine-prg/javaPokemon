
package sidiabed.INTERFACES;

import java.util.Random;
import sidiabed.POKEMON.Pokemon;


public interface Defendable {
    public default int evaporate(Pokemon p){
        Random R = new Random();
        int defensePower = R.nextInt(2);
                
        return defensePower;
    }
    public default int steamify(Pokemon p){
        Random R = new Random();
        int defensePower = R.nextInt(3);
                
        return defensePower;
    }
    public default int soak(Pokemon p){
        Random R = new Random();
        int defensePower = R.nextInt(2);
                
        return defensePower;
    }
    public default int extinguish(Pokemon p){
        Random R = new Random();
        int defensePower = R.nextInt(3);
                
        return defensePower;
    }

}
