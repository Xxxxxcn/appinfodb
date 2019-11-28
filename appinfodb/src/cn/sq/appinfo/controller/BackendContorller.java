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
import cn.sq.appinfo.tools.Constants;

@Controller
@RequestMapping("/manager")
public class BackendContorller {
	
	@Resource
	private BackendUserService us;
	
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
}
