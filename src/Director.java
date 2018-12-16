import java.lang.*;
import java.util.*;
import BattleField.*;
import Beings.*;
public class Director {
	
	private BattleFields BFs;
	private CalabashBrothers CBs;
	//private Monsters Ms;
	Director(){
		BFs = null;
		CBs = null;
		//Ms = null;
	}
	Director(BattleFields bfs){
		BFs = bfs;
	}
	
	Director(BattleFields bfs, CalabashBrothers cbs){//, Monsters ms){
		BFs = bfs;
		CBs = cbs;
		//Ms =ms;
	}
	
	public boolean setFormation(int x, int y, String formationName) {
		switch(formationName) {
		case "鹤翼"://坐标为左上
			if(BFs.Containable(x, y, 7, 4 )) {
				return true;
			}
			else return false;
		case "雁行"://坐标为左上
			if(BFs.Containable(x, y, 5, 5)) {
				return true;
			}
			else return false;

		case "衡轭"://坐标为左上
			if(BFs.Containable(x, y, 2, 6)) {
				return true;
			}
			else return false;

		case "长蛇"://坐标为上
			if(BFs.Containable(x, y, 1, 6)) {
				return true;
			}
			else return false;

		case "鱼鳞"://左上
			if(BFs.Containable(x, y, 4, 5)) {
				return true;
			}
			else return false;

		case "方门"://坐标同上
			if(BFs.Containable(x, y, 5, 5)) {
				return true;
			}
			else return false;

		case "偃月"://同上
			if(BFs.Containable(x, y, 4, 9)) {
				return true;
			}
			else return false;

		case "锋矢":
			if(BFs.Containable(x, y, 5, 6)) {
				return true;
			}
			else return false;

		default://随机选择一个能够容纳下的
			return false;

		}
	}
	
	//输出名字状态
	public void QueueNameStatus() {
		CBs.QueueNameStatus();
	}
	
	public void QueueNameStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueNameStatus();
	}
	
	//输出颜色状态
	public void QueueColorStatus() {
		CBs.QueueColorStatus();
	}
	public void QueueColorStatus(CalabashBrothers calabashbrothers) {
		calabashbrothers.QueueColorStatus();
	}
	
	//冒泡排序
	public void BubbleSort() {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(CBs.getBrother(j).compareTo(CBs.getBrother(j + 1))>0) {
					
					CBs.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	public static void BubbleSort(CalabashBrothers calabashbrothers) {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6 - i; j++) {
				if(calabashbrothers.getBrother(j).compareTo(calabashbrothers.getBrother(j + 1))>0) {
					
					calabashbrothers.SwapBrother(j, j + 1);
					
				}
			}
		}
	}
	
	//快速排序
	private int Partition(int p, int r){
		CalabashBrother pivot= CBs.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(CBs.getBrother(j).compareTo(pivot) < 0){
				i++;
				CBs.SwapBrother(i, j);
			}
		}
		CBs.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public void QuickSort(int p, int r) {
		if(p < r) {
			int q = Partition(p, r);
			QuickSort(CBs, p, q - 1);
			QuickSort(CBs, q + 1, r);
		}
	}
	
	private static int Partition(CalabashBrothers calabashbrothers, int p, int r){//静态方法无需实例化
		CalabashBrother pivot= calabashbrothers.getBrother(r);
		int i = p - 1;
		for(int j = p; j < r;j++){
			if(calabashbrothers.getBrother(j).compareTo(pivot) < 0){
				i++;
				calabashbrothers.SwapBrother(i, j);
			}
		}
		calabashbrothers.SwapBrother(r, i + 1);
		//elements[r] = elements[i + 1]
		//elements[i + 1] = pivot;
		return i + 1;
	}
	public static void QuickSort(CalabashBrothers calabashbrothers, int p, int r) {//静态方法无需实例化
		if(p < r) {
			int q = Partition(calabashbrothers, p, r);
			QuickSort(calabashbrothers, p, q - 1);
			QuickSort(calabashbrothers, q + 1, r);
		}
	}
	
	public void Disorder() {
		CBs.Disorder();
	}
	public static void main(String[] args) {
		//BattleFields battlefields = new BattleFields();
		Director director = new Director(new BattleFields(),new CalabashBrothers());//, new Monsters());
		//作业2
		//CalabashBrothers calabashbrothers = new CalabashBrothers();
		//calabashbrothers.QueueNameStatus();
		//calabashbrothers.QueueColorStatus();
		System.out.println("作业二");
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.BubbleSort();
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.Disorder();
		director.QueueNameStatus();
		director.QueueColorStatus();
		
		director.QuickSort(0, 6);
		director.QueueNameStatus();
		director.QueueColorStatus();
		
	}
	
}
