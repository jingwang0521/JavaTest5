package com.hand.exam.api.service.impl;



import com.hand.exam.domain.entity.FilmE;
import com.hand.exam.infra.mapper.FilmMapper;
import com.hand.exam.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {


	@Autowired
	private FilmMapper filmMapper;


	@Override
	public FilmE selectByPrimaryKey(Short filmId) {
		return filmMapper.selectByPrimaryKey(filmId);
	}

	@Override
	public List<FilmE> selectAll() {
		return filmMapper.selectAll();
	}


}
