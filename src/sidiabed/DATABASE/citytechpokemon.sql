DROP DATABASE IF EXISTS citytechpokemon;
CREATE DATABASE citytechpokemon;
USE citytechpokemon;

CREATE TABLE pokemon(
    PokeName VARCHAR(50),
    PokeSpecies VARCHAR(50),
    PokeType ENUM('WATER','FIRE'),
    PokeValue INT,
    MaxHealth INT,
    CurrentHealth INT,
    BaseAttackValue INT,
    BaseDefenseValue INT,

    CONSTRAINT PK_Pokemon PRIMARY KEY(PokeName)
);

CREATE TABLE pokemon_record(
    PokeName VARCHAR(50),
    Wins INT,
    Loses INT,
    Draws INT,

    CONSTRAINT PK_Pokemon PRIMARY KEY(PokeName),
    CONSTRAINT FK_record FOREIGN KEY(PokeName) REFERENCES Pokemon(PokeName)
);

CREATE TABLE pokemon_battles(
    BattleID VARCHAR(50),
    WinnerName VARCHAR(50),
    LoserName VARCHAR(50),
    WinnerSpecies VARCHAR(50),
    LoserSpecies VARCHAR(50),

    CONSTRAINT PK_battles PRIMARY KEY(BattleID)
);
