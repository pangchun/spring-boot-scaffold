package cn.pangchun.scaffold.support.response;

/**
 * 统一响应状态码
 *
 * @author pangchun
 * @since 2023/2/18
 */
public enum CodeEnum implements CodeType {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(-1, "失败"),

    /**
     * 未知异常
     */
    UNKNOWN_EXCEPTION(1000, "未知异常"),

    /**
     * 业务异常
     */
    BUSINESS_EXCEPTION(1001, "业务异常"),

    /**
     * 认证异常
     */
    AUTHORIZATION_EXCEPTION(1002, "认证异常"),

    /**
     * 参数异常
     */
    PARAMETER_EXCEPTION(1003, "参数异常"),

    /**
     * 服务器异常
     */
    SERVER_EXCEPTION(1004, "服务器异常"),

    /**
     * 网络异常
     */
    HTTP_EXCEPTION(1005, "网络异常"),

    ;

    private final int code;

    private final String message;

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
