package BattleField;
import java.util.*;
import Beings.*;
public class BattleFields {//战场为M*N的矩形
	//version 1.0

	private int M;//战场的长
	private int N;//战场的宽

	private  BattleField BFs[][];//????
	//private ArrayList<BattleField<? extends Beings>> BF = new ArrayList<>();
	//private T battleField[][];
	public BattleFields(){
		M = 20;
		N = 20;
		BFs = new BattleField[M][N];
		for(int i = 0; i < M;i++) {
			for(int j = 0; j < N;j++) {
				BFs[i][j]=null;
			}
		}

	}
	BattleFields(int m, int n){

		M = m;
		N = n;
		BFs = new BattleField[M][N];
		for(int i = 0; i < M;i++) {
			for(int j = 0; j < N;j++) {
				BFs[i][j]=null;
			}
		}


	}
	public boolean Containable(int x, int y, int SizeX, int SizeY,int biasY) {
		if(((x + SizeX) <= M) && ((y + SizeY) <= N) && ((x + SizeX) >=0 ) && ((y + SizeY) >=0))return true;
		else return false;
	}
	public boolean Containable(int x, int y, int length, int height, boolean[][] subGraph) {
		
		return true;
	}
	public boolean SetBFPosition(int x, int y, Creature t) {
		if(BFs[x][y]!=null)return false;
		else {
			BFs[x][y]=new BattleField<Creature>(t);
			return true;
		}
		
	}
	public void BFOutput() {
		for(int i = 0; i < M;i++) {
			for(int j = 0;j < N;j++) {
				if(BFs[i][j]==null)System.out.print("* ");
				else{
					Beings t = BFs[i][j].getBeing();
					if(t instanceof CalabashBrother) {
						System.out.print("c ");
					}
					else if(t instanceof LouLuo){
						System.out.print("l ");
					}
					else if(t instanceof GrandPa) {
						System.out.print("g ");
					}
					else if(t instanceof Scorpion) {
						System.out.print("s ");
					}
					else if(t instanceof Snake) {
						System.out.print("S ");
					}
				}
			}
			System.out.println(" ");
		}
	}

}