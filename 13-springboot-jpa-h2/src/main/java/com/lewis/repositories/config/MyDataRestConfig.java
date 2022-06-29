package com.lewis.repositories.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.lewis.entities.Country;
import com.lewis.entities.Product;
import com.lewis.entities.ProductCategory;
import com.lewis.entities.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors)
	{
		
		
		HttpMethod[] theUnsupportedActions =
			{HttpMethod.PUT,HttpMethod.POST, HttpMethod.DELETE};
		
		
		
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metdata, httpMethods) ->
		httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods) ->
		httpMethods.disable(theUnsupportedActions));
		
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metdata, httpMethods) ->
		httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods) ->
		httpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration()
		.forDomainType(Country.class)
		.withItemExposure((metdata, httpMethods) ->
		httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods) ->
		httpMethods.disable(theUnsupportedActions));
		
		
		config.getExposureConfiguration()
		.forDomainType(State.class)
		.withItemExposure((metdata, httpMethods) ->
		httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods) ->
		httpMethods.disable(theUnsupportedActions));
	
	}
	
	

	
	
}
