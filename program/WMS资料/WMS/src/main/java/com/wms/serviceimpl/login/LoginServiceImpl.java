package com.wms.serviceimpl.login;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.login.LoginMapper;
import com.wms.model.CommonDate;
import com.wms.model.LoginLeftBar;
import com.wms.model.MessageDefined;
import com.wms.model.UserInfo;
import com.wms.service.login.LoginService;
import com.wms.util.GetToken;
import com.wms.util.JWT;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	public BackMessage login(HttpServletRequest req,HttpServletResponse res,MessageDefined defined,
			HttpSession session
			,CommonDate date){
		BackMessage backMessage = null;
		try {
			boolean flag = false;
			String usercode = (req.getParameter("usercode") == null ? "" :(req.getParameter("usercode").trim()));
			String password = (req.getParameter("password") == null ? "" :(req.getParameter("password").trim()));

			/*String code = (req .getParameter("code") == null ? "" :(req.getParameter("code").trim()));


			String servercode = (String)session.getAttribute("code");
			if(!code.equals(servercode)){

				return new BackMessage(1, defined.VERTIFYCODE_ERROR);
			}*/
			if(usercode==""||password==""){
				return new BackMessage(1, defined.LOGIN_USER_NULL);
			}
			UserInfo userInfo = loginMapper.getUser(usercode);
			if (userInfo == null) {
				return new BackMessage(1, defined.LOGIN_USERID_ERROR);

			} else {
				if (!userInfo.getPassword().equals(password)) {
					return new BackMessage(1, defined.LOGIN_PASSWORD_ERROR);

				} else {


					if (!userInfo.getUser_state().trim().equals("0")) {
						return new BackMessage(1, defined.LOGIN_USERID_DISABLED);

					} else {
						String token = JWT.sign(userInfo, 300L* 1000L* 30L);
						//封装成对象返回给客户端
						backMessage = new BackMessage(0, "success");
						backMessage = backMessage.putDataValue("token", token);
						System.out.println(backMessage.getDatas().get("token"));
						return backMessage;


					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1,defined.LOGIN_UNEXPECTED_ERROR);
		}

	}

	public BackMessage goRegister(HttpServletRequest req,HttpServletResponse res,MessageDefined defined){
		try {
			boolean flag = false;
			String usercode = (req.getParameter("usercode") == null ? "" :(req.getParameter("usercode").trim()));
			String username = (req.getParameter("username") == null ? "" :(req.getParameter("username").trim()));
			String password = (req.getParameter("password") == null ? "" :(req.getParameter("password").trim()));
			




			UserInfo userInfo = loginMapper.getUser(usercode);
			if (userInfo != null) {
				//已存在该用户
				return new BackMessage(1, defined.REGISTER_USERID_EXIST);

			} else {
				userInfo = new UserInfo();
				userInfo.setUsername(username);
				userInfo.setUsercode(usercode);
				userInfo.setPassword(password);


				
				flag = loginMapper.addUser(userInfo);
				if(flag == false){
					return new BackMessage(1, defined.REGISTER_ADDUSER_ERROR);
				}else{
					/*userInfo = loginMapper.getUser(usercode);*/
					/*session.setAttribute("loginUser", userInfo);
					session.setAttribute("login_status", true);*/
					//登录成功
					return new BackMessage(0, defined.REG_SUCCESS);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1,defined.REG_UNEXPECTED_ERROR);
		}

	}



	public BackMessage getqueryMenu(HttpServletRequest req,HttpServletResponse res){

		BackMessage backMessage = null;
		//		HttpSession session = req.getSession();
		try {

			UserInfo info = GetToken.TokenValue(req, res);
			if (info!=null) {
				String level  = info.getLevel();
				List<Object> list = loginMapper.getqueryMenu(level); 
				
				backMessage = new BackMessage(0, "success", list.size(), list);
				

			}else {
				backMessage = new BackMessage(1, "get menu Failed");
			}
			return backMessage;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BackMessage(1, "发生异常");
		}

	}

	public BackMessage login(HttpServletRequest req, HttpServletResponse res, MessageDefined defined) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
