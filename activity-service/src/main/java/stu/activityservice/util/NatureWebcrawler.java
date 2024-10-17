package stu.activityservice.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import stu.activityservice.entity.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class NatureWebcrawler implements WebCrawler {
    @Override
    public List<Activity> fetchActivities() {
        List<Activity> activities = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://syw.ctgu.edu.cn/xsyw.htm").get();
            System.out.println(doc);
            Elements elements = doc.select("div.wz_list li a");
            for (Element element : elements) {
                String date = element.select("span").text();
                String title = element.select("a").text();
                String link = element.select("a").attr("href");
                activities.add(new Activity(date, title, link));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activities;
    }
}
