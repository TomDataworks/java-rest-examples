package io.github.arven.rs.filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author brian.becker
 */
@Provider
public class StatusCodeFilter implements ContainerResponseFilter {

    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
        System.out.println("<<<STOPPED>>>");
        if(res.getEntity() instanceof StatusCode) {
            StatusCode s = (StatusCode) res.getEntity();
            res.setStatus(s.error());
        }
    }
    
}
