package com.chenle.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

//"id": "1248244730181488641",
//        "parentId": "1080756158205726721",
//        "categoryName": "龙果充值系统",
//        "remark": "龙果充值系统",
//        "list": []
@Data
public class CourseVo {
    Integer id;
    Integer parentId;
    String categoryName;
    String remark;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CourseVo> list;
}
