package stu.activityservice.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import stu.activityservice.DTO.CompetitionDTO;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionWebcrawler {

    public List<CompetitionDTO> fetchCompetition() {
        List<CompetitionDTO> competitions = new ArrayList<>();
        try {
            for(int i = 0; i <9;i++) {
                // 爬取网页
                String url = "http://bisai.172xiaoyuan.com/plus/arcmulti.php?mtype=&pnum=" + i + "&tagid=index";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("div#x");
                System.out.println(elements);
                // 遍历每个比赛信息并提取内容
                for (Element element : elements) {
                    // 提取比赛的标题
                    String title = element.select("div#z ul li:first-of-type a").text();
                    // 提取比赛的链接（href属性）
                    String link = "http://bisai.172xiaoyuan.com" + element.select("div#p a").attr("href");
                    // 提取比赛日期
                    String date = element.select("div#z ul li#t span").text().split(" ")[1];
                    // 提取比赛的描述
                    String description = element.select("div#z ul p").text();
                    String picture = "http://bisai.172xiaoyuan.com" + element.select("div#p img").attr("src");

                    // 将数据封装到 CompetitionDTO 对象中
                    CompetitionDTO competitionDTO = new CompetitionDTO(title, picture, description, link, date);
                    competitions.add(competitionDTO);
                    System.out.println(competitionDTO);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return competitions;
    }
}
