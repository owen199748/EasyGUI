package pw.owen.easygui.main;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @see GUI�¼��ӿ�,ʵ���������¼�
 */
public interface GUIEvent {
	/**
	 * @see �������һ��GUI��ĳ��λ��ʱ,�������λ�õ��¼�call����
	 * @param event ������¼�
	 * @param gui ����GUIʵ��
	 * @return �Ƿ�ȡ������¼�(��ֹ�ƶ���Ʒ)
	 */
public boolean call(InventoryClickEvent event,GUI gui);
/**
 * @see ����ҳ֮����ߴ���һ���µ�Inventoryʱ,����GUI��ÿ����ע����¼�refresh����
 * @param gui ����GUIʵ��
 * @param p �������
 * @return ���ظ��º����Ʒ��ջ
 */
public ItemStack refresh(GUI gui,Player p);
/**
 * @see ��call����ִ�����ʱ,����changePage����
 * @param gui ����GUIʵ��
 * @param p �������
 * @return �����޸ĺ��ҳ��(-1��ʾ���޸�,���Ҳ�����refresh����)
 */
public int changePage(GUI gui,Player p);

}
