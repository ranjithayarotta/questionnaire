package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.QuestionsAndAnswer;

@Repository
public interface QuestionAnswerRepo extends JpaRepository<QuestionsAndAnswer, Long> {
	@Query("select answer from QuestionsAndAnswer   where question=:question")
    public  String findAnswerByQuestion(@Param("question") String question);
	
}