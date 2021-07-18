package com.rafaelnaranjo.pbb.users.dto;

import com.rafaelnaranjo.pbb.utility.BaseEntity;
import com.rafaelnaranjo.pbb.utility.ConstanceDB;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users",schema = ConstanceDB.SCHEME)
public class User extends BaseEntity {

    private String name;
    private String lastname;
    private Date birthdate;

}
