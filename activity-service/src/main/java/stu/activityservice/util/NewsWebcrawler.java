package stu.activityservice.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import stu.activityservice.entity.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsWebcrawler   {
    public List<List<Activity>> fetchActivities() {
        List<List<Activity>> activities = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://syw.ctgu.edu.cn/xxyw.htm").get();
            System.out.println(doc);
            Elements elements = doc.select("ul.wz_list li");
            List<Activity> activitie = new ArrayList<>();
            for (Element element : elements) {
                String date = element.select("span").text();
                String title = element.select("a").text();
                String link ="https://syw.ctgu.edu.cn/"+element.select("a").attr("href");
                activitie.add(new Activity(date, title, link));
            }
            activities.add(activitie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Document doc = Jsoup.connect("https://syw.ctgu.edu.cn/zhxw.htm").get();
            System.out.println(doc);
            Elements elements = doc.select("ul.wz_list li");
            List<Activity> activitie = new ArrayList<>();
            for (Element element : elements) {
                String date = element.select("span").text();
                String title = element.select("a").text();
                String link ="https://syw.ctgu.edu.cn/"+element.select("a").attr("href");
                activitie.add(new Activity(date, title, link));
            }
            activities.add(activitie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Document doc = Jsoup.connect("https://syw.ctgu.edu.cn/xyrw.htm").get();
            System.out.println(doc);
            Elements elements = doc.select("ul.wz_list li");
            List<Activity> activitie = new ArrayList<>();
            for (Element element : elements) {
                String date = element.select("span").text();
                String title = element.select("a").text();
                String link ="https://syw.ctgu.edu.cn/"+element.select("a").attr("href");
                activitie.add(new Activity(date, title, link));
            }
            activities.add(activitie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activities;
    }
}