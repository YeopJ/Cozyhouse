package com.baeksoo.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    //public List<Item> findAllItems;

    public void saveItem(String title, Integer price, String img, String username){
        //새로운 item 객체를 생성하고 데이터들을 저장
        Item newitem = new Item();
        newitem.setTitle(title);
        newitem.setPrice(price);
        newitem.setImg(img);
        newitem.setUsername(username);
        //데이터베이스에 저장
        itemRepository.save(newitem);
    }

    public void updateItem(Long id, String title, Integer price) throws Exception {
        //데이터 수정하는 코드
        Optional<Item> item = itemRepository.findById(id);
        if(title.length() >= 100 || price < 0){
            throw new Exception();
        }

        if (item.isPresent()) {
            Item newitem = item.get();
            newitem.setTitle(title);
            newitem.setPrice(price);

            itemRepository.save(newitem);
        } else {
            //예외처리
            throw new Exception();
        }
    }

    public List<Item> findAllItem(){
        return itemRepository.findAll();
    }


}
