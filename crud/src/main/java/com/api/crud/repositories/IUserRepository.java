package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.UserModel;

/**
 * La anotación @Repository indica que esta interfaz es un componente de repositorio en Spring,
 * lo que significa que se encargará de la interacción con la base de datos para la entidad UserModel.
 * Aunque no es estrictamente necesario con Spring Data JPA (debido a que JpaRepository ya lo maneja),
 * se utiliza para indicar claramente que es un bean de tipo repositorio.
 */
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    // Al extender JpaRepository, esta interfaz hereda varios métodos CRUD (crear, leer,
    // actualizar, eliminar) para trabajar con la entidad UserModel sin necesidad
    // de implementar manualmente estos métodos.
    
    // El tipo genérico <UserModel, Long> especifica que esta interfaz manejará la entidad
    // UserModel, y el campo 'id' de dicha entidad es de tipo Long.
    
    // Spring Data JPA generará automáticamente las implementaciones de estos métodos básicos,
    // como findAll(), findById(), save(), delete(), entre otros.

}
