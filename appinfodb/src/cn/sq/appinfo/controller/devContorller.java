package cn.sq.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.DevUserService;
import cn.sq.appinfo.tools.Constants;

@Controller
@RequestMapping("/dev")
public class devContorller {

	@Resource
	private DevUserService devs;

	@RequestMapping("/login")
	public String login() {
		return "devlogin";
	}

	@RequestMapping("/dologin")
	public String dologin(String devCode, String devPassword, HttpSession session,Model model) {
		DevUser dsevUser = devs.login(devCode, devPassword);
		System.out.println(devCode+"---"+devPassword);
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
}
