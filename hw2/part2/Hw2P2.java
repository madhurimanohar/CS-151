package hw2p2;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class Hw2P2 {
    
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        nums.add(60);

        DataModel dataM = new DataModel(nums);
        TextView t = new TextView(dataM);
        GraphView b = new GraphView(dataM);
        dataM.notifyListeners(b);
    }

}
