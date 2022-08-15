package com.inside;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class App {

    public static void main( String[] args ) {
        String uri = "http://localhost:8080/UserRestApi_war_exploded/rest/api/";

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        // Get all users
        WebTarget target = client.target(uri + "all-users");
        String request = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(request);

        // Get user by id
        target = client.target(uri + "user-by-id?id=2");
        request = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(request);

        // Delete user
        target = client.target(uri + "delete-user?id=3");
        request = target.request().accept(MediaType.TEXT_PLAIN_TYPE).delete(String.class);

        System.out.println(request);

    }
}
