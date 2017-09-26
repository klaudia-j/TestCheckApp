package pl.jarno.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.jarno.entity.Category;
import pl.jarno.repository.CategoryRepository;



public class CategoryConverter implements Converter<String, Category> {
	@Autowired
	private CategoryRepository repo;
	
	@Override
	public Category convert(String source) {
		Category category = repo.findOne(Long.parseLong(source));
	    return  category;
	}


}
