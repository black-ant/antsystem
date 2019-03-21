package com.msclient.logistics.clientlogistics.view;

import com.msclient.logistics.clientlogistics.entity.Info;
import com.msclient.logistics.clientlogistics.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/21 23:13
 * @Version 1.0
 **/
@Named
public class InfoView implements Serializable {

    private static final long serialVersionUID = -814938721259900592L;

    @Autowired
    private InfoService infoService;

    private List<Info> list;

    private Info info;

    /**
     * 查询所有信息
     */
    public List<Info> infoList(){
        list = infoService.findAll();
        return list;
    }

    /**
     * 查询指定 id 信息
     */
    public void selectOne(Integer id) {
        info = infoService.getOne(id);
    }

    /**
     * 更新信息
     */
    public void update(Info info)
    {
        System.out.println(info.getId());
        System.out.println(info.getTitle());
        System.out.println(info.getTime());
        info = infoService.save(new Info(info.getId(), info.getTitle(), info.getTime()));
    }

    /**
     * 删除信息
     */
    public void delete(Info info){
        infoService.deleteById(info.getId());
    }

    /** Getter Setter**/
    public List<Info> getList() {
        return list;
    }

    public Info getSelect() {
        return info;
    }

    public void setSelect(Info info) {
        this.info = info;
    }
}
