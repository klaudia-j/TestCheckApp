package pl.jarno.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.jarno.entity.Question;
import pl.jarno.repository.QuestionRepository;

public class QuestionConverter implements Converter<String, Question> {
	@Autowired
	private QuestionRepository repo;
	
	@Override
	public Question convert(String source) {
		Question question = repo.findOne(Long.parseLong(source));
	    return  question;
	}

}
