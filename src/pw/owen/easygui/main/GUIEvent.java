package pw.owen.easygui.main;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @see GUI事件接口,实现以制作事件
 */
public interface GUIEvent {
	/**
	 * @see 当鼠标点击一个GUI的某个位置时,调用这个位置的事件call方法
	 * @param event 鼠标点击事件
	 * @param gui 所属GUI实例
	 * @return 是否取消点击事件(禁止移动物品)
	 */
public boolean call(InventoryClickEvent event,GUI gui);
/**
 * @see 当换页之后或者创建一个新的Inventory时,调用GUI内每个被注册的事件refresh方法
 * @param gui 所属GUI实例
 * @param p 所属玩家
 * @return 返回更新后的物品堆栈
 */
public ItemStack refresh(GUI gui,Player p);
/**
 * @see 当call方法执行完毕时,调用changePage方法
 * @param gui 所属GUI实例
 * @param p 所属玩家
 * @return 返回修改后的页数(-1表示不修改,并且不调用refresh方法)
 */
public int changePage(GUI gui,Player p);

}
