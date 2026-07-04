package com.yukta.systemdesign.lld.high_design_patterns.clean_architecture;

public class CleanArchitectureDemo {
    public static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();
        RegisterUserUseCase useCase = new RegisterUserUseCase(repository);
        UserController controller = new UserController(useCase, new ConsoleUserPresenter());
        controller.register("Yukta");
    }
}

record User(String name) {}
interface UserRepository { void save(User user); }
class InMemoryUserRepository implements UserRepository { public void save(User user) { System.out.println("Saved user: " + user.name()); } }
class RegisterUserUseCase {
    private final UserRepository repository;
    RegisterUserUseCase(UserRepository repository) { this.repository = repository; }
    User execute(String name) { User user = new User(name); repository.save(user); return user; }
}
interface UserPresenter { void present(User user); }
class ConsoleUserPresenter implements UserPresenter { public void present(User user) { System.out.println("Registered user: " + user.name()); } }
class UserController {
    private final RegisterUserUseCase useCase;
    private final UserPresenter presenter;
    UserController(RegisterUserUseCase useCase, UserPresenter presenter) { this.useCase = useCase; this.presenter = presenter; }
    void register(String name) { presenter.present(useCase.execute(name)); }
}
