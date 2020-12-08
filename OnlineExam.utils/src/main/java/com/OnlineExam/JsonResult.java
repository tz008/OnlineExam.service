package com.OnlineExam;

import com.OnlineExam.annotation.ExceptionCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 自定义统一响应体
 */
@ApiModel
public class JsonResult<T> {
    @ApiModelProperty(value = "状态码", notes = "默认1000是成功")
    private int code;
    @ApiModelProperty(value = "响应信息", notes = "来说明响应情况")
    private String msg;
    @ApiModelProperty(value = "响应的具体数据")
    private T data;


    public JsonResult(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public JsonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public JsonResult(ExceptionCode annotation, T data) {
        this.code = annotation.value();
        this.msg = annotation.message();
        this.data = data;
    }

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(){
       this.code = ResultCode.SUCCESS.getCode();
       this.msg = ResultCode.SUCCESS.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
