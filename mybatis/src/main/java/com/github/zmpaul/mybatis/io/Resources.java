package com.github.zmpaul.mybatis.io;

import java.io.InputStream;

/**
 * 读取Xml
 * @author zm
 * @version 1.0
 * @description: TODO
 * @date 2022/2/28 15:03
 */
public class Resources {
    public static InputStream getResources(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
