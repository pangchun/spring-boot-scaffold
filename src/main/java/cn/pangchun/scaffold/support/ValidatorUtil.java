package cn.pangchun.scaffold.support;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

/**
 * ValidatorUtil
 *
 * @author pangchun
 * @since 2023/1/15
 */
public class ValidatorUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static synchronized <T> void validate(T t, String msg, Class<?>... groups) throws Exception {
        if (!StringUtils.isEmpty(msg)) {
            Assert.notNull(t, msg);
        }
        // 校验
        Set<ConstraintViolation<T>> validate = VALIDATOR.validate(t, groups);
        // 获取校验结果
        Optional<String> message = validate.stream().map(ConstraintViolation::getMessage).findFirst();
        // 根据校验结果判断是否抛出异常
        if (message.isPresent()) {
            throw new Exception(message.get());
        }
    }
}
