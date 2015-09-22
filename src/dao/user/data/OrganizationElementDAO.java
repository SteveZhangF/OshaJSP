package dao.user.data;

import bean.user.data.OrganizationElement;

public interface OrganizationElementDAO {
	
	public void save(OrganizationElement p) ;

	public OrganizationElement getOEbyID(String uuid) ;

	public void delete(String id) ;
}
