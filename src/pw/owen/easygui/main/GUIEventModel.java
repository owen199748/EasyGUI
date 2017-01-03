package pw.owen.easygui.main;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
/**
 * @see GUIEventModel
 * GUI事件类,可以储存item对象进行修改
 */
public abstract class GUIEventModel implements GUIEvent{

private ItemStack item;

/**
 * 构造方法,创建对象时传入一个物品堆栈用于以后每次刷新时获取模板
 * @param item 物品堆栈模板
 */
public GUIEventModel(ItemStack item) {
	this.item=item;
} 
	


	@Override
		public ItemStack refresh(Inventory inventory,GUI gui, Player p,int slot) {
			return refreshItem(inventory,gui,p,slot,item);
		}

	/**
	 * 继承本类重写refreshItem方法而不是refresh,写法一样,提供创建对象时传入的物品堆栈模板
	 * @param inventory 当前库存实例
	 * @param gui 所属GUI实例
	 * @param p 所属玩家
	 * @param slot 物品所在位置
	 * @param item 物品堆栈模板
	 * @return 返回刷新后的物品堆栈
	 */
	public abstract ItemStack refreshItem(Inventory inventory,GUI gui, Player p,int slot, ItemStack item);
	
}
