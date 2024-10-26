package ru.prokhorov.produck.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * Пользователь.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "username")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Long id;
    String username;
}
