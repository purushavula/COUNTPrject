package com.tech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;


public class Doctor {
	public static Connection con=null;
	public static java.sql.Statement s=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;

	public void creating() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "purush");
			s=con.createStatement();
			s.executeUpdate("create table Doctor(did int primary key auto_increment,dname varchar(40),dage int,dspec varchar(50)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(s!=null) {
					s.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}
	public void inserting(String dname,int dage,String dspec) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "purush");
			ps=con.prepareStatement("inserting into Doctor(dname,dage,dspec)values(?,?,?)");
			ps.setString(1, dname);
			ps.setInt(2, dage);
			ps.setString(3, dspec);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}
	public void update(int did,String dspec,int dage) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "purush");
			ps=con.prepareStatement("update Doctor set dspec=?,dage=? where did=?");
			ps.setString(1, dspec);
			ps.setInt(2, dage);
			ps.setInt(3, did);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}
	public void delete(int did) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "purush");
			ps=con.prepareStatement("delete from Doctor where did=?");
			ps.setInt(1, did);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}
	public void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "purush");
			s=con.createStatement();
			rs=s.executeQuery("select * from Doctor");
			while(rs.next()) {
				System.out.println(rs.getInt("did"));
				System.out.println(rs.getString("dname"));
				System.out.println(rs.getInt("dage"));
				System.out.println(rs.getString("dspec"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(s!=null) {
					s.close();
				}
				if(con!=null) {
					con.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}


	
	
	

	
	
	

}
