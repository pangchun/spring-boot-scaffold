package cn.pangchun.scaffold.spider.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.pangchun.scaffold.spider.constant.WallHavenConstants;
import cn.pangchun.scaffold.spider.service.WallHavenService;
import cn.pangchun.scaffold.spider.util.WallHavenUtil;
import cn.pangchun.scaffold.support.exception.HttpException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

/**
 * WallHavenServiceImpl
 *
 * @author pangchun
 * @since 2023/3/2
 */
@Slf4j
@Service
public class WallHavenServiceImpl implements WallHavenService {

    @Override
    @Nullable
    public List<String> crawl(@NotBlank String pageUrl) {
        Document doc;
        try {
            log.info("连接wallhaven，请求地址 => {}", pageUrl);
            doc = Jsoup.connect(pageUrl).get();
        } catch (IOException e) {
            log.error("网页请求失败,未获取到html,当前请求地址 => {}, 错误信息 => {}", pageUrl, e.getMessage());
            throw new HttpException(e.getMessage());
        }
        Elements links = doc.select("img[src]");
        if (CollectionUtil.isEmpty(links)) {
            return null;
        }
        List<String> originList = Lists.newArrayList();
        for (Element link : links) {
            // wallHaven使用了图片懒加载，直接请求获取到的src属性可能是空字符串，可访问的src其实存在data-src属性中
            String url = StrUtil.isBlank(link.attr("src")) ? link.attr("data-src") : link.attr("src");
            String originUrl = WallHavenUtil.transferImgUrl2OriginUrl(url);
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
    public List<String> crawlLatest(@Min(value = 1) Integer page) {
        String pageUrl = WallHavenUtil.setPageForPageUrl(WallHavenConstants.LATEST_PAGE_URL, page);
        log.info("抓取最近的图片链接, 请求的pageUrl => {}", pageUrl);
        return crawl(pageUrl);
    }

    @Override
    public List<String> crawlTopList(@Min(value = 1) Integer page) {
        String pageUrl = WallHavenUtil.setPageForPageUrl(WallHavenConstants.TOP_LIST_PAGE_URL, page);
        return crawl(pageUrl);
    }

    @Override
    public List<String> crawlRandom(@Min(value = 1) Integer page) {
        String pageUrl = WallHavenUtil.setPageForPageUrl(WallHavenConstants.RANDOM_PAGE_URL, page);
        return crawl(pageUrl);
    }
}
