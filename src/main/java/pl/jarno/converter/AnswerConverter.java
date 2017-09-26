package pl.jarno.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.jarno.entity.Answer;
import pl.jarno.repository.AnswerRepository;


public class AnswerConverter implements Converter<String, Answer> {
	@Autowired
	private AnswerRepository repo;
	
	@Override
	public Answer convert(String source) {
		Answer answer = repo.findOne(Long.parseLong(source));
	    return answer;
	}
}
