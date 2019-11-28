package cn.sq.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.dao.BackendUserDao;
import cn.sq.appinfo.pojo.BackendUser;
import cn.sq.appinfo.service.BackendUserService;

@Controller
@RequestMapping("/manager")
public class managerContorller {
	
	@Resource
	private BackendUserService us;
	
	@RequestMapping("/login")
	public String login() {
		return "backendlogin";
	}
	
	@RequestMapping("/dologin") 
	public ModelAndView login(String userCode,String userPassword,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(us.login(userCode,userPassword)!=null) {
			session.setAttribute("session_name", userCode);
			mv.setViewName("");
			return mv;
		}else {
			session.setAttribute("error", "登入失败");
			mv.setViewName("backendlogin");
			return mv;
		}
	}
}
