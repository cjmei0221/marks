package com.marks.module.inner.supermarket.smgoodinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class SmGoodInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *商品ID
    *
    */
    private String goodId;
    /**
    *条形码
    *
    */
    private String barCode;
    /**
    *商品名称
    *
    */
    private String goodName;
    /**
    *商品价格
    *
    */
    private String goodPrice;
    /**
    *图片路径
    *
    */
    private String imgUrl;
    /**
    *上架状态
    *0：未上架，1：上架，2，下架
    */
    private int onsale;
    /**
    *创建时间
    *
    */
    private Date createtime;
    /**
    *更新时间
    *
    */
    private Date updatetime;
    /**
    *创建者
    *
    */
    private String creator;
    /**
    *最后更新者
    *
    */
    private String updator;
    /**
    *超市ID
    *
    */
    private String smId;



    public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getBarCode(){
        return barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    public String getGoodName(){
        return goodName;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }

    public String getGoodPrice(){
        return goodPrice;
    }
    public void setGoodPrice(String goodPrice){
        this.goodPrice = goodPrice;
    }

    public String getImgUrl(){
        return imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public int getOnsale(){
        return onsale;
    }
    public void setOnsale(int onsale){
        this.onsale = onsale;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getUpdator(){
        return updator;
    }
    public void setUpdator(String updator){
        this.updator = updator;
    }

    public String getSmId(){
        return smId;
    }
    public void setSmId(String smId){
        this.smId = smId;
    }


	public String toLog(){
		return " - goodId:" +String.valueOf(goodId)+" - barCode:" +String.valueOf(barCode)+" - goodName:" +String.valueOf(goodName)+" - goodPrice:" +String.valueOf(goodPrice)+" - imgUrl:" +String.valueOf(imgUrl)+" - onsale:" +String.valueOf(onsale)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - creator:" +String.valueOf(creator)+" - updator:" +String.valueOf(updator)+" - smId:" +String.valueOf(smId);
	}
}