
package sidiabed.POKEMON;

import java.sql.SQLException;
import java.util.Random;
import sidiabed.ENUMS.PokemonType;


public class Pokemon_Fire extends Pokemon{

    public Pokemon_Fire(String name, String pokeSpecies, int pokeValue, int maxHealth, int baseAttackValue, int baseDefenseValue) throws SQLException, ClassNotFoundException {
        super(name, PokemonType.FIRE , pokeSpecies, pokeValue, maxHealth, baseAttackValue, baseDefenseValue);
    }

    @Override
    public int attack(Pokemon p) {
         
        Random R = new Random();
        int attackPower = 0;
        String moveName = "";
        double r = R.nextDouble();
        
        if(r < .05){
            //fireStream attack
           attackPower = (int)(this.fireStream(p) + (R.nextDouble() * this.getBaseAttackValue()));
           moveName = "Fire Stream";
        }else{
            //flameBlast attack
            attackPower = (int)(this.flameBlast(p) + (R.nextDouble() * this.getBaseAttackValue()));
            moveName = "Fire Blast";
        }
               System.out.println(this.getName() + " attacks " + p.getName() + " with " + attackPower + " power");       
        
        System.out.println(this.getName() + " attacks " + p.getName() + " with " + moveName + " (" + attackPower + ") power");
        return attackPower;  
    }

    @Override
    public int defend(Pokemon p) {

        Random R = new Random();
        double r = R.nextDouble();
        String moveName = "";
        int defensePower = 0; 
        
        if(r < 0.5){
           defensePower = (int)(this.evaporate(p) + (R.nextDouble() * this.getBaseDefenseValue()));
           moveName = " Evaporate ";

        }else{
            defensePower = (int)(this.steamify(p) + (R.nextDouble() * this.getBaseDefenseValue()));
            moveName = " Steamify ";
        }
        System.out.println(this.getName() + " defends " + p.getName() + "'s attack with" + moveName + " (" + defensePower + ")");
        return defensePower;
    }
    
    
}
