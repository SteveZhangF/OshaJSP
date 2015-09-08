package database.dao;

import java.sql.SQLException;
import java.util.List;

import model.ElementType;

public interface ElementTypeDAO {
	public void add(ElementType p) throws SQLException;

	// 更新方法
	public void update(ElementType p) throws SQLException;

	// 查找方法
	public ElementType findById(String id) throws SQLException;

	// 查找所有
	public List<ElementType> findAll() throws SQLException;

	public List<ElementType> findbyClass(String type_class) throws SQLException;

	public void delete(String id) throws SQLException;
}
