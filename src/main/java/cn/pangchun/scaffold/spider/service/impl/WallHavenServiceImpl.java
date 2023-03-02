package cn.pangchun.scaffold.spider.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.pangchun.scaffold.spider.constant.WallHavenConstants;
import cn.pangchun.scaffold.spider.service.WallHavenService;
import cn.pangchun.scaffold.spider.util.WallHavenUrlUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * WallHavenServiceImpl
 *
 * @author pangchun
 * @since 2023/3/2
 */
@Slf4j
public class WallHavenServiceImpl implements WallHavenService {

    @Override
    public List<String> crawl(String pageUrl) {
        Document doc;
        try {
            doc = Jsoup.connect(pageUrl).get();
        } catch (IOException e) {
            log.error("网页请求失败,未获取到html,当前请求地址 => {}, 错误信息 => {}", pageUrl, e.getMessage());
            return null;
        }
        Elements links = doc.select("img[src]");
        List<String> originList = Lists.newArrayList();
        for (Element link : links) {
            String url = link.attr("abs:src");
            String originUrl = WallHavenUrlUtil.transferUrl2OriginUrl(url);
            if (StrUtil.isNotBlank(originUrl)) {
                originList.add(originUrl);
            }
        }
        return originList;
    }

    @Override
    public List<String> crawlHome() {
        return crawl(WallHavenConstants.HOME_PAGE_URL);
    }

    @Override
    public List<String> crawlLatest() {
        return crawl(WallHavenConstants.LATEST_PAGE_URL);
    }
}
