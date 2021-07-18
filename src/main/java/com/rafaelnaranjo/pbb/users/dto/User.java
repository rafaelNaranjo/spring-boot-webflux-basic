package com.rafaelnaranjo.pbb.users.dto;

import com.rafaelnaranjo.pbb.utility.dto.BaseEntity;
import com.rafaelnaranjo.pbb.utility.ConstanceDB;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",schema = ConstanceDB.SCHEME)
public class User extends BaseEntity {

    private String name;
    private String lastname;
    private Date birthdate;
}
