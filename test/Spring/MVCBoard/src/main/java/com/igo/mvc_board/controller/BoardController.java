package com.igo.mvc_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.igo.mvc_board.command.*;
import com.igo.mvc_board.util.Constant;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	BCommand command=null;
	
public static JdbcTemplate template;
	
	@Autowired //자동주입
	public void setTemplate(JdbcTemplate template) {
	this.template = template;
	
	Constant.template=this.template; // 추가
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list");
		
		command= new BListCommand();
		command.execute(model);
		
		return "board/list";
	}
	
	@RequestMapping("/write")
	public String write_view(){
		System.out.println("write_view()");
		return "board/write_view";
	}
	@RequestMapping(method=RequestMethod.POST, value="/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write");
		model.addAttribute("request", request);
		command=new BWriteCommand(); 
		command.execute(model); 
				
		return "redirect:list";
	}
	@RequestMapping(value="/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view");
		model.addAttribute("request", request);
		command=new BContentCommand();
		command.execute(model);

		return "board/content_view";
	}
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify");
		
		model.addAttribute("request", request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete");
		
		model.addAttribute("request", request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("reply_view");
		model.addAttribute("request", request);
		command=new BReplyViewCommand();
		command.execute(model);
		return "board/reply_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply");
		model.addAttribute("request", request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}

}
