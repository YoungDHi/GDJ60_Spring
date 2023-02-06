package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	//getMax
	public Long getProductNum() throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disconnect(rs, st, connection);
		
		return num;
		
		
	}
	
	public List<ProductOptionDTO> getOptionList() throws Exception {
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION ORDER BY OPTIONPRICE";
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTOPNNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionJego(rs.getInt("OPTIONJEGO"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
		
	}

	public int setAddOption(ProductOptionDTO productOptionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTION_EGO) "
				+ "VALUES (PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setInt(3, productOptionDTO.getOptionPrice());
		st.setInt(4, productOptionDTO.getOptionJego());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnect(st, connection);
		
		return result;
		
	}
	//-------------------------
	
	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		ProductDTO productDTO2 = new ProductDTO();
		Connection connection = DBConnection.getConnection();
		
		String sql= "SELECT * FROM PRODUCT WHERE PRODUCTNUM = ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO2 = new ProductDTO();
			productDTO2.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO2.setProductName(rs.getString("PRODUCTNAME"));
			productDTO2.setProductDetail(rs.getString("PRODUCTDETAIL"));
			productDTO2.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
		} else {
			productDTO2 = null;
		}
		
		return productDTO2;
		
		
	}
	
	
	//return은 Arraylist의 부모형 List로 해두는 것이 좋음
	public List<ProductDTO> getProductList() throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
		
	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) "
				+ "VALUES (?, ?, ?, 0.0)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		//st.setDouble(3, productDTO.getProduct_jumsu());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnect(st, connection);
		
		return result;
		
	}
	
	
}

