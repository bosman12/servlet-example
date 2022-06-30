package entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String userName;

    private String name;

    private String surName;

    private String password;

    private int age;

    private String email;

    public boolean status;



}
