package com.github.zmpaul.mybatis.executor;

import com.github.zmpaul.mybatis.mapping.MappedStatement;
import com.github.zmpaul.mybatis.session.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 18:45
 */
public class BaseExecutor implements Executor{

    protected Configuration configuration;
    public BaseExecutor(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter) throws SQLException {
        Connection connection = configuration.getDataSource().getConnection();

        return null;
    }
}
