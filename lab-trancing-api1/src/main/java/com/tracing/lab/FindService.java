package com.tracing.lab;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"unchecked", "rawtypes"})
public interface FindService<T extends RequestParams<?>, C extends GenericParams<?>> {

    String getTipo();
    String getModelo();
    Optional<GetResult<?>> getById(String model, String tipo, String id);
    SearchResult filter(String model, String tipo, T params);
    T params(Map<String, List<String>> params);
    SearchResult filter(String model, String tipo, C params);

    default public C buildParam(Map<String, Object> o) {
        try {
            Type genericInterface = getClass().getGenericInterfaces()[0];
            ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
            Type typeOfC = parameterizedType.getActualTypeArguments()[1];
            return ((Class<C>) typeOfC).getConstructor(Map.class).newInstance(o);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
