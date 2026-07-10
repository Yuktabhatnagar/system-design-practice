package com.yukta.systemdesign.lld.api.types.restapi;

public class RestApiDemo {
    public static void main(String[] args) {
        RestUserController controller = new RestUserController();
        System.out.println(controller.getUser(1));
    }
}

record RestResponse(int status, String body) {}
class RestUserController {
    RestResponse getUser(int id) {
        return new RestResponse(200, "GET /users/" + id + " returned user data");
    }
}
