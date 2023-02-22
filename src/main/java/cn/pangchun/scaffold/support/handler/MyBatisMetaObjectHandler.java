package cn.pangchun.scaffold.support.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MybatisPlus自动填充
 *
 * @author pangchun
 * @since 2023/2/22
 */
@Component
public class MyBatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建人
     */
    private static final String CREATE_BY = "createBy";

    /**
     * 更新人
     */
    private static final String UPDATE_BY = "updateBy";

    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";

    /**
     * 更新时间
     */
    private static final String UPDATE_TIME = "updateTime";

    /**
     * 是否删除
     */
    private static final String IS_DEL = "del";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充创建人 TODO: 2023/2/22 人员一般是在登录之后从session中获取，目前写死
        if (metaObject.findProperty(CREATE_BY, false) != null && metaObject.getValue(CREATE_BY) == null) {
            this.strictInsertFill(metaObject, CREATE_BY, Long.class, 1L);
        }
        // 填充更新人 TODO: 2023/2/22 人员一般是在登录之后从session中获取，目前写死
        if (metaObject.findProperty(UPDATE_BY, false) != null && metaObject.getValue(UPDATE_BY) == null) {
            this.strictInsertFill(metaObject, UPDATE_BY, Long.class, 1L);
        }
        // 填充创建时间
        if (metaObject.findProperty(CREATE_TIME, false) != null && metaObject.getValue(CREATE_TIME) == null) {
            this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        // 填充更新时间
        if (metaObject.findProperty(UPDATE_TIME, false) != null && metaObject.getValue(UPDATE_TIME) == null) {
            this.strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
        // 填充是否删除
        if (metaObject.findProperty(IS_DEL, false) != null && metaObject.getValue(IS_DEL) == null) {
            this.strictInsertFill(metaObject, IS_DEL, Boolean.class, false);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充更新人 TODO: 2023/2/22 人员一般是在登录之后从session中获取，目前写死
        if (metaObject.findProperty(UPDATE_BY, false) != null) {
            this.strictUpdateFill(metaObject, UPDATE_BY, Long.class, 2L);
        }
        // 填充更新时间
        if (metaObject.findProperty(UPDATE_TIME, false) != null) {
            this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        }
    }
}
