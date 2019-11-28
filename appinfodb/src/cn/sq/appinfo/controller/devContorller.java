package cn.sq.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sq.appinfo.pojo.DevUser;
import cn.sq.appinfo.service.DevUserService;

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
	public String login(String userCode, String userPassword, HttpSession session) {
		DevUser DevUser = devs.login(userCode, userPassword);
		if (DevUser != null) {
			session.setAttribute("session_name", DevUser);
			return "main";
		} else {
			session.setAttribute("error", "登入失败");
			return "devlogin";
		}
	}
}
