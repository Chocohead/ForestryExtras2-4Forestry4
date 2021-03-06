package forestryextras.main;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {

	public static Configuration config;

	public static void loadConfig(File file){
		if (config == null)
		{
			config = new Configuration(file);
			try 
			{
				config.load();
			}
			catch (Exception ex)
			{}
			updateConfig();
		}
	}

	public static void updateConfig(){
//    	list = config.get(Configuration.CATEGORY_GENERAL, "list", configDirectory).getString();
//    	forestryFMP = config.get(Configuration.CATEGORY_GENERAL, "forestryFMP", true).getBoolean(forestryFMP);
    	dragonEggRecipe = config.get(Configuration.CATEGORY_GENERAL, "dragonEggRecipe", true, "Allow Dragon Egg Recipe").setRequiresMcRestart(true).getBoolean(dragonEggRecipe);
    	unstableBee = config.get(Configuration.CATEGORY_GENERAL, "unstableBee", true, "Allow unstable Bees").setRequiresMcRestart(true).getBoolean(unstableBee);
    	enableCropChecker = config.get(Configuration.CATEGORY_GENERAL, "enableCropChecker", true, "Enable Crop Checker").setRequiresMcRestart(true).getBoolean();
    	enableBeeducer = config.get(Configuration.CATEGORY_GENERAL, "enableBeeducer", true, "Enable Beeducer").setRequiresMcRestart(true).getBoolean();
    	beeducerTime = config.get(Configuration.CATEGORY_GENERAL, "beeducerTime", 30, "Time in seconds it takes the Beeducer to produce one comb").setRequiresMcRestart(true).getInt();
    	beeducerTurns = config.get(Configuration.CATEGORY_GENERAL, "beeducerTurns", 4, "The number of combs the Beeducer to produce from one Bee").setRequiresMcRestart(true).getInt();
    	enableDonatorMetals = config.get(Configuration.CATEGORY_GENERAL, "enableDonatorMetals", true, "Enable Donator Metals").setRequiresMcRestart(true).getBoolean();
    	modSupportFramesEasy = config.get(Configuration.CATEGORY_GENERAL, "modSupportFramesEasy", true, "Is mod metal frames easy to craft").setRequiresMcRestart(true).getBoolean();
    	reinforcedGrafterSaplingModifier = (float)config.get(Configuration.CATEGORY_GENERAL, "reinforcedGrafterSaplingModifier", 75.0, "Sapling drop rate modifier").setRequiresMcRestart(true).getDouble();
    	draconicGrafterSaplingModifier = (float)config.get(Configuration.CATEGORY_GENERAL, "draconicGrafterSaplingModifier", 90.0, "Sapling drop rate modifier").setRequiresMcRestart(true).getDouble();
    	if (config.hasChanged()) {
    		config.save();
    	}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(Main.modName))
		{
			updateConfig();
		}
	}

//	public static String list;
//  public static boolean forestryFMP;
    public static boolean dragonEggRecipe;
    public static boolean unstableBee;
    public static boolean enableCropChecker;
    public static boolean enableBeeducer;
    public static int beeducerTime;
    public static int beeducerTurns;
    public static boolean enableDonatorMetals;
    public static boolean modSupportFramesEasy;
    public static float reinforcedGrafterSaplingModifier;
    public static float draconicGrafterSaplingModifier;
}