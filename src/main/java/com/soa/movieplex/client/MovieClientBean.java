/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.client;

import com.soa.movieplex.entities.Movie;
import com.soa.movieplex.json.MovieWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author umairwarsi
 */
@Named
@RequestScoped
public class MovieClientBean {

    Client client;
    WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/movieplex/rest/movies/");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Movie[] getMovies() {
        return target.request().get(Movie[].class);
    }

    @Inject
    MovieBackingBean bean;

    public Movie getMovie() {
        Movie movie = target
                .path("{movieId}")
                .resolveTemplate("movieId", bean.getMovieId()).request()
                .get(Movie.class);
        return movie;
    }

    public void addMovie() {
        Movie movie = new Movie();
        movie.setId(bean.getMovieId());
        movie.setName(bean.getMovieName());
        movie.setActors(bean.getActors());
        target.register(MovieWriter.class)
                .request()
                .post(Entity.entity(movie, MediaType.APPLICATION_JSON));
    }

}
