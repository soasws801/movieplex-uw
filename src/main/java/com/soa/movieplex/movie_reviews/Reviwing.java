/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.movie_reviews;

import com.soa.movieplex.entities.Movie;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author umairwarsi
 */
@Named
@FlowScoped("reviwing")
public class Reviwing implements Serializable {

    int movieId;
    String MovieReview;
    int ID;

    //@PersistenceContext
    //EntityManager entityManager;
    public String getMovieReview() {
        return MovieReview;

    }

    public void addReview() throws Exception {
        userTransaction.begin();

        MovieReview review = new MovieReview(bean.getReviewId(), bean.getCustomer(), bean.getRating(), bean.getComments());
        Movie movie = new Movie(movieId);
        review.setMovie(movie);

        entityManager.persist(review);
        userTransaction.commit();
        
        @Resource
        private userTransaction userTransaction;
    }
}
