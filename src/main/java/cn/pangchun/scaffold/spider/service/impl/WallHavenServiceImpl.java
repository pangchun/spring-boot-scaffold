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
    public List<String> crawlHome() throws IOException {
        Document doc = Jsoup.connect(WallHavenConstants.HOME_PAGE_URL).get();
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
}
