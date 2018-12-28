package java2018.CalabashBrother.BattleField;
import java.util.*;
import java2018.CalabashBrother.Beings.*;
public class BattleFields {//战场为M*N的矩形
	//version 1.0

	private int M;//战场的长
	private int N;//战场的宽
	private int goodboyCount;
	private int badboyCount;
	private  BattleField BFs[][];//????
	//private ArrayList<BattleField<? extends Beings>> BF = new ArrayList<>();
	//private T battleField[][];
	public BattleFields(){
		M = 10;
		N = 20;
		BFs = new BattleField[M][N];
		initializeBattleField();
		goodboyCount = -1;
		badboyCount = -1;

	}
	BattleFields(int m, int n){

		M = m;
		N = n;
		BFs = new BattleField[M][N];
		initializeBattleField();
		goodboyCount = -1;
		badboyCount = -1;

	}
	public void initializeBattleField() {
		for(int i = 0; i < M;i++) {
			for(int j = 0; j < N;j++) {
				BFs[i][j]=null;
			}
		}
	}
	public void initializeCount(int goodboyCount, int badboyCount) {
		this.goodboyCount = goodboyCount;
		this.badboyCount = badboyCount;
	}
	public void updateCount() {
		goodboyCount = 0;
		badboyCount = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 20;j++) {
				synchronized(this) {
					if(BFs[i][j]==null)continue;
					if(BFs[i][j].getClass().getSuperclass().getName()==Goodboy.class.getName()) {
						goodboyCount++;
					}
					else {
						badboyCount++;
					}
			}}
		}
	}
	public boolean isVictary() {
		synchronized(this) {
			System.err.println("goodboyCount*badboyCount="+goodboyCount*badboyCount+((goodboyCount*badboyCount)==0));
		return (goodboyCount*badboyCount)==0;
		}
	}
	public boolean Containable(int x, int y, int SizeX, int SizeY) {
		if(((x + SizeX) <= M) && ((y + SizeY) <= N) && ((x + SizeX) >=0 ) && ((y + SizeY) >=0))return true;
		else return false;
	}
	public boolean Containable(int x, int y, int length, int height, boolean[][] subGraph) {
		
		return true;
	}
	public boolean SetBFPosition(int x, int y, Creature t) {
		synchronized(BattleFields.class){
		//	if(BFs[x][y]==null)System.err.println("NullPointer");
		//if((!(BFs[x][y]==null))||(!BFs[x][y].isEmpty()))return false;
		
		if(!isEmpty(x,y))return false;
		else {
			BFs[x][y]=new BattleField<Creature>(t);
			
			return true;
		}
		}
	}
	public void remove(int x, int y) {
		synchronized(BattleFields.class){
		BFs[x][y]=null;
	}}
	public int findDirection(Creature c,int x, int y) {
		for(int i = 1;i<=28;i++) {
			for(int j = (i+1)/2; j <= i;j++) {
				Creature c1 = getCreature(x-j,y-i+j);
				if((c1!=null)&&(c1.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 0;
				
				c1 = getCreature(x-i+j,y-j);				
				if((c1!=null)&&(c1.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 1;
				
				Creature c2 = getCreature(x+i-j,y-j);
				if((c2!=null)&&(c2.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 2;
				
				Creature c3 = getCreature(x+j,y-i+j);
				if((c3!=null)&&(c3.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 3;
				
				Creature c4 = getCreature(x+j,y+i-j);
				if((c4!=null)&&(c4.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 4;
				
				c3 = getCreature(x+i-j,y+j);
				if((c3!=null)&&(c3.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 5;
				
				c4 = getCreature(x-i+j,y+j);
				if((c4!=null)&&(c4.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 6;
				
				
				
				c2 = getCreature(x-j,y+i-j);
				if((c2!=null)&&(c2.getClass().getSuperclass().getName()!=c.getClass().getSuperclass().getName()))return 7;
				
				
				
				
			}
		}
		return -1;
	}
	public boolean isEmpty(int x, int y) {
		if(x<0||x>9||y<0||y>19)return false;
		synchronized(BattleFields.class){
		return BFs[x][y]==null;
		}
	}
	public String creatureType(int x, int y) {
		synchronized(this){
		return BFs[x][y].getBeing().getClass().getName();
	}}
	public String CBName(int x, int y) {
		synchronized(this){
		return ((CalabashBrother)BFs[x][y].getBeing()).getName();
	}
	}
	public Creature  getCreature(int x, int y) {
		synchronized(this) {
			if(x<0||x>9||y<0||y>19)return null;
			else if(BFs[x][y]==null)return null;
			else return BFs[x][y].getCreature();
		}
	}
	public void BFOutput() {
		for(int i = 0; i < M;i++) {
			for(int j = 0;j < N;j++) {
				if(BFs[i][j]==null)System.err.print("* ");
				else{
					Beings t = BFs[i][j].getBeing();
					if(t instanceof CalabashBrother) {
						System.err.print("C ");
						//System.out.println(BFs[i][j].getBeing().getClass().getName());
					}
					else if(t instanceof LouLuo){
						System.err.print("L ");
					}
					else if(t instanceof GrandPa) {
						System.err.print("G ");
					}
					else if(t instanceof Scorpion) {
						System.err.print("S ");
					}
					else if(t instanceof Snake) {
						System.err.print("s ");
					}
				}
			}
			System.err.println(" ");
		}
	}

}