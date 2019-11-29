package cn.sq.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.dao.BackendUserDao;
import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.pojo.BackendUser;
import cn.sq.appinfo.pojo.DataDictionary;
import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.AppinfoService;
import cn.sq.appinfo.service.BackendUserService;
import cn.sq.appinfo.service.DataDictionaryService;
import cn.sq.appinfo.tools.Constants;
import cn.sq.appinfo.tools.Page;

@Controller
@RequestMapping("/manager")
public class BackendContorller {
	
	@Resource
	private BackendUserService us;
	@Resource
	private DataDictionaryService ds;
	@Resource
	private AppinfoService apps;
	
	@RequestMapping("/login")
	public String login() {
		return "backendlogin";
	}
	
	@RequestMapping("/dologin") 
	public ModelAndView login(String userCode,String userPassword,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		BackendUser backendUser =us.login(userCode,userPassword);
		if(backendUser!=null) {
			session.setAttribute(Constants.USER_SESSION, backendUser);
			mv.setViewName("/backend/main");
			return mv;
		}else {
			mv.addObject("error", "登入失败,请从新输入！");
			mv.setViewName("backendlogin");
			return mv;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		return "backendlogin";
	}
	
	@RequestMapping("/list")
	public String appinfolist(HttpSession session, Model model, String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3,
			Integer queryFlatformId,Page page) {
		//按需求查询数据数量
		int totalCount = apps.getAppInfoCount(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, null);
		//按要求查询信息
		List<AppInfo> appInfoList =apps.getAppInfoList(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, null, page.getCurrentpage(),page.getPageSize());
		//按要求查询typecode
		List<DataDictionary> statusList = ds.DataDictionaryTypeCode("APP_STATUS");
		List<DataDictionary> flatFormList =ds.DataDictionaryTypeCode("APP_FLATFORM");
		page = new Page();
		page.setList(appInfoList);
		page.setTotalCount(totalCount);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("pages", page);
		
		return "backend/applist";
	}
}
