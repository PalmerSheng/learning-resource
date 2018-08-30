package com.sf.controller;




import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sf.common.SystemControllerLog;
import com.sf.model.UserInfo;
import com.sf.service.LogService;
import com.sf.service.UserService;
import com.sf.util.CommonDate;
import com.sf.util.CusAccessObjectUtil;
import com.sf.util.LogUtil;
import com.sf.util.NetUtil;
import com.sf.util.WordDefined;

/**
 * 
 * @author : sf
 * @time   : 2018年7月31日  下午4:45:40 
 * @TODO   :登录 注册与注销
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	
	/*@Autowired
	private LoginService loginService;*/
	
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	/**
	 * 登录判断
	 * @param userid
	 * @param password
	 * @param session
	 * @param attributes
	 * @param defined
	 * @param date
	 * @param logUtil
	 * @param netUtil
	 * @param request
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/goIndex", method = RequestMethod.POST)
	public String login(String userid, String password,String code, HttpSession session, RedirectAttributes attributes,
			WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request) throws UnknownHostException  {
		
		if(userid==null||userid==""){
			attributes.addFlashAttribute("error", defined.LOGIN_USERID_EMPTY);
			return "redirect:/user/login";
		}
		if(password==null||password==""){
			attributes.addFlashAttribute("error", defined.LOGIN_PASSWORD_EMPTY);
			return "redirect:/user/login";
		}
		if(code==null||code==""){
			attributes.addFlashAttribute("error", defined.LOGIN_CODE_EMPTY);
			return "redirect:/user/login";
		}
		
		String vertifycode = (String)session.getAttribute("vertifycode");
		if(!vertifycode.equals(code.toLowerCase())){
			attributes.addFlashAttribute("error", defined.LOGIN_CODE_INCORRECT);
			return "redirect:/user/login";
		}
		UserInfo userInfo = userService.selectUserByUserid(userid);

		if (userInfo == null) {
			attributes.addFlashAttribute("error", defined.LOGIN_USERID_ERROR);
			return "redirect:/user/login";
		} else {
			if (!userInfo.getPassword().equals(password)) {
				attributes.addFlashAttribute("error", defined.LOGIN_PASSWORD_ERROR);
				return "redirect:/user/login";
			} else {
				
				if (!userInfo.getStatus().equals("0")) {
					attributes.addFlashAttribute("error", defined.LOGIN_USERID_DISABLED);
					return "redirect:/user/login";
				} else {
					String ip=CusAccessObjectUtil.getIpAddress(request);
					if("0:0:0:0:0:0:0:1".equals(ip)){
						//这个ip代表为本机的ip
						InetAddress addr = InetAddress.getLocalHost();
						ip = addr.getHostAddress().toString(); 
					}
					logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_DETAIL_USER_LOGIN, ip));
					session.setAttribute("userid", userid);
					session.setAttribute("loginuser", userInfo);
					session.setAttribute("login_status", true);
					userInfo.setLasttime(date.getTime24());
					userService.update(userInfo);
					attributes.addFlashAttribute("message", defined.LOGIN_SUCCESS);
					return "redirect:/chat";
				}
			}
		}
	}
	
	@RequestMapping(value = "/logout")
	@SystemControllerLog("注销")
	public String logout(HttpSession session, RedirectAttributes attributes, WordDefined defined) {
		session.removeAttribute("userid");
		session.removeAttribute("login_status");
//		attributes.addFlashAttribute("message", defined.LOGOUT_SUCCESS);
		return "redirect:/user/login";
	}
	
	@RequestMapping("/login")
	public String logIn(){
		return "login";
		
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
		
	}
	/**
	 * 注册
	 * @param userid
	 * @param password
	 * @param checkPassword
	 * @param nickname
	 * @param session
	 * @param attributes
	 * @param defined
	 * @param date
	 * @param logUtil
	 * @param netUtil
	 * @param request
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value="/goRegister",method = RequestMethod.POST)
	public String addUser(String userid, String password, String checkPassword, String nickname, HttpSession session, RedirectAttributes attributes,
			WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request) throws UnknownHostException {
		UserInfo user;
		
		if(userid==null||userid==""){
			attributes.addFlashAttribute("error", defined.REG_USERID_EMPTY);
			return "redirect:/user/register";
		}
		if(password==null||password==""){
			attributes.addFlashAttribute("error", defined.REG_PASSWORD_EMPTY);
			return "redirect:/user/register";
		}
		if(checkPassword==null||checkPassword==""){
			attributes.addFlashAttribute("error", defined.REG_CHECKPASSWORD_EMPTY);
			return "redirect:/user/register";
		}
		if(nickname==null||nickname==""){
			attributes.addFlashAttribute("error", defined.REG_NICKNAME_EMPTY);
			return "redirect:/user/register";
		}
		
		
		
		user= userService.selectUserByUserid(userid);
		
		if (user != null) {
			attributes.addFlashAttribute("error", defined.REG_USERID_ERROR);
			return "redirect:/user/register";
		} else {	
			user = new UserInfo();
			if (password.equals(checkPassword)) {
				user.setUserid(userid);
				user.setPassword(password);
				user.setNickname(nickname);
				user.setStarttime(date.getTime24());
				userService.insert(user);
				String ip=CusAccessObjectUtil.getIpAddress(request);
				if("0:0:0:0:0:0:0:1".equals(ip)){
					//这个ip代表为本机的ip
					InetAddress addr = InetAddress.getLocalHost();
					ip = addr.getHostAddress().toString(); 
				}
				logService.insert(logUtil.setLog(userid, date.getTime24(),  defined.LOG_DETAIL_USER_REG,ip));
				session.setAttribute("userid", userid);
				session.setAttribute("loginuser", user);
				session.setAttribute("login_status", true);
				user = userService.selectUserByUserid(userid);
				user.setLasttime(date.getTime24());
				userService.update(user);
				attributes.addFlashAttribute("message", defined.LOGIN_SUCCESS);
				return "redirect:/chat";
			} else {
				attributes.addFlashAttribute("error", defined.REG_ADDUSER_ERROR);
				return "redirect:/user/register";

			}
		}
	}
	
	
}
