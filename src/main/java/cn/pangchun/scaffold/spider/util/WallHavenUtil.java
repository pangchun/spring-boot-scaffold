package cn.pangchun.scaffold.spider.util;

import cn.hutool.core.util.StrUtil;
import cn.pangchun.scaffold.spider.constant.WallHavenConstants;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * WallHavenUtil
 *
 * @author pangchun
 * @since 2023/3/2
 */
@Slf4j
public class WallHavenUtil {

    /**
     * 将url转为原图url
     * <p>
     * 1、如果传入的url参数是以
     * {@link WallHavenConstants#HOME_START}、
     * {@link WallHavenConstants#THUMBNAIL_START}、
     * {@link WallHavenConstants#ORIGIN_START}、
     * 开头的url则可以正常转为原图url,否则返回null
     *
     * @param url 图片url
     * @return 原图url
     */
    @Nullable
    public static String transferImgUrl2OriginUrl(@Nullable String url) {
        if (StrUtil.isBlank(url)) {
            return null;
        }
        if (url.startsWith(WallHavenConstants.ORIGIN_START)) {
            return url;
        }
        if (url.startsWith(WallHavenConstants.HOME_START) || url.startsWith(WallHavenConstants.THUMBNAIL_START)) {
            String[] splits = url.split(StrUtil.SLASH);
            // 图片名称
            String name = WallHavenConstants.WALL_HAVEN.concat(StrUtil.DASHED).concat(splits[splits.length - 1]);
            // 最后一级目录名称
            String dir = splits[splits.length - 2];
            // 构造原图url
            return String.join(StrUtil.SLASH, WallHavenConstants.ORIGIN_START, dir, name);
        }
        log.warn("url => {} 无法转为原图url,url可能是用户头像，默认不会获取", url);
        return null;
    }

    /**
     * 为页面url设置分页参数
     * 1. 页面分页参数url示例：https://wallhaven.cc/latest?page=2
     *
     * @param pageUrl 页面url
     * @param page    第几页
     * @return 带分页参数的页面url
     */
    public static String setPageForPageUrl(@NotBlank String pageUrl, @Min(value = 1) int page) {
        if (page == 1) {
            return pageUrl;
        }
        return pageUrl.concat("?page=").concat(String.valueOf(page));
    }
}
