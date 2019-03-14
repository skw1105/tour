package edu.autocar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {
	@GetMapping("/board/search")
	public String search(@RequestParam("query") String query, @RequestParam("page") int page) {
		return "board/search_result";
	}
	
//	@RequestMapping("/board/search2")
//	public ModelAndView search2(@RequestParam(value="query", required=false) String query,
//			@RequestParam(value="page", defaultValue="1") int page) {
//		return new ModelAndView();
//	}
}
