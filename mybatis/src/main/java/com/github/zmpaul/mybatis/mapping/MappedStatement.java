package com.github.zmpaul.mybatis.mapping;

/**
 * MappedStatement对象对应一个mapper.xml中的一个SQL节点
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 15:10
 */
public class MappedStatement {
    //id
    private String id;
    //sql语句
    private String sql;
    //输⼊参数
    private Class<?> parameterType;
    //输出参数
    private Class<?> resultType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class<?> getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class<?> parameterType) {
        this.parameterType = parameterType;
    }

    public Class<?> getResultType() {
        return resultType;
    }

    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }
}
