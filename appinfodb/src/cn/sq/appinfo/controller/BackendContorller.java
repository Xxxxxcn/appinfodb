package cn.sq.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.dao.BackendUserDao;
import cn.sq.appinfo.pojo.AppCategory;
import cn.sq.appinfo.pojo.AppInfo;
import cn.sq.appinfo.pojo.AppVersion;
import cn.sq.appinfo.pojo.BackendUser;
import cn.sq.appinfo.pojo.DataDictionary;
import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.AppCategoryService;
import cn.sq.appinfo.service.AppVersionService;
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
	@Resource
	private AppCategoryService as;
	@Resource
	private AppVersionService avs;

	@RequestMapping("/login")
	public String login() {
		return "backendlogin";
	}

	@RequestMapping("/dologin")
	public ModelAndView login(String userCode, String userPassword, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		BackendUser backendUser = us.login(userCode, userPassword);
		if (backendUser != null) {
			session.setAttribute(Constants.USER_SESSION, backendUser);
			mv.setViewName("/backend/main");
			return mv;
		} else {
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
			Integer queryFlatformId, Integer pageNo) {
		// 按需求查询数据数量
		int totalCount = apps.getAppInfoCount(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, null);
		Page page = new Page();
		if (pageNo != null) {
			page.setPageInex(pageNo);
		}
		page.setTotalCount(totalCount);
		// 按要求查询信息
		List<AppInfo> appInfoList = apps.getAppInfoList(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, null, page.getCurrentpage(), page.getPageSize());
		page.setList(appInfoList);
		// 按要求查询typecode
		List<DataDictionary> statusList = ds.DataDictionaryTypeCode("APP_STATUS");
		List<DataDictionary> flatFormList = ds.DataDictionaryTypeCode("APP_FLATFORM");
		// 一级分类，二级分类，三级分类
		List<AppCategory> categoryLevel1List = as.getAppCategories(null);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("pages", page);
		model.addAttribute("queryStatus", queryStatus);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("queryFlatformId", queryFlatformId);

		return "backend/applist";
	}

	@RequestMapping("categorylevellist")
	@ResponseBody
	public Object getAppCategoryList(Integer pid) {
		System.out.println(pid);
		return as.getAppCategories(pid);
	}

	@RequestMapping("check")
	public String check(Integer aid, Integer vid, Model model) {
		AppInfo appInfo = apps.getAppinfoIdandAPKName(aid, null);
		AppVersion appVersion = avs.getAppVersion(vid);
		model.addAttribute(appInfo);
		model.addAttribute(appVersion);
		return "backend/appcheck";
	}

	@RequestMapping("checksave")
	public String checkSave(Integer status,Integer id) {
		if (apps.updateStatus(id,status)) {
			return "redirect:/manager/list.do";
		}
		return "backend/appcheck";
	}
	
}
