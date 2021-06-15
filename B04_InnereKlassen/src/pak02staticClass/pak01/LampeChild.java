package pak02staticClass.pak01;

import pak02staticClass.Lampe;

public class LampeChild extends Lampe{
	public static void main(String[] args) {
		Lampe.Gluehbirne birne01;
	}
}

class OtherClass{
	static void go() {
		Lampe.Gluehbirne birne;
	}
}

