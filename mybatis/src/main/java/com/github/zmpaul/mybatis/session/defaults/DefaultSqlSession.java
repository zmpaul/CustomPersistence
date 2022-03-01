package com.github.zmpaul.mybatis.session.defaults;

import com.github.zmpaul.mybatis.executor.BaseExecutor;
import com.github.zmpaul.mybatis.executor.Executor;
import com.github.zmpaul.mybatis.mapping.MappedStatement;
import com.github.zmpaul.mybatis.session.Configuration;
import com.github.zmpaul.mybatis.session.SqlSession;

import java.util.List;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 14:37
 */
public class DefaultSqlSession implements SqlSession {
    private final Configuration configuration;
    //private final Executor executor;

    public DefaultSqlSession(Configuration configuration){
        this.configuration = configuration;
        //处理器对象
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement) {
        MappedStatement ms = configuration.getMappedStatement().get(statement);
        return null;
    }
}
