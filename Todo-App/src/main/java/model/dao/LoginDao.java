package model.dao;

import model.bean.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		

		try {Connection connection = JDBCUtils.getConnection();
				String query = "select * from users where username = '" + loginBean.getUsername() + "' and password = '"
						+ loginBean.getPassword() + "'";
				System.out.println(query);
				Statement stmt = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) {
					return true;
				
				}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}
}
