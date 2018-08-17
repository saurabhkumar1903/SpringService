package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.*;
import dto.User;

@Controller
public class HelloController {

	@Autowired
	HelloDao hellodao;

	@RequestMapping("/")
	public ModelAndView fun() {

		return new ModelAndView("input", "msg", "welcome");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(@RequestParam("userid") String userid, @RequestParam("password") String password) {

		int result = hellodao.insertinto(userid, password);
		if (result == 1)
			return new ModelAndView("successSignUp", "msg", "Welcome");
		else
			return new ModelAndView("error", "msg", "Error");

	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signIn(@RequestParam("userid") String userid, @RequestParam("password") String password) {
		
		List<User> result = hellodao.finduser(userid, password);
		
		if(result.iterator().hasNext())
			return new ModelAndView("successSignIn", "msg", "Welcome :" + result.get(0).getUserid());
		else
			return new ModelAndView("error", "msg", "Error");
		
		}
		
}
