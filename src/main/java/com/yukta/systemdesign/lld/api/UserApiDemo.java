package com.yukta.systemdesign.lld.api;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserApiDemo {
    public static void main(String[] args) {
        UserApiRepository repository = new InMemoryUserApiRepository();
        UserApiService service = new UserApiService(repository);
        UserApiController controller = new UserApiController(service);

        ApiResponse<UserResponse> created = controller.createUser(new CreateUserRequest("Yukta", "yukta@example.com"));
        System.out.println(created);

        ApiResponse<UserResponse> found = controller.getUser(1);
        System.out.println(found);

        ApiResponse<UserResponse> missing = controller.getUser(99);
        System.out.println(missing);
    }
}

record CreateUserRequest(String name, String email) {
}

record UserResponse(int id, String name, String email) {
}

record ApiResponse<T>(int statusCode, String message, T data) {
    static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(200, "OK", data);
    }

    static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, "Created", data);
    }

    static <T> ApiResponse<T> badRequest(String message) {
        return new ApiResponse<>(400, message, null);
    }

    static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(404, message, null);
    }
}

record UserApiEntity(int id, String name, String email) {
}

class UserApiController {
    private final UserApiService service;

    UserApiController(UserApiService service) {
        this.service = service;
    }

    ApiResponse<UserResponse> createUser(CreateUserRequest request) {
        if (request.name() == null || request.name().isBlank()) {
            return ApiResponse.badRequest("Name is required");
        }

        if (request.email() == null || request.email().isBlank()) {
            return ApiResponse.badRequest("Email is required");
        }

        return ApiResponse.created(service.createUser(request));
    }

    ApiResponse<UserResponse> getUser(int id) {
        return service.findUser(id)
                .map(ApiResponse::ok)
                .orElseGet(() -> ApiResponse.notFound("User not found"));
    }
}

class UserApiService {
    private final UserApiRepository repository;

    UserApiService(UserApiRepository repository) {
        this.repository = repository;
    }

    UserResponse createUser(CreateUserRequest request) {
        UserApiEntity savedUser = repository.save(request.name(), request.email());
        return toResponse(savedUser);
    }

    Optional<UserResponse> findUser(int id) {
        return repository.findById(id).map(this::toResponse);
    }

    private UserResponse toResponse(UserApiEntity entity) {
        return new UserResponse(entity.id(), entity.name(), entity.email());
    }
}

interface UserApiRepository {
    UserApiEntity save(String name, String email);

    Optional<UserApiEntity> findById(int id);
}

class InMemoryUserApiRepository implements UserApiRepository {
    private final Map<Integer, UserApiEntity> users = new HashMap<>();
    private int nextId = 1;

    @Override
    public UserApiEntity save(String name, String email) {
        UserApiEntity user = new UserApiEntity(nextId++, name, email);
        users.put(user.id(), user);
        return user;
    }

    @Override
    public Optional<UserApiEntity> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }
}
