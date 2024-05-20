package org.example.app.app.utils;

import org.example.app.app.utils.validate.validate_entity.ValidateAnswer;

import java.util.List;

public class ValidateUtils {

    public static String validateProcessing(List<ValidateAnswer> answers) {
        StringBuilder errors = new StringBuilder();
        answers.forEach(
            answer -> {
                if (!answer.isValid()) {
                    errors.append(answer.getErrorsList().toString()).append("\n");
                }
            }
        );
        return errors.toString();
    }
}
