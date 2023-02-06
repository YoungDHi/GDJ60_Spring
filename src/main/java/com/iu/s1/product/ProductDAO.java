package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum) throws Exception {
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	//getMax
	public Long getProductNum() throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM_SEQ.NEXTVAL FROM DUAL";
		
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
			productOptionDTO.setOptionNum(rs.getLong("OPTIOPNNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disconnect(rs, st, connection);
		
		return ar;
		
	}

	public int setAddOption(ProductOptionDTO productOptionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK) "
				+ "VALUES (OPTIONNUM_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setInt(3, productOptionDTO.getOptionPrice());
		st.setInt(4, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disconnect(st, connection);
		
		return result;
		
	}
	//-------------------------
	
	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);	
	}
	
	//return은 Arraylist의 부모형 List로 해두는 것이 좋음
	public List<ProductDTO> getProductList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddProduct", productDTO);
	}
	
	
}

