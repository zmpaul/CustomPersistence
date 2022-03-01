package com.github.zmpaul.mybatis.builder.xml;

import cn.hutool.core.util.XmlUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.zmpaul.mybatis.io.Resources;
import com.github.zmpaul.mybatis.session.Configuration;
import lombok.NoArgsConstructor;
import org.w3c.dom.*;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 15:25
 */
public class XMLConfigBuilder {
    private Configuration configuration;
    public XMLConfigBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    public Configuration parseConfiguration(InputStream inputStream){
        Document document = XmlUtil.readXML(inputStream);
        //解析DataSource
        NodeList propertyDocument = XmlUtil.getNodeListByXPath("//configuration/properties/property",document);
        Properties properties = new Properties();
        for (int i=0;i<propertyDocument.getLength();i++){
            NamedNodeMap namedNodeMap = propertyDocument.item(i).getAttributes();
            properties.setProperty(namedNodeMap.getNamedItem("name").getNodeValue(),namedNodeMap.getNamedItem("value").getNodeValue());
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getProperty("driverClass"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
        //填充DruidDataSource
        configuration.setDataSource(druidDataSource);

        NodeList mapperDocument = XmlUtil.getNodeListByXPath("//configuration/mappers/mapper",document);
        for (int i=0;i<mapperDocument.getLength();i++){
            NamedNodeMap namedNodeMap = mapperDocument.item(i).getAttributes();
            String resource = namedNodeMap.getNamedItem("resource").getNodeValue();
            InputStream mapperResource = Resources.getResources(resource);
        }
        return configuration;
    }

}
