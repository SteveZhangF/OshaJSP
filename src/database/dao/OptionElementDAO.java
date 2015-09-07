package database.dao;

import java.sql.SQLException;
import java.util.List;

import model.OptionElement;

public interface OptionElementDAO {
	// 添加方法
	public void add(OptionElement p) throws SQLException;

	// 更新方法
	public void update(OptionElement p) throws SQLException;

	// 查找方法
	public OptionElement findById(String id) throws SQLException;

	// 查找所有
	public List<OptionElement> findAll() throws SQLException;

	public List<OptionElement> findbyParentID(String id) throws SQLException;

	public void delete(String id) throws SQLException;
}
