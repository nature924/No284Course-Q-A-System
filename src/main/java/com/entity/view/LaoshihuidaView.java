package com.entity.view;

import com.entity.LaoshihuidaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 老师回答
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
@TableName("laoshihuida")
public class LaoshihuidaView  extends LaoshihuidaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaoshihuidaView(){
	}
 
 	public LaoshihuidaView(LaoshihuidaEntity laoshihuidaEntity){
 	try {
			BeanUtils.copyProperties(this, laoshihuidaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
