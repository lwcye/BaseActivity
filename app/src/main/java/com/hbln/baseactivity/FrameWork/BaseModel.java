package com.hbln.baseactivity.FrameWork;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * 模型基本类
 * Created by lwc on 2015/12/24.
 */
public class BaseModel {
    public BaseModel() {
    }

    /**
     * 通过json得到模型类
     *
     * @param json         json（String）
     * @param classOfT     （Model类型）
     * @param <T>（Model类型）
     * @return 单个模型
     */
    public static <T extends BaseModel> T getModelByJson(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }

    /**
     * 通过json得到数组模型类
     *
     * @param json              json（String）
     * @param classOfT（Model类型）
     * @param <T>               （Model类型）
     * @param <E>               （List<Model>类型）
     * @return 数组模型类
     */
    public static <T extends BaseModel, E extends List<T>> E getModelListByJson(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, new TypeToken<E>() {
        }.getType());
    }
}

