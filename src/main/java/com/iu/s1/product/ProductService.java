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
		Long productnum = productDAO.getProductNum();
		productDTO.setProduct_num(productnum);
		int result = productDAO.setAddProduct(productDTO);
		
		if(ar != null) {
			
			for(ProductOptionDTO productOptionDTO:ar) {
				productOptionDTO.setPrduct_num(productnum);
				result = productDAO.setAddOption(productOptionDTO);
			}
		}
		return result;
		
	}

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name("product1");
		productDTO.setProduct_detail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOption_name("optionName1");
		productOptionDTO.setOption_price(100);
		productOptionDTO.setOption_jego(10);
		productOptionDTO.setPrduct_num(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOption_name("optionName2");
		productOptionDTO2.setOption_price(200);
		productOptionDTO2.setOption_jego(20);
		productOptionDTO2.setPrduct_num(null);
		
		try {
			Long num = productDAO.getProductNum();
			
			productDTO.setProduct_num(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setPrduct_num(num);
			
			if (result>0) {
				
				productDAO.setAddOption(productOptionDTO2);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
