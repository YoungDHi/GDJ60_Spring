package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
		//
	}
	
	
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProductList();
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product , option
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		
		if(ar != null) {
			
			for(ProductOptionDTO productOptionDTO:ar) {
				productOptionDTO.setProductNum(productNum);
				result = productDAO.setAddOption(productOptionDTO);
			}
		}
		return result;
		
	}

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName1");
		productOptionDTO.setOptionPrice(100);
		productOptionDTO.setOptionJego(10);
		productOptionDTO.setProductNum(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOptionName("optionName2");
		productOptionDTO2.setOptionPrice(200);
		productOptionDTO2.setOptionJego(20);
		productOptionDTO2.setProductNum(null);
		
		try {
			Long num = productDAO.getProductNum();
			
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProductNum(num);
			
			if (result>0) {
				
				productDAO.setAddOption(productOptionDTO2);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
