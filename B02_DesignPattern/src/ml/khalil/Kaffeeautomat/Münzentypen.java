package ml.khalil.Kaffeeautomat;

public enum Münzentypen {
	_1cent(1,"cent",1), _2cent(2,"cent",2),_5cent(5,"cent",3), _10cent(10,"cent",4),_20cent(20,"cent",5),_50cent(50,"cent",6)
	,_1euro(1,"euro",7),
	_2euro(2,"euro",8);
int zahl;
String type;
int num;
Münzentypen(int zahl,String type,int num){
	this.zahl=zahl;
		this.type=type;
		this.num=num;
}
public int  getNum() {
	return this.num;
	
}
}
