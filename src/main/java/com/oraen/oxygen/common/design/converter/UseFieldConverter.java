//package com.oraen.oxygen.common.design.converter;
//
//import com.oraen.oxygen.common.util.ReflectUtil;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//
//public abstract class UseFieldConverter<T, S> implements BatchConverter<T, S> {
//    Class<? extends Annotation> attention;
//
//    public UseFieldConverter(Class<? extends Annotation> attention){
//        this.attention = attention;
//    }
//
//
//
//    @Override
//    public S from(T t){
//        for(Field f : ReflectUtil.getAllFields(e).values()){
//            if(f.isAnnotationPresent(attention) || attention == Annotation.class){
//                dispose(e, f);
//            }
//        }
//    }
//
//    public abstract S analyseFrom(T t, Field field, S s);
//}
