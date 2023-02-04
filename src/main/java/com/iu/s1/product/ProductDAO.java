package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnetion;

@Repository
public class ProductDAO {
	public List<ProductDTO> getproductList() throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection connection = DBConnetion.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU "
				+ "FROM PRODUCT";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
		
		DBConnetion.disconnect(rs, st, connection);
		
		return ar;
		
	}
	
	public int setProduct(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnetion.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) "
				+ "VALUES (? , ?, ?, 0.0)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		
		int result = st.executeUpdate();
		
		DBConnetion.disconnect(st, connection);
		
		return result;
	}
	public Long getProductnum() throws Exception {
		Connection connection = DBConnetion.getConnection();
		
		String sql = "SELECT PRODUCTNUM_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnetion.disconnect(rs, st, connection);
		
		return num;
		
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		ProductDTO productDTO2 = new ProductDTO();
		Connection connection = DBConnetion.getConnection();
		
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNUM = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO2.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO2.setProductName(rs.getString("PRODUCTNAME"));
			productDTO2.setProductDetail(rs.getString("PRODUCTDETAIL"));
			productDTO2.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
		} else {
			productDTO2 = null;
		}
		return productDTO2;
	}
	
}
