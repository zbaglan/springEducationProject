package org.example.test.service;

import org.example.test.entity.Question;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileParserImpl extends FileParser {
    public CsvFileParserImpl(String path) {
        super(path);
    }

    public String openFile(String path) {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource(path);
        return asString(resource);
    }

    private String asString(Resource resource) {
        try {
            InputStream inputStream = resource.getInputStream();
            return FileCopyUtils.copyToString(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }

    public void showQuestions(List<Question> questionList) {
        for (Question question : questionList) {
            System.out.println(question.getQuestion());
            question.getAnswers().forEach(System.out::println);
        }
    }

    public List<Question> convert(String questions) {
        String[] split = questions.split(";");
        List<Question> questionList = new ArrayList<>();
        for (String string : split) {
            String[] question = string.split("&");
            Question entity = new Question();
            entity.setQuestion(question[0]);//exception
            entity.setAnswers(Arrays.asList(question[1].split("\\|"))); //exception
            questionList.add(entity);
        }
        return questionList;
    }
}
