package com.wms.serviceimpl.assist;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wms.common.BackMessage;
import com.wms.mapper.assist.StoreKeeperMapper;
import com.wms.model.UserInfoModel;
import com.wms.service.assist.StoreKeeperService;

@Service
public class StoreKeeperImpl implements StoreKeeperService {
	
	
	@Autowired
	private  StoreKeeperMapper mapper;
	//将list<?>变成<list<object>格式
	static public <E> List<Object> toObject(List<E> list){
		List<Object> objlist = new ArrayList<Object>();
		for(Object e : list){
			Object obj = (Object)e;
			objlist.add(obj);
		}
		return objlist;
	}
    //修改管理员信息表
	public BackMessage UpdateStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		String depart=(req.getParameter("depart")==null?"":
			req.getParameter("depart").trim());
		String group=(req.getParameter("group")==null?"":
			req.getParameter("group").trim());
		String usercode=(req.getParameter("usercode")==null?"":
			req.getParameter("usercode").trim());
		String unit_code=(req.getParameter("unit_code")==null?"":
			req.getParameter("unit_code").trim());
		String username=(req.getParameter("username")==null?"":
			req.getParameter("username").trim());
		String level=(req.getParameter("level")==null?"":
			req.getParameter("level").trim());
		String tel=(req.getParameter("tel")==null?"":
			req.getParameter("tel").trim());
		String password=(req.getParameter("password")==null?"":
			req.getParameter("password").trim());
		
System.out.println("heloo");
		try {
			int flag =0;
			flag = mapper.UpdateStoreKeeperInfo(depart, group, username, password,usercode, unit_code, level, tel);
			System.out.println("flag:"+flag);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			//return new BackMessage(1001, "修改信息出错", -1, null);
		}
		return new BackMessage(0, "修改信息成功", -1, null);
		
	}
    //新增管理员信息表
	public BackMessage InsertStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		
	
		
		String depart=(req.getParameter("depart")==null?"":
			req.getParameter("depart").trim());
		String group=(req.getParameter("group")==null?"":
			req.getParameter("group").trim());
		
		String id=(req.getParameter("id")==null?"":
			req.getParameter("id").trim());
		String usercode=(req.getParameter("usercode")==null?"":
			req.getParameter("usercode").trim());
		String unit_code=(req.getParameter("unit_code")==null?"":
			req.getParameter("unit_code").trim());
		String username=(req.getParameter("username")==null?"":
			req.getParameter("username").trim());
		String level=(req.getParameter("level")==null?"":
			req.getParameter("level").trim());
		String tel=(req.getParameter("tel")==null?"":
			req.getParameter("tel").trim());
		String password=(req.getParameter("password")==null?"":
			req.getParameter("password").trim());
		
		try {
			mapper.InsertStoreKeeperInfo(depart, group, id,username,
					usercode,unit_code,level,tel,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			//return new BackMessage(1001, "修改信息出错", -1, null);
		}
		return new BackMessage(0, "新增信息成功", -1, null);
		
	}

	
  //删除管理员信息表
	public BackMessage DeleteStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		String Arrays=req.getParameter("data").trim();
		BackMessage backMessage = new BackMessage(0, "success");
		//List<RejectTreatmentInfo> list=new ArrayList<RejectTreatmentInfo>();
		try {
			Arrays=new String(Arrays.getBytes(),"UTF-8");
		//进行解决乱码
		JSONObject ArraysJson=JSON.parseObject(Arrays);//将字符串转化为JSON对象
		JSONArray  ArraysList=JSON.parseArray(ArraysJson.getString("data"));//转化为JSON数组
		List<UserInfoModel> deleteList = JSON.parseArray(ArraysList.toJSONString(),UserInfoModel.class);
		//将json格式对象改成list对象
		//JSONObject dataAllJson=JSON.parseObject(ArraysList.getString(i));
		String username = (req.getParameter("username") == null ? "" :(req.getParameter("username").trim()));
		String usercode = (req.getParameter("usercode") == null ? "" :(req.getParameter("usercode").trim()));
		String pan_month = (req.getParameter("unit_code") == null ? "" :(req.getParameter("unit_code").trim()));
		String tel = (req.getParameter("tel") == null ? "" :(req.getParameter("tel").trim()));
		
		for(int i=0;i<deleteList.size();i++)
		{
			// 遍历 jsonarray 数组，把每一个对象转成 json 对象  
			UserInfoModel job = deleteList.get(i);
			mapper.DeleteStoreKeeperInfo(job);
			//将json格式对象改成list对象
			}
		//注释修改
			//backMessage = new BackMessage(0, "success");
			//rejecttreatmentMapper.DeleteInfo(deleteList);
	
		} catch (UnsupportedEncodingException e) {
			backMessage = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return backMessage;
	}
	
	//条件查询
	public BackMessage StoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		String username = (req.getParameter("username") == null ? "" :(req.getParameter("username").trim()));
		String usercode = (req.getParameter("usercode") == null ? "" :(req.getParameter("usercode").trim()));
		BackMessage backMessage=null;
		List<UserInfoModel> list=mapper.StoreKeeperInfo(username, usercode);
		List<Object> objList = toObject(list);
			
		backMessage=new BackMessage(0, "ok", objList.size(), objList);
		return backMessage;
			
	}
	
	


}
