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
     * 抓取首页的图片链接
     *
     * @return 原图url
     * @throws IOException io异常
     */
    List<String> crawlHome() throws IOException;

}
