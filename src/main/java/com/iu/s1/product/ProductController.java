package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		List<ProductDTO> ar = productService.getProductList();
		System.out.println(ar.size()>0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		
		return mv;
		
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void setProduct() {
		
	}
	@RequestMapping(value ="productAdd", method = RequestMethod.POST)
	public String setProduct(ProductDTO productDTO) throws Exception {
		productService.setProduct(productDTO);
		return "redirect:./list";
		
	}
	
	@RequestMapping(value = "update")
	public ModelAndView updateProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
	@RequestMapping(value = "delete")
	public ModelAndView deleteProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productDelete");
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public ModelAndView getProductDetail(ProductDTO productDTO, ModelAndView mv) throws Exception {
		productDTO = productService.getProductDetail(productDTO);
		
		mv.setViewName("product/productDetail");
		mv.addObject("dto", productDTO);
		
		return mv;
		
	}
	
}
