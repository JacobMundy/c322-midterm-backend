package edu.iu.c322.midterm.controllers;

import edu.iu.c322.midterm.model.Question;
import edu.iu.c322.midterm.model.Quiz;
import edu.iu.c322.midterm.repository.FileRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/quizzes")
public class QuizController {
    FileRepository fileRepository;
    public QuizController(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }
    @PostMapping
    public boolean add(@RequestBody Quiz quiz){
        try {
            System.out.println("QuizController.add: " + quiz);
            return fileRepository.add(quiz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping({"/{id}"})
    public boolean update(@RequestBody Map<String, List<Integer>> requestBody, @PathVariable int id) {
        List<Integer> questionIds = requestBody.get("questionIds");
        try {
            return fileRepository.update(questionIds, id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<Quiz> findAll() {
        try {
            return fileRepository.findAllQuizzes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable int id) {
        try {
            return fileRepository.findAllQuizzes().get(id-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
