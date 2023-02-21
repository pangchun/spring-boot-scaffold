package cn.pangchun.scaffold.support.exception;

/**
 * 参数异常
 *
 * @author pangchun
 * @since 2023/2/21
 */
public class ParameterException extends RuntimeException{

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
