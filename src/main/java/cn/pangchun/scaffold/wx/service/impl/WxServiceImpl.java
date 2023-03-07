package cn.pangchun.scaffold.wx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.pangchun.scaffold.support.util.ValidatorUtil;
import cn.pangchun.scaffold.wx.constant.WxConstants;
import cn.pangchun.scaffold.wx.model.dto.MsgSendDTO;
import cn.pangchun.scaffold.wx.model.template.WxMessageParam;
import cn.pangchun.scaffold.wx.service.WxService;
import cn.pangchun.scaffold.wx.util.WxParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * WxServiceImpl
 *
 * @author pangchun
 * @since 2023/3/7
 */
@Service
@Slf4j
public class WxServiceImpl implements WxService {
    @Override
    public Boolean sendMessage(WxMessageParam param, String accessToken) {
        // 获取消息体json
        String json = WxParamUtil.bean2JsonWithSnakeCase(param);
        // 获取access_token,并拼接至url
        String url = WxConstants.SEND_URL.concat(accessToken);
        // 发起请求
        String rs = HttpUtil.post(url, json);
        log.info("推送消息 ========>> 响应：{}", rs);
        return true;
    }

    @Override
    public Boolean sendMessage(MsgSendDTO msgSendDTO) {
        checkParam(msgSendDTO);

        // TODO: 2023/3/7 根据appId从缓存中获取access_token,并拼接至url
        String accessToken = "******";

        // TODO: 2023/3/7 根据模板Code查询模板Id
        String templateId = "******";

        // 构造消息推送请求参数
        WxMessageParam param = msgSendDto2WxMessageParam(msgSendDTO, templateId);

        Boolean rs = sendMessage(param, accessToken);

        // TODO: 2023/3/7 将消息记录存入数据表


        return rs;
    }

    /**
     * 参数校验
     *
     * @param t   入参
     * @param <T> 泛型定义
     */
    private <T> void checkParam(T t) {
        try {
            ValidatorUtil.validate(t, t.getClass().getName() + "参数不能为空");
        } catch (Exception e) {
            log.error("参数校验异常");
            e.printStackTrace();
        }
    }

    /**
     * 构造WxMessageParam
     *
     * @param msgSendDTO MsgSendDTO
     * @param templateId 模板id
     * @return WxMessageParam
     */
    private WxMessageParam msgSendDto2WxMessageParam(MsgSendDTO msgSendDTO, String templateId) {
        WxMessageParam param = new WxMessageParam();
        param.setTouser(msgSendDTO.getTouser())
                .setTemplateId(templateId)
                .setPage(msgSendDTO.getPage())
                .setData(msgSendDTO.getData())
                .setMiniprogramState(msgSendDTO.getMiniprogramState())
                .setLang(msgSendDTO.getLang());
        return param;
    }
}
