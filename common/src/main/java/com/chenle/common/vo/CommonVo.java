package com.chenle.common.vo;

import lombok.Data;

/**
 * name:'Taylor Swift',
 *           id:19891221,
 *           headImg:'https://ae01.alicdn.com/kf/H94c78935ffa64e7e977544d19ecebf06L.jpg',
 *           comment:'我发行了我的新专辑Lover',
 *           time:'2019年9月16日 18:43',
 *           like:5,
 *           inputShow:false,
 */
@Data
public class CommonVo {
    private Integer id;
    private String name;
    private String headImg;
    private String comment;
    private String time;
    private Integer like;
    private Boolean inputShow;
}
