package Test3;

public abstract class Chicken extends Animal
implements Etiable{
@Override
public String howToEat(){
	return "Chicken:Fry it";
}
@Override
public String introduceSelf() {
	return "I'm chicken";
}
}
