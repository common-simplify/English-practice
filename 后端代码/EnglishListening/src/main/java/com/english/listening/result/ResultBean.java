package com.english.listening.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象包装类(带泛型)
 * @author Gentle
 */
@Data
public class ResultBean<T> implements Serializable {

   private static final long serialVersionUID = 1L;

   public static final int NO_LOGIN = -1;

   public static final int SUCCESS = 0;

   public static final int CHECK_FAIL = 1;

   public static final int NO_PERMISSION = 2;

   public static final int UNKNOWN_EXCEPTION = -99;

   /**
    * 返回的信息(主要出错的时候使用)
    */
   private String msg = "success";

   /**
    * 接口返回码, 0表示成功, 其他看对应的定义
    * 0   : 成功
    * >0 : 表示已知的异常(例如提示错误等, 需要调用地方单独处理) 
    * <0 : 表示未知的异常(不需要单独处理, 调用方统一处理)
    */

   private int code = SUCCESS;

   @JsonInclude(JsonInclude.Include.NON_NULL)
   private int count;

   /**
    * 路径
    */
   @JsonInclude(JsonInclude.Include.NON_NULL)
   private String path;

   /**
    * 返回的数据
    */
   @JsonInclude(JsonInclude.Include.NON_NULL)
   private T data;

   public ResultBean() {
      super();
   }

   public ResultBean(T data) {
      super();
      this.data = data;
   }
   public ResultBean(T data,String path){
      super();
      this.data = data;
      this.path = path;
   }
   public ResultBean(int code,String msg){
      super();
      this.code = code;
      this.msg = msg;
   }
   public ResultBean(String msg,T data){
      super();
      this.data = data;
      this.msg = msg;
   }
    public ResultBean(T data,int count){
        super();
        this.data = data;
        this.count = count;
    }
   public ResultBean(Throwable e) {
      super();
      this.msg = e.toString();
      this.code = UNKNOWN_EXCEPTION;
   }
}