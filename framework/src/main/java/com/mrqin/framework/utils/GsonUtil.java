package com.mrqin.framework.utils;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @data on 2018/3/13 11:59
 * @describe:
 */
public class GsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtil() {
    }

    /**
     * 将object对象转成json字符串
     *
     * @param object
     * @return
     */
    public static String GsonToString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 将object对象转gsonString转成泛型bean
     *
     * @param object
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(Object object, Class<T> cls) {
        try {
            T t = null;
            try {
                if (gson != null) {
                    t = gson.fromJson(GsonToString(object), cls);
                    if (t == null) {
                        t = gson.fromJson(object.toString(), cls);
                    }
                }
            } catch (IllegalStateException | JsonSyntaxException exception) {
                exception.printStackTrace();
            }
            if (t == null)
                try {
                    if (gson != null) {
                        t = gson.fromJson(object.toString(), cls);
                    }
                } catch (IllegalStateException | JsonSyntaxException exception) {
                    exception.printStackTrace();
                }
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        try {
            T t = null;
            if (gson != null) {
                t = gson.fromJson(gsonString, cls);
            }
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     *
     * @param object
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(Object object, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(GsonToString(object)).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String json, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(json).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 转成list
     * 解决泛型问题
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }

    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
