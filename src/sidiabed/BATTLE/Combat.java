package sidiabed.BATTLE;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import sidiabed.DATABASE.DBSupport;
import sidiabed.POKEMON.Pokemon;

public class Combat {

    public static int lastBattleId;
    
    static {
        try {
            lastBattleId = getLastBattleID();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void battlePokemon(Pokemon p1, Pokemon p2) throws SQLException, ClassNotFoundException{
        
        for(int i = 0; i < 5; i++){
            System.out.print("\n");
            System.out.println("Round: " + i);

            if(i%2 ==0){
                fightRound(p1, p2);
            }else{
                fightRound(p2,p1);
            }
        }

        if(p1.getCurrentHealth() > p2.getCurrentHealth()){
            System.out.println("<-----" + p1.getName() + " WINS ----->");
            p1.setWins(p1.getWins() + 1);
            p2.setLosses(p2.getLosses() + 1);

            String query = "UPDATE pokemon_record SET wins = " + p1.getWins() + " WHERE PokeName = '" + p1.getName() + "';";
            DBSupport.executeQuery(query);

            String query2 = "UPDATE pokemon_record SET loses = " + p2.getLosses() + " WHERE PokeName = '" + p2.getName() + "';";
            DBSupport.executeQuery(query2);

            String query3 = "INSERT INTO pokemon_battles VALUES('B" + (++lastBattleId) + "','" + p1.getName() + "','" + p2.getName() + "','" + p1.getPokeSpecies() + "','" + p2.getPokeSpecies() + "');";
            DBSupport.executeQuery(query3);
            
        }
        if(p2.getCurrentHealth() > p1.getCurrentHealth()){
            System.out.println("<-----" + p2.getName() + " WINS ----->");
            p2.setWins(p2.getWins() + 1);
            p1.setLosses(p1.getLosses() + 1);

            String query = "UPDATE pokemon_record SET wins = " + p2.getWins() + " WHERE PokeName = '" + p2.getName() + "';";
            DBSupport.executeQuery(query);

            String query2 = "UPDATE pokemon_record SET loses = " + p1.getLosses() + " WHERE PokeName = '" + p1.getName() + "';";
            DBSupport.executeQuery(query2);

            String query3 = "INSERT INTO pokemon_battles VALUES('B" + (++lastBattleId) + "','" + p2.getName() + "','" + p1.getName() + "','" + p2.getPokeSpecies() + "','" + p1.getPokeSpecies() + "');";
            DBSupport.executeQuery(query3);           
        }
        if(p1.getCurrentHealth() == p2.getCurrentHealth()){
            System.out.println("DRAW");
            p1.setDraws(p1.getDraws() + 1);
            p2.setDraws(p2.getDraws() + 1);

            String query = "UPDATE pokemon_record SET draws = " + p1.getDraws() + " WHERE pokeName = '" + p1.getName() + "';";
            DBSupport.executeQuery(query);

            String query2 = "UPDATE pokemon_record SET draws = " + p2.getDraws() + " WHERE pokeName = '" + p2.getName() + "';";
            DBSupport.executeQuery(query2);

        }

        System.out.println("");        
        p1.displayPokemon();        
        
        System.out.println("");        
        p2.displayPokemon();        

        lastBattleId++;

    }
    
    public static int getLastBattleID() throws SQLException, ClassNotFoundException{
        int lastBattleId = 0;
        Statement stmt = null;
       
        String query = "SELECT MAX(CAST(SUBSTRING(BattleID, 2) AS UNSIGNED)) AS max_id FROM pokemon_battles"; 
        ResultSet rs = DBSupport.fetchResultSet(query);
            
        if (rs.next()) {
            lastBattleId = rs.getInt("max_id");
        }
        
        rs.close();      
        
        return lastBattleId; 
        
    }

    
    public static void fightRound(Pokemon p1, Pokemon p2){
        int attack = p1.attack(p2);
        int defense = p2.defend(p1);
        
        int damage = attack - defense;
        
        if(damage < 0){
            damage = 0;
        }
        
        p2.setCurrentHealth(p2.getCurrentHealth() - damage);
        System.out.println(p2.getName() + " suffers " + damage + " points of damage");
        
    }
}
