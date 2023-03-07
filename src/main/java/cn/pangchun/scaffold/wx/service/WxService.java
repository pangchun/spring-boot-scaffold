package cn.pangchun.scaffold.wx.service;

import cn.pangchun.scaffold.wx.model.dto.MsgSendDTO;
import cn.pangchun.scaffold.wx.model.template.WxMessageParam;

/**
 * WxService
 *
 * @author pangchun
 * @since 2023/3/7
 */
public interface WxService {

    /**
     * 推送消息
     *
     * @param param       消息参数
     * @param accessToken 请求token
     * @return 是否成功
     */
    Boolean sendMessage(WxMessageParam param, String accessToken);

    /**
     * 推送消息
     *
     * @param msgSendDTO 消息参数
     * @return 是否成功
     */
    Boolean sendMessage(MsgSendDTO msgSendDTO);


}
