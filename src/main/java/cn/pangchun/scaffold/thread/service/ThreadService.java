package cn.pangchun.scaffold.thread.service;

import java.util.List;

/**
 * ThreadService
 *
 * @author pangchun
 * @since 2023/2/28
 */
public interface ThreadService {

    /**
     * 批量下载图片
     * 1、图片的url可以使用java爬虫爬取
     *
     * @param urls 图片链接
     */
    void downloadImg(List<String> urls);

}
