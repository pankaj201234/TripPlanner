package com.tripplanner.app.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class Customer extends Auditable {

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter @Setter @NotBlank
    private String phoneNo;

    @Getter @Setter @Email
    private String email;

    @Getter @Setter @URL
    private String picURL;

    @Getter @Setter
    private String password;
}