package com.wms.serviceimpl.storemanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wms.common.BackMessage;
import com.wms.mapper.storemanagement.OnOrOutStoreMapper;
import com.wms.model.BackOrTakeModel;
import com.wms.service.storemanagement.OnOrOutStoreService;
import com.wms.util.TimeGetNow;

@Service
@SuppressWarnings("all")
public class OnOrOutStoreServiceImpl implements OnOrOutStoreService {

	@Autowired
	private OnOrOutStoreMapper mapper;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式

	public BackMessage onStore(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

		/**
		 * json解析 data{ goods:[{id:'',goods_code:'',goods_num:'',
		 * supply_code:'',user_code:'',time:'',sum_money:'',
		 * single_money:'',state:''}] }
		 * 
		 * id, goods_code ,goods_num, take_code, duty_code, time, take_state,
		 * state, take_state;// 领料状态 0未领 1已领 state;// 进出库状态 0入库 1出库
		 */

		List<BackOrTakeModel> list = null;
		String data = req.getParameter("data");
		JSONObject object = JSON.parseObject(data);
		JSONArray jsonArray = object.getJSONArray("goods");

		/**
		 * 得到BackOrTakeModel集合
		 */
		list = JSON.parseArray(jsonArray.toJSONString(), BackOrTakeModel.class);

		try {
			// List<BackOrTakeModel> models = mapper.selGoods(list);
			mapper.backStore01(list, "");
			mapper.backStore02(list, "");
			return new BackMessage(200, "进料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "进料失败");
		}
	}

	public BackMessage outStore(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

		/**
		 * json解析 data{ goods:[{id:'',goods_code:'',goods_num:'',
		 * supply_code:'',user_code:'',time:'',sum_money:'',
		 * single_money:'',state:''}] }
		 * 
		 * id, goods_code ,goods_num, take_code, duty_code, time, take_state,
		 * state, take_state;// 领料状态 0未领 1已领 state;// 进出库状态 0入库 1出库
		 */

		List<BackOrTakeModel> list = null;
		String data = req.getParameter("data");
		JSONObject object = JSON.parseObject(data);
		JSONArray jsonArray = object.getJSONArray("goods");

		/**
		 * 得到BackOrTakeModel集合
		 */
		list = JSON.parseArray(jsonArray.toJSONString(), BackOrTakeModel.class);

		try {
			// List<BackOrTakeModel> models = mapper.selGoods(list);
			mapper.takeStore01(list, "");
			mapper.takeStore02(list, "");
			return new BackMessage(200, "退料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "退料失败");
		}

	}

	public BackMessage onStore01(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

		String goods_code = (req.getParameter("goods_code") == null ? "" : (req.getParameter("goods_code").trim()));
		String goods_num = (req.getParameter("goods_num") == null ? "" : (req.getParameter("goods_num").trim()));
		String supply_code = (req.getParameter("supply_code") == null ? "" : (req.getParameter("supply_code").trim()));
		String user_code = (req.getParameter("user_code") == null ? "" : (req.getParameter("user_code").trim()));
		String time = TimeGetNow.getTime();//(req.getParameter("time") == null ? "" : (req.getParameter("time").trim()));
		String sum_money = (req.getParameter("sum_money") == null ? "" : (req.getParameter("sum_money").trim()));
		String single_money = (req.getParameter("single_money") == null ? "" : (req.getParameter("single_money").trim()));
		String state = (req.getParameter("state") == null ? "" : (req.getParameter("state").trim()));
		
		List<BackOrTakeModel> list = new ArrayList<BackOrTakeModel>();
		BackOrTakeModel model = new BackOrTakeModel();
		model.setGoods_code(goods_code);
		model.setGoods_num(goods_num);
		model.setSupply_code(supply_code);
		model.setUser_code(user_code);
		model.setTime(time);
		model.setSum_money(sum_money);
		model.setSingle_money(single_money);
		model.setState("0");
		list.add(model);

		List<BackOrTakeModel> models = mapper.takeStore03(list, time);
		
		try {
			if (models.size()==0) {
				mapper.backStore01(list, "");
				mapper.backStore03(list, "");
				return new BackMessage(200, "进料成功");
			}
			mapper.backStore01(list, "");
			mapper.backStore02(list, "");
			return new BackMessage(200, "进料成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1000, "进料失败");
		}
	}

	public BackMessage outStore01(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

		String goods_code = (req.getParameter("goods_code") == null ? "" : (req.getParameter("goods_code").trim()));
		String goods_num = (req.getParameter("goods_num") == null ? "" : (req.getParameter("goods_num").trim()));
		String supply_code = (req.getParameter("supply_code") == null ? "" : (req.getParameter("supply_code").trim()));
		String user_code = (req.getParameter("user_code") == null ? "" : (req.getParameter("user_code").trim()));
		String time = TimeGetNow.getTime();//(req.getParameter("time") == null ? "" : (req.getParameter("time").trim()));
		String sum_money = (req.getParameter("sum_money") == null ? "" : (req.getParameter("sum_money").trim()));
		String single_money = (req.getParameter("single_money") == null ? "" : (req.getParameter("single_money").trim()));
		String state = (req.getParameter("state") == null ? "" : (req.getParameter("state").trim()));
		
		List<BackOrTakeModel> list = new ArrayList<BackOrTakeModel>();
		BackOrTakeModel model = new BackOrTakeModel();
		model.setGoods_code(goods_code);
		model.setGoods_num(goods_num);
		model.setSupply_code(supply_code);
		model.setUser_code(user_code);
		model.setTime(time);
		model.setSum_money(sum_money);
		model.setSingle_money(single_money);
		model.setState("1");
		list.add(model);
		List<BackOrTakeModel> models = mapper.takeStore03(list, time);
		for (int i = 0; i < models.size(); i++) {
			BackOrTakeModel model2 = models.get(i);
			if (Integer.parseInt(model2.getGoods_num()) < Integer.parseInt(model.getGoods_num())) {
				return new BackMessage(1000, "数量不够，出料失败");
			}
		}
		try {
			// List<BackOrTakeModel> models = mapper.selGoods(list);
			mapper.takeStore01(list, "");
			mapper.takeStore02(list, "");
			return new BackMessage(200, "出料成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1000, "出料失败");
		}
	}

	private String getStr(String str, HttpServletRequest req) {

		String newStr = req.getParameter(str);// .trim();
		newStr = (newStr == null) ? "" : newStr;
		return newStr;
	}
}
