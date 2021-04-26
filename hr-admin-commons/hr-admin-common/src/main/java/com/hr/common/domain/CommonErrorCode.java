package com.hr.common.domain;

/**
 * @author yuelimin
 * @description 枚举一些常用状态码以及提示信息
 * @since 1.8
 */
public enum CommonErrorCode implements ErrorCode {
    /**
     * 枚举的一些状态码以及提示信息
     */
    SUCCESS(true, "00000", "操作成功"),
    USER_NOT_EXISTS(false, "A0201", "账户不存在"),
    USER_NOT_ACTIVE(false, "A0202", "账户冻结"),
    PASSWORD_ERROR(false, "A0210", "密码错误"),
    UNAUTHORIZED(false, "A0301", "访问未授权"),
    AUTHORIZATION_EXPIRES(false, "A0311", "授权过期"),
    WITHOUT_PERMISSION(false, "A0312", "无权限使用API"),
    AUTHORIZATION_ERROR(false, "A0340", "用户签名异常"),
    FAILED(false, "B0001", "系统执行失败"),
    VALIDATE_FAILED(false, "B0002", "参数校验失败"),
    CHILDREN_FAILED(false, "B0003", "存在子节点, 操作失败"),
    AUDIT_FAILED(false, "B0004", "审核未通过或未审核"),
    UNKNOWN_ERROR(false, "B0300", "系统资源异常"),
    NOT_FOUND(false, "B0404", "对象丢失"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(false, "B0405", "请求方法不支持"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED(false, "B0415", "不支持媒体类型"),
    REMOTE_ERROR(false, "C0001", "第三方调用错误");

    private boolean flag;
    private String code;
    private String message;

    private CommonErrorCode(boolean flag, String code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean getFlag() {
        return flag;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}


