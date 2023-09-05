import uz.pdp.instagram.controller.MainUi;
import uz.pdp.instagram.controller.UserUi;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.User;

import static uz.pdp.instagram.util.Util.userService;

public class Main {
    public static void main(String[] args) {
defaultData();
        MainUi.runWindow();

    }

    public static void defaultData() {
        User user = new User.UserBuilder().setName("d").setPhoneNum("d").setPassword("d").build();
        SignUpDTO u = new SignUpDTO(user.getName(),user.getPhoneNum(),user.getPassword());
        userService.add(u);

        User user1 = new User.UserBuilder().setName("a").setPhoneNum("a").setPassword("a").build();
        SignUpDTO u1 = new SignUpDTO(user1.getName(),user1.getPhoneNum(),user1.getPassword());
        userService.add(u1);

        User user2 = new User.UserBuilder().setName("b").setPhoneNum("b").setPassword("b").build();
        SignUpDTO u2 = new SignUpDTO(user2.getName(),user2.getPhoneNum(),user2.getPassword());
        userService.add(u2);
    }
}

