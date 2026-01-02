package com.hkd.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.pojo.Member;
import com.hkd.service.MemberService;
import com.hkd.service.MemberServiceImp;

@Controller
public class MemberController {

	@Autowired
	MemberService msi;
	
//会员查询	
	@RequestMapping("/membersearch")
	public String membersearch(String number,HttpSession session,HttpServletRequest request) {
		
		//获取前台卡号
		//防止空指针
		if(!("".equals(number))&&number!=null) {

		Member member=msi.getMemberByid(Integer.parseInt(number));

		//取出原价
		//此处的处理注意
		double sum=Double.parseDouble(session.getAttribute("sum").toString()) ;

        if(member!=null) {
        	//是会员，有优惠
        	request.setAttribute("member_info","是会员" );
        	//double运算精度问题
        	DecimalFormat df = new DecimalFormat("0.00");
        	String formatted = df.format(sum*member.getDiscount_rate());
        	request.setAttribute("discount_sum", formatted);
        	//存入会员对象
        	session.setAttribute("member", member);


        }else {
        	//不是会员，无优惠
        	request.setAttribute("member_info","不是会员" );
        	request.setAttribute("discount_sum", sum);
        }
	}else {
		//刷新操作
		session.removeAttribute("member");
	}	
		
		return "car";
	}

	
//查看所有会员
	@RequestMapping("/domember")	
	public String allmembers(HttpServletRequest req,HttpSession session) {
	
				//获取person对象
				if(session.getAttribute("person")!=null) {
				//判断是否为查询请求
				if(req.getParameter("member")!=null) {
					//初始化pageno
					session.setAttribute("pageno", 1);

				}

				ArrayList<Member> mlist=msi.getAllMembers();
				//获取记录总数
				int count =mlist.size();

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
				ArrayList<Member> mlist2=null;
				if(pageno<=(count/5)) {
					mlist2=new ArrayList<>( mlist.subList((pageno-1)*5, pageno*5));


				}else {

					mlist2=new ArrayList<>(mlist.subList((pageno-1)*5, count));
				}

				session.setAttribute("mlist", mlist2);
				
					return "redirect:member.jsp";
				}else {
					return "redirect:login.jsp";

				}	
		
	}
	
//添加一个会员
	@RequestMapping("addmember")
	
	public String addmember(String tel) {
		System.out.println(tel);
		msi.addMember(tel);
		return "redirect:domember?member=''";
	}
	
}
