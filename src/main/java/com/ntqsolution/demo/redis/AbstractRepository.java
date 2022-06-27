package com.ntqsolution.demo.redis;


import com.ntqsolution.demo.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> extends BaseRedis {

    protected abstract AbstractEntity convertToEntity(String string);

    protected abstract String convertToDatabaseObject(T entity);

    public void insert(String key, String field, T entity) {
        String databaseObj = convertToDatabaseObject(entity);
        set(key, field, databaseObj);
    }

    public AbstractEntity getEntityById(String key, String field) {
        String entity = get(key, field);
        return convertToEntity(entity);
    }

    public List<AbstractEntity> getEntities(String key) {
        Map<String, String> entities = getAll(key);
        List<AbstractEntity> entitiesList = new ArrayList<>();
        for (String keys : entities.keySet()) {
            entitiesList.add(convertToEntity(entities.get(keys)));
        }
        return entitiesList;
    }

    public void deleteEntity(String key, String field) {
        delete(key, field);
    }
}
