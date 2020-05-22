package hw2p2;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel extends Observable {

	private ArrayList<Integer> data;
	private ChangeListener listener;

	public DataModel(ArrayList<Integer> data) {
		this.data = data;
	}

	public ArrayList<Integer> getDataInput() {
		return data;
	}

	public void setChanged(int position, int num) {
	    data.set(position, num);
        ChangeEvent event = new ChangeEvent(this);
        listener.stateChanged(event);
	}
	
	public void notifyListeners(ChangeListener c) {
	    listener = c;
	}

}
