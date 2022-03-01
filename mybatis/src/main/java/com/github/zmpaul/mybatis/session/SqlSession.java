package com.github.zmpaul.mybatis.session;

import java.util.List;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 14:34
 */
public interface SqlSession {

   <T> T selectOne(String statement);

   <E> List<E> selectList(String statement);


}
