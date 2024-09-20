package com.api.crud.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

/**
 * La anotación @Service indica que esta clase es un componente de servicio en Spring,
 * lo que la convierte en un bean de servicio. Maneja la lógica de negocio y opera con
 * el repositorio para interactuar con la base de datos.
 */
@Service
public class UserService {

    /**
     * Inyectamos una instancia de IUserRepository mediante @Autowired. Esto permite
     * a Spring resolver y proporcionar automáticamente una implementación de IUserRepository.
     */
    @Autowired
    private IUserRepository userRepository;

    /**
     * Método para obtener todos los usuarios almacenados en la base de datos.
     * Utiliza el método findAll() del repositorio, que retorna una lista de usuarios.
     * 
     * @return ArrayList<UserModel> - una lista de todos los usuarios.
     */
    public ArrayList<UserModel> getUsers() {
        // Se hace casting a ArrayList ya que findAll() retorna una List.
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    /**
     * Método para guardar un nuevo usuario en la base de datos.
     * Utiliza el método save() de JpaRepository, que puede tanto crear un nuevo registro
     * como actualizar uno existente si tiene el mismo id.
     * 
     * @param user - El objeto UserModel que se desea guardar.
     * @return UserModel - El usuario guardado.
     */
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * Método para obtener un usuario por su ID. Utiliza el método findById() que devuelve
     * un Optional, por lo que usamos el método get() para obtener el usuario si está presente.
     * 
     * @param id - El ID del usuario que se desea recuperar.
     * @return UserModel - El usuario encontrado por ID.
     */
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * Método para actualizar un usuario existente por su ID. Primero busca el usuario
     * con el ID proporcionado, luego actualiza sus atributos con los valores del
     * objeto request, y finalmente retorna el usuario actualizado.
     * 
     * @param id - El ID del usuario a actualizar.
     * @param request - El objeto UserModel con los nuevos valores para el usuario.
     * @return UserModel - El usuario actualizado.
     */
    public UserModel updateById(Long id, UserModel request) {
        // Se busca el usuario a actualizar
        UserModel userToUpdate = userRepository.findById(id).get();
        
        // Se actualizan los campos del usuario
        userToUpdate.setName(request.getName());
        userToUpdate.setLastname(request.getLastname());
        userToUpdate.setEmail(request.getEmail());

        return userToUpdate;
    }

    /**
     * Método para eliminar un usuario por su ID. Utiliza el método deleteById()
     * del repositorio, y captura cualquier excepción para retornar false en caso
     * de fallo.
     * 
     * @param id - El ID del usuario a eliminar.
     * @return Boolean - true si se elimina correctamente, false si ocurre un error.
     */
    public Boolean deleteUserById(Long id) {
        try {
            // Se intenta eliminar el usuario
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // Si ocurre un error, retorna false
            return false;
        }
    }
}
