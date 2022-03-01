package com.github.zmpaul.mybatis.session;

import com.github.zmpaul.mybatis.mapping.MappedStatement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 核心配置
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 15:06
 */
public class Configuration {

    /**
     * 数据源
     */
    private DataSource dataSource;

    /**
     *  SQL的节点
     */
    private Map<String, MappedStatement> mappedStatement;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatement() {
        return mappedStatement;
    }

    public void setMappedStatement(Map<String, MappedStatement> mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

}
