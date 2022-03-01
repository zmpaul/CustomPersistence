package com.github.zmpaul.mybatis.session;

import com.github.zmpaul.mybatis.builder.xml.XMLConfigBuilder;
import com.github.zmpaul.mybatis.builder.xml.XMLMapperBuilder;
import com.github.zmpaul.mybatis.session.defaults.DefaultSqlSessionFactory;
import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

/**
 * 创建sqlSessionFactory
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 15:20
 */
public class SqlSessionFactoryBuilder {
    private Configuration configuration;
    public SqlSessionFactoryBuilder(){
        this.configuration = new Configuration();
    }

    public SqlSessionFactory build(InputStream stream){

        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(configuration);

        //解析配置⽂件，封装Configuration XMLConfigerBuilder
        Configuration configuration = xmlConfigBuilder.parseConfiguration(stream);

        //2.创建 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =  new DefaultSqlSessionFactory();
        return sqlSessionFactory;
    }
}
