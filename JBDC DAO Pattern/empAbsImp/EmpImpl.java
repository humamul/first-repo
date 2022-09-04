package empAbsImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.EmpException;
import jdbc.EmployeeBean;
import utility.Connect;

public class EmpImpl implements Abstracts{

	@Override
	public int getSalary(int id) throws EmpException {
		int salary=0;
		
		try(Connection con = Connect.getCon()) {
			if(con==null) System.out.println("kya yar");
			PreparedStatement ps = con.prepareStatement("select salary from employee2 where eid = ?");
					ps.setInt(1,id);
					
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					salary = rs.getInt("salary");
				}else {
					throw new EmpException("This id:"+id+" does not Exist");
				}
					
				
		} catch (SQLException e) {
			throw new EmpException(e.getMessage());
		}
		
		return salary;
		}

	@Override
	public List<EmployeeBean> getAllEmployyes() throws EmpException{
		
		List<EmployeeBean> list = new ArrayList<>();
		
		try (Connection con = Connect.getCon()){
			PreparedStatement ps = con.prepareStatement("select * from employee2");
			
			
			ResultSet x = ps.executeQuery();
			
			while(x.next()) {
				int eid = x.getInt("eid");
				
			    int salary = x.getInt("salary");
			    
			    String name = x.getString("name");
			    String add = x.getString("address");
			    
			    
			    EmployeeBean e = new EmployeeBean(eid, salary, name, add);
			    
			   list.add(e);
			}
			if(list.size()==0) {throw new EmpException("No employees is there in table Employee2");}
			
			
			
			
		} catch (Exception e) {
			throw new EmpException(e.getMessage());
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void giveBonusToAll(int n) throws EmpException{
		
		try (Connection c  = Connect.getCon()){
			
			PreparedStatement pm= c.prepareStatement("update employee2 set salary = salary + ?");
		    
			
			pm.setInt(1, n);
		
			int x = pm.executeUpdate();
			if(x!=0) System.out.println("Added the bonus amount into the salary");
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmpException(e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<EmployeeBean> getEmployeesMoreSalary(int salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enterEmpDetailsNoAddress(EmployeeBean e) throws EmpException {
		// TODO Auto-generated method stub
try (Connection c  = Connect.getCon()){
			
			PreparedStatement pm= c.prepareStatement("insert into employee2(eid,name,salary) values(?,?,?)");
		    pm.setInt(1, e.getEid());
		    pm.setString(2, e.getName());
		    pm.setInt(3,e.getSalary());
		    
			
		
			int x = pm.executeUpdate();
			if(x!=0) System.out.println("Added the bonus amount into the salary");
			
		} catch (SQLException ex) {
			// TODO: handle exception
			throw new EmpException(ex.getMessage());
		}
	}

	
	
}
