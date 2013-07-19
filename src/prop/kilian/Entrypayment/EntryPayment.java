package prop.kilian.Entrypayment;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.*;

import cosine.boseconomy.BOSEconomy;

public class EntryPayment extends JavaPlugin {

	  BOSEconomy economy;
	  
	  @Override
	  public void onEnable()
	  {
		  getLogger().info("[INFO] VegasCraftEntryPayment has been enabled");
		  getServer().getPluginManager().registerEvents(new EventListener(this,economy),this);
	  }
	  @Override
	  public void onDisable()
	  {
		  getLogger().info("[INFO] VegasCraftEntryPayment has been disabled");
	  }
	  
	  public void loadBOSEconomy()
	  {
		   Plugin temp = this.getServer().getPluginManager().getPlugin("BOSEconomy");
		   
		   if(temp == null)
		   {
			   economy = null;
		   }
		   else
		   {
			   economy = (BOSEconomy)temp;
		   }
	  }
	  
}
