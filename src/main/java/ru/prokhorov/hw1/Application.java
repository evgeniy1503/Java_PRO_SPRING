package ru.prokhorov.hw1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.prokhorov.hw1.entity.User;
import ru.prokhorov.hw1.service.UserService;

/**
 * Точка входа в приложение.
 *
 * @author Evgeniy_Prokhorov
 */
@ComponentScan
public class Application {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User().setUsername("Evgeniy");
        userService.saveUser(user);
        System.out.println("Запрос на сохранение выполнен: " + user);

        User userById = userService.getUserById(user.getId());
        System.out.println("Получен пользователь: " + userById);

        userById.setUsername("Alex");
        userService.updateUser(userById);
        System.out.println("Пользователь обновлен: " + userById);

        userService.deleteUser(userById.getId());
        System.out.println("Пользователь удален: " + userById);
    }
}
