package com.entity.view;

import com.entity.GuanzhuliebiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 关注列表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
@TableName("guanzhuliebiao")
public class GuanzhuliebiaoView  extends GuanzhuliebiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuanzhuliebiaoView(){
	}
 
 	public GuanzhuliebiaoView(GuanzhuliebiaoEntity guanzhuliebiaoEntity){
 	try {
			BeanUtils.copyProperties(this, guanzhuliebiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
