package model.bo;

import model.bean.User;
import model.dao.RegisterDao;

public class RegisterBo {
	public int Register(User user) throws ClassNotFoundException {
		RegisterDao userdao = new RegisterDao();
		return userdao.registerEmployee(user);
	}
}
