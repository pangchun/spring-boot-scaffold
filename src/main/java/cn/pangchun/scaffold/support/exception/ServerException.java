package cn.pangchun.scaffold.support.exception;

/**
 * 服务器异常
 *
 * @author pangchun
 * @since 2023/2/21
 */
public class ServerException extends RuntimeException{

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
