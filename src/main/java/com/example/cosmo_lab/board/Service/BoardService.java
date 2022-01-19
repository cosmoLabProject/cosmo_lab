//package com.example.cosmo_lab.board.Service;
//
//
//import com.example.cosmo_lab.board.Repository.ItemRepository;
//import com.example.cosmo_lab.item.dto.Item;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BoardService {
//
//
//    private final ItemRepository itemRepository;
//
//    public BoardService(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    //게시글 리스트 처리
//    public Page<Item> boardList(Pageable pageable) {
//        return itemRepository.findAll(pageable);
//    }
//
//}
