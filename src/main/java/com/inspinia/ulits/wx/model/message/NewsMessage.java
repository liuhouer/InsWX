package com.inspinia.ulits.wx.model.message;

import java.util.List;

/**
 * Desc:图文消息(news)
 * author:zhangyang.z@icloud.com
 * Date:15/12/21
 */

public class NewsMessage extends BaseMessage {
	
	// 图文消息个数，限制为10条以内 
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    private List<Article> Articles;

    // 图文消息标题
    private String Title;

    // 图文消息描述
    private String Description;

    // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String PicUrl;

    // 点击图文消息跳转链接
    private String Url;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

    /**
     * 图文消息XML数据包
     *
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[news]]></MsgType>
     * <ArticleCount>2</ArticleCount>
     * <Articles>
     * <item>
     * <Title><![CDATA[title1]]></Title>
     * <Description><![CDATA[description1]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl>
     * <Url><![CDATA[url]]></Url>
     * </item>
     * <item>
     * <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl>
     * <Url><![CDATA[url]]></Url>
     * </item>
     * </Articles>
     * </xml>
     *
     */

}
