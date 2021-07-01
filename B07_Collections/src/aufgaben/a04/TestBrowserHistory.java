package aufgaben.a04;

public class TestBrowserHistory {

	public static void main(String[] args) {
		BrowserHistory h = new BrowserHistory(5);

		h.open("u1.com");
		h.open("u2.com");
		h.open("u3.com");
		h.open("u4.com");
		h.open("u5.com");
		System.out.println(h.getCurrent()); // u5.com
		
		h.open("u6.com");
		System.out.println(h.getCurrent()); // u6.com

		h.openPrevious();
		h.openPrevious();
		h.openPrevious();
		h.openPrevious();
        System.out.println( h.getCurrent() ); // u2.com 

		try {
			h.openPrevious();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()); // previous history is empty
		}
		System.out.println(h.getCurrent()); // u2.com
		
		h.openNext();
		h.openNext();
		h.openNext();
		h.openNext();
        System.out.println( h.getCurrent() ); // u6.com
        
		try {
			System.out.println(h.openNext());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());// next history is empty
		}
           System.out.println( h.getCurrent() ); // u6.com
	}

}
