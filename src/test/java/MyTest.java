import cn.pangchun.scaffold.ScaffoldApplication;
import cn.pangchun.scaffold.blog.mapper.SmsMapper;
import cn.pangchun.scaffold.blog.service.SmsService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScaffoldApplication.class)
@Slf4j
public class MyTest {

    @Autowired
    private SmsMapper smsMapper;

    @Autowired
    private SmsService smsService;

    /**
     * 爬取wallhaven.cc的图片
     * 1、每页24张图片
     * 2、页数直接递增,通过对link判空来决定是否到达最后一页
     * 3、连接超时：最好设置一下idea科学上网，否则连接wallhaven.cc容易超时
     * 4、
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        Document doc = Jsoup.connect("https://wallhaven.cc/latest?page=2").get();
        Elements pages = doc.select("header.thumb-listing-page-header>h2");
        System.out.println("pages = " + pages); // <h2>Page <span class="thumb-listing-page-num">2</span> / 18179</h2>
        System.out.println("pages.first().val() = " + pages.first().val());

        // Elements links = doc.select("img[data-src]");
        // for (Element link : links) {
        //     System.out.println(link.attr("abs:data-src"));
        //     String url = link.attr("abs:data-src");
        //     String[] urlSplitList = url.split("/");
        //     String name = "wallhaven-" + urlSplitList[urlSplitList.length - 1];
        //     String spec = urlSplitList[urlSplitList.length - 2];
        //     String newUrl = "https://w.wallhaven.cc/full/".concat(spec).concat("/").concat(name);
        //     try {
        //         FileUtils.copyURLToFile(new URL(newUrl), new File("C:\\Users\\Administrator\\Documents\\GitHub\\spring-boot-scaffold\\src\\main\\resources\\img\\" + name));
        //     } catch (FileNotFoundException e) {
        //        log.error( e.getMessage());
        //     }
        // }
    }
}
