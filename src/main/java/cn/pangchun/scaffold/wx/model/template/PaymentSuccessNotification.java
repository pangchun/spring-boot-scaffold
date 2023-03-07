package cn.pangchun.scaffold.wx.model.template;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 付款成功通知
 *
 * @author pangchun
 * @since 2023/3/6
 */
@Getter
@NoArgsConstructor
@Validated
public class PaymentSuccessNotification {

    /**
     * 订单编号
     * 32位以内数字、字母或符号
     */
    @NotEmpty(message = "characterString1不能为空")
    private Map<String, String> characterString1;

    /**
     * 付款时间
     * 2019年10月1日，或：2019年10月1日 15:01
     */
    @NotEmpty(message = "date2不能为空")
    private Map<String, String> date2;

    /**
     * 商品详情
     * 可汉字、数字、字母或符号组合 20个以内字符
     */
    @NotEmpty(message = "thing3不能为空")
    private Map<String, String> thing3;

    /**
     * 支付方式
     * 可汉字、数字、字母或符号组合 20个以内字符
     */
    @NotEmpty(message = "thing4不能为空")
    private Map<String, String> thing4;

    /**
     * 付款金额
     * 1个币种符号+10位以内纯数字，可带小数，结尾可带“元”
     */
    @NotEmpty(message = "amount5不能为空")
    private Map<String, String> amount5;

    public PaymentSuccessNotification setCharacterString1(String characterString1) {
        this.characterString1 = getFormat(characterString1);
        return this;
    }

    public PaymentSuccessNotification setDate2(String date2) {
        this.date2 = getFormat(date2);
        return this;
    }

    public PaymentSuccessNotification setThing3(String thing3) {
        this.thing3 = getFormat(thing3);
        return this;
    }

    public PaymentSuccessNotification setThing4(String thing4) {
        this.thing4 = getFormat(thing4);
        return this;
    }

    public PaymentSuccessNotification setAmount5(String amount5) {
        this.amount5 = getFormat(amount5);
        return this;
    }

    /**
     * 获取value map
     * @param value 参数值
     * @return {"value": value}
     */
    public Map<String, String> getFormat(String value) {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(1);
        map.put("value", value);
        return map;
    }
}
