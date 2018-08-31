package cn.edu.glut.util;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;




/**
 * 响应对象通用类
 * @author Kuang
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }
    //设置字段的get方法给sprimgmvc获取
    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    /**
     * 创建只含成功码的响应对象
     * @return 响应成功的对象
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    /**
     * 创建含成功码和消息的响应对象
     * @param msg
     * @return 响应成功的对象
     */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    /**
     *创建含成功码和数据的响应对象 
     * @param data
     * @return 响应成功的对象
     */
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    /**
     *创建含成功码和数据以及数据的响应对象  
     * @param msg
     * @param data
     * @return 响应成功的对象
     */
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    /**
     * 创建含失败码的响应对象
     * @return 创建失败响应的方法
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     * 创建含失败码和失败信息的响应对象
     * @param errorMessage
     * @return 创建失败响应的方法
     */
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    /**
     * 创建含失败码和失败信息的响应对象
     * @param errorCode （自定义的错误码）
     * @param errorMessage
     * @return 创建失败响应的方法
     */
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
}
