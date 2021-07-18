package com.rafaelnaranjo.pbb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {PbbApplication.class})
class PbbApplicationTests {

    @Test
    void contextLoads() {
        PbbApplication.main(new String[]{});
    }

}
