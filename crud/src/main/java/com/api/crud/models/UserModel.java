package com.api.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * La anotación @Entity marca esta clase como una entidad JPA, lo que significa que será
 * mapeada a una tabla en la base de datos.
 */
@Entity

/**
 * La anotación @Table especifica el nombre de la tabla en la base de datos que estará 
 * asociada a esta entidad. En este caso, la tabla será "user".
 */
@Table(name = "user")
public class UserModel {

    /**
     * La anotación @Id indica que este campo es la clave primaria de la entidad.
     * El campo 'id' es el identificador único para cada registro en la tabla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue indica que el valor del 'id' será generado automáticamente.
    // El 'strategy = GenerationType.IDENTITY' especifica que el valor se generará
    // usando una columna de auto-incremento en la base de datos.
    private Long id;

    // Campo para almacenar el nombre del usuario.
    private String name;

    // Campo para almacenar el apellido del usuario.
    private String lastname;

    // Campo para almacenar el email del usuario.
    private String email;

    // Método getter para obtener el valor del campo 'id'.
    public Long getId() {
        return id;
    }

    // Método setter para asignar un valor al campo 'id'.
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obtener el valor del campo 'name'.
    public String getName() {
        return name;
    }

    // Método setter para asignar un valor al campo 'name'.
    public void setName(String name) {
        this.name = name;
    }

    // Método getter para obtener el valor del campo 'lastname'.
    public String getLastname() {
        return lastname;
    }

    // Método setter para asignar un valor al campo 'lastname'.
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Método getter para obtener el valor del campo 'email'.
    public String getEmail() {
        return email;
    }

    // Método setter para asignar un valor al campo 'email'.
    public void setEmail(String email) {
        this.email = email;
    }
}
