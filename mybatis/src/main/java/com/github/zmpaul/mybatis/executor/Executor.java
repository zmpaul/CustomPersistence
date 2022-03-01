package com.github.zmpaul.mybatis.executor;

import com.github.zmpaul.mybatis.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 16:08
 */
public interface Executor {
    <E> List<E> query(MappedStatement ms, Object parameter) throws SQLException;
}
