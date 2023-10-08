
package sidiabed.POKEMON;

import java.sql.SQLException;
import java.util.Random;
import sidiabed.ENUMS.PokemonType;

public class Pokemon_Water extends Pokemon{

    public Pokemon_Water(String name, String pokeSpecies, int pokeValue, int maxHealth, int baseAttackValue, int baseDefenseValue) throws SQLException, ClassNotFoundException {
        super(name, PokemonType.WATER , pokeSpecies, pokeValue, maxHealth, baseAttackValue, baseDefenseValue);
    }

    @Override
    public int attack(Pokemon p) {
        Random R = new Random();
        int attackPower = 0;
        String moveName = "";
        double r = R.nextDouble();
        
        if(r < .05){
           attackPower = (int)(this.waterSpray(p) + (R.nextDouble() * this.getBaseAttackValue()));
           moveName = "Water Spray";
        }else{
            attackPower = (int)(this.hydroFlood(p) + (R.nextDouble() * this.getBaseAttackValue()));
            moveName = "Hydro Flood";
        }
                
        System.out.println(this.getName() + " attacks " + p.getName() + " with " + moveName + " (" + attackPower + ") power");
        return 0;  
    }

    @Override
    public int defend(Pokemon p) {

        Random R = new Random();
        double r = R.nextDouble();
        String moveName = "";
        int defensePower = 0; 
        
        if(r < 0.5){
           defensePower = (int)(this.soak(p) + (R.nextDouble() * this.getBaseDefenseValue()));
           moveName = " Soak ";

        }else{
            defensePower = (int)(this.extinguish(p) + (R.nextDouble() * this.getBaseDefenseValue()));
            moveName = " Extinguish ";
        }

        System.out.println(this.getName() + " defends " + p.getName() + "'s attack with" + moveName + " (" + defensePower + ")");
        return defensePower;
    }
    
    
}
