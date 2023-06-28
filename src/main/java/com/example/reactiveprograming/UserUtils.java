package com.example.reactiveprograming;

import com.example.reactiveprograming.dto.UserDto;
import com.example.reactiveprograming.model.User;

/**
 * @author Subodh Bhandari on 6/28/2023
 */

public class UserUtils {

    public static User toUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName());
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getFirstName(), user.getLastName());
    }

}
