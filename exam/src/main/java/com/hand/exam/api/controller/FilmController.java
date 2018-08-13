package com.hand.exam.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.hand.exam.domain.entity.FilmE;
import com.hand.exam.domain.system.Page;
import com.hand.exam.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/film")
public class FilmController {
	@Autowired
	private
	FilmService filmService;


	//分页查询film列表
	@GetMapping(value = "/films")
	public PageInfo<List<FilmE>> queryFilms(@RequestParam("page") int page,
											@RequestParam("page") int pageSize) throws Exception{


		PageHelper.startPage(page,pageSize);
		List<FilmE>  list= filmService.selectAll();
		PageInfo<List<FilmE>> pageInfo=new PageInfo(list);

		return pageInfo;

	}



}
