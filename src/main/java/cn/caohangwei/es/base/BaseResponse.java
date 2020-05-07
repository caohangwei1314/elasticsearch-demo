package cn.caohangwei.es.base;


import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class BaseResponse<T> {
    public enum CodeEnum {
        TRUE(0, "请求成功"),
        FALSE(1, "请求失败，请联系平台技术支持");

        private int code;

        private String msg;

        CodeEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    private Integer code;

    private String msg;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BaseResponse createSuccessBaseResponse(){
        return new BaseResponse().setCode(CodeEnum.TRUE.code).setMsg(CodeEnum.TRUE.getMsg());
    }

    public static BaseResponse createSuccessBaseResponse(Object object){
        return new BaseResponse().setCode(CodeEnum.TRUE.code).setMsg(CodeEnum.TRUE.getMsg()).setData(object);
    }

    public static BaseResponse createErrorBaseResponse(){
        return new BaseResponse().setCode(CodeEnum.FALSE.code).setMsg(CodeEnum.FALSE.getMsg());
    }

}

