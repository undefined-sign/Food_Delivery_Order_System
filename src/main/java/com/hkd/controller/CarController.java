package com.hkd.controller;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.pojo.Car;
import com.hkd.pojo.Member;
import com.hkd.pojo.Person;
import com.hkd.pojo.order_detail;
import com.hkd.pojo.order_header;
import com.hkd.service.CarService;
import com.hkd.service.MemberService;
import com.hkd.service.MemberServiceImp;
import com.hkd.service.order_detailService;
import com.hkd.service.order_headerService;

@Controller
public class CarController {

	@Autowired
	CarService csi;

	
	//添加购物车
	@RequestMapping("/addcar")
	public String addcar(int dish_id,HttpSession session) {
		
		//获取car对象
		Car car=csi.getCarByid(dish_id);
		
		//创建购物车对象
		ArrayList<Car> clist=null;
		
		//判断session中是否存在car
		if (session.getAttribute("car")==null) {
			
			clist=new ArrayList<Car>();
			clist.add(car);
			session.setAttribute("car", clist);
		}else {
			clist=(ArrayList<Car>)session.getAttribute("car");
			//调用service层的添加方法
			csi.addCar(dish_id, clist);
			session.setAttribute("car", clist);
		}
		
		return "redirect:dishes.jsp";	
	}
	
	//删除购物车
	@RequestMapping("/delcar")
	public String delcar(int dish_id,HttpSession session) {
		
		//获取car
		ArrayList<Car> clist=(ArrayList<Car>)session.getAttribute("car");
		
		//调用service层的删除方法
		csi.removeCar(dish_id, clist);
		
		//重新存放session
		session.setAttribute("car", clist);
		
		return "redirect:car.jsp";	
	}
	
	//修改购物车
	@RequestMapping("/updatecar")
	public String updatecar(int dish_id,int num,HttpSession session) {
		
		//获取car
		ArrayList<Car> clist=(ArrayList<Car>)session.getAttribute("car");
		
		//创建car对象
		Car car=new Car();
		car.setDish_id(dish_id);
		car.setNum(num);
		
		//调用service层的修改方法
		csi.updateCar(car, clist);
		
		//重新存放session
		session.setAttribute("car", clist);
		
		return "redirect:car.jsp";	
	}	
	
	
	
}
