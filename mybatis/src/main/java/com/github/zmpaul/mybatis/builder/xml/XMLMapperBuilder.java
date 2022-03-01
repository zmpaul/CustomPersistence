package com.github.zmpaul.mybatis.builder.xml;

import cn.hutool.core.util.XmlUtil;
import com.github.zmpaul.mybatis.mapping.MappedStatement;
import com.github.zmpaul.mybatis.session.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * 解析xml
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 16:29
 */
public class XMLMapperBuilder {
    private Configuration configuration;
    public XMLMapperBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    public Configuration parse(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        NodeList selectNodeList = XmlUtil.getNodeListByXPath("//mapper/select",document);
        Node root = XmlUtil.getNodeByXPath("//mapper",document);
        NamedNodeMap rootAttributes = root.getAttributes();
        String namespace = rootAttributes.getNamedItem("namespace").getNodeValue();
        for (int i=0;i<selectNodeList.getLength();i++){
            NamedNodeMap nodeMap = selectNodeList.item(i).getAttributes();
            String id = nodeMap.getNamedItem("id").getNodeValue();
            String resultType = nodeMap.getNamedItem("resultType").getNodeValue();
            String parameterType = nodeMap.getNamedItem("parameterType").getNodeValue();

            //返回结果class
            Class<?> resultTypeClass = Class.forName(resultType);
            //参数class
            Class<?> parameterTypeClass = Class.forName(parameterType);
            //sql语句
            String textTrim = selectNodeList.item(i).getTextContent().trim();
            //statementId
            String key = namespace + "." + id;

            //封装 mappedStatement
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParameterType(parameterTypeClass);
            mappedStatement.setResultType(resultTypeClass);
            mappedStatement.setSql(textTrim);

            configuration.getMappedStatementMap().put(key, mappedStatement);
        }
        return configuration;
    }
}
