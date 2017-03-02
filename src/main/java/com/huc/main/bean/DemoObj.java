package com.huc.main.bean;

/**
 * Created by huc on 2017/2/28.
 */
public class DemoObj {
    private Long id;
    private String name;
    public DemoObj(){//jackjson对对象和json做转换时一定需要此空构造
        super();
    }
    public DemoObj(Long id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
