package com.hkd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.pojo.Dish;
import com.hkd.service.DishService;
import com.hkd.service.DishServiceImp;

@Controller
public class DishController {
	
	@Autowired
	DishService dsi;
//按照类别进行查找	
	@RequestMapping("/dodishes")
	public String dodishes(String Category,HttpServletRequest request) {
		
				//获取session对象
				HttpSession session =request.getSession();
//System.out.println(Category);
				//判断是否为查询请求
				if(Category!=null) {
					//获取餐品类别编号
					int cid=Integer.parseInt(Category);
					//存放在session中，供上下页操作时使用
					session.setAttribute("cid", cid);
					//初始化pageno
					session.setAttribute("pageno", 1);

				}
				//取出cid
				int cid=(int)session.getAttribute("cid");
				ArrayList<Dish> dlist1=dsi.getDishesByCid(cid);
				//获取记录总数
				int count =dlist1.size();

				//获取flag参数更新pageno
				String flag=request.getParameter("flag");
				int pageno=(int)session.getAttribute("pageno");

				if("up".equals(flag)) {

					if(pageno>1) {

						pageno--;
					}

				}else if("down".equals(flag)) {
					
					//可以多一个空白页，但不会少一条数据
					if(pageno<=(count/5)) {
						pageno++;
					}

				}

				//将更新后的pageno重新存入session中
				session.setAttribute("pageno", pageno);

				//根据pageno为前台响应数据
				ArrayList<Dish> dlist2=null;
				if(pageno<=(count/5)) {
					dlist2=new ArrayList<>( dlist1.subList((pageno-1)*5, pageno*5));


				}else {

					dlist2=new ArrayList<>(dlist1.subList((pageno-1)*5, count));
				}

				session.setAttribute("dlist", dlist2);
		
				//根据flag确定相应给用户还是商家的dishes页面
				if("0".equals(request.getParameter("sign"))) {
					
					return "dishes";
				}else {
					return "dishes2";
				}
				
				
	}
	
	//修改菜品信息
	@RequestMapping("/updatedish")
	public String updatedish(Dish dish) {
		
		//调用service层的修改方法
		dsi.updateDish(dish);
		
		return "redirect:dodishes";	
	}
	
	//添加菜品
	@RequestMapping("/adddish")
	public String adddish(Dish dish) {
		System.out.println(dish);
		//调用service层的添加方法
		dsi.addDish(dish);
		
		return "redirect:dodishes";	
	}
	
	
	//搜索
	
	@RequestMapping("/dosearch")
	public String searchdish(String search,HttpServletRequest request) {
		
		//获取session对象
		HttpSession session =request.getSession();
		
       //先判断是否是表单请求，如果是，获取请求数据，并存储在session中
       if(request.getParameter("search")!=null){
    	   
      	 session.setAttribute("search", search);
      	 //pageno进行初始化
      	 session.setAttribute("pageno", 1);

       }


       //取出search

       String search2=(String)session.getAttribute("search");
       //查询条目
       int count =dsi.count(search2);


  	   int pageno=(int)session.getAttribute("pageno");
  	   String flag=request.getParameter("flag");

  	   if("up".equals(flag)){
  		   if(pageno>1) {
			pageno--;
		}

  	   }else if("down".equals(flag)){

  		   if(pageno<=(count/5)) {
			pageno++;
		}
  	   }

  	   session.setAttribute("pageno", pageno);


//  	   System.out.println("**"+search+"**");
     /*查询数据存储session中*/

     ArrayList<Dish> dlist=new ArrayList();
     dlist=dsi.getDishesBypage(search2, (pageno-1)*5);

  	session.setAttribute("dlist2",dlist);

 			return "redirect:search.jsp";
		
	}

}