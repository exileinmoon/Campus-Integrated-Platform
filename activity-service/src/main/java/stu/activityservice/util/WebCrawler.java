package stu.activityservice.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import stu.activityservice.entity.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface WebCrawler {

    public List<Activity> fetchActivities();
}

// 创建活动类