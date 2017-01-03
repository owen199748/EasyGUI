package pw.owen.easygui.main;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @see GUIEvent
 * GUI�¼��ӿ�,ʵ���������¼�
 */
public interface GUIEvent {
	/**
	 * �������һ��GUI��ĳ��λ��ʱ,�������λ�õ��¼�call����
	 * @param event ������¼�
	 * @param gui ����GUIʵ��
	 * @return �Ƿ�ȡ������¼�(��ֹ�ƶ���Ʒ)
	 */
public boolean call(InventoryClickEvent event,GUI gui);
/**
 * ���ر�GUIʱ,����ÿ����ע����¼�close����
 * @param event �رտ���¼�
 * @param gui ����GUIʵ��
 */
public void close(InventoryCloseEvent event,GUI gui);
/**
 * ����ҳ֮����ߴ���һ���µ�Inventoryʱ,����GUI��ÿ����ע����¼�refresh����
 * @param inventory ��ǰ���ʵ��
 * @param gui ����GUIʵ��
 * @param p �������
 * @param slot ��Ʒ����λ��
 * @return ���ظ��º����Ʒ��ջ
 */
public ItemStack refresh(Inventory inventory,GUI gui,Player p,int slot);
/**
 * ��call����ִ�����ʱ,����changePage����
 * @param inventory ��ǰ���ʵ��
 * @param gui ����GUIʵ��
 * @param p �������
 * @return �����޸ĺ��ҳ��(-1��ʾ���޸�,���Ҳ�����refresh����)
 */
public int changePage(Inventory inventory,GUI gui,Player p);

}
