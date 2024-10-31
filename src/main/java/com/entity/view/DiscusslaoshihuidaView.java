package com.entity.view;

import com.entity.DiscusslaoshihuidaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 老师回答评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
@TableName("discusslaoshihuida")
public class DiscusslaoshihuidaView  extends DiscusslaoshihuidaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusslaoshihuidaView(){
	}
 
 	public DiscusslaoshihuidaView(DiscusslaoshihuidaEntity discusslaoshihuidaEntity){
 	try {
			BeanUtils.copyProperties(this, discusslaoshihuidaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
