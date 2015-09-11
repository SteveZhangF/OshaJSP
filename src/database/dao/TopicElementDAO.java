package database.dao;

import java.sql.SQLException;
import java.util.List;

import model.FormElement;
import model.TopicElement;

public interface TopicElementDAO {
	// 添加方法
	public void add(TopicElement p) throws SQLException;

	// 更新方法
	public void update(TopicElement p) throws SQLException;


	// 查找方法
	public TopicElement findById(String id) throws SQLException;

	// 查找所有
	public List<TopicElement> findAll() throws SQLException;


	public List<TopicElement> findbyParentID(String id) throws SQLException;

	public void delete(String id) throws SQLException;

}
