package com.baeksoo.shop.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findPageBy(Pageable page);
    //Page 사용시 전체 행 개수 계산하는 SQL 코드실행되는데 이거 싫으면 Slice 사용. 단 전체 행 개수, 페이지같은거 안알려줌
    //Slice<Item> findPageBy(Pageable page);

    List<Item> findAllByTitleContains(String title);
    //title 포함한 컬럼 탖아서 리턴하는 함수
    @Query(value = "select * from item where match(title) against(?1)", nativeQuery = true)
    List<Item> rawQuery1(String text);
    //full text index로 찾아서 리턴하는 함수
}
