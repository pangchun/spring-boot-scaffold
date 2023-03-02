package cn.pangchun.scaffold.spider.constant;

/**
 * WallHaven Constants
 *
 * @author pangchun
 * @since 2023/3/2
 */
public class WallHavenConstants {

    /**
     * WallHaven 字符串常量
     */
    public static final String WALL_HAVEN = "wallhaven";

    /**
     * WallHaven主要存在四个页面供我们爬取图片,如下：
     * <p>
     * 1、首页 = https://wallhaven.cc
     * 2、最近 = https://wallhaven.cc/latest
     * 3、热门 = https://wallhaven.cc/toplist
     * 4、随机 = https://wallhaven.cc/random
     * 这四个页面都没有加分页参数，因此都是默认指第一页，如果需要爬取第二、第三页的图片就需要在url后拼接分页参数
     * (注意: 首页是没有分页参数的)
     */
    public static final String HOME_PAGE_URL = "https://wallhaven.cc";
    public static final String LATEST_PAGE_URL = HOME_PAGE_URL.concat("/latest");
    public static final String TOP_LIST_PAGE_URL = HOME_PAGE_URL.concat("/toplist");
    public static final String RANDOM_PAGE_URL = HOME_PAGE_URL.concat("/random");

    /**
     * WallHaven的图片链接有三种格式,如下:
     * <p>
     * 1、首页小图 = https://th.wallhaven.cc/lg/yx/yxqzpd.jpg;
     * 2、列表页面缩略图 = https://th.wallhaven.cc/small/yx/yxqzpd.jpg;
     * 3、详情页的原图(可下载) = https://w.wallhaven.cc/full/yx/wallhaven-yxqzpd.jpg;
     * 当爬取到的图片是非首页小图或者列表缩略图时,手动将url转为原图url格式用于下载
     */
    public static final String HOME_START = "https://th.wallhaven.cc/lg";
    public static final String THUMBNAIL_START = "https://th.wallhaven.cc/small";
    public static final String ORIGIN_START = "https://w.wallhaven.cc/full";


}
