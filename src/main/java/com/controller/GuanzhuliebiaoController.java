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

import com.entity.GuanzhuliebiaoEntity;
import com.entity.view.GuanzhuliebiaoView;

import com.service.GuanzhuliebiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 关注列表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
@RestController
@RequestMapping("/guanzhuliebiao")
public class GuanzhuliebiaoController {
    @Autowired
    private GuanzhuliebiaoService guanzhuliebiaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuanzhuliebiaoEntity guanzhuliebiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoshi")) {
			guanzhuliebiao.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			guanzhuliebiao.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuanzhuliebiaoEntity> ew = new EntityWrapper<GuanzhuliebiaoEntity>();
		PageUtils page = guanzhuliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guanzhuliebiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuanzhuliebiaoEntity guanzhuliebiao, HttpServletRequest request){
        EntityWrapper<GuanzhuliebiaoEntity> ew = new EntityWrapper<GuanzhuliebiaoEntity>();
		PageUtils page = guanzhuliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guanzhuliebiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuanzhuliebiaoEntity guanzhuliebiao){
       	EntityWrapper<GuanzhuliebiaoEntity> ew = new EntityWrapper<GuanzhuliebiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guanzhuliebiao, "guanzhuliebiao")); 
        return R.ok().put("data", guanzhuliebiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuanzhuliebiaoEntity guanzhuliebiao){
        EntityWrapper< GuanzhuliebiaoEntity> ew = new EntityWrapper< GuanzhuliebiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guanzhuliebiao, "guanzhuliebiao")); 
		GuanzhuliebiaoView guanzhuliebiaoView =  guanzhuliebiaoService.selectView(ew);
		return R.ok("查询关注列表成功").put("data", guanzhuliebiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuanzhuliebiaoEntity guanzhuliebiao = guanzhuliebiaoService.selectById(id);
        return R.ok().put("data", guanzhuliebiao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuanzhuliebiaoEntity guanzhuliebiao = guanzhuliebiaoService.selectById(id);
        return R.ok().put("data", guanzhuliebiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuanzhuliebiaoEntity guanzhuliebiao, HttpServletRequest request){
    	guanzhuliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guanzhuliebiao);
        guanzhuliebiaoService.insert(guanzhuliebiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuanzhuliebiaoEntity guanzhuliebiao, HttpServletRequest request){
    	guanzhuliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guanzhuliebiao);
        guanzhuliebiaoService.insert(guanzhuliebiao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GuanzhuliebiaoEntity guanzhuliebiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guanzhuliebiao);
        guanzhuliebiaoService.updateById(guanzhuliebiao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guanzhuliebiaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GuanzhuliebiaoEntity> wrapper = new EntityWrapper<GuanzhuliebiaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoshi")) {
			wrapper.eq("laoshizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = guanzhuliebiaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
