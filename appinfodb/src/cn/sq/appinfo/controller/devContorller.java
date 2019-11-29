package cn.sq.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.pojo.DataDictionary;
import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.AppinfoService;
import cn.sq.appinfo.service.DataDictionaryService;
import cn.sq.appinfo.service.DevUserService;
import cn.sq.appinfo.tools.Constants;
import cn.sq.appinfo.tools.Page;

@Controller
@RequestMapping("/dev")
public class devContorller {

	@Resource
	private DevUserService devs;	
	@Resource
	private AppinfoService apps;
	@Resource
	private DataDictionaryService ds;

	@RequestMapping("/login")
	public String login() {
		return "devlogin";
	}

	@RequestMapping("/dologin")
	public String dologin(String devCode, String devPassword, HttpSession session,Model model) {
		DevUser dsevUser = devs.login(devCode, devPassword);
		if (dsevUser != null) {
			session.setAttribute(Constants.DEV_USER_SESSION, dsevUser);
			return "/developer/main";
		} else {
			model.addAttribute("error", "登入失败,请从新输入！");
			return "devlogin";
		}
	}
	

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
	
	@RequestMapping("/list")
	public String list(HttpSession session, Model model, String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3,
			Integer queryFlatformId,Page page) {
		Integer devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
		//按需求查询数据数量
		int totalCount = apps.getAppInfoCount(querySoftwareName,queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		//按要求查询信息
		List<AppInfo> appInfoList =apps.getAppInfoList(querySoftwareName,queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, page.getCurrentpage(),page.getPageSize());
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
		return "developer/appinfolist";
	}
}






























































































