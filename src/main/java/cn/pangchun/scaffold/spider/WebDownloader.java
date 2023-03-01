package cn.pangchun.scaffold.spider;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 下载网络图片
 */
public class WebDownloader extends Thread {

    private String url; //网络图片地址
    private String name; //保存的文件名

    public WebDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void download(String url, String name) throws IOException {
        // IOUtils.copy(new URL(url), new File(name));
        FileUtils.copyURLToFile(new URL(url), new File(name), 8000000, 4000000);

        // IOUtils.copy(new URL(url), new File(name));

    }

    @Override
    public void run() {
        try {
            download(url, name);
            System.out.println("下载文件名为： " + name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载异常");
        }
    }
}
