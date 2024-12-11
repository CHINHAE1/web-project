package com.wn;

import com.wn.mapper.EmpMapper;
import com.wn.pojo.Emp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testList(){
        List<Emp> empList = empMapper.list(null);
        empList.forEach(System.out::println);
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 / 1000))
                .compact();

        System.out.println(jwt);
    }
}
