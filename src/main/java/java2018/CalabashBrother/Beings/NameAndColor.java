package java2018.CalabashBrother.Beings;

public enum NameAndColor {//
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	String getName() {
		return this.NAME[ordinal()];
	}
	String getColor() {
		return this.COLOR[ordinal()];
	}
}
 