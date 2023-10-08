package sidiabed.HELPER;

import java.util.Random;
import sidiabed.DATABASE.DBSupport;
import sidiabed.ENUMS.PokemonType;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Generate {
    
    
    /* 
        Methods: 
        pullRandomStoredPokemon - Grabs a nickname from the db so we can build pokemon object for battle
        generateNicknames() - Returns a random nickname string within the array
        generateSpecies(type) - Returns a random pokemon species string within the arry
        generatePokemonType -  Returns either a Fire Type or a Water Type 
    
    */
    
    
    public static String generateNickname(){
        String[] pokemonNicknames = {
            "Sparky", "Bubbles", "Blaze", "Tide", "Inferno", "Mist",
            "Fluffy", "Shadow", "Luna", "Sunny", "Pebbles", "Twilight",
            "Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid",
            "Donner", "Blitzen", "Nimbus", "Stormy", "Whiskers", "Flicker",
            "Glimmer", "Shimmer", "Glow", "Star", "Moonbeam", "Rusty",
            "Goldie", "Silvie", "Bronze", "Cobalt", "Crimson", "Jade",
            "Sapphire", "Topaz", "Pearl", "Onyx", "Emerald", "Turquoise",
            "Raven", "Phoenix", "Hawk", "Falcon", "Eagle", "Talon",
            "Sky", "Thunder", "Lightning", "Cloud", "Rain", "Snowflake",
            "Hail", "Sleet", "Misty", "Foggy", "Zephyr", "Breeze",
            "Gusty", "Blowy", "Hurricane", "Tornado", "Cyclone", "Typhoon",
            "Dewy", "Drizzle", "Splash", "Wave", "River", "Stream",
            "Brook", "Lake", "Pond", "Spring", "Delta", "Bay",
            "Gulf", "Sea", "Ocean", "Tsunami", "Ripple", "Surf",
            "Tidal", "Bubble", "Foam", "Spray", "Mist", "Frost",
            "Ice", "Sleet", "Slush", "Snow", "Blizzard", "Chill",
            "Freeze", "Glacier", "Igloo", "Polar", "Arctic", "Antarctic",
            "Bear", "Wolf", "Fox", "Lynx", "Puma", "Tiger",
            "Lion", "Jaguar", "Panther", "Leopard", "Cheetah", "Cougar",
            "Bobcat", "Ocelot", "Serval", "Caracal", "Eren", "Weasel",
            "Mink", "Otter", "Badger", "Wolverine", "Hedgehog", "Porcupine",
            "Sloth", "Meerkat", "Mongoose", "Swan", "Duck", "Goose",
            "Eagle", "Hawk", "Falcon", "Vulture", "Owl", "Pigeon",
            "Dove", "Parrot", "Raven", "Crow", "Magpie", "Jay",
            "Sparrow", "Robin", "Finch", "Flicker", "Woodpecker", "Hummingbird",
            "Buddy", "Whisper", "Ranger", "Scout", "Explorer", "Swift",
            "Bolt", "Zoom", "Flash", "Streak", "Dash", "Blitz",
            "Sonic", "Rocket", "Jet", "Racer", "Bullet", "Arrow",
            "Dart", "Laser", "Radar", "Seeker", "Hunter", "Tracker",
            "Pioneer", "Voyager", "Navigator", "Adventurer", "Traveler", "Wanderer",
            "Roamer", "Marauder", "Rover", "Globetrotter", "Trekker", "Nomad",
            "Drifter", "Rambler", "Walker", "Strider", "Runner", "Jumper",
            "Hopper", "Bounder", "Leaper", "Glider", "Flyer", "Soarer",
            "Diver", "Swimmer", "Sinker", "Floater", "Skater", "Slider",
            "Surfer", "Cruiser", "Driver", "Rider", "Driver", "Steerer",
            "Pilot", "Captain", "Chief", "Boss", "Leader", "Master",
            "Champion", "Winner", "Topper", "Ace", "Best", "First",
            "Prime", "Ultra", "Mega", "Super", "Hyper", "Turbo",
            "Speedy", "Brisk", "Rapid", "Quick", "Hasty", "Nifty",
            "Snappy", "Blister", "Dynamo", "Burst", "Blast", "Blowout",
            "Rush", "Hurricane", "Tornado", "Cyclone", "Whirlwind", "Twister",
            "Gust", "Wind", "Breeze", "Draft", "Vent", "Air",
            "Cloud", "Vapor", "Steam", "Mist", "Fog", "Haze",
            "Puff", "Blow", "Waft", "Breath", "Whiff", "Sniff",
            "Scent", "Smell", "Odor", "Perfume", "Fragrance", "Aroma",
            "Stink", "Stench", "Pong", "Funk", "Musk", "Redolence",
            "Bouquet", "Nose", "Snout", "Beak", "Muzzle", "Trunk",
            "Snoot", "Proboscis", "Bill", "Pecker", "Jaw", "Teeth", "Tooth", "Tusk", "Fang",
            "Trace", "Tracker", "Trailer", "Hunter", "Stalker", "Shadow",
            "Tag", "Hound", "Dog", "Harass", "Pester", "Bother", "Leafy", "Bloomer", "Twister", 
            "ThunderClap", "Starshine", "Moonlit","SunnyRay", "SnowTail", "WindGlide", "RainDancer", "FlarePetal", "TidalWave",
            "Mystique", "ShadowFang", "AstralWing", "EclipseTail", "WhisperClaw", "SolarBeam",
            "LunarLance", "DuskFury", "DawnGuard", "NovaStar", "Eldritch", "Gloomshade",
            "BattlePaw", "WarFang", "StrikeWing", "ArmorScale", "ShieldTail", "SwordBeak",
            "Lancer", "BlitzClaw", "CombatFur", "ValorTusk", "KnightFin", "WarriorWhisk",
            "PyroPuff", "HydroHorn", "ElectroFur", "TerraTail", "AeroWing", "FrostFang",
            "MagmaMane", "SteamSnout", "BoltBeak", "QuakeClaw", "TornadoToes", "BlizzardBrow",
            "SwiftFoot", "GentleGaze", "MightyMuzzle", "LavaLeap", "SilentSting", "ThunderToe",
            "MysticMist", "GoldenGill", "SilverScale", "CrystalClaw", "GemEye", "DiamondDust",
            "PearlPaw", "RubyRoar", "SapphireScream", "EmeraldEcho", "TopazTear", "JadeJump",
            "MoonMuse", "StarStriker", "SunSeeker", "GalaxyGlow", "CometChase", "MeteorMight",
            "NebulaNose", "OrbitEar", "PlanetPounce", "AsteroidAce", "StellarSprint", "LightLeap",
            "EagleEye", "TigerTread", "LionLunge", "BearBounce", "FalconFlight", "RavenRush",
            "OwlOgle", "BeeBuzz", "MantisMight", "WaspWhirl", "AntAttack", "BeetleBlast",
            "HopperHigh", "BugBounce", "WormWiggle", "MothMingle", "ButterflyBreeze", "SpiderSpin",
            "ScorpionSting", "LocustLunge", "FlyFlit", "DragonDart", "PhoenixFlare", "GriffinGlide",
            "UnicornUp", "ManticoreMight", "BasiliskBlink", "HarpyHigh", "CentaurCharge", "MinotaurMaul",
            "NymphNod", "SpriteSprint", "ElfEdge", "DwarfDive", "FairyFly", "TrollTrail",
            "OgreOffer", "GiantGait", "GnomeGlimpse", "SpriteSight", "CyclopsSee", "SirenSong",
            "PixiePrance", "MermaidMuse", "KrakenKick", "HydraHello", "GorgonGaze", "SatyrStride",
            "FaunFrolic", "VampireVeer", "WerewolfWander", "ZombieZigzag", "GhoulGlide", "WitchWhirl",
            "DemonDash", "AngelArc", "SpiritSkip", "NagaNod", "BansheeBlast", "GenieGlimpse",
            "LeprechaunLook", "ChimeraCharge", "SphinxSee", "PegasusPrance", "LamiaLeap", "MummyMove",
            "FrankensteinFlee", "YetiYelp", "GremlinGrip", "GoblinGo", "GhostGlide", "DragonflyDart",
            "DinoDash", "RaptorRun", "RexRampage", "FossilFoot", "StoneStomp", "MagmaMarch",
            "LavaLunge", "EruptionEscape", "CinderCircle", "FlameFlicker", "BlazeBolt", "InfernoInch",
            "HeatHop", "FireFoot", "WarmWave", "GlowGo", "SparkSkip", "EmberEscape",
            "CharCoalChase", "BurnBounce", "TorchTrot", "FlintFlash", "MatchMove", "SizzleStride",
            "ScorchSprint", "AshArc", "SmokeSlip", "FumeFrolic", "SteamSlide", "MistMingle",
            "BubbleBolt", "RippleRun", "WaveWander", "SurgeStride", "SplashSkip", "DewDance",
            "RainRush", "PuddlePrance", "StreamSlide", "RiverRun", "BrookBounce", "PondPounce",
            "SeaStride", "OceanOgle", "MarineMarch", "AquaArc", "TideTrail", "H2OHop",
            "LiquidLeap", "CurrentCharge", "WhirlpoolWhirl", "EddyEscape", "FountainFrolic", "DropDash",
            "GeyserGo", "CascadeCanter", "WaterfallWander", "RapidsRush", "SpringSprint", "WellWave",
            "GlacierGlide", "IceInch", "SnowSlide", "FrostFrolic", "ColdCanter", "FreezeFlee",
            "ChillChase", "SnowflakeSkip", "BlizzardBolt", "WinterWhirl", "CoolCanter", "SleetSlide",
            "FlurryFlee", "CrystalCanter", "DiamondDance", "GemGait", "JewelJog", "RubyRun",
            "SapphireStride", "EmeraldEscape", "AgateArc", "OnyxOgle", "TopazTrot", "AmethystAmble",
            "OpalOunce", "PearlPrance", "CoralCanter", "JadeJump", "QuartzQuest", "BerylBolt",
            "MoonstoneMarch", "SunstoneStride", "StarstoneSprint", "EarthstoneEager", "SkyStoneSkip", "NightstoneNod",
            "DaystoneDance", "MorningstoneMarch", "EveningstoneEscape", "DuskstoneDash", "DawnstoneDart", "ShadowstoneSlide",
            "LightstoneLeap", "DarkstoneDash", "BrightstoneBolt", "DullstoneDawdle", "RainbowstoneRun", "CloudstoneCanter",
            "WindstoneWhirl", "FirestoneFlicker", "WaterstoneWave", "LeafstoneLeap", "ThunderstoneThrust", "LavastoneLunge",
            "RockstoneRush", "SandstoneSlide", "RiverstoneRun", "MountainstoneMarch", "ForeststoneFlee", "MeadowstoneMingle",
            "GrassstoneGlide", "GreenstoneGo", "BluestoneBolt", "RedstoneRush", "YellowstoneYield", "PurplestonePrance",
            "OrangestoneOgle", "BrownstoneBounce", "BlackstoneBolt", "WhitestoneWhirl", "GoldstoneGlimpse", "SilverstoneSlide",
            "BronzestoneBolt", "IronstoneInch", "SteelstoneStride", "TinystoneTrot", "GiantstoneGallop", "TinyStoneTip",
            "MassiveStoneMarch", "MinuteStoneMove", "HeavystoneHop", "LightstoneLeap", "SmoothstoneSlide", "RoughstoneRush",
            "HardstoneHasten", "SoftstoneSaunter", "SolidstoneSprint", "HollowstoneHop", "MagicstoneMingle", "MysticstoneMove",
            "RarestoneRun", "CommonstoneCanter", "ShinystoneStride", "DullstoneDawdle", "SharpstoneSkip", "BluntstoneBounce",
            "KeenstoneCanter", "DensestoneDart", "ThinystoneThrust", "ThickstoneThump", "LongstoneLeap", "ShortstoneSlide",
            "RoundstoneRoll", "FlatstoneFlee", "HighstoneHop", "LowstoneLunge", "DeepstoneDive", "ShallowstoneSlide",
            "WideStoneWalk", "NarrowStoneNudge", "FaststoneFleet", "SlowstoneStroll", "YoungstoneYip", "OldstoneOunce",
            "FreshstoneFlick", "StalestoneStagger", "RichstoneRush", "PoorstonePlod", "BrightstoneBreeze", "GloomyStoneGlide",
            "HappyStoneHop", "SadstoneSaunter", "AngryStoneArc", "CalmStoneCanter", "BravestoneBolt", "CowardStoneCower",
            "KindstoneCanter", "CruelStoneCruise", "LoudstoneLeap", "SilentStoneSlide", "ProudStonePrance", "ModestStoneMarch",
            "CleanStoneClamber", "DirtyStoneDash", "StrongStoneStride", "WeakStoneWander", "HealthyStoneHustle", "SickStoneSaunter",
            "TightstoneTrot", "LooseStoneLeap", "HeavyStoneHike", "LightStoneLift", "HotStoneHasten", "ColdStoneCrawl",
            "WetStoneWade", "DryStoneDash", "FullStoneFleet", "EmptyStoneEager", "HardStoneHurtle", "SoftStoneSaunter",
            "SmoothStoneStride", "RoughStoneRomp", "SharpStoneSkip", "BluntStoneBounce", "SourStoneStride", "SweetStoneSprint",
            "BitterStoneBolt", "SaltyStoneSlide", "SpicyStoneSpurt", "MildStoneMeander", "ClearStoneClamber", "CloudyStoneCanter",
            "RainyStoneRun", "SunnyStoneStride", "SnowyStoneSlide", "WindyStoneWhirl", "StormyStoneSprint", "StarryStoneSkip",
            "MoonlitStoneMingle", "SunnyStoneSaunter", "FlashStoneFlash", "EagleEyeStone", "LionLeapStone", "BearBoundStone",
            "HawkHoverStone", "OwlObserveStone", "FoxFleetStone", "WolfWanderStone", "SnakeSlitherStone", "HorseHoofStone",
            "FrogFleetStone", "ToadTrotStone", "RabbitRunStone", "TurtleTreadStone", "GiraffeGaitStone", "ElephantEagerStone",
            "KangarooCanterStone", "KoalaClimbStone", "MonkeyMoveStone", "ApeAmbleStone", "CheetahChaseStone", "LeopardLeapStone",
            "TigerTreadStone", "LionLungeStone", "PantherProwlStone", "PumaPranceStone", "CougarCanterStone", "BobcatBoundStone",
            "LynxLeapStone", "ChameleonChangeStone", "CrocCruiseStone", "GatorGallopStone", "LizardLoungeStone", "IguanaInclineStone",
            "GeckoGlideStone", "DinoDashStone", "RaptorRushStone", "StegoStrideStone", "TrexTrotStone", "PteroPounceStone",
            "BrontoBounceStone", "MammothMoseyStone", "CavemanCanterStone", "SpearmanSprintStone", "RockyRushStone", "StoneSlingerStone",
            "PebblePouncerStone", "BoulderBouncerStone", "RockRollerStone", "MountainMoverStone", "HillHikerStone", "ValleyVenturerStone",
            "CanyonClimberStone", "PlateauPlodderStone", "DesertDasherStone", "MeadowMoverStone", "ForestForagerStone", "GroveGalloperStone",
            "WoodlandWalkerStone", "JungleJoggerStone", "SwampStomperStone", "MarshMarauderStone", "BogBounderStone", "FenFrolickerStone",
            "MoorMoverStone", "WetlandWandererStone", "TundraTrekkerStone", "IcebergInclinerStone", "GlacierGliderStone", "SnowfieldSprinterStone",
            "PolarPlodderStone", "EquatorEagerStone", "HemisphereHikerStone", "LatitudeLoperStone", "LongitudeLungerStone", "MeridianMoseyStone",
            "TropicTrekkerStone", "ZoneZoomerStone", "RegionRusherStone", "AreaAdventurerStone", "LocaleLoperStone", "VicinityVoyagerStone",
            "PlacePouncerStone", "SpotSprinterStone", "PositionPrancerStone", "LocationLoperStone", "DestinationDarterStone", "GoalGallopStone",
            "TargetTrotterStone", "ObjectiveObeyerStone", "MissionMoverStone", "TaskTakerStone", "ChoreChaserStone", "DutyDoerStone", "FunctionFulfillerStone", "RoleRunnerStone",
        };
       
        return pokemonNicknames[new Random().nextInt(pokemonNicknames.length)];

    }
    
    public static String[] pullRandomStoredPokemon() throws SQLException, ClassNotFoundException{
        String q = "SELECT PokeName FROM pokemon ORDER BY RAND() LIMIT 1;";
        ResultSet R = DBSupport.fetchResultSet(q);
        R.next();
        
        String r1 = R.getString("PokeName");
        R.close();
        //keeping it an array just in case I need to pull more info in the future
        String[] data = {r1};
        



        
        return data;
    }    
    
    public static String generateSpecies(PokemonType type){
        
        
        String[] fireSpecies = {
           "Charmander", "Charmeleon", "Charizard", "Vulpix", "Ninetales",
           "Growlithe", "Arcanine", "Ponyta", "Rapidash", "Magmar",
           "Flareon", "Moltres", "Cyndaquil", "Quilava", "Typhlosion",
           "Slugma", "Magcargo", "Houndour", "Houndoom", "Magby",
           "Torchic", "Combusken", "Blaziken", "Numel", "Camerupt",
           "Torkoal", "Chimchar", "Monferno", "Infernape", "Magmortar",
           "Victini", "Tepig", "Pignite", "Emboar", "Pansear",
           "Simisear", "Darumaka", "Darmanitan", "Heatmor", "Litwick", 
           "Lampent", "Chandelure", "Larvesta", "Volcarona", "Fennekin",
           "Braixen", "Delphox", "Litleo", "Pyroar", "Fletchinder",
           "Talonflame", "Litten", "Torracat", "Incineroar", "Bailey",
           "Cinderace", "Carkol", "Coalossal", "Sizzlipede", "Centiskorch",
           "Scorbunny", "Rolycoly"};
     
     
    String[] waterSpecies = {
       "Squirtle", "Wartortle", "Blastoise", "Psyduck", "Golduck",
       "Poliwag", "Poliwhirl", "Poliwrath", "Tentacool", "Tentacruel",
       "Seel", "Dewgong", "Shellder", "Cloyster", "Krabby",
       "Kingler", "Horsea", "Seadra", "Goldeen", "Seaking",
       "Staryu", "Starmie", "Magikarp", "Gyarados", "Lapras",
       "Vaporeon", "Omanyte", "Omastar", "Kabuto", "Kabutops",
       "Totodile", "Croconaw", "Feraligatr", "Chinchou", "Lanturn",
       "Marill", "Azumarill", "Politoed", "Wooper", "Quagsire",
       "Slowking", "Qwilfish", "Corsola", "Remoraid", "Octillery",
       "Mantine", "Kingdra", "Mudkip", "Marshtomp", "Swampert",
       "Lombre", "Ludicolo", "Wingull", "Pelipper", "Surskit",
       "Masquerain", "Carvanha", "Sharpedo", "Wailmer", "Wailord",
       "Barboach", "Whiscash", "Corphish", "Crawdaunt", "Feebas",
       "Milotic", "Spheal", "Sealeo", "Walrein", "Clamperl",
       "Huntail", "Gorebyss", "Relicanth", "Luvdisc", "Piplup",
       "Prinplup", "Empoleon", "Buizel", "Floatzel", "Shellos",
       "Gastrodon", "Finneon", "Lumineon", "Mantyke", "Phione",
       "Manaphy", "Oshawott", "Dewott", "Samurott", "Panpour",
       "Simipour", "Tympole", "Palpitoad", "Seismitoad", "Ducklett",
       "Swanna", "Frillish", "Jellicent", "Alomomola", "Froakie",
       "Frogadier", "Greninja", "Skrelp", "Dragalge", "Clauncher",
       "Clawitzer", "Popplio", "Brionne", "Primarina", "Wishiwashi",
       "Mareanie", "Toxapex", "Dewpider", "Araquanid", "Pyukumuku",
       "Bruxish", "Sobble", "Drizzile", "Inteleon", "Cramorant",
       "Arrokuda", "Barraskewda", "Eiscue", "Kubfu", "Urshifu"};
        
       if(type == PokemonType.FIRE){
            return fireSpecies[new Random().nextInt(fireSpecies.length)];
       }
       else{
           return waterSpecies[new Random().nextInt(waterSpecies.length)];
       }
    }   

    public static PokemonType generatePokemonType(){
        return new Random().nextInt(2) % 2 == 0 ? PokemonType.FIRE : PokemonType.WATER;
    } 
    

    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
