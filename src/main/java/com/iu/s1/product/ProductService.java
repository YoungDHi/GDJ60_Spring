package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pagination;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getProductDetail(productDTO);
		//
	}
	
	
	public List<ProductDTO> getProductList(Pagination pagination) throws Exception{
		
		Long totalCount = productDAO.getProductCount();//20
		
		return productDAO.getProductList(pagination);
	}
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product , option
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar != null) {
			
			for(ProductOptionDTO productOptionDTO:ar) {
				productOptionDTO.setProductNum(productNum);
				result = productDAO.setAddOption(productOptionDTO);
			}
		}
		return result;
		
	}

	

	

}
