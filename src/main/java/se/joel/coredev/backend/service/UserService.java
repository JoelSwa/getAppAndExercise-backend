package se.joel.coredev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.joel.coredev.backend.repository.UserRepository;
import se.joel.coredev.backend.repository.data.User;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public final class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) throws NoSuchAlgorithmException {
        return userRepository.save(HashAssistant.hashPassword(authChecked(user)));
    }

    public Optional<User> login(User user) {
        //Should implement error-handling instead of returning optional
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            User userDB = userRepository.findByUsername(user.getUsername()).get();
            boolean correctPassword = HashAssistant.comparePasswords(
                    userDB.getPassword(),
                    user.getPassword());
            System.out.println("Correct password: " + correctPassword);
            if(correctPassword){
                return Optional.of(userDB);
            }
        }
        return Optional.empty();
    }

    private User authChecked(User user) {
        if (null == user.getAuthority()) {
            return new User(user.getUsername(), user.getPassword(), "user");
        }
        return user;
    }
}
