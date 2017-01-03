package pw.owen.easygui.main;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.scheduler.BukkitRunnable;




public class AutoListener implements Listener {

	@EventHandler
	public void ede(InventoryClickEvent e) {
			if(e.getRawSlot()>=e.getView().getTopInventory().getSize())
				return;
		InventoryHolder holder=e.getView().getTopInventory().getHolder();
		
		if( e.getWhoClicked() instanceof Player)
		if(holder instanceof GUI)
			{
			GUI gui=((GUI)holder);
			GUIEvent event=gui.getEvent(e.getRawSlot());
			
			Player p =(Player) e.getWhoClicked();
				
				
			
			
			if(event!=null)
			{
				
				if(!event.call(e,gui))
					e.setCancelled(true);
				
				int page = event.changePage(e.getClickedInventory(),gui, p);
				if(page!=-1){
				gui.setPage(page);
				gui.refresh(p);
				}
				


				
				
			}else e.setCancelled(true);
			new BukkitRunnable() {
				
				@Override
				public void run() {
			
				p.updateInventory();
				
				}
			
			
			}.runTask(Main.getMain());
			}
		
	}
	
	@EventHandler
	public void ede1(InventoryMoveItemEvent e) {

		
		
		InventoryHolder holder=e.getDestination().getHolder();
		
		if(holder instanceof GUI)
			e.setCancelled(true);
		
		holder=e.getInitiator().getHolder();
		
		if(holder instanceof GUI)
			e.setCancelled(true);
		
		
	}	@EventHandler
	public void ede1(InventoryCloseEvent e) {

		
		
		InventoryHolder holder=e.getInventory().getHolder();
		
		if(holder instanceof GUI)
		{
			GUI gui = (GUI)holder;
			Map<Integer, GUIEvent> events = gui.getEvents();
			for(Integer key:events.keySet())
				events.get(key).close(e, gui);
		}

		
		
	}
	
	@EventHandler
	public void ede2(InventoryDragEvent e) {
		InventoryHolder holder=e.getInventory().getHolder();
		
		if(holder instanceof GUI)
			e.setCancelled(true);
		
	}

}

