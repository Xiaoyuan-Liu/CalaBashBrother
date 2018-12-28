package java2018.CalabashBrother.Beings;

import java2018.CalabashBrother.BattleField.BattleFields;

public class Goodboy extends Creature{
	Goodboy(int CE, int DEF, int HP){
		super(CE,DEF,HP);
	}
	Goodboy(int CE, int DEF, int HP, boolean Motivated){
		super(CE,DEF,HP,Motivated);
	}
	Goodboy(int CE, int DEF, int HP, boolean Motivated, BattleFields BFs){
		super(CE,DEF,HP,Motivated,BFs);
	}
	
}
