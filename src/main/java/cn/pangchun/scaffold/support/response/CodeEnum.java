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
     * 未知
     */
    UNKNOWN(1000, "未知错误"),

    /**
     * 认证失败
     */
    UNAUTHORIZED(2000, "认证失败"),

    /**
     * 没有权限
     */
    FORBIDDEN(3000, "没有权限"),

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
