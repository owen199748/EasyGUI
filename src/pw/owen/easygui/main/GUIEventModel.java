package pw.owen.easygui.main;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
/**
 * @see GUIEventModel
 * GUI�¼���,���Դ���item��������޸�
 */
public abstract class GUIEventModel implements GUIEvent{

private ItemStack item;

/**
 * ���췽��,��������ʱ����һ����Ʒ��ջ�����Ժ�ÿ��ˢ��ʱ��ȡģ��
 * @param item ��Ʒ��ջģ��
 */
public GUIEventModel(ItemStack item) {
	this.item=item;
}
	


	@Override
		public ItemStack refresh(GUI gui, Player p,int slot) {
			return refreshItem(gui,p,slot,item);
		}

	/**
	 * �̳б�����дrefreshItem����������refresh,д��һ��,�ṩ��������ʱ�������Ʒ��ջģ��
	 * @param gui ����GUIʵ��
	 * @param p �������
	 * @param slot ��Ʒ����λ��
	 * @param item ��Ʒ��ջģ��
	 * @return ����ˢ�º����Ʒ��ջ
	 */
	public abstract ItemStack refreshItem(GUI gui, Player p,int slot, ItemStack item);
	
}
