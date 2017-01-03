package com.age.mvctest1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

/*@RequestMapping("/board")*/
@Controller
public class ViewController {
	@RequestMapping("view")
	public String view(Model model ){
		model.addAttribute("id", "abcd");
		model.addAttribute("pw", "1234");
		return "view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model ){
		model.addAttribute("name", "kim");
		model.addAttribute("age", "23");
		return "/board/content";
	}
	
	@RequestMapping("/board/content1")
	public ModelAndView content1(HttpServletRequest httpServletRequest){
		String id=httpServletRequest.getParameter("id");
		int age=Integer.parseInt(httpServletRequest.getParameter("age"));
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "kim");
		mv.addObject("age", "23");
		mv.setViewName("board/content1");
		return mv;
	}
	
	@RequestMapping("/board/content2")
	public ModelAndView content2(){
		ModelAndView mv2=new ModelAndView();
		mv2.addObject("name", "kim");
		mv2.addObject("age", "23");
		mv2.setViewName("board/content2");
		return mv2;
	}
	
	@RequestMapping("/board/content3")
	public ModelAndView content3(@RequestParam("id") String id,
			@RequestParam("pw") String pw){
		ModelAndView mv2=new ModelAndView();
		mv2.addObject("name", "kim");
		mv2.addObject("age", "23");
		mv2.setViewName("board/content3");
		return mv2;
	}
}