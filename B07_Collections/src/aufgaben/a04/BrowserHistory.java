package aufgaben.a04;

import java.util.ArrayList;

public class BrowserHistory {

	private ArrayList<String> listOfUrls;
	private int pointer;
	private int maxUrls;
	
	public BrowserHistory() {
		this(5);//0 bis 4 sind 5 Indizes
	}
	
	public BrowserHistory(int maxSize) {
		this.listOfUrls = new ArrayList<>();
		pointer = -1;
		maxUrls = maxSize-1;//-1 da Indizes immer mit Zero(0) beginnen.
	}
	
	public void open(String url) {
		if(pointer<maxUrls) {
			this.listOfUrls.add(url);
			pointer = this.listOfUrls.size()-1;
		} else {
			this.listOfUrls.remove(0);
			this.listOfUrls.add(url);
		}
	}
	
	public String getCurrent() {
		return this.listOfUrls.get(pointer);	
	}
	
	public void openPrevious() {
		if(pointer==0) {
			throw new IllegalStateException("ex - previous history is empty");
		}
		pointer--;
	}
	
	public boolean openNext() {
		if(pointer==maxUrls) {
			throw new IllegalStateException("ex - next history is empty");
		}
		pointer++;
		return true;
	}
}
