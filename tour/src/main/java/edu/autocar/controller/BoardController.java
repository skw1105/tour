package edu.autocar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.domain.Board;
import edu.autocar.domain.PageInfo;
import edu.autocar.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;

//	@GetMapping("/list")
//	public void list(Model model) throws Exception {
//		PageInfo<Board> pi = service.getPage(1);
//		log.info(pi.toString());
//		model.addAttribute("pi", pi);
//	}

	@GetMapping("/list")
	public void list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) throws Exception {
		PageInfo<Board> pi = service.getPage(page);
		model.addAttribute("pi", pi);
	}

	@GetMapping("/create")
	public void getCreate(Model model) throws Exception {
		model.addAttribute("board", new Board());
	}

	@PostMapping("/create")
	public String postCreate(@Valid Board board, BindingResult result) throws Exception {
		log.info(board.toString());
		if (result.hasErrors()) {
			log.info("유효성 검증 실패");
			return "board/create";
		}
		service.create(board);
		return "redirect:list";
	}
}
