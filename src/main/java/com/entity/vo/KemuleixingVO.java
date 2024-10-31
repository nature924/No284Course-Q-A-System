package com.entity.vo;

import com.entity.KemuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 科目类型
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public class KemuleixingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 简要
	 */
	
	private String jianyao;
				
	
	/**
	 * 设置：简要
	 */
	 
	public void setJianyao(String jianyao) {
		this.jianyao = jianyao;
	}
	
	/**
	 * 获取：简要
	 */
	public String getJianyao() {
		return jianyao;
	}
			
}
