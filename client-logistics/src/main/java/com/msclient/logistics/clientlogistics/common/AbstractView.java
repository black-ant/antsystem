package com.msclient.logistics.clientlogistics.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@ViewScoped
public abstract class AbstractView {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void postConstruct() {
        init();
    }

    /**
     * @PostConstruct 初始化方法, 在构造方法之前执行
     */
    protected abstract void init();
}
