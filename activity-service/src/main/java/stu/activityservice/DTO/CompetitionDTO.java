package stu.activityservice.DTO;

import lombok.*;

@Setter
@Data
@AllArgsConstructor@Getter
@NoArgsConstructor
public class CompetitionDTO {
    private String title;
    private String pictureUrl;
    private String description;
    private String link;
    private String date;

}
