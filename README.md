# 作业：面向葫芦娃编程
# 一、物体
物体有自己在场地的坐标(x,y)
## 生物
生物是物体的继承类，除了有坐标外，还有攻击力、防御力和血量三个生物属性。\
生物分为两个阵营，一方是**葫芦兄弟阵营**，另一方是**妖怪阵营**。\
生物有两种，一种是能够**直接进行攻击的生物**，包括葫芦娃、蝎子精和小喽啰；另一种是不能攻击，但当其在场上时，能够**对本阵营产生正面buff、对敌对阵营产生负面buff**，包括爷爷和蛇精两种。
#### 1、葫芦娃🐸
*葫芦娃*是*葫芦兄弟*阵营的主力输出，具有高攻击力和较高的防御力。每个*葫芦娃*还根据自身特点附带技能，**老大**力大无穷，攻击易*暴击*，**老二**千里眼顺风耳，*命中率*和*闪避率*高，**老三**铜头铁臂，钢筋铁骨，有几率*反弹攻击*，**老四**会玩火，攻击附带*持续灼烧伤害*，**老五**会玩水，攻击附带*持续冰冻伤害*，并能够*降低命中者攻速*，**老六**会隐身术，攻击有几率触发*刺杀*，直接杀死被命中者，**老七**有宝葫芦，攻击有几率触发*我叫你一声你敢答应吗*技能，触发后将敌方单位吸入葫芦，基础时间为2秒，受buff影响。\
尽管*葫芦兄弟*天生就有高额攻击和防御，但都是小孩子，受*爷爷*影响大，如果***爷爷*阵亡**，则*葫芦兄弟*技能就失去作用，如果*蛇精*在场，*老七*会受其*蛊惑*，变为*妖怪阵营*成员，同时随机对除自身外在场的一名*葫芦娃*使用*我叫你一声你敢答应吗*技能。
#### 2、爷爷👴
*爷爷*年老体衰，攻击力与防御力是所有生物中最低的。*爷爷*在场时，*葫芦兄弟*的特殊技能全部生效。\
*爷爷*唯一的技能是*浇水*，每3秒恢复场上每个*葫芦娃*5%的*生命值*
#### 3、蝎子精🦂
*蝎子精*作为肉体最强生物，拥有远高（<300%）于其他生物的攻击力、防御力和血量。\
*蝎子精*的技能为*振奋*，每三次攻击产生一次*暴击*。
####4、蛇精🐍
*蛇精*没有攻击力，防御力与血量一般。\
*蛇精*的技能为*魅惑*，*精神冲击*和*舍人为己*。*魅惑*能够使对方精神错乱攻击友军，*精神冲击*能够使对方精神错乱不能攻击，二者的持续时间都为1秒钟，二者同属精神类攻击，当*爷爷*在场时不能产生效果。*舍人为己*随机选定一名*小喽啰*，替*蛇精*承受一次攻击，本次攻击中，*蛇精*不受伤害，*小喽啰*受到120%的伤害
####5、小喽啰🕷🦇
攻击力防御力弱，炮灰，没有技能。
## 攻击波
生物攻击时，会发出攻击波，攻击波在场地中飞行，每秒飞行一距离。遇到第一个敌人时产生效果并结束。
# 二、场地
## 区域
## 阵型
作战前首先要摆放阵型。每个阵营只能在自己的阵地摆放阵型，每个阵型将占有能够容纳它的最小的矩形，例如鹤翼阵需要占用7*4大小的矩形。\
摆放时，接收一个坐标输入(x,y)，指示上述矩形的中心位置，根据中心位置判断能够在本阵营区域摆放阵型。
#### 1、葫芦兄弟
葫芦兄弟只有一个阵型——长蛇阵，爷爷自己一个阵型，可以摆放在任意位置（如果你不想他死那么快就请把他放在葫芦娃身后）
#### 2、妖怪
妖怪有八种阵型——鹤翼、雁行、衡轭、长蛇、鱼鳞、方门、偃月和锋矢。其中蝎子精处于阵型最中央，身先士卒，勇气可嘉，阵型的其他位置都是小喽啰。蛇精也可以摆放在场地的任何位置（同样的如果你不想她死那么快就请把她放在妖怪们身后）
# 三、GUI
# 四、Multithreading
# 五、类及类间关系
#### package Beings
Beings.java
```javascript
package Beings;

//本类是生物和攻击波的父类
public class Beings {
    //坐标
	protected int x, y;
	//移动
	public void MoveToPos(int x, int y)
}
```

Creature.java
```javascript
//本类是葫芦娃、爷爷、蝎子精、蛇精、小喽啰的父类，是Beings的派生类
package Beings;
public class Creature extends Beings{
    //攻击力Combat Effectiveness
	protected int CE;
    //防御力Defence
	protected int DEF;
    //血量Health Point
	protected int HP;
    //buff状态
	protected boolean Motivated;
    //存活状态
	protected boolean livingStatus;
    //取攻击力
    public int getCE(int radio);
	//取防御力
    public int getDEF();
	//取血量
    public int getHP();
    //取buff状态
	public boolean isMotivated();
    //取存活状态
	public boolean isLiving();
    //设置buff状态
	public void setMotivated(boolean Motivated);
    //攻击
	public void Attack(Creature attackedBeing,int radio);
}
```

CalaBashBrother.java
```javascript
package Beings;
enum NameAndColor {//
	RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
	String[] NAME = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	String[] COLOR = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
	//取名字
    String getName() ;
	//取颜色
    String getColor();
}
public class CalabashBrother extends Creature{

	private NameAndColor nc;
    //默认构造函数
	CalabashBrother();
    //带参构造函数
	CalabashBrother(NameAndColor NC);
	CalabashBrother(int x, int y);
	CalabashBrother(int x, int y, NameAndColor NC);
	//取名字
    public String getName();
	//取颜色
    public String getColor();
	//设置颜色和名字，对应上面的enum类型
    public void setNameAndColor(int index);
    //比较函数，用于作业二排序
	public int compareTo(CalabashBrother brother);
}
```

CalabashBrothers.java

```javascript
package Beings;
public class CalabashBrothers {
    //七个葫芦兄弟
	private CalabashBrother[] calabashbrothers;
    //默认构造函数
	public CalabashBrothers();//设置位置
	public void SetCBPostion(int index, int x, int y);
	//作业二排序交换位置
	public void SwapBrother(int index1, int index2);
    //取index位置的葫芦娃
	public CalabashBrother getBrother(int index);
    //取index位置的葫芦娃的名字
	public String getName(int index);
    //取index位置的葫芦娃名字
	public String getColor(int index);
    //作业二输出当前葫芦兄弟队的情况
	public void QueueNameStatus();
	public void QueueColorStatus();
    //作业二打乱葫芦兄弟队伍
	public void Disorder();
}

```

GrandPa.java
```javascript
package Beings;
public class GrandPa extends Creature{

}
```

Scorpion.java
```javascript
package Beings;
//蝎子精
public class Scorpion extends Creature{

}
```

Snake.java
```javascript
package Beings;

public class Snake extends Creature{

}

```

LouLuo.java
```javascript
package Beings;
public class LouLuo extends Creature{

}

```
#### package BattleField
BattleField.java
```javascript
//泛型，可存放所有物体
package BattleField;
import Beings.*;
public class BattleField<T extends Beings> {
    //本块场地中的物体
	private T Being;
    //默认构造函数
	BattleField();
    //带参构造函数
	BattleField(T t);
    //查看格子是否为空
	public boolean isEmpty()；
    //取得本格子上的物体
	public T getBeing()；
    //把格子上的物体移走
	public T removeBeing()；
    //在格子上放上物体。已内嵌removeBeing方法
	public boolean setBeing(T t)；
}
```

BattleFields.java
```javascript
package BattleField;
import java.util.*;
import Beings.*;
public class BattleFields {//战场为M*N的矩形
	//version 1.0
    //场地长
	private int M;
	//场地宽
    private int N;
    //场地
	private  BattleField BFs[][];
	private ArrayList<BattleField<? extends Beings>> BF = new ArrayList<>();
    //默认构造函数
	public BattleFields();
    //带参构造函数
	BattleFields(int m, int n);
	public boolean Containable(int x, int y, int length, int height);
	public boolean SetBFPosition(int x, int y, BattleField<? extends Beings> t);

}
```