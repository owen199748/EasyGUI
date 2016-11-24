package pw.owen.easygui.main;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;




public class Main extends JavaPlugin{
public static Main main=null;

	@Override
	public void onEnable() {
	
		
		
		main=this;
		Logger lg = getLogger();
		getServer().getPluginManager().registerEvents(new AutoListener(), this);
		lg.info("---¼ÓÔØ³É¹¦>>>");

		
	}

public static Main getMain() {
	return main;
}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		return false;
		
	

}

	
}
