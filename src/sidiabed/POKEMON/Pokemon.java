
package sidiabed.POKEMON;

import java.sql.SQLException;
import sidiabed.DATABASE.DBSupport;
import sidiabed.ENUMS.PokemonType;
import sidiabed.INTERFACES.*;

public abstract class Pokemon implements Attackable, Defendable{
    private String name; 
    private PokemonType pokeType;
    private String pokeSpecies; 
    private int pokeValue;
    private int maxHealth;
    private int currentHealth; 
    private int baseAttackValue; 
    private int baseDefenseValue;
    private int wins; 
    private int losses;
    private int draws;

    public Pokemon() {}

    public Pokemon(String name, PokemonType pokeType, String pokeSpecies, int pokeValue, int maxHealth, int baseAttackValue, int baseDefenseValue) throws SQLException, ClassNotFoundException{
        this.name = name;
        this.pokeType = pokeType;
        this.pokeSpecies = pokeSpecies;
        this.pokeValue = pokeValue;
        this.maxHealth = maxHealth;
        this.baseAttackValue = baseAttackValue;
        this.baseDefenseValue = baseDefenseValue;
        this.currentHealth = maxHealth; 
        this.wins = 0; this.losses = 0; this.draws = 0;
        this.toSQL();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getPokeType() {
        return pokeType;
    }

    public void setPokeType(PokemonType pokeType) {
        this.pokeType = pokeType;
    }

    public String getPokeSpecies() {
        return pokeSpecies;
    }

    public void setPokeSpecies(String pokeSpecies) {
        this.pokeSpecies = pokeSpecies;
    }

    public int getPokeValue() {
        return pokeValue;
    }

    public void setPokeValue(int pokeValue) {
        this.pokeValue = pokeValue;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getBaseAttackValue() {
        return baseAttackValue;
    }

    public void setBaseAttackValue(int baseAttackValue) {
        this.baseAttackValue = baseAttackValue;
    }

    public int getBaseDefenseValue() {
        return baseDefenseValue;
    }

    public void setBaseDefenseValue(int baseDefenseValue) {
        this.baseDefenseValue = baseDefenseValue;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Poke Type: " + pokeType.name() + "\n" +
               "Poke Species: " + pokeSpecies + "\n" +
               "Poke Value: " + pokeValue + "\n" +
               "Max Health: " + maxHealth + "\n" +
               "Current Health: " + currentHealth + "\n" +
               "Base Attack Value: " + baseAttackValue + "\n" +
               "Base Defense Value: " + baseDefenseValue + "\n" +
               "Wins: " + wins + "" +
               " Losses: " + losses + "" +
               " Draws: " + draws;
    }

    
    public void displayPokemon(){
        System.out.println(this.toString());
    };
    
    public abstract int attack(Pokemon p);
    
    public abstract int defend(Pokemon p);
    
    
    public void toSQL() throws SQLException, ClassNotFoundException{
        String query = "INSERT INTO pokemon VALUES('" + name + "', '" + pokeSpecies + "', '" + pokeType + "', '" + pokeValue + "', '" + maxHealth + "', '" + currentHealth + "', '" + baseAttackValue + "', '" + 
                baseDefenseValue + "') ON DUPLICATE KEY UPDATE pokeSpecies = '" + pokeSpecies + "', pokeType = '" + pokeType + "', pokeValue = '" + pokeValue + "', maxHealth = '" + maxHealth + "', currentHealth = '" + 
                currentHealth + "', baseAttackValue = '" + baseAttackValue + "', baseDefenseValue = '" + baseDefenseValue + "';";
      
      DBSupport.executeQuery(query);
      
      
      String query2 = "INSERT INTO pokemon_record VALUES('" + name + "', " + wins + ", " + losses + ", " + draws + ") ON DUPLICATE KEY UPDATE Wins = " + wins + ", Loses = " + losses + ", Draws = " + draws + ";";
      

      DBSupport.executeQuery(query2);
    };
    
    
    
    
}
