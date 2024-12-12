package com.doctorya.Demo.infraestructure.wrapper;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Wrapper<T> {
    @JsonIgnore // Ignoramos esta propiedad directamente al serializar
    private final String key;
    @JsonIgnore
    private final List<T> items;

    public Wrapper(String key, List<T> items) {
        this.key = key;
        this.items = items;
    }

    @JsonAnyGetter //gregar dinámicamente el contenido del mapa
    public Map<String, List<T>> getDynamicProperties() {
        Map<String, List<T>> map = new HashMap<>();
        map.put(key, items);
        return map;
    }
}
