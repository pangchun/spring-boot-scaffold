package cn.pangchun.scaffold.support.exception;

/**
 * 业务异常
 *
 * @author pangchun
 * @since 2023/2/21
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
