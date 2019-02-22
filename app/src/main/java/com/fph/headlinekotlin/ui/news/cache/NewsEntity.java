package com.fph.headlinekotlin.ui.news.cache;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fengpeihao on 2018/3/27.
 */

@Entity
public class NewsEntity {

    @Id
    private long id;

    private String url;

    @Generated(hash = 997668745)
    public NewsEntity(long id, String url) {
        this.id = id;
        this.url = url;
    }

    @Generated(hash = 2121778047)
    public NewsEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
