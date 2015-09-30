package bean.workflow;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.module.Module;
import database.dao.factory.DAOFactoryImpl;
import test.test;
@Entity
@Table(name = "tbl_workflow")
public class WorkFlowNode implements Serializable {
	
	@Test
	public void test(){
		WorkFlowNode first = new WorkFlowNode();
		first.setForm_id("40288091501ca6d601501ccc5ad50001");
		WorkFlowNode yes = new WorkFlowNode();
		yes.setForm_id("40288091501c934501501c9e9bc30000");
		
		first.getBranchMap().put("yes", yes.getUuid());
		Module m = DAOFactoryImpl.getModuleDAO().getModuleById("402880914ffe493e014ffe4b36a80003");
		
		new BaseDao<WorkFlowNode>(){}.saveObject(yes);
		new BaseDao<WorkFlowNode>(){}.saveObject(first);
		
		m.setWorkFlowID(first.getUuid());
		
		DAOFactoryImpl.getModuleDAO().save(m);
//		
//		WorkFlowNode diyige = new BaseDao<WorkFlowNode>(){}.getObject(WorkFlowNode.class, "40288091501d2ad001501d2ad35c0001");
//		HashMap<String, String> map = diyige.getBranchMap();
//		System.out.println(map.get("yes"));
		
	
	}
	
	
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "uuid", nullable = false)
	private String uuid;
	private String form_id;
	@OneToOne
	@JoinColumn(name = "next")
	private WorkFlowNode next;
	
	private boolean ifBranch = false;
	@Lob
	private HashMap<String, String> branchMap=new HashMap<String,String>();
	
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public WorkFlowNode getNext() {
		return next;
	}
	public void setNext(WorkFlowNode next) {
		this.next = next;
	}
	public HashMap<String, String> getBranchMap() {
		return branchMap;
	}
	public void setBranchMap(HashMap<String, String> branchMap) {
		this.branchMap = branchMap;
	}
	
	public String toXML(){
		StringBuffer sb = new StringBuffer();
		return "";
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isIfBranch() {
		return ifBranch;
	}
	public void setIfBranch(boolean ifBranch) {
		this.ifBranch = ifBranch;
	}
}
