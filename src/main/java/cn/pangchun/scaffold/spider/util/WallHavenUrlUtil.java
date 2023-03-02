package cn.pangchun.scaffold.spider.util;

import cn.hutool.core.util.StrUtil;
import cn.pangchun.scaffold.spider.constant.WallHavenConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * WallHavenUrlUtil
 *
 * @author pangchun
 * @since 2023/3/2
 */
@Slf4j
public class WallHavenUrlUtil {

    /**
     * 将url转为原图url
     * <p>
     * 1、如果传入的url参数是以
     * {@link WallHavenConstants#HOME_START}、
     * {@link WallHavenConstants#THUMBNAIL_START}、
     * {@link WallHavenConstants#ORIGIN_START}、
     * 开头的url则可以正常转为原图url,否则返回null
     *
     * @param url 首页小图url
     * @return 原图url
     */
    public static String transferUrl2OriginUrl(String url) {
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
}
