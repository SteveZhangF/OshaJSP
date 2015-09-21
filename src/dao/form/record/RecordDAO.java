package dao.form.record;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.LiteralNode;

import bean.form.record.FormRecord;

public interface RecordDAO {
	public FormRecord getRecordbyID(String id);
	public List<FormRecord> getRecordsbyOE_ID(String uuid);
	
	public void save(FormRecord obj);
	
	public void delete(FormRecord obj);
}
