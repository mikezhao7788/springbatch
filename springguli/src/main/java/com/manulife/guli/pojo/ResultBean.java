package com.manulife.guli.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 封装统一返回结果信息
 * @param <T>
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {
    private  String status;
    private  T data;

}
