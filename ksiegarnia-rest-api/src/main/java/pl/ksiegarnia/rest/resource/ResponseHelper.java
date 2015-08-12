package pl.ksiegarnia.rest.resource;

/**
 * Created by pgrubarek on 12.08.15.
 */

import javax.ws.rs.core.Response;

/**
 * Pomocnicza klasa do budowania zwrotek HTTP wraz z niezbędnymi nagłówkami.
 */
public class ResponseHelper {

    private ResponseHelper() {}

    public static Response notFound() {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public static Response unauthorized() {
        return Response.status(Response.Status.UNAUTHORIZED)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response internalServerError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response created() {
        return Response.status(Response.Status.CREATED)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response ok() {
        return Response.status(Response.Status.OK)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response ok(Object o) {
        return Response.ok(o).header("Content-type", "application/json; charset=utf-8")/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

    public static Response forbidden() {
        return Response.status(Response.Status.FORBIDDEN)/*.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS").header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia")*/.build();
    }

}

