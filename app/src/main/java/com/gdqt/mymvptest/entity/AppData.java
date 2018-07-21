package com.gdqt.mymvptest.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/10/10.
 */
public class AppData<T> implements Serializable {

    private List<T> list;

    private String total;



    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "list:"+list+",total:"+total;
    }
}

