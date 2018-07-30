package com.gdqt.mymvptest.entity;

import java.util.Map;

public class RealDataDetailEvent {
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    private Map<String,Object>map;
    public RealDataDetailEvent(Map<String,Object> map)
    {
        this.map=map;
    }
}
