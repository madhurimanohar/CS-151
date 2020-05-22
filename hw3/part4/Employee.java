import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Employee implements Cloneable{

    private int ID;
    private String name;

    public Employee(int id, String n) {
        super();
        ID = id;
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        ID = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Employee clone = (Employee) super.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nID: "  + ID + "\n";
    }

    class SortNames implements Comparator<Employee>{

        @Override
        public int compare(Employee e1, Employee e2) {
           return e1.getName().compareTo(e2.getName());
        }
    }
    
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Employee> list = new ArrayList<>();
        
        Employee Maya = new Employee(14,"Maya");
        Employee Amy = new Employee(18,"Amy");
        Employee Sarah = new Employee(63,"Sarah");

        list.add(Maya);
        list.add(Amy);
        list.add(Sarah);
        
        ArrayList<Employee> clonedList = new ArrayList<>();
        
        Iterator<Employee> i = list.iterator();
        
        do {
            clonedList.add((Employee) i.next().clone());
        } while (i.hasNext());
        
        Collections.sort(clonedList, new Employee(0, null).new SortNames());
        
        System.out.print("Original\n");
        System.out.println(list);
        System.out.println("");
        System.out.print("Clone (sorted alphabetically by name)\n");
        System.out.println(clonedList);
        System.out.println("");
        System.out.print("Index 0 in clone is being changed.\n");
        clonedList.get(0).setName("Jo");
        System.out.println("");
        System.out.print("Original\n");
        System.out.println(list);
        System.out.println("");
        System.out.println("New Clone");
        System.out.println(clonedList);
    } 
}
