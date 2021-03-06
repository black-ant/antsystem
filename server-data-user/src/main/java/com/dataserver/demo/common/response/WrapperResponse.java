package com.dataserver.demo.common.response;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/27 19:20
 * @Version 1.0
 **/
public class WrapperResponse {

    private WrapperResponse() {
    }

    public static <E> Wrapper<E> wrap(int code, String message, E o) {
        return new Wrapper<>(code, message, o);
    }

    public static <E> Wrapper<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }

    public static <E> Wrapper<E> wrap(int code) {
        return wrap(code, null);
    }

    public static <E> Wrapper<E> wrap(Exception e) {
        return new Wrapper<>(Wrapper.ERROR_CODE, e.getMessage());
    }

    public static <E> E unWrap(Wrapper<E> wrapper) {
        return wrapper.getResult();
    }

    public static <E> Wrapper<E> illegalArgument() {
        return wrap(Wrapper.ILLEGAL_CODE, Wrapper.ILLEGAL_MESSAGE);
    }

    public static <E> Wrapper<E> ok() {
        return new Wrapper<>();
    }


}
