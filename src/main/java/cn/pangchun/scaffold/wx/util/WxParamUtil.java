package cn.pangchun.scaffold.wx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * WxParamUtil
 *
 * @author pangchun
 * @since 2023/3/7
 */
public class WxParamUtil {

    /**
     * bean转json 驼峰转下划线
     *
     * @param bean 对象
     * @return json string
     */
    public static String bean2JsonWithSnakeCase(Object bean) {
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCase);
        return JSON.toJSONString(bean, serializeConfig);
    }
}
