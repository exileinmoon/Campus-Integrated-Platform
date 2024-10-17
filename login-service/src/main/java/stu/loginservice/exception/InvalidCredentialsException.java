package stu.loginservice.exception;


public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message); // 调用父类构造函数
    }
}
