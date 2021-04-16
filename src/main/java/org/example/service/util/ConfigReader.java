package org.example.service.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 读取config.xml
 */
public class ConfigReader {

    public static String getClassName() throws ClassNotFoundException {
        InputStream in = Class.forName("org.example.service.util.ConfigReader").getResourceAsStream("/config.xml");
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(in);//把document和config.xml做一个映射
            //得到某个节点
            Element element = (Element) document.selectObject("/files/file");
            return element.getStringValue();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "";
    }
}