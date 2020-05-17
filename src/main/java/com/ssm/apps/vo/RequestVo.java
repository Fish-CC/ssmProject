package com.ssm.apps.vo;

import com.ssm.apps.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;


/**
 * 接口返回数据格式
 *
 * @author scott
 * @email jeecgos@163.com
 * @date 2019年1月19日
 */
@Data
@ApiModel(value = "接口返回对象", description = "接口返回对象")
public class RequestVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T RequestVo;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public RequestVo() {

    }

    public RequestVo<T> success(String message) {
        this.message = message;
        this.code = CommonConstant.SC_SERVER_OK_200;
        this.success = true;
        return this;
    }

    public static RequestVo<Object> ok() {
        RequestVo<Object> r = new RequestVo<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_SERVER_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static RequestVo<Object> ok(String msg) {
        RequestVo<Object> r = new RequestVo<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_SERVER_OK_200);
        r.setMessage(msg);
        return r;
    }

    public static RequestVo<Object> ok(Object data) {
        RequestVo<Object> r = new RequestVo<Object>();
        r.setSuccess(true);
        r.setCode(CommonConstant.SC_SERVER_OK_200);
        r.setRequestVo(data);
        return r;
    }

    public static RequestVo<Object> error(String msg) {
        return error(CommonConstant.SC_SERVER_ERROR_500, msg);
    }

    public static RequestVo<Object> error(int code, String msg) {
        RequestVo<Object> r = new RequestVo<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public RequestVo<T> error500(String message) {
        this.message = message;
        this.code = CommonConstant.SC_SERVER_ERROR_500;
        this.success = false;
        return this;
    }
}
