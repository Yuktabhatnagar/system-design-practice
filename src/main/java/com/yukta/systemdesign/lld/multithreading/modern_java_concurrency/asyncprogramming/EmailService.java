package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Async
    public void sendEmail() {

        System.out.println(
                Thread.currentThread().getName()
        );
    }
}

/*@
SpringBootApplication
@EnableAsync
public class Application {
}
Call Service
emailService.sendEmail();*/
