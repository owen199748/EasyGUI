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
		public ItemStack refresh(GUI gui, Player p) {
			return refreshItem(gui,p,item);
		}

	/**
	 * �̳б�����дrefreshItem����������refresh,д��һ��,�ṩ��������ʱ�������Ʒ��ջģ��
	 * @param gui ����GUIʵ��
	 * @param p �������
	 * @param item ��Ʒ��ջģ��
	 * @return ����ˢ�º����Ʒ��ջ
	 */
	public abstract ItemStack refreshItem(GUI gui, Player p, ItemStack item);
	
}
