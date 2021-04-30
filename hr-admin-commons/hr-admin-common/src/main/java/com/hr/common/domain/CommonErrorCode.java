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
    USER_EXISTS(false, "A0111", "用户名已存在"),
    USER_NOT_EXISTS(false, "A0201", "账户不存在"),
    USER_NOT_ACTIVE(false, "A0202", "账户冻结"),
    PASSWORD_ERROR(false, "A0210", "密码错误"),
    UNAUTHORIZED(false, "A0301", "访问未授权"),
    WITHOUT_PERMISSION(false, "A0312", "无权限使用API"),
    VALIDATE_INPUT(false, "A0402", "无效的用户输入"),
    SYSTEM_EXECUTION_TIMEOUT(false, "B0100", "系统执行超时"),
    SYSTEM_RESOURCE_ERROR(false, "B0300", "系统资源异常"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(false, "B0405", "请求方法不支持"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED(false, "B0415", "不支持媒体类型"),
    API_NOT_EXIST(false, "C0113", "接口不存在"),
    ;

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


