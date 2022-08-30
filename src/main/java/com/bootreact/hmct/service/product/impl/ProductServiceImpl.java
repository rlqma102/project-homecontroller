package com.bootreact.hmct.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootreact.hmct.entity.Product;
import com.bootreact.hmct.entity.ProductImage;
import com.bootreact.hmct.mapper.ProductMapper;
import com.bootreact.hmct.repository.ProductImageRepository;
import com.bootreact.hmct.repository.ProductRepository;
import com.bootreact.hmct.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductImageRepository productImageRepository;
	
	@Override
	public int insertProduct(Product product){
		productRepository.save(product);
		productRepository.flush();
		return product.getProductNo();
	}
	
	@Override
	public void insertProductFiles(List<ProductImage> fileList) {
		for(ProductImage pi : fileList) {
			int piNo = productMapper.getNextProductImageNo(pi.getProduct().getProductNo());
			pi.setProductImageNo(piNo);
			productImageRepository.save(pi);
		}
	}

	@Override
	public List<Product> getProductList(int productNo) {
		
		return productRepository.findByProductNo(productNo);
	}
}
