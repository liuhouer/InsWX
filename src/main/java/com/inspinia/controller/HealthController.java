package com.inspinia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspinia.entity.Health;
import com.inspinia.service.HealthService;
import com.inspinia.ulits.BC_Constant;
import com.inspinia.ulits.TimeUtils;
import com.inspinia.ulits.wx.SignUtil;
import com.inspinia.ulits.wx.WXTokenUtil;
import com.inspinia.ulits.wx.model.WeixinOauth2Token;
import com.inspinia.ulits.wx.servlet.MPCoreService;

@Controller
public class HealthController {
	
	
	@Autowired
	public HealthService healthService;
	
	
	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Model model,HttpServletRequest request){
		
		//获取openid
		String openid = getOpenID(request);
		
		if(StringUtils.isNotEmpty(openid)) model.addAttribute("openid",openid);
		
		return "order";
    }
	
	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/orderList")
	public String orderList(Model model,HttpServletRequest request){
		
		List<Health> orderList = healthService.selectAll();
		
		model.addAttribute("orderList",orderList);
		
		return "orderList";
    }

	
	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveOrder")
	@ResponseBody
	public String saveOrder(Model model,HttpServletRequest request){
		
		//获取openid
		String openid = getOpenID(request);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String project = request.getParameter("project");
		String confirm = request.getParameter("confirm");
		if(StringUtils.isNotEmpty(openid)) {
			Health m = new Health();
			
			m.setAddress(address);
			m.setAddtime(TimeUtils.nowTime());
			if (StringUtils.isNotEmpty(confirm))m.setAgreement(Integer.valueOf(confirm));
			
			m.setName(name);
			m.setOpenid(openid);
			
			m.setPhone(phone);
			
			m.setProject(project);
			m.setStatus(1);
			healthService.insert(m);
		}
		
		return "success";
    }


	/**
	 * 获取openid
	 * @param request
	 * @return
	 */
	private String getOpenID(HttpServletRequest request) {
		String openid = "";
		
		//先从session会话获取
		openid = (String) request.getSession().getAttribute("openid");
		
		if(StringUtils.isEmpty(openid)) {
			//调用oauth2获取
			String code = request.getParameter("code");
			System.out.println("code===>"+code);
			if(StringUtils.isNotEmpty(code)) {
				WeixinOauth2Token oauth2AccessToken = WXTokenUtil.getOauth2AccessToken(BC_Constant.weixin_app_id, BC_Constant.weixin_app_secret_id, code);
				if(oauth2AccessToken!=null) {
					openid = oauth2AccessToken.getOpenId();
					request.getSession().setAttribute("openid", openid);
					request.getSession().setMaxInactiveInterval(60 * 60);//一小时失效
				}
			}
		}
		return openid;
	}
	
	
	@RequestMapping(value="/")
	@ResponseBody
	public void check(Model model,HttpServletRequest request, HttpServletResponse response){
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		
		PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && SignUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // 进入post聊天处理
            System.out.println("enter post");
            try {
				print = response.getWriter();
				// 接收消息并返回消息
				// 调用核心服务类接收处理请求
				//处理各种消息和事件
				String respXml = MPCoreService.processRequest(request);
				print.print(respXml);
				print.flush();
				print.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	/**
	 * 确认同意
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/confirm")
	public String confirm(Model model){
		
		return "confirm";
    }
	
	/**
	 * 企业简介
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/introduction")
	public String introduction(Model model){
		return "introduction";
    }
	/**
	 * oauth2重定向域名校验
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/MP_verify_7t0IsitZ5SeZufI9.txt")
	public String oauth2(Model model){
		return "MP_verify_7t0IsitZ5SeZufI9.txt";
    }
	
	
	
}
