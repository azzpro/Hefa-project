package com.azz.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.Assert;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author 黄雄星（13077862552） 2013-10-11 下午3:38:27
 */
public final class XmlUtils {

    private XmlUtils() {

    }

    /**
     * 
     * <p>
     * 对象转换成xml
     * </p>
     * 
     * @param c
     * @return
     * @throws Exception
     * @author 黄雄星（13077862552） 2014-3-13 下午7:26:22
     */
    public static <T> String objectToXml(Class<T> c, T obj) throws JAXBException {
        return objectToXml(c, obj, "UTF-8");
    }

    /**
     * 
     * <p>
     * 对象转换成xml
     * </p>
     * 
     * @param c
     * @param isOut
     * @param charset
     * @param isHead
     * @return
     * @throws Exception
     * @author 黄雄星（13077862552） 2014-3-13 下午7:26:39
     * @throws JAXBException
     */
    public static <T> String objectToXml(Class<T> c, T obj, String charset) throws JAXBException {
        Assert.notNull(obj, "对象转换成xml,转换对象不能为空obj:" + obj);
        StringWriter stringwriter = new StringWriter();
        JAXBContext jaxbcontext = JAXBContext.newInstance(c);
        Marshaller marshaller = jaxbcontext.createMarshaller();
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";

        }
        marshaller.setProperty(Marshaller.JAXB_ENCODING, charset);
        marshaller.marshal(obj, stringwriter);
        return stringwriter.toString();
    }

    /**
     * 
     * <p>
     * xml转换成对象
     * </p>
     * 
     * @param xmlStr
     * @param c
     * @return
     * @throws Exception
     * @author 黄雄星（13077862552） 2014-3-13 下午7:26:45
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(String xmlStr, Class<T> c) throws JAXBException {
        Assert.notNull(xmlStr, "xml转换成对象,xmlStr不能为空");
        StringReader stringreader = new StringReader(xmlStr);
        JAXBContext jaxbcontext = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(stringreader);
    }

    /**
     * 
     * <p>
     * xml装换为map
     * </p>
     * 
     * @param xmlStr
     * @param map
     * @return
     * @throws DocumentException
     * @author 朱建谱（15626573212） 2015-9-22 上午11:50:26
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> xmlToMap(String xmlStr, Map<String, String> map)
            throws DocumentException {
        map = map == null ? new HashMap<String, String>() : map;
        Document doc = DocumentHelper.parseText(xmlStr);
        Element rootElement = doc.getRootElement();
        List<Element> list = rootElement.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }
}
