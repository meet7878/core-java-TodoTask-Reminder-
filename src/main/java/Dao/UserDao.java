package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.bean.UserTaskBean;
import util.DbConnection;

public class UserDao {
	public void insertUser(UserBean userBean) {
		 
		 try {
		 Connection con = DbConnection.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("insert into users (firstname,lastname,email,password,gender,usertype,sports )values(?,?,?,?,?,?,?)");

		 pstmt.setString(1, userBean.getFirstName());
	     pstmt.setString(2, userBean.getLastName());
	     pstmt.setString(3, userBean.getEmail());
	     pstmt.setString(4, userBean.getPassword());
		 pstmt.setString(5, userBean.getGender());
		 pstmt.setString(6, userBean.getUsertype());
		 pstmt.setString(7, userBean.getSports());
		 
		
		 
		 int records = pstmt.executeUpdate();


		 System.out.println(records+" inserted..."); 
		 
		 }catch(Exception e) {
			 System.out.println("some thing wrong in insert user()");
		      e.printStackTrace();
		 }
		 
		 	 
}
	
	
	public void insertUserTask(UserTaskBean userTaskBean) {
		 
		 try {
		 Connection con = DbConnection.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("insert into task (task,description,date,time,userid,startdate,status,priority)values(?,?,?,?,?,?,?,?)");
		 pstmt.setString(1, userTaskBean.getTask());
	     pstmt.setString(2, userTaskBean.getDescription());
	     pstmt.setString(3, userTaskBean.getDate());
	     pstmt.setString(4, userTaskBean.getTime());
		 pstmt.setInt(5,userTaskBean.getUserid());
		 pstmt.setString(6, userTaskBean.getStartdate());
		 pstmt.setString(7, userTaskBean.getStatus());
		 pstmt.setString(8, userTaskBean.getPriority());

		 
		 int records = pstmt.executeUpdate();


		 System.out.println(records+" Task inserted..."); 
		 
		 }catch(Exception e) {
			 System.out.println("some thing wrong in insert TaskDao()");
		      e.printStackTrace();
		 }
		 
		 	 
}
	 public ArrayList<UserTaskBean>  getAllTaskUsers(int userid) {
		   ArrayList<UserTaskBean> users = new ArrayList<UserTaskBean>();
		   try {
			   Connection con = DbConnection.getConnection();
			   PreparedStatement pstmt = con.prepareStatement("select * from task where userid=?");
			   pstmt.setInt(1,userid);
			  ResultSet rs =  pstmt.executeQuery();//show all data on db
			   
			  while(rs.next() == true)//1st row 2nd row
			  {
			  Integer taskid = rs.getInt("taskid");//db column name
			  String task = rs.getString("task");
			  String description = rs.getString("description");
			  String date = rs.getString("date");
			  String time = rs.getString("time");
			  String start = rs.getString("startdate");
			  String status = rs.getString("status");
			  String priority = rs.getString("priority");
			  
			 
			  
			  UserTaskBean user = new UserTaskBean();
			  user.setTaskid(taskid);
			  user.setTask(task);
			  user.setDescription(description);
			  user.setDate(date);
			  user.setTime(time);
			  user.setStartdate(start);
			  user.setStatus(status);
			  user.setPriority(priority);
			  
			  System.out.println(user);
			  users.add(user);
			  
		   }
			  //go to line num 74
			  
			   
		} catch (Exception e) {
			System.out.println("smw in user Dao:getAllTaskUser()");
			e.printStackTrace();
		}
		   return users;
		   
	   }
	
	
	
	
	
	
	public UserBean login(String email,String password) {
		  UserBean user = null;
		try {
         Connection con = DbConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
         pstmt.setString(1, email);
         pstmt.setString(2, password);
          
        ResultSet rs= pstmt.executeQuery(); //read data on db.
        
        if(rs.next()) {
      	  user = new UserBean();
      	  user.setUserId(rs.getInt("userid"));
      	  user.setFirstName(rs.getString("firstname"));
      	  user.setUsertype(rs.getString("usertype"));
      	  
      	  
        }
		} catch (Exception e) {
			System.out.println("smw in login dao");
		}
		return user;
	}
	
	
	public UserBean forgot(String email,String sports) {
		  UserBean user = null;
		try {
       Connection con = DbConnection.getConnection();
       PreparedStatement pstmt = con.prepareStatement("select * from users where email = ?  and sports = ?");
       pstmt.setString(1, email);
       pstmt.setString(2,sports);
      
      ResultSet rs= pstmt.executeQuery(); //read data on db.
      
		
		  if(rs.next()) { 
			  user = new UserBean(); 
		 user.setUserId(rs.getInt("userid")); 
		  user.setFirstName(rs.getString("firstname"));
		  user.setUsertype(rs.getString("usertype"));
		  
		  
		  }
		 
		} catch (Exception e) {
			System.out.println("smw in fogot dao");
		}
		return user;
	}

	public boolean updatePasswordUser(UserBean user) {
		   boolean flag = false;
		   try(Connection con = DbConnection.getConnection();
				   PreparedStatement psmt = con.prepareStatement("update users set password=? where email=?");
				   		)
			 {
			  
				psmt.setString(1, user.getPassword());
				psmt.setString(2, user.getEmail());
				int updateCount = psmt.executeUpdate();
				if(updateCount == 1) {
					flag = true;
		   }
			 }
		   
		   catch (Exception e) {
		   e.printStackTrace();	// TODO: handle exception
		}
		   return flag;
	   }

	 public boolean updateUser(UserTaskBean update) {
		   boolean flag = false;
		   try(Connection con = DbConnection.getConnection();
				   PreparedStatement psmt = con.prepareStatement("update task set status = ? where taskid=?");
				   		)
			 {
			   psmt.setString(1, update.getStatus());
				psmt.setInt(2, update.getTaskid());
				System.out.println(psmt);
				int updateCount = psmt.executeUpdate();
				if(updateCount == 1) {
					flag = true;
		   }
			 }
		   
		   catch (Exception e) {
		   e.printStackTrace();	// TODO: handle exception
		}
		   return flag;
	   }


	 public boolean deleteTask(int taskid) {
			boolean flag = false;
			try(
					Connection con = DbConnection.getConnection();
					PreparedStatement psmt = con.prepareStatement("delete from task where taskid = ?");
					){
				psmt.setInt(1, taskid);
				int deleteRows = psmt.executeUpdate();
				if(deleteRows==1) {
					flag = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return flag;
		}


	public Boolean ValidEmail(String email) {

     try (
    	 Connection con = DbConnection.getConnection();
    	 PreparedStatement pstmt = con.prepareStatement("select * from users where email = ?");
    	 )
     {
    	 pstmt.setString(1, email);
    	 ResultSet rs = pstmt.executeQuery();
    	 
    	 if(rs.next()) {
    		 return true;
    		 
     }
     }
     catch (Exception e) {
		e.printStackTrace();
	}
			return false;
	
	}
	
	//update task
	   public UserTaskBean gettaskdata(int taskid) {
		   UserTaskBean user = new UserTaskBean();
		   try(Connection con = DbConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("select * from task where taskid = ?");){
			 pstmt.setInt(1, taskid);
			 ResultSet rs= pstmt.executeQuery();
			 
			 while(rs.next()) {
					user= new UserTaskBean();
				user.setTask(rs.getString("task"));
				user.setDescription(rs.getString("description"));
				user.setPriority(rs.getString("priority"));
				user.setTaskid(taskid);
			 }
			 
		   }
		   catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
			   
		   
		   return user;
		   
	   }
	
	public boolean EditTaskDao(UserTaskBean userTaskBean) {
		   boolean flag = false;
		   try(Connection con = DbConnection.getConnection();
				   PreparedStatement psmt = con.prepareStatement("update task set  task = ? ,description = ?  , priority = ? where taskid=?");
				   		)
			 {
			   psmt.setString(1, userTaskBean.getTask());
				psmt.setString(2, userTaskBean.getDescription());
			
				psmt.setString(3, userTaskBean.getPriority());
				psmt.setInt(4, userTaskBean.getTaskid());
				System.out.println(psmt);
				int updateCount = psmt.executeUpdate();
				if(updateCount == 1) {
					flag = true;
		   }
			 }
		   
		   catch (Exception e) {
		   e.printStackTrace();	// TODO: handle exception
		}
		   return flag;
	   }

	
}



