package org.example.app.server.services.Interfaces;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(
        style = SOAPBinding.Style.RPC,
        use = SOAPBinding.Use.ENCODED,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED
    )
public interface SOAPServerInterface {
    @WebMethod
    String getAllUsers();
    @WebMethod
    String getUserById(String idUser);
    @WebMethod
    String addUser(String[]  createdUserData);
    @WebMethod
    String updateUser(String[] updatedUserData);
    @WebMethod
    String deleteUser(String idUser);
}
