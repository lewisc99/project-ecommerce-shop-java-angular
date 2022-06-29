package com.lewis.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lewis.entities.Country;
import com.lewis.entities.Product;
import com.lewis.entities.ProductCategory;
import com.lewis.entities.State;
import com.lewis.repositories.CountryRepository;
import com.lewis.repositories.ProductCategoryRepository;
import com.lewis.repositories.ProductRepository;
import com.lewis.repositories.StateRepository;



@Configuration
@Profile("test")
public class TestConfig implements  CommandLineRunner {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	
	
	public TestConfig()
	{
		
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		ProductCategory c1 = new ProductCategory("Computers");
		ProductCategory c2 = new ProductCategory("Smartphones");
		ProductCategory c3 = new ProductCategory("headphones");
		ProductCategory c4 = new ProductCategory("Tablets");
		
		
		productCategoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		
		Product p1 = new Product("Inspiron 24 5000 Black All-In-One with Bipod Stand",6399.00,"Intel® Pentium® Gold 7505 (4 MB cache, 2 cores, 4 threads, up to 3.50 GHz",
				"",c1);
		
		Product p2 = new Product("New Inspiron Desktop",519.99,"12th Gen Intel® Core™ i3-12100 (12 MB cache, 4 cores, 8 threads, 3.30 GHz to 4.30 GHz Turbo)",
				"",c1);
		Product p3 = new Product("Inspiron 24 5000 Black All-In-One with Bipod Stand",549.99,"Intel® Pentium® Gold 7505 (4 MB cache, 2 cores, 4 threads, up to 3.50 GHz",
				"",c1);
		
		Product p4 = new Product("New Inspiron 24 5000 All-In-One",729.99,"AMD Ryzen™ 3 5425U 4-core/8-thread Processor with Radeon™ Graphics",
				"",c1);
		
		
		
		
		Product p5 = new Product("iPhone 13 Pro",999.00,"6.1-inch Super Retina XDR displayfootnote¹ with ProMotion for a faster, more responsive feel",
				"",c2);
		
		Product p6 = new Product("iPhone SE",429.00,"4.7-inch Retina HD displayfootnote¹ that’s bright, colorful, and sharp",
				"",c2);

		Product p7 = new Product("iPhone 11",429.00,"Dual-camera system with Night mode, Portrait mode, and 4K video up to 60 fps",
				"",c2);
		
		Product p8 = new Product("Iphone 12",629.99,"AMD Ryzen™ 3 5425U 4-core/8-thread Processor with Radeon™ Graphics",
				"",c2);
		
		

		
		Product p9 = new Product("AirPods",111.00,"6.1-inch Super Retina XDR displayfootnote¹ with ProMotion for a faster, more responsive feel",
				"",c3);
		
		Product p10 = new Product("AirPords Pro",120.00,"4.7-inch Retina HD displayfootnote¹ that’s bright, colorful, and sharp",
				"",c3);

		Product p11 = new Product("iPhone 11",115.00,"Dual-camera system with Night mode, Portrait mode, and 4K video up to 60 fps",
				"",c3);
		
		Product p12 = new Product("AirPords Max",200.99,"AMD Ryzen™ 3 5425U 4-core/8-thread Processor with Radeon™ Graphics",
				"",c3);
		
		
		Product p13 = new Product("iPad Pro",599.00,"6.1-inch Super Retina XDR displayfootnote¹ with ProMotion for a faster, more responsive feel",
				"",c4);
		
		Product p14 = new Product("iPad Air",329.00,"4.7-inch Retina HD displayfootnote¹ that’s bright, colorful, and sharp",
				"",c4);

		Product p15 = new Product("iPad",499.00,"Dual-camera system with Night mode, Portrait mode, and 4K video up to 60 fps",
				"",c4);
		
		Product p16 = new Product("iPad mini",799.99,"AMD Ryzen™ 3 5425U 4-core/8-thread Processor with Radeon™ Graphics",
				"",c4);
		
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16));
	
	
		Country country1 =  new Country("BR","Brazil");
		Country country2 =  new Country("CA","Canada");
		Country country3 =  new Country("DE","Germany");
		Country country4 =  new Country("IN","India");
		Country country5 =  new Country("TR","Turkey");
		Country country6 =  new Country("US","United States");
	
		countryRepository.saveAll(Arrays.asList(country1,country2,country3,country4,country5,country6));
	
		
		State state1 = new State("Acre",country1);
		State state2 = new State("Alagoas",country1);
		State state3 = new State("Amapá",country1);
		State state4 = new State("Amazonas",country1);
		State state5 = new State("Bahia",country1);
		
		State state6 = new State("Newfoundland and Labrador",country2);
		State state7 = new State("Northwest Territories",country2);
		State state8 = new State("Nova Scotia",country2);
		State state9 = new State("Nunavut",country2);
		State state10 = new State("Ontario",country2);
		
		
		State state11 = new State("'Baden-Württemberg",country3);
		State state12 = new State("Bavaria",country3);
		State state13 = new State("Berlin",country3);
		State state14 = new State("Brandenburg",country3);
		State state15 = new State("Ontario",country3);
		
		
		State state16 = new State("Nagaland",country4);
		State state17 = new State("Odisha",country4);
		State state18 = new State("Rajasthan",country4);
		State state19 = new State("Telangana",country4);
		State state20 = new State("Tripura",country4);
		
		State state21 = new State("''Diyarbakır'",country5);
		State state22 = new State("''Düzce'",country5);
		State state23 = new State("''Erzincan'",country5);
		State state24 = new State("''Eskişehir'",country5);
		State state25 = new State("''Eskişehir'",country5);
		
		
		State state26 = new State("Texas",country6);
		State state27 = new State("Vermont",country6);
		State state28 = new State("Wyoming",country6);
		State state29 = new State("Ağrı",country6);
		State state30 = new State("Ardahan",country6);
		
		
		stateRepository.saveAll(Arrays.asList(
				
				state1,state2,state3,state4,state5,state6,state7,state8,state9,state10,
				state11,state12,state13,state14,state15,state16,state17,state18,state19,state20,
				state21,state22,state23,state24,state25,state26,state27,state28,state29,state30
				
				));
		
	}
	


}
