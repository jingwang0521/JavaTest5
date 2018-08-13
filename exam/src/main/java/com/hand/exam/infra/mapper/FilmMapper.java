package com.hand.exam.infra.mapper;


import com.hand.exam.domain.entity.FilmE;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmMapper {


	FilmE selectByPrimaryKey(Short filmId);

	List<FilmE> selectAll();

}