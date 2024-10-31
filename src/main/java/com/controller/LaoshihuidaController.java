package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LaoshihuidaEntity;
import com.entity.view.LaoshihuidaView;

import com.service.LaoshihuidaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 老师回答
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
@RestController
@RequestMapping("/laoshihuida")
public class LaoshihuidaController {
    @Autowired
    private LaoshihuidaService laoshihuidaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LaoshihuidaEntity laoshihuida,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			laoshihuida.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laoshi")) {
			laoshihuida.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LaoshihuidaEntity> ew = new EntityWrapper<LaoshihuidaEntity>();
		PageUtils page = laoshihuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laoshihuida), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LaoshihuidaEntity laoshihuida, HttpServletRequest request){
        EntityWrapper<LaoshihuidaEntity> ew = new EntityWrapper<LaoshihuidaEntity>();
		PageUtils page = laoshihuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laoshihuida), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LaoshihuidaEntity laoshihuida){
       	EntityWrapper<LaoshihuidaEntity> ew = new EntityWrapper<LaoshihuidaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( laoshihuida, "laoshihuida")); 
        return R.ok().put("data", laoshihuidaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LaoshihuidaEntity laoshihuida){
        EntityWrapper< LaoshihuidaEntity> ew = new EntityWrapper< LaoshihuidaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( laoshihuida, "laoshihuida")); 
		LaoshihuidaView laoshihuidaView =  laoshihuidaService.selectView(ew);
		return R.ok("查询老师回答成功").put("data", laoshihuidaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LaoshihuidaEntity laoshihuida = laoshihuidaService.selectById(id);
		laoshihuida.setClicknum(laoshihuida.getClicknum()+1);
		laoshihuidaService.updateById(laoshihuida);
        return R.ok().put("data", laoshihuida);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LaoshihuidaEntity laoshihuida = laoshihuidaService.selectById(id);
		laoshihuida.setClicknum(laoshihuida.getClicknum()+1);
		laoshihuidaService.updateById(laoshihuida);
        return R.ok().put("data", laoshihuida);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        LaoshihuidaEntity laoshihuida = laoshihuidaService.selectById(id);
        if(type.equals("1")) {
        	laoshihuida.setThumbsupnum(laoshihuida.getThumbsupnum()+1);
        } else {
        	laoshihuida.setCrazilynum(laoshihuida.getCrazilynum()+1);
        }
        laoshihuidaService.updateById(laoshihuida);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LaoshihuidaEntity laoshihuida, HttpServletRequest request){
    	laoshihuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laoshihuida);
        laoshihuidaService.insert(laoshihuida);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LaoshihuidaEntity laoshihuida, HttpServletRequest request){
    	laoshihuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laoshihuida);
        laoshihuidaService.insert(laoshihuida);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshihuidaEntity laoshihuida, HttpServletRequest request){
        //ValidatorUtils.validateEntity(laoshihuida);
        laoshihuidaService.updateById(laoshihuida);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        laoshihuidaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LaoshihuidaEntity> wrapper = new EntityWrapper<LaoshihuidaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laoshi")) {
			wrapper.eq("laoshizhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = laoshihuidaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
