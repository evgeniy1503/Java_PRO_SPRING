package ru.prokhorov.hw1.repository;

import ru.prokhorov.hw1.entity.User;

import java.util.Optional;

/**
 * ����������� ��� ���������� CRUD �������� � ��������� {@link User}.
 *
 * @author Evgeniy_Prokhorov
 */
public interface UserDAO {

    /**
     * ���������� ������������ � ���� ������
     *
     * @param user ������������
     */
    void createUser(User user);

    /**
     * ��������� ������������ �� ��������������
     *
     * @param id �������������
     * @return ������������
     */
    Optional<User> findUserById(Long id);

    /**
     * ���������� ������ �� ������������
     *
     * @param user ������������
     */
    void updateUser(User user);

    /**
     * �������� ������������ �� ��������������
     *
     * @param id �������������
     */
    void deleteUserById(Long id);
}
