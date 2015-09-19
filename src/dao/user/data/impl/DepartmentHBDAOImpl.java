package dao.user.data.impl;

import java.sql.SQLException;

import bean.dao.BaseDao;
import bean.user.data.Department;
import dao.user.data.DepartmentDAO;

public class DepartmentHBDAOImpl extends BaseDao<Department>implements DepartmentDAO {

	@Override
	public void save(Department p) throws SQLException {
		super.saveObject(p);
	}

	@Override
	public Department getDepartmentbyID(String uuid) throws SQLException {
		return super.getObject(Department.class, uuid);

	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		super.deleteObject(getDepartmentbyID(id));
	}

}
