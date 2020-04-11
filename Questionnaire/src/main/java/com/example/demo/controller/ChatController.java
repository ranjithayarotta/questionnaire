package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ChatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.example.demo.Repo.QuestionAnswerRepo;
import com.example.demo.model.QuestionsAndAnswer;

@RestController
@RequestMapping("/api/chat")
@Api(value="ChatController API", description="Operations pertaining to Language")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	@Autowired
	private QuestionAnswerRepo questionAnswerRepo;
	
	

	@GetMapping("/validate/{id}/{answer}")
	public QuestionsAndAnswer  validateAnswer(@PathVariable("id") Long id,@PathVariable("answer")String answer)
	{
		return 	chatService.isAnswerCorrect(id,  answer);
	}
	@PostMapping("/save_question_answer")
	public QuestionsAndAnswer saveQuestionandAnswer(@RequestBody QuestionsAndAnswer questionsAndAnswer )
	{
		return questionAnswerRepo.save(questionsAndAnswer);
		
	}
	@GetMapping("/get_answer/{question}")
	public String getAnswer(@PathVariable String question)
	{
		return questionAnswerRepo.findAnswerByQuestion(question);
	}

}
