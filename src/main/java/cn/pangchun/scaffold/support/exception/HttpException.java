package cn.pangchun.scaffold.support.exception;

/**
 * http连接异常
 *
 * @author pangchun
 * @since 2023/3/11
 */
public class HttpException extends RuntimeException{

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }
}
