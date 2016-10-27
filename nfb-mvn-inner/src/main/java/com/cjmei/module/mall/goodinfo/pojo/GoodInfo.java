package com.cjmei.module.mall.goodinfo.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class GoodInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *商品ID
    */
    private String goodId;
    /**
    *商品名称
    */
    private String goodName;
    /**
    *商品单价
    */
    private int goodPrice;
    /**
    *商品单位
    */
    private String unit;
    /**
    *商品主图
    */
    private String imageUrl;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *创建者
    */
    private String creator;



    public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getGoodName(){
        return goodName;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }

    public int getGoodPrice(){
        return goodPrice;
    }
    public void setGoodPrice(int goodPrice){
        this.goodPrice = goodPrice;
    }

    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }


}