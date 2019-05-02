package se.joel.coredev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.joel.coredev.backend.exception.BadInputException;
import se.joel.coredev.backend.exception.NotFoundException;
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
        return userRepository.save(HashAssistant.hashPassword(validate(user)));
    }

    public User login(User user) {
        Optional<User> userOptional = userRepository.findByUsername(validate(user).getUsername());
        if (userOptional.isPresent()) {
            User userDB = userOptional.get();
            System.out.println("userDB username : " + userDB.getUsername());
            System.out.println("userDB password : " + userDB.getPassword());
            System.out.println("userDB authority : " + userDB.getAuthority());
            boolean correctPassword = HashAssistant.comparePasswords(
                    userDB.getPassword(),
                    user.getPassword());
            System.out.println("Correct password : " + correctPassword + "\n");
            if (correctPassword) {
                return userDB;
            }
            throw new BadInputException("Wrong password");
        }
        throw new NotFoundException("User not found");
    }

    private User validate(User user) {
        if (null == user) {
            throw new BadInputException("User is null");
        }
        if (null == user.getUsername() || user.getUsername().isEmpty()) {
            throw new BadInputException("Username is empty");
        }
        if (null == user.getPassword() || user.getPassword().isEmpty()) {
            throw new BadInputException("Password is empty");
        }
        if (null == user.getAuthority() || user.getAuthority().isEmpty()) {
            return new User(user.getUsername(), user.getPassword(), "user");
        }
        return user;
    }
}
