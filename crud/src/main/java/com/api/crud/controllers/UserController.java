package com.api.crud.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;

/**
 * La anotación @RestController indica que esta clase es un controlador de Spring que manejará 
 * las solicitudes HTTP. Combina @Controller y @ResponseBody, lo que significa que los datos 
 * devueltos por los métodos serán convertidos directamente a JSON o XML.
 */
@RestController

/**
 * @RequestMapping("/user") establece la ruta base de todas las solicitudes que manejará este 
 * controlador. En este caso, todas las solicitudes relacionadas con "user" empezarán con "/user".
 */
@RequestMapping("/user")
public class UserController {

    /**
     * Inyectamos el servicio UserService mediante @Autowired, lo que permite utilizar los 
     * métodos del servicio sin necesidad de instanciar manualmente el objeto.
     */
    @Autowired
    private UserService userService;

    /**
     * Este método maneja solicitudes GET para obtener todos los usuarios.
     * 
     * @return ArrayList<UserModel> - una lista de todos los usuarios.
     */
    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }
    
    /**
     * Método para manejar solicitudes POST, que permite crear un nuevo usuario.
     * La anotación @RequestBody indica que los datos del cuerpo de la solicitud HTTP
     * serán mapeados a un objeto UserModel.
     * 
     * @param user - El usuario que se va a crear.
     * @return UserModel - El usuario guardado.
     */
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    /**
     * Método para manejar solicitudes GET para obtener un usuario por su ID.
     * @PathVariable indica que el valor del {id} en la URL será mapeado al parámetro Long id.
     * 
     * @param id - El ID del usuario a recuperar.
     * @return UserModel - El usuario correspondiente al ID.
     */
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    /**
     * Método para manejar solicitudes PUT para actualizar un usuario existente.
     * Usa @PutExchange para mapear las solicitudes PUT a este método.
     * 
     * @param id - El ID del usuario que se va a actualizar.
     * @param request - Los nuevos valores del usuario.
     * @return UserModel - El usuario actualizado.
     */
    @PutExchange("/{id}")
    public UserModel updateById(@PathVariable Long id, @RequestBody UserModel request) {
        return this.userService.updateById(id, request);
    }

    /**
     * Método para manejar solicitudes DELETE para eliminar un usuario por su ID.
     * Si la eliminación es exitosa, devuelve un mensaje indicando que el usuario fue eliminado;
     * de lo contrario, indica que no fue encontrado.
     * 
     * @param id - El ID del usuario a eliminar.
     * @return String - Mensaje indicando el resultado de la eliminación.
     */
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        boolean ok = this.userService.deleteUserById(id);
        if (ok) {
            return "User with ID " + id + " was deleted";
        }
        return "User with ID " + id + " was not found";
    }
}
