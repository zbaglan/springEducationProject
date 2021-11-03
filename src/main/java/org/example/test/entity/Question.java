package org.example.test.entity;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String question;
    private List<String> answers;
}
