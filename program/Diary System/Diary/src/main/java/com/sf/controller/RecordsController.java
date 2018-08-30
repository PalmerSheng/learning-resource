package com.sf.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sf.common.SystemControllerLog;
import com.sf.model.Records;
import com.sf.service.RecordsService;
import com.sf.util.CommonDate;
import com.sf.util.WordDefined;

/**
 * 
 * @author : sf
 * @time   : 2018年8月1日  上午9:20:03 
 * @TODO   :	日志生成
 */
@Controller
@RequestMapping("records")
public class RecordsController {
	
	@Autowired
	private RecordsService recordsService;
	
	@SystemControllerLog("提交个人日志")
	@RequestMapping("saveDiary")
	public String saveDiary(String id,String message,String problem,CommonDate date,WordDefined defined,RedirectAttributes attributes,HttpSession session){
		try {
			String userid = (String)session.getAttribute("userid");
			Records records = new Records();
			records.setUserid(userid);
			records.setRemark(message);
			records.setTroublemeet(problem);
				records.setWritetime(date.getTimeToDay());
				int num = 0;
			if(id!=null &&id!=""){
				records.setId(Integer.parseInt(id));
				num= recordsService.updateByIdSelective(records);
				if(num>0){
					attributes.addFlashAttribute("message", defined.DIARY_UPDATE_SUCCESS);
					return "redirect:/chat";
				}else{
					attributes.addFlashAttribute("error", defined.DIARY_UPDATE_FAIL);
					return "redirect:/chat";
				}
			}else{
				
				String records_id  = recordsService.selectIdByDate(records.getWritetime());
				if(records_id!=null){
					num= recordsService.updateByIdSelective(records);
					if(num>0){
						attributes.addFlashAttribute("message", defined.DIARY_UPDATE_SUCCESS);
						return "redirect:/chat";
					}else{
						attributes.addFlashAttribute("error", defined.DIARY_UPDATE_FAIL);
						return "redirect:/chat";
					}
				}else{
					num= recordsService.insertSelective(records);
					if(num>0){
						attributes.addFlashAttribute("message", defined.DIARY_INSERT_SUCCESS);
						return "redirect:/chat";
					}else{
						attributes.addFlashAttribute("error", defined.DIARY_INSERT_FAIL);
						return "redirect:/chat";
					}
				}
				
			}
			
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
		
		
	}
	
	@SystemControllerLog("更新个人日志")
	@RequestMapping("updateDiary")
	public String updateDiary(String message,String problem,CommonDate date,WordDefined defined,RedirectAttributes attributes){
		Records records = new Records();
		records.setRemark(message);
		records.setTroublemeet(problem);
		
			records.setWritetime(new SimpleDateFormat("yyyy-MM-dd").format(date.getTime24()));
		
		int num = 0;
		num= recordsService.updateByUseridSelective(records);
		if(num>0){
			attributes.addFlashAttribute("message", defined.DIARY_UPDATE_SUCCESS);
			return "redirect:/chat";
		}else{
			attributes.addFlashAttribute("error", defined.DIARY_UPDATE_FAIL);
			return "redirect:/chat";
		}
		
	}
	@SystemControllerLog("查找个人日志")
	@RequestMapping("selectDiary")
	public ModelAndView selectDiary(CommonDate date,WordDefined defined,RedirectAttributes attributes,HttpSession session){
		 ModelAndView view = new ModelAndView("index");
		
        return view;
		}
	
	
	

}