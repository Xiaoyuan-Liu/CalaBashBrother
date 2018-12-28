package java2018.CalabashBrother.Beings;

import java2018.CalabashBrother.BattleField.BattleFields;
import java2018.CalabashBrother.Randomnum.Randomnum;
import javafx.application.Platform;

public class Creature extends Beings implements Runnable{
	static int count=0;
	int id;
	protected int CE;//Combat Effectiveness
	protected int DEF;//Defence
	protected int HP;//Health Point
	protected boolean Motivated;
	protected boolean livingStatus;
	protected BattleFields BFs;
	Creature(int CE, int DEF, int HP){
		id=count;
		count++;
		this.CE = CE;
		this.DEF = DEF;
		this.HP = HP;
		Motivated = false;
		livingStatus = true;
	}
	Creature(int CE, int DEF, int HP, boolean Motivated){
		id=count;
		count++;
		this.CE = CE;
		this.DEF = DEF;
		this.HP = HP;
		this.Motivated = Motivated;
		livingStatus = true;
	}
	Creature(int CE, int DEF, int HP, boolean Motivated, BattleFields BFs){
		id=count;
		count++;
		this.CE = CE;
		this.DEF = DEF;
		this.HP = HP;
		this.Motivated = Motivated;
		livingStatus = true;
		this.BFs = BFs;
	}
	public void setBFs(BattleFields BFs) {
		this.BFs = BFs;
	}
	public int getDEF() {
		return DEF;
	}
	public int getHP() {
		synchronized(this){
		return HP;
		}
	}
	public void setHP(int HP) {
		synchronized(this){
		this.HP = HP;
		}
	}
	public boolean isMotivated() {
		return Motivated;
	}
	public boolean isLiving() {
		synchronized(this){
		return livingStatus;
		}
	}
	public void setMotivated(boolean Motivated) {
		this.Motivated = Motivated;
	}
	public synchronized boolean setLivingStatus() {
		if(HP<=0)
			livingStatus = false;
		return livingStatus;
	}
	public synchronized void Attack(Creature attackedBeing) {
		Attack(attackedBeing,1);
	}
	public synchronized void Attack(Creature attackedBeing,int radio) {
		
		if(this.getClass().getSuperclass().getName()==attackedBeing.getClass().getSuperclass().getName())return;
		

		if(this.getCE(radio) > (attackedBeing.getHP() + attackedBeing.DEF)){
			
			System.err.println("***********************"+attackedBeing.getClass().getName()+" id:"+id+" die!");
			attackedBeing.setHP(0);
			attackedBeing.setLivingStatus();
			BFs.remove(attackedBeing.getX(), attackedBeing.getY());
			BFs.updateCount();
		}
		else if(this.getCE(radio) > attackedBeing.DEF)
			attackedBeing.setHP(attackedBeing.getHP() - (this.getCE(radio) - attackedBeing.DEF));
		System.err.println("this: "+this.getClass().getName()+" at("+this.x+","+this.y+")"+ "attack "+attackedBeing.getClass().getName()+" at("+attackedBeing.x+","+attackedBeing.y+")"
				+ "HP: "+attackedBeing.getHP());
	}
	public int getCE(int radio) {
		if(Motivated)
			return CE * radio;
		else
			return CE;
	}
	public void run() {

	

		while(isLiving()) {
			Platform.runLater(()->{
			Creature c1 = BFs.getCreature(x-1, y);
			Creature c2 = BFs.getCreature(x, y-1);
			Creature c3 = BFs.getCreature(x+1, y);
			Creature c4 = BFs.getCreature(x, y+1);

			if(c1!=null) {
				Attack(c1);
			}
			if(c2!=null) {
				Attack(c2);
			}
			if(c3!=null) {
				Attack(c3);
			}
			if(c4!=null) {
				Attack(c4);
			}
			int movePos = BFs.findDirection(this, this.x, this.y);
			System.err.println("move choose" + movePos);
			
			switch(movePos) {
			case 0:
				
				if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+this.y+")");
					BFs.remove(x, y);
					x=x-1;
					y=y;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(x, y);
					x=x;
					y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				
				
			case 1:
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(x, y);
					x=x;
					y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+(this.y)+")");
					BFs.remove(x, y);
					x=x-1;
					y=y;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
				
			case 2:
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(x, y);
					x=x;
					y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				
				if(BFs.isEmpty(x+1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(x, y);
					x=x+1;
					y=y;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 3:
				
				if(BFs.SetBFPosition(x+1, y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(x, y);
					x=x+1;
					y=y;
					
					break;
				}

				if(BFs.SetBFPosition(x, y-1, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(x, y);
					x=x;
					y=y-1;
					;
				}
				break;
			case 4:
				if(BFs.SetBFPosition(x+1, y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(x, y);
					this.x=x+1;
					this.y=y;
					;
					break;
				}

				if(BFs.SetBFPosition(x, y+1, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(x, y);
					x=x;
					y=y+1;
					;
				}
				break;
			case 5:
				if(BFs.SetBFPosition(this.x, this.y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y+1;
					;
					break;
				}

				if(BFs.SetBFPosition(x+1, y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+(this.y)+")");
					BFs.remove(x, y);
					x=x+1;
					y=y;
					;
				}
				break;
			case 6:
				if(BFs.SetBFPosition(x, y+1, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(x, y);
					x=x;
					y=y+1;
					;
					break;
				}

				if(BFs.SetBFPosition(x-1, y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+(this.y)+")");
					BFs.remove(x, y);
					x=x-1;
					y=y;
					;
				}
				break;
			case 7:
				if(BFs.SetBFPosition(x-1, y, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+this.y+")");
					BFs.remove(x, y);
					x=x-1;
					y=y;
					;
					break;
				}

				if(BFs.SetBFPosition(x, y-1, this)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(x, y);
					x=x;
					y=y-1;
					;
				}
				break;
				/*
				 * if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+this.y+")");
					BFs.remove(this.x, this.y);
					this.x=x-1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				
				
			case 1:
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+(this.y)+")");
					BFs.remove(this.x, this.y);
					this.x=x-1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
				
			case 2:
				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}
				
				if(BFs.isEmpty(x+1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(this.x, this.y);
					this.x=x+1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 3:
				
				if(BFs.isEmpty(x+1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(this.x, this.y);
					this.x=x+1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 4:
				if(BFs.isEmpty(x+1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+this.y+")");
					BFs.remove(this.x, this.y);
					this.x=x+1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x, y+1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y+1;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 5:
				if(BFs.isEmpty(x, y+1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y+1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x+1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x+1)+","+(this.y)+")");
					BFs.remove(this.x, this.y);
					this.x=x+1;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 6:
				if(BFs.isEmpty(x, y+1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y+1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y+1;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+(this.y)+")");
					BFs.remove(this.x, this.y);
					this.x=x-1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
			case 7:
				if(BFs.isEmpty(x-1, y)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x-1)+","+this.y+")");
					BFs.remove(this.x, this.y);
					this.x=x-1;
					this.y=y;
					BFs.SetBFPosition(this.x, this.y, this);
					break;
				}

				if(BFs.isEmpty(x, y-1)) {
					System.err.println(this.getClass().getName()+"move from("+this.x+","+this.y+")to("+(this.x)+","+(this.y-1)+")");
					BFs.remove(this.x, this.y);
					this.x=x;
					this.y=y-1;
					BFs.SetBFPosition(this.x, this.y, this);
				}
				break;
				 * */
				 
			}
		});
			System.err.println("Thread"+this.id+" "+this.getClass().getName()+ " ("+this.x+","+ this.y+")");
			try {
				Thread.sleep(Randomnum.getRandom(1000)+1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
