package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	

	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getproductList();
	}
	
	public int setProduct(ProductDTO productDTO) throws Exception {
		
		Long productNum = productDAO.getProductnum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProduct(productDTO);
		
		return result;
		
		
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
		
	}
}
