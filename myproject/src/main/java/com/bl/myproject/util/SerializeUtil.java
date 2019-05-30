package com.bl.myproject.util;


import java.io.*;

/**
 * @author bl
 * @date 2019/5/29
 */
public class SerializeUtil {

    /**
     * 将对象序列化
     * @param value 对象
     * @return 二进制对象
     */
    public static byte[] serialize(Object value){
        if(value == null){
            return null;
        }
        byte[]  rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            //创建二进制数组字节输出流对象
            bos = new ByteArrayOutputStream();
            //读写对象输出流
            os = new ObjectOutputStream(bos);
            //writeObject（Object obj），将指定的对象写入
            os.writeObject(value);
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        }
        finally {
            try {
                os.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rv;
    }

    /**
     * 反序列化
     * @param byteValue 二进制数组对象
     * @return 对象
     */
    public static Object unSerialize(byte[] byteValue){
        if(byteValue == null){
            return null;
        }
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream in = null;
        try {
            //创建二进制数组字节流对象
            bis = new ByteArrayInputStream(byteValue);
            in = new ObjectInputStream(bis);
            //readObject（），从ObjectInputStream读取对象
            rv = in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return rv;
    }
}
