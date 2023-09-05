package uz.pdp.instagram.service.user;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.SignInDTO;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.userRepository;

public class UserServiceImpl implements UserService{
    private static  final UserServiceImpl instance = new UserServiceImpl();
    private UserServiceImpl() {
    }
    public static UserServiceImpl getInstance() {
        return instance;
    }
    @Override
    public BaseResponce add(SignUpDTO signUpDTO) {
        User user = new User.UserBuilder()
                .setPhoneNum(signUpDTO.phoneNumber())
                .setPassword(signUpDTO.password())
                .setName(signUpDTO.name())
                .build();
        if (userRepository.save(user) == -1) {
            return new BaseResponce("This user already exist",400);
        }else {
            return new BaseResponce<>("Succesfully signed up ",200);
        }
    }

    @Override
    public int remove(User user) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public BaseResponce<User> signIn(SignInDTO signInDTO) {
        User user = new User.UserBuilder()
                .setPhoneNum(signInDTO.phoneNumber())
                .setPassword(signInDTO.password())
                .build();
        if (userRepository.getAll().isEmpty()) {
            return new BaseResponce<>("USer not found", 400);
        } else {
            for (User user1 : userRepository.getAll()) {
                if (Objects.equals(user1.getPhoneNum(), user.getPhoneNum())) {
                    return new BaseResponce<>("ok", user1, 200);
                }
            }
            return new BaseResponce<>("User not found", 400);
        }
    }

    @Override
    public ArrayList<User> search(String name) {
        return userRepository.search(name);
    }
}
