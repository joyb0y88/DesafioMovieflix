package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value = "SELECT obj FROM Movie obj JOIN FETCH obj.genre "
			+ "WHERE :genreMovie is null or obj.genre.id = :genreMovie",
			countQuery = "SELECT COUNT(obj) FROM Movie obj JOIN obj.genre "
					+ "WHERE :genreMovie is null or obj.genre.id = :genreMovie")
	Page<Movie> movieByGenre(Long genreMovie, Pageable pageable);
}
