package com.baeksoo.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString//함수에서 tostring()을 사용할 수 있게 해줌. tostring은 테이블 내의 오브젝트를 출력했을 떄 데이터 값을 보여주는 함수.
@Getter
@Setter
@Table(indexes = @Index(columnList = "T=title", name = "titleIndex"))
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer price;
    private String username;
    private String img;
}