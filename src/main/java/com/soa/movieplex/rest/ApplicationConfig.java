/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author umairwarsi
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.soa.movieplex.json.MovieReader.class);
        resources.add(com.soa.movieplex.json.MovieWriter.class);
        resources.add(com.soa.movieplex.rest.MovieFacadeREST.class);
        resources.add(com.soa.movieplex.rest.ShowTimingFacadeREST.class);
        resources.add(com.soa.movieplex.rest.TheaterFacadeREST.class);
        resources.add(com.soa.movieplex.rest.TimeslotFacadeREST.class);
    }
    
}
