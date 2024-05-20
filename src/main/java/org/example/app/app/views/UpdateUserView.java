package org.example.app.app.views;

import org.example.app.app.controllers.ReadController;
import org.example.app.app.controllers.UpdateController;
import org.example.app.app.db_connect.DbConnectInit;
import org.example.app.app.entity.User;
import org.example.app.app.utils.ActionAnswer;
import org.example.app.app.utils.CreateUpdateParams;
import org.example.app.app.utils.ReadParams;
import org.example.app.app.utils.validate.validate_entity.ValidateAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.example.app.app.utils.ValidateUtils.validateProcessing;

public class UpdateUserView {
    private final DbConnectInit connection;

    public UpdateUserView(DbConnectInit connection) {
        this.connection = connection;
    }

    public String updateUserViewProcessing(String[] data) {
        CreateUpdateParams updateParams = new CreateUpdateParams();
        ReadParams readParamsById = new ReadParams();
        List<String> inputData = Arrays.asList(data);
        List<ValidateAnswer> validateIdList = new ArrayList<>();
        String idData = inputData.get(0);
        ValidateAnswer validateId = readParamsById.setId(idData);
        validateIdList.add(validateId);
        String idIsExists = validateProcessing(validateIdList);
        if (!idIsExists.isEmpty()) {
            return idIsExists;
        }
        ReadController readController = new ReadController();
        Optional<List<User>> currentUser = readController.controllerReadById(connection, readParamsById);

        if (currentUser.isPresent()) {
            User user = currentUser.get().getFirst();
            List<ValidateAnswer> validateAnswers = new ArrayList<>();
            String firstName = inputData.get(1);
            if (firstName.isEmpty()) {
                updateParams.setFirstName(user.getFirstName());
            } else {
                ValidateAnswer validateFirstName = updateParams.setFirstName(firstName);
                validateAnswers.add(validateFirstName);
            }

            String lastName = inputData.get(2);
            if (lastName.isEmpty()) {
                updateParams.setLastName(user.getLastName());
            } else {
                ValidateAnswer validateLastName = updateParams.setLastName(lastName);
                validateAnswers.add(validateLastName);
            }

            String email = inputData.get(3);
            if (email.isEmpty()) {
                updateParams.setEmail(user.getEmail(), connection, true);
            } else {
                ValidateAnswer validateEmail = updateParams.setEmail(email, connection, false);
                validateAnswers.add(validateEmail);
            }

            String phone = inputData.get(4);
            if (phone.isEmpty()) {
                updateParams.setPhone(user.getPhone());
            } else {
                ValidateAnswer validatePhone = updateParams.setPhone(phone);
                validateAnswers.add(validatePhone);
            }

            String isCorrect = validateProcessing(validateAnswers);
            if (!isCorrect.isEmpty()) {
                return isCorrect;
            }

            UpdateController updateController = new UpdateController();
            ActionAnswer update = updateController.updateUser(connection, currentUser.get().getFirst(), updateParams);
            if (update.isSuccess()) {
                return update.getSuccessMsg();
            } else {
                StringBuilder updateErrorsString = new StringBuilder();
                update.getErrors().forEach(
                        error -> updateErrorsString.append(error).append("\n")
                );
                return updateErrorsString.toString();
            }
        } else {
            return "No users found";
        }
    }
}
