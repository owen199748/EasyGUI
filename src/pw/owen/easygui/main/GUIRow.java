package pw.owen.easygui.main;
/**
 * @see GUIRow
 * GUI行数枚举类,其中包含所有可以正常显示的行数
 */
public enum GUIRow {
ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

private int row=1;

private GUIRow(int row) {this.row=row;}

public int getRow() {return row;}

public int getSize() {return row*9;}
}
