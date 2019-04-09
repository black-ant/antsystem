package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.common.AbstractView;
import lombok.Data;

import javax.inject.Named;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 12:34
 * @Version 1.0
 **/
@Named
@Data
public class TestView extends AbstractView {

    Boolean showButtonTrue = Boolean.TRUE;
    Boolean showButtonFalse = Boolean.FALSE;
    String showMessgae;
    int num = 0;

    @Override
    protected void init() {
        showMessgae = "未点击";
    }

    public void testListener() {

        this.showMessgae = "已点击" + (++num);
    }


}
