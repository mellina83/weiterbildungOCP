package pak02staticClass;

//import pak02staticClass.Demo02.Tag;

public class Demo02 {
	static class In extends Demo02{}
	private static interface I{}
	abstract static class AClass{} 
	enum Tag{MO}

	public static void main(String[] args) {
		Tag tag = Tag.MO;

	}
}
class Other{
	static void go() {
//		Tag tag;
	}
}
