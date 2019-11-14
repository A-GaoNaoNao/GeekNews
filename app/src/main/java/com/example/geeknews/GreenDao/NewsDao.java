package com.example.geeknews.GreenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class NewsDao {
    @Id(autoincrement = false)
    private Long id;
    private Boolean Checked;
    private String title;
    private Integer mPosition;
    @Generated(hash = 244200026)
    public NewsDao(Long id, Boolean Checked, String title, Integer mPosition) {
        this.id = id;
        this.Checked = Checked;
        this.title = title;
        this.mPosition = mPosition;
    }
    @Generated(hash = 619588464)
    public NewsDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getChecked() {
        return this.Checked;
    }
    public void setChecked(Boolean Checked) {
        this.Checked = Checked;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getMPosition() {
        return this.mPosition;
    }
    public void setMPosition(Integer mPosition) {
        this.mPosition = mPosition;
    }

    @Override
    public String toString() {
        return "NewsDao{" +
                "id=" + id +
                ", Checked=" + Checked +
                ", title='" + title + '\'' +
                ", mPosition=" + mPosition +
                '}';
    }
}
