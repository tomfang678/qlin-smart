package com.qlin.smart.common.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * 作者：tomfng
 * 日期：2017-04-06
 * 描述：xml转string,string转xml对象公共类
 */
public class JAXBUtil<T> {

    public static <T> T cast(Object o) throws Exception {
        if (o != null) {
            return (T) o;
        }
        return null;
    }

    private JAXBUtil() {

    }

    private static final JAXBUtil instance = new JAXBUtil();

    public static JAXBUtil getInstance() {
        return instance;
    }

    /**
     * 将xml文件流 转为对象
     */
    public T xmlToObject(Class<T> clazz, InputStream is) throws Exception {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller un = context.createUnmarshaller();
        return cast(un.unmarshal(is));
    }

    /**
     * 将xml字符串 转为对象
     */
    public T xmlToObject(Class<T> clazz, String str) {

        T t = null;
        InputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            t = xmlToObject(clazz, byteArrayInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != byteArrayInputStream) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;

    }

    /**
     * 将xml文件 转为对象
     */
    public T xmlToObject(Class<T> clazz, File file) throws Exception {
        return xmlToObject(clazz, new FileInputStream(file));
    }

    /**
     * 将对象转为xml格式
     */
    public void objectToXml(Object element, OutputStream os) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(element.getClass());
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化
        String coding = System.getProperty("file.encoding");
        m.setProperty(Marshaller.JAXB_ENCODING, coding);
        // 去掉生成xml的默认报文头
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.marshal(element, os);
    }

    /**
     * 将对象转为xml格式字符串
     */
    public String objectToXml(Object element) {
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            objectToXml(element, outputStream);
            return outputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 将对象转为xml格式并写入文件
     */
    public void objectToXml(Object element, File output) throws FileNotFoundException, JAXBException {
        objectToXml(element, new FileOutputStream(output));
    }
}
