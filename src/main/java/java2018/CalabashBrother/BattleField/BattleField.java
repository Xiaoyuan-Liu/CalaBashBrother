
package java2018.CalabashBrother.BattleField;
import java2018.CalabashBrother.Beings.*;
public class BattleField<T extends Creature> {

	private T Being;
	BattleField(){
		Being = null;
	}
	BattleField(T t){
		Being = t;
	}
	public T getBeing() {
		return Being;
	}
	public Creature getCreature() {
		return (Creature)Being;
	}
	public T removeBeing() {
		T res = Being;
		Being = null;
		return res;
	}
}
