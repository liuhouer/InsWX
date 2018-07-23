package com.inspinia.ulits.wx.model.message;

import java.io.Serializable;

/**
 * Desc:文本消息(text)
 * author:zhangyang.z@icloud.com
 * Date:15/12/21
 */

public class TextMessage extends BaseMessage implements Serializable{

    private static final long serialVersionUID = 6927068033720909436L;

    // 文本消息内容
    private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

    /**
     * 回复文本消息XML数据包
     *
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[text]]></MsgType>
     * <Content><![CDATA[你好]]></Content>
     * </xml>
     *
     */

}
