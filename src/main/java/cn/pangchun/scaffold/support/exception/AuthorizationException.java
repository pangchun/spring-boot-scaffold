package cn.pangchun.scaffold.support.exception;

/**
 * 认证异常
 *
 * @author pangchun
 * @since 2023/2/21
 */
public class AuthorizationException extends RuntimeException{

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
