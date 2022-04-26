package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setKlass(usersDto.getKlass());
        users.setStag(usersDto.getStag());
        users.setZp(usersDto.getZp());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;
    }

    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .klass(users.getKlass())
                .stag(users.getStag())
                .zp(users.getZp())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
