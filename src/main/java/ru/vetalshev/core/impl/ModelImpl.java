package ru.vetalshev.core.impl;

import ru.vetalshev.core.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModelImpl implements Model {

    private Map<String, Object> model = new HashMap<>();

    @Override
    public void addAttribute(String key, Object value) {
        model.put(key, value);
    }

    public Object getAttribute(String key) {
        return model.get(key);
    }

    @Override
    public void addAllAttributes(Map<String, Object> attributes) {
        model.putAll(attributes);
    }

    @Override
    public Map<String, Object> asMap() {
        return model; // TODO: clone the Map
    }

}
