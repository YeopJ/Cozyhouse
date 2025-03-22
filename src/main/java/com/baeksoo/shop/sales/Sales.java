package com.baeksoo.shop.sales;

import com.baeksoo.shop.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Integer price;
    private Integer count;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT ) )//fk제약사항없음
    private Member member;

    @CreationTimestamp //행 추가시 자동으로 created 데이터 추가
    private LocalDateTime created;
}
