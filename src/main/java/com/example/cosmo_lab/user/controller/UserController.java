package com.example.cosmo_lab.user.controller;

//import com.example.cosmo_lab.user.model.dao.UserMapper;
import com.example.cosmo_lab.user.domain.*;
import com.example.cosmo_lab.user.model.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    // 로그 기록용 변수 선언
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // ===== 인덱스 =====
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView Homepage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        return mv;
    }

    // ===== 회원가입 페이지 이동 =====
    @RequestMapping(value="/joinForm", method = RequestMethod.GET)
    private ModelAndView joinForm(@ModelAttribute User user, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("join");
        return mv;
    }

    // ===== 회원가입 처리 =====
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ModelAndView join(@ModelAttribute User user) throws Exception {
        ModelAndView mv = new ModelAndView();

        System.out.println(user.toString());

        userMapper.createAccount(user);
        //User user =
        //int result = userMapper.createAccount(user);
        mv.setViewName("index");

        return mv;
    }

    // ===== 로그인 페이지 이동 =====
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login");
        return mv;
    }

    // ===== 로그인 =====
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

       logger.info("입력 된 아이디 >>> " + user.getId());
       logger.info("입력 된 비밀번호 >>> "  + user.getPw());

        String id = user.getId();
        String pw = user.getPw();

        // 로그인 시도
        User loginInfo = userMapper.login(id, pw);

        if (loginInfo != null && loginInfo.getId() != null) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("isLogOn", true);
            session.setAttribute("userInfo", loginInfo);
            session.setAttribute("userID", id);
            logger.info("로그인 성공!");

            mv.setViewName("redirect:/");
        } else {
            logger.info("로그인 실패");
            String message = "아이디 또는 비밀번호가 잘못 입력되었습니다.";
            mv.addObject("message", message);
            mv.setViewName("login");
        }

        return mv;
    }

    // ===== 로그아웃 =====
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        session.removeAttribute("userID");
        session.invalidate();
        logger.info("세션 삭제");
        logger.info("로그아웃 완료");

        mv.setViewName("redirect:/");
        return mv;
    }

    // ===== 마이페이지 이동 =====
    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Order order) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        //String id = (String) session.getAttribute("userID");
        //int user_id = userMapper.getUserID(id);

        String id = (String) session.getAttribute("userID");
        logger.info("아이디 >>> " + id);

        if (id == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 후 이용해주시기 바랍니다.'); location.href='/loginPage';</script>");
            out.flush();

        } else {
            int user_id = userMapper.getUserID(id);
            logger.info("회원 번호 >>> " + user_id);

            List<Order> orderList = userMapper.OrderList(user_id);
            System.out.println(orderList);
            System.out.println("orderList.size() >>> " + orderList.size());

            mv.addObject("list", orderList);
            mv.addObject("size", orderList.size());
            mv.setViewName("myPage");
        }

        return mv;
    }

    // ===== 회원 탈퇴 페이지 이동 =====
    @RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
    public ModelAndView deletePage(@ModelAttribute Reason reason, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("deleteAccount");
        return mv;
    }

    // ===== 회원 탈퇴 =====
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute Reason reason, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userID"); // 세션에 담긴 아이디 받아오기
        logger.info("세션에 담긴 아이디 >>> " + id);

        if(id == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 후 이용해주시기 바랍니다.'); location.href='/';</script>");
            out.flush();
        } else {
            int user_id = userMapper.getUserID(id); // 아이디로 회원 번호 받아오기
            logger.info("아이디로 찾은 회원 번호 >>> " + user_id);

            String pw = userMapper.getPassword(user_id);
            logger.info("회원 번호로 찾은 비밀번호 >>> " + pw);

            String pwCheck = reason.getPw();
            logger.info("비밀번호 확인 입력 값 >>> " + pwCheck);

            System.out.println("회원 탈퇴 정보 >>> " + reason.toString());

            if(pw.equals(pwCheck)) {
                userMapper.deleteUser(user_id);
                logger.info("회원 탈퇴 성공!");

                mv.setViewName("deleteComplete");
            } else {
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('비밀번호를 확인해주시기 바랍니다.'); location.href='/deleteForm';</script>");
                out.flush();
            }
        }

        return mv;
    }

    // ===== 장바구니 조회 =====
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        //String id = session.getId();
        String id = (String) session.getAttribute("userID");
        logger.info("세션에 저장된 아이디 >>> " + id);

        if(id == null) {
            logger.info("로그인 필요 >>> 장바구니 진입 실패");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 후 이용해주시기 바랍니다.'); location.href='/';</script>");
            out.flush();
            //mv.setViewName("redirect:/");
        } else {
            int user_id = userMapper.getUserID(id);
            logger.info("회원 번호 확인 >>> " + user_id);

            List<Cart> cartList = userMapper.cartList(user_id);
            logger.info("cartList 크기 >>> " + cartList.size());
            mv.addObject("cart", cartList);
            mv.addObject("cartSize", cartList.size());

            for(int i = 0; i < cartList.size(); i++) {
                logger.info("cartList " + i + "번");
                System.out.println(cartList);
            }
           /* if(cartList == null) {
                logger.info("담긴 상품 없음 -> 페이지 처리 어떻게 할까?");
                mv.addObject("cart", cartList);
            } else {
                logger.info("상품 존재!");
                mv.addObject("cart", cartList);
            }*/

            mv.setViewName("cart");
        }


        return mv;
    }

    // ===== 장바구니 물건 삭제 =====
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public ModelAndView deleteProduct(HttpServletRequest requeset) throws Exception {
        ModelAndView mv = new ModelAndView();

        logger.info("deleteProduct 실행");

        HttpSession session = requeset.getSession();
        String id = (String) session.getAttribute("userID");
        logger.info("사용자 아이디 >>> " + id);

        int user_id = userMapper.getUserID(id);
        logger.info("회원 번호 >>> " + user_id);

        String[] ajaxMsg = requeset.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i = 0; i < size; i++) {
            logger.info("ajax >>> " + ajaxMsg[i]);
            int product_id = Integer.parseInt(ajaxMsg[i]);
            userMapper.deleteItem(user_id, product_id);
            logger.info("삭제 완료");
        }


        mv.setViewName("redirect:/cart");

        return mv;
    }

    // ===== 문의 작성 페이지 이동 =====
    @RequestMapping(value = "/qna", method = RequestMethod.GET)
    public ModelAndView qnaPage(HttpServletRequest request, @ModelAttribute Question qna) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        mv.setViewName("qna");
        return mv;
    }

    // ===== 문의 작성 =====
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(HttpServletRequest request, @ModelAttribute Question question) throws Exception {
        ModelAndView mv = new ModelAndView();

        logger.info("문의 작성 페이지 진입");

        HttpSession session = request.getSession();

        String id = (String) session.getAttribute("userID");
        logger.info("아이디 >>> " + id);

        int user_id = userMapper.getUserID(id);
        logger.info("회원 번호 >>> " + user_id);

        String subject = question.getSubject();
        String content = question.getContent();
        logger.info("문의 제목 >>> " + subject);
        logger.info("문의 내용 >>> " + content);

        System.out.println(question.toString());

        userMapper.addQuestion(user_id, subject, content);
        logger.info("문의 성공");
        mv.setViewName("redirect:/qnaList");

        return mv;
    }


    // ===== 문의 내역 페이지 이동 =====
    @RequestMapping(value = "/qnaList", method = RequestMethod.GET)
    public ModelAndView qnaList(HttpServletRequest request, @ModelAttribute Question question) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        String id = (String) session.getAttribute("userID");
        logger.info("아이디 >>> " + id);

        int user_id = userMapper.getUserID(id);

        List<Question> qnaList = userMapper.QuestionList(user_id);
        int qnaSize = qnaList.size();

        mv.addObject("list", qnaList);
        mv.addObject("size", qnaSize);

        System.out.println(qnaList);

        mv.setViewName("qnaList");
        return mv;
    }
}
