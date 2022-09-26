package com.example.cookbook.user;

import org.springframework.stereotype.Service;

@Service
public class UserDtoMapper {
    UserDto map(UserInfo user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setLoginName(user.getLoginName());
        dto.setPassword(user.getPassword());
        dto.setSubscriber(user.getSubscriber());
        return dto;
    }
}
