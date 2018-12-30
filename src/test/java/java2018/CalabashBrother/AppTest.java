package java2018.CalabashBrother;

import java.util.Vector;

import java2018.CalabashBrother.BattleField.BattleFields;
import java2018.CalabashBrother.Beings.CalabashBrothers;
import java2018.CalabashBrother.Beings.Creature;
import java2018.CalabashBrother.Beings.GrandPa;
import java2018.CalabashBrother.Beings.LouLuo;
import java2018.CalabashBrother.Beings.Scorpion;
import java2018.CalabashBrother.Beings.Snake;
import java2018.CalabashBrother.Randomnum.Randomnum;
import java2018.CalabashBrother.application.Main;
import java2018.CalabashBrother.Director.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
    public AppTest( String testName )
    {
        super( testName );
        
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        //assertTrue( true );
      //BattleFields battlefields = new BattleFields();
      		Director director = new Director(new BattleFields(),new CalabashBrothers());//, new Monsters());
      		//Thread t = new Thread((Runnable) new Main());
      		//t.start();
      		//Main mainUI = new Main();
      		//作业2
      		//CalabashBrothers calabashbrothers = new CalabashBrothers();
      		//calabashbrothers.QueueNameStatus();
      		//calabashbrothers.QueueColorStatus();
      		/*
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
      		*/
      		
      		//作业三
      		//葫芦娃以长蛇阵放在阵地中
      	
      		while(true) {
      			director.clearBattleField();
      		int x0,y0;
      		Vector<Creature>CBList = new Vector<Creature>();
      		CBList.add(director.getBrother(0));
      		CBList.add(director.getBrother(1));
      		CBList.add(director.getBrother(2));
      		CBList.add(director.getBrother(3));
      		CBList.add(director.getBrother(4));
      		CBList.add(director.getBrother(5));
      		CBList.add(director.getBrother(6));
      		do {
      			x0 = Randomnum.getRandom(10);
      			y0 =Randomnum.getRandom(10);
      			director.QuickSort(0, 6);
      			System.out.println(CBList.size());
      		}while(!director.setFormation(x0, y0, 0, "长蛇", CBList));
      			
      		//放置爷爷	
      		GrandPa g = new GrandPa();
      		do {
      			x0 = Randomnum.getRandom(10);
      			y0 =Randomnum.getRandom(10);
      		}while(!director.setFormation(x0, y0, 0, g));
      		
      		
      		
      		//放置蝎子精和小喽啰
      		int x1,y1;
      		int formation = Randomnum.getRandom(7);//生成随机数选择阵型
      		String formationName = null;
      		Vector<Creature>MonsterList = new Vector<Creature>();
      		do {
      			MonsterList.clear();
      			x1 = Randomnum.getRandom(10);
      			y1 =Randomnum.getRandom(10) + 10;
      			switch(formation) {
      			
      			case 0:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      			
      				MonsterList.add(new Scorpion());
      			
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("鹤翼");
      				//director.setFormation(x1, y1, "鹤翼", MonsterList);
      				break;
      			
      			case 1:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      			
      				MonsterList.add(new Scorpion());
      			
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("雁行");
      				//director.setFormation(x1, y1, "雁行", MonsterList);
      				break;
      			case 2:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      			
      				MonsterList.add(new Scorpion());
      			
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("衡轭");
      				//director.setFormation(x1, y1, "衡轭", MonsterList);
      				break;
      		/*case 3:
      			MonsterList.add(new LouLuo());
      			MonsterList.add(new LouLuo());
      			
      			MonsterList.add(new Scorpion());
      			
      			MonsterList.add(new LouLuo());
      			MonsterList.add(new LouLuo());
      			MonsterList.add(new LouLuo());
      			director.setFormation(x1, y1, "长蛇", MonsterList);
      			break;
      		*/
      	
      			case 3:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());	
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new Scorpion());
      				formationName = new String("鱼鳞");
      				//director.setFormation(x1, y1, "鱼鳞", MonsterList);
      				break;
      			case 4:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new Scorpion());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("方门");
      				//director.setFormation(x1, y1, "方门", MonsterList);
      				break;
      			case 5:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new Scorpion());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("偃月");
      				//director.setFormation(x1, y1, "偃月", MonsterList);
      				break;
      			case 6:
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new Scorpion());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				MonsterList.add(new LouLuo());
      				formationName = new String("锋矢");
      				//director.setFormation(x1, y1, "锋矢", MonsterList);
      				break;
      			
      		}
      			System.out.println("x1"+x1+"y1"+y1);
      		}while(!director.setFormation(x1, y1, 10, formationName, MonsterList));
      		//放置蛇精
      		
      		Snake S = new Snake();
      		do {
      			x1 = Randomnum.getRandom(10);
      			y1 =Randomnum.getRandom(10)+10;
      			System.out.println("蛇精x1:"+x1+" y1:"+y1);
      		}while(!director.setFormation(x1, y1, 10, S));
      		System.out.println(x1+" "+y1);
      		director.showBF();
      		//new UI().initiaize();//mainUI.showBF(director.getBFs());
      		try{Thread.sleep(1000);
      		}catch(InterruptedException e) {
      		}
      		}

      		
    }
}
