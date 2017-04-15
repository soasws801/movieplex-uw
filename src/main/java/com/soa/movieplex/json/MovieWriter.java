/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.json;

import com.soa.movieplex.entities.Movie;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author umairwarsi
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MovieWriter implements MessageBodyWriter<Movie> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Movie.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Movie t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override 
    public void writeTo(Movie movie,Class<?>type,Type type1,Annotation[]annotations,MediaType mediaType,MultivaluedMap<String,Object>multivaluedMap,OutputStream output) throws IOException,WebApplicationException {
        JsonGenerator generator = Json.createGenerator(output);
        
        generator.writeStartObject()
                .write("id",movie.getId())
                .write("name",movie.getName())
                .write("actors",movie.getActors())
                .writeEnd();
        
        generator.flush();
    }
    
}
