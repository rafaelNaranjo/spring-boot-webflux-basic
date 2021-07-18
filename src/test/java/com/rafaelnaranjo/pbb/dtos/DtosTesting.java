package com.rafaelnaranjo.pbb.dtos;

import com.rafaelnaranjo.pbb.users.dto.User;
import com.rafaelnaranjo.pbb.utility.dto.BaseEntity;
import com.rafaelnaranjo.pbb.utils.TestPojos;
import org.junit.jupiter.api.Test;

public class DtosTesting {

    @Test
    public void TestingDtos(){
        TestPojos.validateAccessors(BaseEntity.class);
        TestPojos.validateAccessors(User.class);
    }
}
