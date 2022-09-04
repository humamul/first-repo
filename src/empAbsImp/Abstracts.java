package empAbsImp;

import java.util.List;

import jdbc.EmpException;
import jdbc.EmployeeBean;

public interface Abstracts {

	public abstract int getSalary(int id) throws EmpException;
	public abstract List<EmployeeBean> getAllEmployyes() throws EmpException;
	public abstract void giveBonusToAll(int n) throws EmpException;
	public abstract void enterEmpDetailsNoAddress(EmployeeBean e) throws EmpException;
	public abstract  List<EmployeeBean> getEmployeesMoreSalary(int salary) throws EmpException;
	
}
