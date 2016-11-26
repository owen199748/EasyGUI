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
 * 对Bukkit的箱子GUI进行包装,事件化的快捷工具类.对与本类对象的管理API不提供任何帮助,请自行管理,或者使用inventory.getHolder()获取对象.
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
	 * 返回这个GUI的页数
	 * @return 页数
	 */
		public int getPage() {
			return page;
		}
		/**
		 * 设置这个GUI的页数
		 * @param page 页数
		 */
		public void setPage(int page) {
			this.page=page;
		}
		
		/**
		 * 通过箱子的slot获取这个slot的事件
		 * @param i 箱子的slot
		 * @return 返回事件对象
		 */
		public GUIEvent getEvent(int i){
			return events.get(i);
		}
		/**
		 *  通过箱子的slot注册这个slot的事件
		 * @param i 箱子的slot
		 * @param event 事件对象
		 */
		public void regEvent(int i,GUIEvent event){
			 events.put(i,event);
		}
		/**
		 *  返回这个GUI的名称
		 * @return 名称
		 */
		public String getName() {
			return name;
		}
		/**
		 *  返回这个GUI的行数
		 * @return 行数
		 */
		public int getRow() {
			return row;
		}
		
		/**
		 *  设置这个GUI的行数
		 * @param guiRow 行数的枚举类
		 */
		public void setRow(GUIRow guiRow) {
			setRow(guiRow.getRow());
		}
		
		/**
		 *  设置这个GUI的行数
		 * @param row 行数(一行9格)
		 */
		public void setRow(int row) {
			this.row=row;
		}
		
		/**
		 *  设置这个GUI的名称(无实际意义,用于区分)
		 * @param name 名称
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 *  返回这个GUI的标题
		 * @return 标题
		 */
		public String getTitle() {
			return title;
		}
		/**
		 *  设置这个GUI的标题
		 * @param title 标题
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		
		/**
		 *  设置这个GUI是否每次刷新重新创建对象
		 * @param multiInstance 是否多实例
		 */
		public void setMultiInstance(boolean multiInstance) {
			this.multiInstance = multiInstance;
		}

		/**
		 *  返回这个GUI是否每次刷新重新创建对象
		 * @return 是否多实例
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
		 *  创建一个GUI
		 * @param name 名称(无实际作用,仅用于区分)
		 * @param title 标题
		 * @param guiRow 行数
		 * @param multiInstance 是否多实例(为真时每次刷新都会创建新的箱子GUI)
		 * @return 返回创建后的GUI对象
		 */
		public static GUI createGUI(String name,String title,GUIRow guiRow,boolean multiInstance){ return createGUI(name, title,guiRow.getRow(),multiInstance); }
		
		/**
		 *  创建一个GUI
		 * @param name 名称(无实际作用,仅用于区分)
		 * @param title 标题
		 * @param row 行数
		 * @param multiInstance 是否多实例(为真时每次刷新都会创建新的箱子GUI)
		 * @return 返回创建后的GUI对象
		 */
		public static GUI createGUI(String name,String title,int row,boolean multiInstance){return new GUI(name,row,title,multiInstance);}

		/**
		 *  让一个玩家打开GUI
		 * @param p 玩家
		 */
		public void open(Player p){
			
			refresh(p);

		}

		
		/**
		 *  强制一个玩家刷新GUI(如果没有打开则会打开GUI)
		 * @param p 玩家
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
		 *  弃用该方法,永久返回空值
		 * @return 返回空值
		 */
		@Deprecated
		public Inventory getInventory() {return null;}
		
		/**
		 *  获取这个玩家在GUI中打开的Inventory实例
		 * @param p 玩家
		 * @return Inventory实例
		 */
		public Inventory getInventory(Player p) {return inventorys.get(p.getName());}
}
