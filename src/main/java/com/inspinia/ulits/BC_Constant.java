package com.inspinia.ulits;

import java.util.HashMap;
import java.util.Map;

public class BC_Constant {

    public static final String Domain = "northpark.cn";
    
    public static String WX_url_menu_create = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static String WX_url_get_access_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static String WX_url_get_media = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    public static String WX_url_get_ticket_jsapi = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    public static String WX_url_base_shouquan_page = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APP_ID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=1#wechat_redirect";

    public static String WX_url_oauth2 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APP_ID&secret=APP_SECRET&code=CODE&grant_type=authorization_code";

    public static String WX_url_getUser = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

//    public static final String weixin_hosts = "http://m.lvzheng.com";//"http://www.lvzheng.com";
    /**
     * wx host uri
     */
    public static final String weixin_hosts = "http://inswx.heartill.com/";//"http://www.lvzheng.com";

    public static final String WX_TOKEN = "liuhouer";//元健康liuhouer //"his8Zzjzweizhan1025";
    public static final String bd_prefix = "DHBD";
    public static final String weixin_app_id = "wxa6cf759d5fb6a01b";
    //1cdebb9f8f252f36e6a1ac05287ed7a8  wxa6cf759d5fb6a01b     ：元健康
    public static final String weixin_app_secret_id = "1cdebb9f8f252f36e6a1ac05287ed7a8";//"d406ed53dc1d4984323eba33a7f18571";//"07a6dd9789e28772f6de32a2ec057fc0";//
    public static final String weixin_app_name = "";//"gh_f5c1ef705fad";//"gh_944897e71947";//
    public static final String coupon_module_id = "";  //"20ZZj0K2uaIYaWD0vA7dMFkacME804FkWlYYiorsyPE"
    
//    URL
//    http://npwx.ngrok.xiaomiqiu.cn
//    必须以http://或https://开头，分别支持80端口和443端口。
//    Token
//    liuhouer
//    必须为英文或数字，长度为3-32字符。
//    什么是Token？
//
//    EncodingAESKey
//    wx5Ul0TchUKHExobxN4wnixcM6Legnb0o2W7q8omNKn
//    43 | 43 随机生成
    

    public static Map<Integer, Long> scend_id_map = new HashMap<Integer, Long>();

    
    /**
     * 是否启用
     */
    public static enum Enabled {
        ENABLED("是", 1), DISENABLED("否", 0);

        private final String key;
        private final int value;

        private Enabled(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public static String getKey(int value) {
            for (Pubilc c : Pubilc.values()) {
                if (c.getValue() == value) {
                    return c.key;
                }
            }
            return null;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 公共状态
     */
    public static enum Pubilc {
        ENABLED("启用", 1), DISABLE("禁用", 0);

        private final String key;
        private final int value;

        private Pubilc(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public static String getKey(int value) {
            for (Pubilc c : Pubilc.values()) {
                if (c.getValue() == value) {
                    return c.key;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }
    }
    
    

}
