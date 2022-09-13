class Student {
    int rollno;
    String name, address;
  
    public Student(int rollno, String name, String address)
    {
  
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
  
    public String toString()
    {
        return this.rollno + " " + this.name + " "
            + this.address;
    }
}
  
class Sortbyroll implements Comparator<Student> {
  
    // sorting in ascending order of
  
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
  

public class TreeMap {
  
    static void Example2ndConstructor()
    {
        // Creating an empty TreeMap
        TreeMap<Student, Integer> tree_map
            = new TreeMap<Student, Integer>(
                new Sortbyroll());
  
        // Mapping string values to int keys
        tree_map.put(new Student(111, "bbbb", "london"), 2);
        tree_map.put(new Student(131, "aaaa", "nyc"), 3);
        tree_map.put(new Student(121, "cccc", "jaipur"), 1);
        // if instead of Student object you put an integer here then it will get automatically sorted in ascending order;
      
        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
      //or we can also print it like this;
      	Set<Map.Entry<Student, Integer>> entrySet =  tree_map.entrySet(); ;
		entrySet.forEach(entry -> System.out.println(entry.getKey() + "==>>>" + entry.getValue()));
    }
  
    // Main driver method
    public static void main(String[] args)
    {
  
        System.out.println("TreeMap using "
                           + "TreeMap(Comparator)"
                           + " constructor:\n");
        Example2ndConstructor();
    }
}
