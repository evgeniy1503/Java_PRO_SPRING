package ru.prokhorov.hw1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.prokhorov.hw1.entity.User;
import ru.prokhorov.hw1.repository.UserDAO;

/**
 * Сервис для работы с {@link UserDAO}.
 *
 * @author Evgeniy_Prokhorov
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;


}
