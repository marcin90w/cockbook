package com.example.cookbook.user;

import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper {
    UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setSubscriber(user.getSubscriber());
        return dto;
    }
}
