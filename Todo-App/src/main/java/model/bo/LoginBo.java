package model.bo;

import java.sql.SQLException;

import model.bean.LoginBean;
import model.dao.JDBCUtils;
import model.dao.LoginDao;

public class LoginBo {
	public boolean isValidAccount(LoginBean loginbean) throws ClassNotFoundException {
		LoginDao login = new LoginDao();
		return login.validate(loginbean);
	}
}
