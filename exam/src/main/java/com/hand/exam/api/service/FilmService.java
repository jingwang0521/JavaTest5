package com.hand.exam.api.service;





import com.hand.exam.domain.entity.FilmE;

import java.util.List;

public interface FilmService {

	FilmE selectByPrimaryKey(Short filmId);

	List<FilmE> selectAll();


}
