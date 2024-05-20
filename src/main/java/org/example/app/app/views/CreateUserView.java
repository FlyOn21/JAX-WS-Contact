package org.example.app.app.views;

import org.example.app.app.controllers.CreateController;
import org.example.app.app.db_connect.DbConnectInit;
import org.example.app.app.utils.ActionAnswer;
import org.example.app.app.utils.CreateUpdateParams;
import org.example.app.app.utils.validate.validate_entity.ValidateAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.app.app.utils.ValidateUtils.validateProcessing;

public class CreateUserView {
    private final DbConnectInit connection;

    public CreateUserView(DbConnectInit connection) {
        this.connection = connection;
    }

    public String createUserViewProcessing(String[] data) {
            CreateUpdateParams createParams = new CreateUpdateParams();
            List<ValidateAnswer> validateAnswers = new ArrayList<>();
            List<String> inputData = Arrays.asList(data);
            String firstName = inputData.get(0);
            ValidateAnswer validateFirstName = createParams.setFirstName(firstName);
            validateAnswers.add(validateFirstName);
            String lastName = inputData.get(1);
            ValidateAnswer validateLastName = createParams.setLastName(lastName);
            validateAnswers.add(validateLastName);
            String email = inputData.get(2);
            ValidateAnswer validateEmail = createParams.setEmail(email, connection, false);
            validateAnswers.add(validateEmail);
            String phone = inputData.get(3);
            ValidateAnswer validatePhone = createParams.setPhone(phone);
            validateAnswers.add(validatePhone);
            String isCorrect = validateProcessing(validateAnswers);
            if (!isCorrect.isEmpty()) {
                return isCorrect;
            }
            CreateController controllerCreateUser = new CreateController();
            ActionAnswer create = controllerCreateUser.controllerCreateUser(connection, createParams);
            if (create.isSuccess()) {
                return create.getSuccessMsg();
            } else {
                StringBuilder createErrorsString = new StringBuilder();
                create.getErrors().forEach(
                    error -> createErrorsString.append(error).append("\n")
                );
                return createErrorsString.toString();
            }
    }
}

