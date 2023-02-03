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
		
		String sql = "SELECT PRODUCT_NUM, PRODUCT_NAME, PRODUCT_DETAIL, PRODUCT_JUMSU "
				+ "FROM PRODUCT";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCT_NUM"));
			productDTO.setProductName(rs.getString("PRODUCT_NAME"));
			productDTO.setProductDetail(rs.getString("PRODUCT_DETAIL"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCT_JUMSU"));
			ar.add(productDTO);
		}
		
		DBConnetion.disconnect(rs, st, connection);
		
		return ar;
		
	}
}
