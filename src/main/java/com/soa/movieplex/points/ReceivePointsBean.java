/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.points;

import java.util.Enumeration;
import java.util.Queue;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.QueueBrowser;

/**
 *
 * @author umairwarsi
 */
@JMSDestinationDefinition(name = "java:global/jms/pointsQueue", interfaceName = "javax.jms.Queue")
@Named
@RequestScoped
public class ReceivePointsBean {

    @Inject
    JMSContext context;
    @Resource(lookup = "java:global/jms/pointsQueue")
    Queue pointsQueue;

    public String receiveMessage() {
        String message = context.createConsumer((Destination) pointsQueue).receiveBody(String.class);
        System.out.println("Received message: " + message);
        return message;
    }

    public int getQueueSize() {
        int count = 0;
        try {
            QueueBrowser browser = context.createBrowser((javax.jms.Queue) pointsQueue);
            Enumeration elements = browser.getEnumeration();
            while (elements.hasMoreElements()) {
                elements.nextElement();
                count++;
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return count;
    }
}
