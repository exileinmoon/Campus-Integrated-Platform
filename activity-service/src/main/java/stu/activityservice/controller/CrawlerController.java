package stu.activityservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stu.activityservice.DTO.CompetitionDTO;
import stu.activityservice.entity.Activity;
import stu.activityservice.util.CompetitionWebcrawler;
import stu.activityservice.util.NewsWebcrawler;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class CrawlerController {

    @GetMapping("/crawl/news")
    public List<List<Activity>> crawlDataNews() {
        return new NewsWebcrawler().fetchActivities();
    }

    @GetMapping("/crawl/compepitition")
    public List<CompetitionDTO> crawlDataCompepition() {
        return new CompetitionWebcrawler().fetchCompetition();
    }


//    @GetMapping("/api/activity/crawl/peoples")
//    public List<Activity> crawlDataPeoples() {
//        return new PeoplesWebcrawler().fetchActivities();
//    };
//    @GetMapping("/api/activity/crawl/nature")
//    public List<Activity> crawlDataNatures() {
//        return new NatureWebcrawler().fetchActivities();
//    }
}