package Questions;

import java.util.List;
import empAbsImp.EmpImpl;
import jdbc.EmpException;
import jdbc.EmployeeBean;

public class Q2 {

	
	public static void main(String[] args) throws EmpException {
	EmpImpl e = new EmpImpl();
	List<EmployeeBean> l = e.getAllEmployyes();
	
	l.stream().forEach(i ->{
		System.out.println(i.toString());
	});
	}
}
