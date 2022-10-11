package windows.projectforgully;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao extends AbstractDao<Product> {
	
	PreparedStatement pstm;
	ResultSet rs;
	String sql;
	int i;
	public int save(Product p) throws ClassNotFoundException, SQLException {
		sql = "insert into product "
				+ "(name, manufacturer, description, price, inStock) "
				+ "values(?,?,?,?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());
		pstm.setString(2, p.getManufacturer());
		pstm.setString(3, p.getDescription());
		pstm.setFloat(4, p.getPrice());
		pstm.setBoolean(5, p.isInStock());
		i = pstm.executeUpdate();
		disconnect();
		return i;
	}

	public Product getOne(Long id) throws ClassNotFoundException, SQLException {
		sql = "select * from product where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		rs = pstm.executeQuery();
		Product p = new Product();
		if(rs.next()) {
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setManufacturer(rs.getString("manufacturer"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getFloat("price"));
			p.setInStock(rs.getBoolean("inStock"));
		}
		disconnect();
		return p;
	}

	public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
		sql = "select * from product";
		connect();
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		ArrayList<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setManufacturer(rs.getString("manufacturer"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getFloat("price"));
			p.setInStock(rs.getBoolean("inStock"));
			products.add(p);
		}
		disconnect();
		return products;
	}

	public int update(Product p) throws ClassNotFoundException, SQLException {
		sql = "update product set name=?, manufacturer=?, description=?, price=?, instock=? "
				+ " where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());
		pstm.setString(2, p.getManufacturer());
		pstm.setString(3, p.getDescription());
		pstm.setFloat(4, p.getPrice());
		pstm.setBoolean(5, p.isInStock());
		pstm.setLong(6, p.getId());
		int i = pstm.executeUpdate();
		return i;
	}

	public int delete(long id) throws ClassNotFoundException, SQLException {
		sql = "delete from product where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		i = pstm.executeUpdate();
		disconnect();
		
		return i;
	}

}
