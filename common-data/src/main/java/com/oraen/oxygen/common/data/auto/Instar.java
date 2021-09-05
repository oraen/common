package com.oraen.oxygen.common.data.auto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Instar {

    double getNum();

    int getInt();

    String getString();

    Object getObject();

    Map<String, Object> getMap();

    <T> List<T> getList(Class<T> clazz);

    <T> T getEntity(Class<T> clazz);

}




