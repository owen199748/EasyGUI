package pw.owen.easygui.main;
/**
 * @see GUIRow
 * GUI����ö����,���а������п���������ʾ������
 */
public enum GUIRow {
ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

private int row=1;

private GUIRow(int row) {this.row=row;}

public int getRow() {return row;}

public int getSize() {return row*9;}
}
