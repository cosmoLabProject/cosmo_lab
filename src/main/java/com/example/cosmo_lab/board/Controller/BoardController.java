//package com.example.cosmo_lab.board.Controller;
//
//
//
//import com.example.cosmo_lab.board.Service.BoardService;
//import com.example.cosmo_lab.item.dto.Item;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;

//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class BoardController {
//
//    @Autowired
//    private BoardService boardService;
//
//    @RequestMapping("/board/list")
//    public String boardList(Model model, @PageableDefault(page = 0, size = 8,sort = "product_id", direction = Sort.Direction.DESC)Pageable pageable){
//
//        Page<Item> list = boardService.boardList(pageable);
//
//        int nowPage = list.getPageable().getPageNumber();
//        int startPage = Math.max(nowPage - 4, 1);
//        int endPage = Math.min(nowPage + 5,list.getTotalPages());
//
//        model.addAttribute("list", list);
//        model.addAttribute("nowPage",nowPage);
//        model.addAttribute("startPage",startPage);
//        model.addAttribute("endPage",endPage);
//
//
//        return "liplist";
//    }
//}
