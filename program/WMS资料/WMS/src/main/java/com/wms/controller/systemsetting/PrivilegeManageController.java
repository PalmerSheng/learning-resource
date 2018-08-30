package com.wms.controller.systemsetting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.model.MessageDefined;
import com.wms.service.systemsetting.PrivilegeManageService;

@Controller
@RequestMapping("PrivilegeManageController")
public class PrivilegeManageController {
	@Autowired
	private PrivilegeManageService privilegeManageService;

	/**
	 * 加载权限
	 * @param req level
	 * @return
	 */
	@RequestMapping("getPrivilege")
	@ResponseBody
	public BackMessage getPrivilege(HttpServletRequest req,HttpServletResponse res){
		MessageDefined defined = new MessageDefined();
		try {
			List<Object> list = privilegeManageService.getPrivilege(req);
			return new BackMessage(0, "success",list.size(),list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BackMessage(1, defined.PRAGRAM_EXCEPTION);
		}
	}


	/**
	 * 保存权限
	 * @param level
	 * @param treelevels
	 * @return
	 */
	@RequestMapping("updateUserPrivilege")
	@ResponseBody
	public BackMessage UpdateUserPrivilege(
			@Param("level")String level,
			@Param("treelevels")String treelevels) {

		BackMessage backMessage = null;		
		int num=0;
		System.out.println("controller level:"+level);
		System.out.println("treelevels"+treelevels);
		try {
			num=privilegeManageService.UpdateUserPrivilege(level,treelevels);
			System.out.println("controller num:"+num);
			backMessage=new BackMessage(0,"成功添加了"+num+"条权限");
			return backMessage;
		} catch (Exception e) {
			e.printStackTrace();
			backMessage=new BackMessage(1,"failed");
			return backMessage;
		}
		
	}

}
