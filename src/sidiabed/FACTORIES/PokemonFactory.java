package sidiabed.FACTORIES;

import java.sql.SQLException;
import java.sql.ResultSet;
import sidiabed.BATTLE.Combat;
import sidiabed.DATABASE.DBSupport;
import sidiabed.ENUMS.PokemonType;
import sidiabed.POKEMON.*;
import sidiabed.HELPER.Generate;


public class PokemonFactory {
        
    public static Pokemon buildPokemon(String pokeName) throws SQLException, ClassNotFoundException{
        ResultSet R = null;
        
        String r1;
        String r2;
        String r3;
        int r4;
        int r5;
        int r7;
        int r8;
        int s1;
        int s2;
        int s3;
                
       try{

            String q = "SELECT * FROM pokemon p " + 
            "INNER JOIN pokemon_record pr ON p.PokeName = pr.PokeName " + 
            "WHERE p.PokeName ='" + pokeName + "';";
            R = DBSupport.fetchResultSet(q);
            R.next();
        
            r1 = R.getString("PokeName");
            r2 = R.getString("PokeSpecies");
            r3 = R.getString("PokeType");
            r4 = R.getInt("PokeValue");
            r5 = R.getInt("MaxHealth");
            r7 = R.getInt("BaseAttackValue");
            r8 = R.getInt("BaseDefenseValue"); 
            s1 = R.getInt("Wins");
            s2 = R.getInt("Loses");
            s3 = R.getInt("Draws");
       
       }finally{
           R.close();
       }

                
        PokemonType ptype;
        if(r3.equals("FIRE")){
            ptype = PokemonType.FIRE;
            Pokemon_Fire p = new Pokemon_Fire(r1,r2,r4,r5,r7,r8);
            p.setWins(s1); p.setLosses(s2); p.setDraws(s3);
            return p;
        }
        else if(r3.equals("WATER")){
            ptype = PokemonType.WATER;
            Pokemon_Water p = new Pokemon_Water(r1,r2,r4,r5,r7,r8);
            p.setWins(s1); p.setLosses(s2); p.setDraws(s3);
            return p;
        }
        else{
            Pokemon p = null;
            return p;
        }
    }
    
    
    public static void populatePokemonTable(int numberGenerated) throws SQLException, ClassNotFoundException{
        // create new pokemon fire or water [even fire odd water]
        // create a unique name (nickname) create function that has like 2k nicknames stored and have it give you a random one
        // Give it a species (pokemon name) create function that has pokemon names stored (fire or water types) do like 300 for each and have it return a random one depending on the type being created
        // Give it a species (pokemon name) create function that has pokemon names stored (fire or water types) do like 300 for each and have it return a random one depending on the type being created
        // For stats generate 4 random numbers that have bounds 
        // instantiate new pokemon object

        for(int i = 0; i < numberGenerated; i++){
            PokemonType type = Generate.generatePokemonType();
            String name = Generate.generateNickname();
            String species = Generate.generateSpecies(type);
          
            if(type == PokemonType.FIRE){
                Pokemon_Fire newPokemon = new Pokemon_Fire(
                        name,
                        species,
                        Generate.generateRandomNumber(100, 200),
                        Generate.generateRandomNumber(10,30),
                        Generate.generateRandomNumber(4, 10),
                        Generate.generateRandomNumber(4, 10));
            }
            else{
                Pokemon_Water newPokemon = new Pokemon_Water(
                        name,
                        species,
                        Generate.generateRandomNumber(100, 200),
                        Generate.generateRandomNumber(10,30),
                        Generate.generateRandomNumber(4, 10),
                        Generate.generateRandomNumber(4, 10));        
            }
        
        }        
    }
    
    
    
    public static void populateBattleTable(int numberGenerated) throws SQLException, ClassNotFoundException{
        for(int i = 0; i < numberGenerated; i++){
           
           //Pull two pokemon from table and create two objects
           String[] pokemonData1 = Generate.pullRandomStoredPokemon();
           String pokeName1 = pokemonData1[0];          
           Pokemon p1 = buildPokemon(pokeName1);
           
           String[] pokemonData2 = Generate.pullRandomStoredPokemon();
           
           if(pokemonData2 == pokemonData1){
                pokemonData2 = Generate.pullRandomStoredPokemon();
           }
           
           String pokeName2 = pokemonData2[0];           
           Pokemon p2 = buildPokemon(pokeName2);
           
           
           
           //Make the two random pokemon battle
           Combat.battlePokemon(p1, p2);
         
           
           
        }
    }
}
