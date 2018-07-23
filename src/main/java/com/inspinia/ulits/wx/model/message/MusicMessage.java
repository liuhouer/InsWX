package com.inspinia.ulits.wx.model.message;

/**
 * Desc:音乐消息(music)
 * author:zhangyang.z@icloud.com
 * Date:15/12/21
 */

public class MusicMessage extends BaseMessage {
	
	// 音乐标题
    private String Title;

    // 音乐描述
    private String Description;

    // 音乐链接
    private String MusicURL;

    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;

    // 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
    private Integer ThumbMediaId;

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

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public Integer getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(Integer thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

    /**
     * 音乐消息XML数据包
     *
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[music]]></MsgType>
     * <Music>
     * <Title><![CDATA[TITLE]]></Title>
     * <Description><![CDATA[DESCRIPTION]]></Description>
     * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     * </Music>
     * </xml>
     *
     */

}
