package dao.user.data.impl;

import bean.dao.BaseDao;
import bean.user.data.OrganizationElement;
import dao.user.data.OrganizationElementDAO;

public class OrganizationElementHBDAOImpl extends BaseDao<OrganizationElement> implements OrganizationElementDAO {

	@Override
	public void save(OrganizationElement p) {
		// TODO Auto-generated method stub
		super.saveObject(p);
	}

	@Override
	public OrganizationElement getOEbyID(String uuid) {
		// TODO Auto-generated method stub
		return super.getObject(OrganizationElement.class, uuid);
	}

	@Override
	public void delete(String id) {
		super.deleteObject(getOEbyID(id));
	}

}
