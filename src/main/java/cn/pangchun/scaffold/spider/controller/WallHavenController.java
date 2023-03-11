package cn.pangchun.scaffold.spider.controller;

import cn.pangchun.scaffold.spider.service.WallHavenService;
import cn.pangchun.scaffold.support.response.CommonResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * WallHavenController
 * 1. 本地调试接口需要为idea设置科学上网代理，因为wallhaven是国外网站
 *
 * @author pangchun
 * @since 2023/3/11
 */
@Api(tags = "WallHaven图片爬取API")
@Validated
@RestController
@RequestMapping("/wallHaven")
@CommonResponseBody
public class WallHavenController {

    @Resource
    private WallHavenService wallHavenService;

    @ApiOperation("抓取首页的图片链接")
    @GetMapping("/crawlHome")
    public List<String> crawlHome() {
        return wallHavenService.crawlHome();
    }

    @ApiOperation("抓取最近的图片链接")
    @GetMapping("/crawlLatest/{page}")
    public List<String> crawlLatest(@PathVariable @Min(value = 1) Integer page) {
        return wallHavenService.crawlLatest(page);
    }

    @ApiOperation("抓取热门的图片链接")
    @GetMapping("/crawlTopList/{page}")
    public List<String> crawlTopList(@PathVariable @Min(value = 1) Integer page) {
        return wallHavenService.crawlTopList(page);
    }

    @ApiOperation("抓取随机的图片链接")
    @GetMapping("/crawlRandom/{page}")
    public List<String> crawlRandom(@PathVariable @Min(value = 1) Integer page) {
        return wallHavenService.crawlRandom(page);
    }
}
