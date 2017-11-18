package ru.vetalshev.core;

import java.util.Map;

public interface Model {

    void addAttribute(String key, Object value);

    void addAllAttributes (Map<String, Object> attributes);

    Map<String, Object> asMap();

}