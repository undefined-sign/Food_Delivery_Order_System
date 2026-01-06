package com.hkd.controller;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.pojo.Car;
import com.hkd.pojo.Member;
import com.hkd.pojo.Person;
import com.hkd.pojo.order_detail;
import com.hkd.pojo.order_header;
import com.hkd.pojo.order_view;
import com.hkd.service.MemberService;
import com.hkd.service.order_detailService;
import com.hkd.service.order_headerService;
import com.hkd.service.order_viewService;

@Controller
public class OrderController {

	@Autowired
	order_headerService ohsi;
	@Autowired
	order_detailService odsi;
	@Autowired
	MemberService msi;
	@Autowired
	order_viewService ovsi;
	//提交订单
	@RequestMapping("/addorder")
	public String addOrder(String address,HttpSession session) {

		//获取用户
		Person person=(Person)session.getAttribute("person");
		Member member=(Member)session.getAttribute("member");

		

		//获取购物车
		if(session.getAttribute("car")!=null) {
			ArrayList<Car> car=(ArrayList<Car>)session.getAttribute("car");

			//产生订单头和订单详情

			order_header oh=new order_header();
			order_detail od=new order_detail();

			oh.setUser_id(person.getUid());
			oh.setAddress(address);

			oh.setOrder_time(LocalDateTime.now());

			//插入数据表
			ohsi.addoh(oh);
			for(Car c:car) {
				
				od.setDish_id(c.getDish_id());
				od.setNum(c.getNum());
				od.setOrder_id(oh.getOrder_id());
				//是否为会员
				if(member!=null) {
				//double运算精度问题
	        	DecimalFormat df = new DecimalFormat("0.00");
	        	String formatted = df.format(c.getPrice()*member.getDiscount_rate());
				od.setPrice(Double.parseDouble(formatted));
				//更新积分
				msi.updatePoints(member.getNumber(),Double.parseDouble(formatted)*c.getNum());

				}else {

					od.setPrice(c.getPrice());
				}

				odsi.addod(od);

			}

			//购物车添加成功后删除所有相关信息，为下一次点单做准备

			session.removeAttribute("car");
			session.removeAttribute("member");

			return "redirect:welcome.jsp";
		}else {
			return "redirect:welcome.jsp";
		}
	}
	
	
	//查看订单头
	@RequestMapping("orderheader")
	public String orderheader(Integer order_header,HttpSession session,HttpServletRequest req) {


				Person person=(Person)session.getAttribute("person");

				//判断是否为查询请求
				if(order_header!=null) {
					//初始化pageno
					session.setAttribute("pageno", 1);

				}


				ArrayList<order_header> ohlist=ohsi.getOrdersByUid(person.getUid());
				//获取记录总数
				int count =ohlist.size();

				//获取flag参数更新pageno
				String flag=req.getParameter("flag");
				int pageno=(int)session.getAttribute("pageno");

				if("up".equals(flag)) {

					if(pageno>1) {

						pageno--;
					}

				}else if("down".equals(flag)) {
					if(pageno<=(count/5)) {
						pageno++;
					}

				}

				//将更新后的pageno重新存入session中
				session.setAttribute("pageno", pageno);

				//根据pageno为前台响应数据
				ArrayList<order_header> ohlist2=null;
				if(pageno<=(count/5)) {
					ohlist2=new ArrayList<>( ohlist.subList((pageno-1)*5, pageno*5));


				}else {

					ohlist2=new ArrayList<>(ohlist.subList((pageno-1)*5, count));
				}

				session.setAttribute("ohlist", ohlist2);
				
					return "redirect:order_header.jsp";
				}		
	
		
	//退单
	@RequestMapping("delorder")
	public String delorder(int order_id,int dish_id) {
		
				odsi.remove(order_id, dish_id);

				return "redirect:orderheader";	
	}
	
	//修改订单状态
	@RequestMapping("updateorderstatus")
	public String updateorderstatus(int order_id,String status) {
		
		ohsi.updateStatus(order_id, status);
		
		return "redirect:doorder";	
	}
	//统计订单
	@RequestMapping("doorder")
	public String doorder(HttpSession session,HttpServletRequest req) {
				
							//是否为post请求
							if(req.getParameter("type")!=null) {
							//获取参数
							int type=Integer.parseInt(req.getParameter("type"));
							session.setAttribute("type", type);
						    //初始化pageno
							session.setAttribute("pageno", 1);
						}
							//取出type
							int type=(int)session.getAttribute("type");
							ArrayList<order_view> ovlist=null;
							//确定哪一种请求
							if(type==1) {
								ovlist=ovsi.getAllOrders();
							}else if(type==2) {
								 ovlist=ovsi.getOrders();

							}else if(type==3) {

								 ovlist=ovsi.getOrdersByTime();
							}else {

								 ovlist=ovsi.getOrdersByDish();

							}
							//获取记录总数
							int count =ovlist.size();

							//获取flag参数更新pageno
							String flag=req.getParameter("flag");
							int pageno=(int)session.getAttribute("pageno");

							if("up".equals(flag)) {

								if(pageno>1) {

									pageno--;
								}

							}else if("down".equals(flag)) {
								if(pageno<=(count/5)) {
									pageno++;
								}

							}

							//将更新后的pageno重新存入session中
							session.setAttribute("pageno", pageno);

							//根据pageno为前台响应数据
							ArrayList<order_view> ovlist2=null;
							if(pageno<=(count/5)) {
								ovlist2=new ArrayList<>( ovlist.subList((pageno-1)*5, pageno*5));


							}else {

								ovlist2=new ArrayList<>(ovlist.subList((pageno-1)*5, count));
							}

							session.setAttribute("ovlist", ovlist2);
							//确定相应给哪个页面
							if(type==1) {
								
								return "redirect:order1.jsp";

							}else if(type==2) {
								return "redirect:order2.jsp";

							}else if(type==3) {

								return "redirect:order3.jsp";
							}else {

								return "redirect:order4.jsp";

							}

						
			}

}

