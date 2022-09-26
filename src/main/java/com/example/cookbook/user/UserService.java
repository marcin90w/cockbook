package com.example.cookbook.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;
    UserDtoMapper userDtoMapper;

    public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    public String userCreated(UserDto userDto) {
        if (userDto.getLoginName() != null && userDto.getPassword() != null) {
            setUser(userDto);
            return "Konto zostało poprawnie zalożone lub edytowane";
        }
        return "Konto nie zostało utworzone";
    }

    private void setUser(UserDto userDto) {
        UserInfo newUser = new UserInfo();
        newUser.setLoginName(userDto.getLoginName());
        newUser.setPassword(userDto.getPassword());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setSubscriber(false);
        newUser.setBirthdate(userDto.getBirthdate());
        userRepository.save(newUser);
    }

    public String validateLogin(String login, String password, String submit) {
        Optional<UserInfo> checkedUser = userRepository.findByLoginNameAndPassword(login, password);
        if (checkedUser.isPresent() & submit.equals("subscribe")) {
            checkedUser.get().setSubscriber(true);
            userRepository.save(checkedUser.get());
            return "Dziękujemy za zasubskrybowanie naszej strony";
        } else if (checkedUser.isPresent() & submit.equals("login")) {
            checkedUser.get().setSubscriber(true);
            return "Poprawnie zalogowano do systemu";

        }
        return "Nieprawidłowa nazwa użytkownika lub hasło";
    }

    public List<UsersListDto> loadUsers() {
        return userRepository.findAll()
                .stream()
                .map(p -> new UsersListDto(p.getId(), p.getLoginName())).collect(Collectors.toList());
    }
}
