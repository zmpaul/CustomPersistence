package com.github.zmpaul.persistence.mapper;

import com.github.zmpaul.persistence.domain.User;

import java.util.List;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 14:43
 */
public interface UserMapper {

    List<User> selectList();


}
