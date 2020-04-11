package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.QuestionAnswerRepo;
import com.example.demo.error.WrongAnswerFoundException;
import com.example.demo.model.QuestionsAndAnswer;

@Service
public class ChatService {
	
	@Autowired
	private QuestionAnswerRepo questionAnswerInterface;
	
	
	public QuestionsAndAnswer isAnswerCorrect(Long id,String answer)
	{
		Optional<QuestionsAndAnswer> questionsAndAnswer = questionAnswerInterface.findById(id);
		return questionsAndAnswer.filter(e->e.getAnswer().equals(answer)).orElseThrow(() -> new WrongAnswerFoundException(id));
	}


}
