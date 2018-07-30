package com.inspinia.ulits.wx.servlet;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.inspinia.ulits.wx.MessageUtil;
import com.inspinia.ulits.wx.model.message.Image;
import com.inspinia.ulits.wx.model.message.MessageResponse;
import com.inspinia.ulits.wx.model.message.TextMessage;


/**
 * 公众号核心Service类
 *
 * @author ivhhs
 * @date 2014.10.16
 */
public class MPCoreService {

    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return xml
     */
    public static String processRequest( HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	
                respContent = "您的信息我们已经收到，请留下您的手机号码，马上安排咨询顾问与您联系。";
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                }
                // 取消关注
                else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                    String eventKey = requestMap.get("EventKey"); 
                    System.out.println(eventKey);
                    if (eventKey.equals("01_02_content")) {   
                    	
////                    ################### 图片资源 --media_id###################
//                    	"item": [{
//                    		"media_id": "CdsrrutLKu3EIS3F-O5hLMxSvmDGZsvr4CNNCVhF_-4",
//                    		"name": "微博图片.jpg",
//                    		"update_time": 1532343242,
//                    		"url": "http:\/\/mmbiz.qpic.cn\/mmbiz_jpg\/pSIPazIL0hp3hprtZpTqsYgicfZibAsXJQCScJxa6o9VAuN1VCevkOaX0gxPn0qvxEwIiaMLY5cyOYV2UeibuU8UwA\/0?wx_fmt=jpeg"
//                    	}, {
//                    		"media_id": "CdsrrutLKu3EIS3F-O5hLI9IHLuW9XmFiGAnFEDwK9Q",
//                    		"name": "易元康单张-02.png",
//                    		"update_time": 1530868336,
//                    		"url": "http:\/\/mmbiz.qpic.cn\/mmbiz_png\/pSIPazIL0hoAHa6DLapve05R1EWoDDoTZibBhPtvfe8DmqrAA1Trmk15wsMfx7W1lS2zjsVuz34sWLBJ8diaVTLg\/0?wx_fmt=png"
//                    	}, {
//                    		"media_id": "CdsrrutLKu3EIS3F-O5hLGKZb2TFZOXKQHCFOmOcaHc",
//                    		"name": "易元康单张-02.png",
//                    		"update_time": 1530867962,
//                    		"url": "http:\/\/mmbiz.qpic.cn\/mmbiz_png\/pSIPazIL0hoAHa6DLapve05R1EWoDDoT8ePHq0EZyBZj6jGbOCSyIv4N3vuiaa1zKnJldRfexicwFCp9U5OCkiabw\/0?wx_fmt=png"
//                    	}, {
//                    		"media_id": "CdsrrutLKu3EIS3F-O5hLLLu9_bqGc36NPOYQfuwmTY",
//                    		"name": "易元康单张-02.png",
//                    		"update_time": 1530867831,
//                    		"url": "http:\/\/mmbiz.qpic.cn\/mmbiz_png\/pSIPazIL0hoAHa6DLapve05R1EWoDDoTHuF5SB3TIOCJPmBrUklgxkp3u6BiaYrhEK3vZlS6ZE1xq0ukJdHCz4w\/0?wx_fmt=png"
//                    	}, {
//                    		"media_id": "CdsrrutLKu3EIS3F-O5hLJ4CU6-xiEk_HsbB2vvOTKk",
//                    		"name": "易元康单张-02.png",
//                    		"update_time": 1530867767,
//                    		"url": "http:\/\/mmbiz.qpic.cn\/mmbiz_png\/pSIPazIL0hoAHa6DLapve05R1EWoDDoTHuF5SB3TIOCJPmBrUklgxkp3u6BiaYrhEK3vZlS6ZE1xq0ukJdHCz4w\/0?wx_fmt=png"
//                    	}],
//                    	"total_count": 6,
//                    	"item_count": 5
//                    }
                    	Image image = new Image();
                    	image.setMediaId("CdsrrutLKu3EIS3F-O5hLGKZb2TFZOXKQHCFOmOcaHc");
                    	String imageMessage = MessageResponse.getImageMessage(fromUserName, toUserName, image);
                    	System.out.println(imageMessage);
                        return imageMessage;
                    } else if (eventKey.equals("02_introduce")) {  
                        respContent = "您好，欢迎关注广州易元康健康管理咨询有限公司官方微信平台，我是易元康咨询顾问，很高兴为您服务！\n" + 
                        		"服务电话： 020.31602206   \n" + 
                        		"手机号码：186 7583 0099  \n" + 
                        		"温馨提示：文字或语音留言请点击页面左下角“小键盘”切换\n";  
                        
                    }else if (eventKey.equals("01_03_steps")){
                    	Image image = new Image();
                    	image.setMediaId("CdsrrutLKu3EIS3F-O5hLMxSvmDGZsvr4CNNCVhF_-4");
                    	String imageMessage = MessageResponse.getImageMessage(fromUserName, toUserName, image);
                    	System.out.println(imageMessage);
                        return imageMessage;
                    	
                    }
                    
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtil.textMessageToXml(textMessage);
            
            System.out.println("返回xml结构：========================》"+respXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

}
