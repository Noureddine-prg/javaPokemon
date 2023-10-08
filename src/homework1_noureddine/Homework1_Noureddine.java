package homework1_noureddine;

import java.sql.SQLException;
import sidiabed.FACTORIES.PokemonFactory;

public class Homework1_Noureddine {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        
        PokemonFactory.populatePokemonTable(5);
        PokemonFactory.populateBattleTable(500);
    }
}
