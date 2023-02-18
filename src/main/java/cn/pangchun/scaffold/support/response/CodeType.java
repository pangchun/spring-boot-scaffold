package cn.pangchun.scaffold.support.response;

/**
 * 统一响应状态码
 *
 * @author pangchun
 * @since 2023/2/18
 */
public interface CodeType {

    /**
     * 获取状态码
     *
     * @return 状态码 如 404
     */
    int code();

    /**
     * 或者状态码消息
     *
     * @return 提示消息 如 页面不存在
     */
    String message();
}
