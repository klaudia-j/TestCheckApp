package pl.jarno.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.jarno.entity.Answer;
import pl.jarno.entity.Question;
import pl.jarno.jsonclass.QuestionWithAnswers;
import pl.jarno.repository.AnswerRepository;
import pl.jarno.repository.CategoryRepository;
import pl.jarno.repository.QuestionRepository;

@RestController
@RequestMapping("/categories")
public class QuestionController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	
	@PostMapping("/{categoryId}/questions")
	public QuestionWithAnswers createQuestion(@RequestBody QuestionWithAnswers questionWithAnswers, @PathVariable Long categoryId) {
		Question question = questionWithAnswers.getQuestion();
		question.setCategory(categoryRepo.findOne(categoryId));
		questionRepo.save(question);
		List<Answer> answers = questionWithAnswers.getAnswers();
		for (int i = 0; i < answers.size(); i++) {
			answers.get(i).setQuestion(question);
			answerRepo.save(answers.get(i));
		}
		return questionWithAnswers;
	}
	
//	@PostMapping("/{categoryId}/questions")
//	public QuestionWithAnswers createQuestion(@RequestBody QuestionWithAnswers questionWithAnswers, @PathVariable Long categoryId) {
//		Question question = new Question();
//		question.setContent(questionWithAnswers.getQuestionContent());
//		question.setCategory(categoryRepo.findOne(categoryId));
//		questionRepo.save(question);
//		questionWithAnswers.setQuestionId(question.getId());
//		List<AnswerInJson> answers = questionWithAnswers.getAnswers();
//		for (int i = 0; i < answers.size(); i++) {
//			Answer answer = new Answer();
//			answer.setContent(answers.get(i).getContent());
//			answer.setCorrect(answers.get(i).getIsCorrect());
//			answerRepo.save(answer);
//			answers.get(i).setId(answer.getId());
//		}
//		return questionWithAnswers;
//	}
	
	@PutMapping("/{categoryId}/questions/{questionId}")
	public Question updateQuestion(@RequestBody Question question, @PathVariable Long categoryId, @PathVariable Long questionId) {
		question.setId(questionId);
		questionRepo.save(question);
		return question;
	}
	
	@DeleteMapping("/{categoryId}/questions/{questionId}")
	public void deleteQuestion(@PathVariable long categoryId, @PathVariable long questionId) {
		questionRepo.delete(questionId);
	}

}
