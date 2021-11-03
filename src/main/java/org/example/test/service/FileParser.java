package org.example.test.service;

import org.example.test.entity.Question;

import java.util.List;

public abstract class FileParser {
    private final String path;

    protected FileParser(String path) {
        this.path = path;
    }

    public final void templateMethod() {
        String questionsAsString = openFile(path);
        List<Question> questions = convert(questionsAsString);
        showQuestions(questions);
    }

    public abstract String openFile(String path);

    public abstract void showQuestions(List<Question> questionList);

    public abstract List<Question> convert(String questions);
}
