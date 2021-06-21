package pak01_functional;


class MyNumber{
	private int value;
	
	public MyNumber(int value) {
		this.setValue(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "MyNumber [value=" + value + "]";
	}
	
}

interface MyNumberAdjuster{
	void adjust(MyNumber num, int value);
}

public class Demo09MethodenReferenzUnbestimmtesObjekt {
	public static void main(String[] args) {
		MyNumber n1 = new MyNumber(22);
		MyNumber n2 = new MyNumber(22);
		MyNumber n3 = new MyNumber(22);
		MyNumber n4 = new MyNumber(22);
		
		//1. Lambda
		MyNumberAdjuster a01 = (MyNumber num, int value)->{
			num.setValue(value);
		};
		a01.adjust(n1, 33);
		
		//Lambda kompakter
		MyNumberAdjuster a02 = (num, value)->num.setValue(value);
		
		//2. Mit Referenz auf eine Instanz Methode des ersten Parameters
		//der abstrakten Methode "adjust"
		MyNumberAdjuster a03 = MyNumber::setValue;
		a03.adjust(n2, 100);
		a03.adjust(n3, 100);
		a03.adjust(n4, 100);
		
		
	}
}
