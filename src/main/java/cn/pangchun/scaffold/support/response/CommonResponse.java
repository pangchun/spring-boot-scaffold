package cn.pangchun.scaffold.support.response;

import lombok.Data;

/**
 * 统一响应对象
 *
 * @author pangchun
 * @since 2023/2/18
 */
@SuppressWarnings("all")
@Data
public class CommonResponse<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态消息
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(T data) {
        this.data = data;
    }

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> ofSuccess(T data) {
        return new CommonResponse<>(CodeEnum.SUCCESS.code(), CodeEnum.SUCCESS.message(), data);
    }

    public static <T> CommonResponse<T> ofSuccess(T data, String message) {
        return new CommonResponse<>(CodeEnum.SUCCESS.code(), message, data);
    }

    public static <T> CommonResponse<T> ofFail(T data) {
        return new CommonResponse<>(CodeEnum.FAIL.code(), CodeEnum.FAIL.message(), data);
    }

    public static <T> CommonResponse<T> ofFail(T data, String message) {
        return new CommonResponse<>(CodeEnum.FAIL.code(), message, data);
    }
}
