package com.jchny.api.controller;

import com.jchny.api.entity.User;
import com.jchny.api.repository.UserJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = {"1. User"})
@RestController
@RequestMapping("/")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    public UserController(UserJpaRepo userJpaRepo) {
        this.userJpaRepo = userJpaRepo;
    }

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다")
    @GetMapping("/user")
    public List<User> findAllUser() {
        return userJpaRepo.findAll();
    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다")
    @PostMapping("/user")
    public User save(@ApiParam(value = "회원아이디", required = true) String uid,
                     @ApiParam(value = "회원이름", required = true) String name) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return userJpaRepo.save(user);
    }
}
