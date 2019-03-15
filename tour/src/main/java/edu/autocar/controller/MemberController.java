package edu.autocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;
import edu.autocar.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/list")
	public void list(@RequestParam(value="page", defaultValue="1") int page, Model model) throws Exception {
		PageInfo<Member> pi = service.getPage(page);
		System.out.println(pi);
		model.addAttribute("pi", pi);
	}
}
