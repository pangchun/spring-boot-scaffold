package cn.pangchun.scaffold.spider.service;

import java.io.IOException;
import java.util.List;

/**
 * WallHavenService
 * 1、wallhaven.cc 图片爬取
 *
 * @author pangchun
 * @since 2023/3/1
 */
public interface WallHavenService {

    /**
     * 抓取图片链接
     *
     * @param pageUrl wallhaven网页链接
     * @return 原图url
     * @throws IOException io异常
     */
    List<String> crawl(String pageUrl);

    /**
     * 抓取首页的图片链接
     *
     * @return 原图url
     */
    List<String> crawlHome();

    /**
     * 抓取最近的图片链接
     *
     * @return 原图url
     */
    List<String> crawlLatest();

}
