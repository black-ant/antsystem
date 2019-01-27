package com.dataserver.demo.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/27 20:44
 * @Version 1.0
 **/
public class ObjectUtil {

    /**
     * 根据字段列表排除复制对象中相同字段的值 凡是在字段列表中出现的不进行复制
     *
     * @param sourceObj -资源对象
     * @param clazz -复制的类
     * @param fields -需要copy的字段
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T1, T2> T2 copyDataExclude(T1 sourceObj, Class<T2> clazz, String[] fields) {
        //1. 获取源数据的类
        Class<?> clazz1 = sourceObj.getClass();
        //2. 创建一个目标数据对象
        T2 targetObj = getInstance(clazz);
        //3. 获取两个类字段集合
        Field[] fields1 = clazz1.getDeclaredFields();
        Field[] fields2 = clazz.getDeclaredFields();
        //4. 复制字段
        copyFieldValueExclude(sourceObj, targetObj, fields, fields1, fields2);
        return targetObj;
    }

    /**
     * 复制两个对象中相同字段的值
     *
     * @param sourceObj
     * @param targetObj
     * @param <T1>
     * @param <T2>
     */
    public static <T1, T2> void copyData(T1 sourceObj, T2 targetObj) {
        //1. 获取两个对象的类
        Class<?> clazz1 = sourceObj.getClass();
        Class<?> clazz2 = targetObj.getClass();
        //3. 获取两个类字段集合
        Field[] fields1 = clazz1.getDeclaredFields();
        Field[] fields2 = clazz2.getDeclaredFields();
        //4. 遍历fields1
        for (Field f1 : fields1) {
            //4-1. 遍历fields2
            for (Field f2 : fields2) {
                //4-2. 复制字段
                if (!"serialVersionUID".equals(f1.getName()) && !"serialVersionUID".equals(f2.getName())) {
                    copyFieldValue(sourceObj, targetObj, f1, f2);
                }
            }
        }
    }

    /**
     * 排除字段复制
     *
     * @param sourceObj
     * @param targetObj
     * @param fields
     * @param fields1
     * @param fields2
     * @param <T1>
     * @param <T2>
     */
    private static <T1, T2> void copyFieldValueExclude(T1 sourceObj, T2 targetObj, String[] fields, Field[] fields1, Field[] fields2) {
        for (String fieldName : fields) {
            //4-1. 遍历fields1
            for (Field f1 : fields1) {
                //4-3. 是否匹配这个字段
                if (fieldName.equals(f1.getName())) {
                    //只要包含该字段就跳过
                    continue;
                }
                //4-4. 遍历fields2
                for (Field f2 : fields2) {
                    //4-5. 复制字段
                    copyFieldValue(sourceObj, targetObj, f1, f2);
                }

            }
        }
    }

    /**
     * 复制字段的值
     *
     * @param sourceObj
     * @param targetObj
     * @param field1
     * @param field2
     * @param <T1>
     * @param <T2>
     */
    public static <T1, T2> void copyFieldValue(T1 sourceObj, T2 targetObj, Field field1, Field field2) {
        try {
            //1. 判断两个字段是否名称相同而且类型相同
            if (field1.getName().equals(field2.getName())
                    && equalFieldsType(field1, field2)) {
                //2. 获取源数据字段的值
                field1.setAccessible(true);
                Object value = field1.get(sourceObj);
                //3. 给目标数据字段赋值
                field2.setAccessible(true);
                field2.set(targetObj, value);
                //4. 访问权限还原
                field2.setAccessible(false);
                field1.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个泛型的实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断两个字段的类型是否相同
     *
     * @param field1 复制源
     * @param field2 复制目标
     * @return
     */
    public static boolean equalFieldsType(Field field1, Field field2) {
        String fTypeName1 = field1.getType().getSimpleName();
        String fTypeName2 = field2.getType().getSimpleName();
        //1. 处理基本数据类型和包装类
        Map<String, String> map = new HashMap<String, String>();
        map.put(int.class.getSimpleName(), Integer.class
                .getSimpleName());
        map.put(byte.class.getSimpleName(), Byte.class
                .getSimpleName());
        map.put(short.class.getSimpleName(), Short.class
                .getSimpleName());
        map.put(char.class.getSimpleName(), Character.class
                .getSimpleName());
        map.put(long.class.getSimpleName(), Long.class
                .getSimpleName());
        map.put(float.class.getSimpleName(), Float.class
                .getSimpleName());
        map.put(double.class.getSimpleName(), Double.class
                .getSimpleName());
        map.put(boolean.class.getSimpleName(), Boolean.class
                .getSimpleName());

        /**
         * 在涉及包装类的判断逻辑中，源数据不能是包装类 因为包装类一旦为null，会引发异常
         */
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (key.equals(fTypeName1) && map.get(key).equals(fTypeName2)) {
                return true;
            }
        }
        //2. 名称相同、类型相同
        if (fTypeName1.equals(fTypeName2)) {
            return true;
        }
        return false;
    }

    /**
     * 遍历一个对象，打印数据与值
     *
     * @param obj {Object} 对象
     * @return
     */
    public static void reflect(Object obj) {
        if (obj == null) {
            return;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            fields[j].setAccessible(true);
            // 字段值
            // String type
            try {
                String item = fields[j].getType().getName();
                switch (item) {
                    case "java.lang.Integer":
                        System.out.println(fields[j].getName() + " ========= " + (Integer) fields[j].get(obj));
                        break;
                    case "java.lang.Boolean":
                        System.out.println(fields[j].getName() + " ====== " + (Boolean) fields[j].get(obj));
                        break;
                    case "java.math.BigDecimal":
                        System.out.println(fields[j].getName() + " ==== " + fields[j].get(obj));
                        break;
                    case "double":
                        System.out.println(fields[j].getName() + " == " + (double) fields[j].getDouble(obj));
                        break;
                    case "java.util.Date":
                        System.out.println(fields[j].getName() + " == " + (Date) fields[j].get(obj));
                        break;
                    default:
                        System.out.println(fields[j].getName() + " ----- " + fields[j].get(obj));
                }
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 其他类型。。。
        }
    }
}
