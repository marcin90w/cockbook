package com.example.cookbook.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    UserDtoMapper userDtoMapper;

    public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    public String userCreated(UserDto userDto) {
        if (userDto.getLogin() != null && userDto.getPassword() != null) {
            setUser(userDto);
            return "Konto zostało poprawnie zalożone lub edytowane";
        }
        return "Konto nie zostało utworzone";
    }

    private void setUser(UserDto userDto) {
        User newUser = new User();
        newUser.setLogin(userDto.getLogin());
        newUser.setPassword(userDto.getPassword());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setBirthdate(userDto.getBirthdate());
        userRepository.save(newUser);
    }

    public boolean subscribe(String login, String password) {
        Optional<User> checkedUser = userRepository.findByLoginAndPassword(login, password);
        if (checkedUser.isPresent()) {
            checkedUser.get().setSubscriber(true);
            return true;
        }
        return false;
    }
}
