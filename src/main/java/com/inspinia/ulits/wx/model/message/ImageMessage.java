package com.inspinia.ulits.wx.model.message;

import java.io.Serializable;


/**
 * Desc:图片消息(image)
 * author:zhangyang.z@icloud.com
 * Date:15/12/21
 */

public class ImageMessage extends BaseMessage implements Serializable{

    private static final long serialVersionUID = 4748848530096622403L;
    
 // 图片
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }


    /**
     * 图片消息XML数据包
     *
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[image]]></MsgType>
     * <Image>
     * <MediaId><![CDATA[media_id]]></MediaId>
     * </Image>
     * </xml>
     *
     */

}
