package pw.owen.easygui.main;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 *  @see GUI
 * @author owen
 * @version 1.0.1
 * ��Bukkit������GUI���а�װ,�¼����Ŀ�ݹ�����.���뱾�����Ĺ���API���ṩ�κΰ���,�����й���,����ʹ��inventory.getHolder()��ȡ����.
 */
public class GUI implements InventoryHolder{
	private String name;
	private String title;
	private boolean multiInstance =	true;
	private Map<String,Inventory> inventorys = new HashMap<String, Inventory>();
	private int row=1;
	private Map<Integer,GUIEvent> events=new HashMap<Integer, GUIEvent>();
	private int page=1;
	
	
	
	
	/**
	 * 
	 * �������GUI��ҳ��
	 * @return ҳ��
	 */
		public int getPage() {
			return page;
		}
		/**
		 * �������GUI��ҳ��
		 * @param page ҳ��
		 */
		public void setPage(int page) {
			this.page=page;
		}
		
		/**
		 * ͨ�����ӵ�slot��ȡ���slot���¼�
		 * @param i ���ӵ�slot
		 * @return �����¼�����
		 */
		public GUIEvent getEvent(int i){
			return events.get(i);
		}
		/**
		 *  ͨ�����ӵ�slotע�����slot���¼�
		 * @param i ���ӵ�slot
		 * @param event �¼�����
		 */
		public void regEvent(int i,GUIEvent event){
			 events.put(i,event);
		}
		/**
		 *  �������GUI������
		 * @return ����
		 */
		public String getName() {
			return name;
		}
		/**
		 *  �������GUI������
		 * @return ����
		 */
		public int getRow() {
			return row;
		}
		
		/**
		 *  �������GUI������
		 * @param guiRow ������ö����
		 */
		public void setRow(GUIRow guiRow) {
			setRow(guiRow.getRow());
		}
		
		/**
		 *  �������GUI������
		 * @param row ����(һ��9��)
		 */
		public void setRow(int row) {
			this.row=row;
		}
		
		/**
		 *  �������GUI������(��ʵ������,��������)
		 * @param name ����
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 *  �������GUI�ı���
		 * @return ����
		 */
		public String getTitle() {
			return title;
		}
		/**
		 *  �������GUI�ı���
		 * @param title ����
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		
		/**
		 *  �������GUI�Ƿ�ÿ��ˢ�����´�������
		 * @param multiInstance �Ƿ��ʵ��
		 */
		public void setMultiInstance(boolean multiInstance) {
			this.multiInstance = multiInstance;
		}

		/**
		 *  �������GUI�Ƿ�ÿ��ˢ�����´�������
		 * @return �Ƿ��ʵ��
		 */
		public boolean isMultiInstance() {
			return this.multiInstance;
		}

		
	
		private GUI(String name, int row,String title,boolean multiInstance) {
		this.name=name;
		this.title=title;
		this.row=row;
		this.multiInstance=multiInstance;
		}

		
		/**
		 *  ����һ��GUI
		 * @param name ����(��ʵ������,����������)
		 * @param title ����
		 * @param guiRow ����
		 * @param multiInstance �Ƿ��ʵ��(Ϊ��ʱÿ��ˢ�¶��ᴴ���µ�����GUI)
		 * @return ���ش������GUI����
		 */
		public static GUI createGUI(String name,String title,GUIRow guiRow,boolean multiInstance){ return createGUI(name, title,guiRow.getRow(),multiInstance); }
		
		/**
		 *  ����һ��GUI
		 * @param name ����(��ʵ������,����������)
		 * @param title ����
		 * @param row ����
		 * @param multiInstance �Ƿ��ʵ��(Ϊ��ʱÿ��ˢ�¶��ᴴ���µ�����GUI)
		 * @return ���ش������GUI����
		 */
		public static GUI createGUI(String name,String title,int row,boolean multiInstance){return new GUI(name,row,title,multiInstance);}

		/**
		 *  ��һ����Ҵ�GUI
		 * @param p ���
		 */
		public void open(Player p){
			
			refresh(p);

		}

		
		/**
		 *  ǿ��һ�����ˢ��GUI(���û�д�����GUI)
		 * @param p ���
		 */
		public void refresh(Player p) {
			Inventory inventory=null;
			
			if(multiInstance)
			inventory=Bukkit.createInventory(this, row*9,title);
			else
			{	inventory=inventorys.get(p.getName());
			if(inventory==null){
				inventory=Bukkit.createInventory(this, row*9,title);
				p.closeInventory();
				p.openInventory(inventory);
				p.updateInventory();
			}
			}	
			inventorys.put(p.getName(), inventory);
			
			for(Integer key:events.keySet()){
			ItemStack item = events.get(key).refresh(this, p,key);
			if(item!=null)
				inventory.setItem(key,item );
			}
			
			if(multiInstance){
			p.closeInventory();
			p.openInventory(inventory);
			}
			p.updateInventory();
			}
		
		/**
		 *  ���ø÷���,���÷��ؿ�ֵ
		 * @return ���ؿ�ֵ
		 */
		@Deprecated
		public Inventory getInventory() {return null;}
		
		/**
		 *  ��ȡ��������GUI�д򿪵�Inventoryʵ��
		 * @param p ���
		 * @return Inventoryʵ��
		 */
		public Inventory getInventory(Player p) {return inventorys.get(p.getName());}
}
