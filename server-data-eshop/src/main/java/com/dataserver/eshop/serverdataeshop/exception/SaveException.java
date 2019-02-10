package com.dataserver.eshop.serverdataeshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 20:16
 * @Version 1.0
 **/
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason = "保存失败")
public class SaveException extends  RuntimeException {


}
