package com.xizi.common.utils;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import cn.hutool.core.util.StrUtil;

/**
 * lambda 工具类
 */
public class LambdaUtils {
    public interface SFun<T, R> extends Function<T, R>, Serializable { }

    public static <T, R> String getFieldName(SFun<T, R> fieldGetter) {
        String fieldName;

        try {
            Method method = fieldGetter.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            String getterName = ((SerializedLambda) method.invoke(fieldGetter)).getImplMethodName();
            if (getterName.startsWith("get")) {
                fieldName = getterName.substring(3);
            } else if (getterName.startsWith("is")) {
                fieldName = getterName.substring(2);
            } else {
                throw new IllegalArgumentException("attrGetter must be a getter method!");
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return StrUtil.lowerFirst(fieldName);
    }
}
