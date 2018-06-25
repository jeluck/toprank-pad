package cc.toprank.byd.stall.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设置称重档口配置信息VO类
 * @author ZhaoLC
 * @Time 2017-3-13 16:00
 */
public class StallWeighSettingInfoVO {
    private Long stallid;

    private Long archiveid;

    private String stallname;

    private String stallcode;

    private String firstletter;

    private String stalldesc;

    private Boolean needconfirm;

    private Integer diffrate;

    private String waitcolor;

    private String handlecolor;

    private String alreadycolor;

    private Long weighttype;

    private Long comport;

    private Long unitid;

    private Integer sortno;

    private Long creatorid;

    private Date createtime;

    private String memo;

    @JsonProperty
    private List<StallWeighContentInfo> stallWeighContentInfoList = new ArrayList<>();

    public static class StallWeighContentInfo{
        private Long contentid;

        private Long stallid;

        private Boolean isfixed;

        private Boolean isshow;

        public Long getContentid() {
            return contentid;
        }

        public void setContentid(Long contentid) {
            this.contentid = contentid;
        }

        public Long getStallid() {
            return stallid;
        }

        public void setStallid(Long stallid) {
            this.stallid = stallid;
        }

        public Boolean getIsfixed() {
            return isfixed;
        }

        public void setIsfixed(Boolean isfixed) {
            this.isfixed = isfixed;
        }

        public Boolean getIsshow() {
            return isshow;
        }

        public void setIsshow(Boolean isshow) {
            this.isshow = isshow;
        }
    }
    public Long getStallid() {
        return stallid;
    }

    public void setStallid(Long stallid) {
        this.stallid = stallid;
    }

    public Long getArchiveid() {
        return archiveid;
    }

    public void setArchiveid(Long archiveid) {
        this.archiveid = archiveid;
    }

    public String getStallname() {
        return stallname;
    }

    public void setStallname(String stallname) {
        this.stallname = stallname;
    }

    public String getStallcode() {
        return stallcode;
    }

    public void setStallcode(String stallcode) {
        this.stallcode = stallcode;
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

    public String getStalldesc() {
        return stalldesc;
    }

    public void setStalldesc(String stalldesc) {
        this.stalldesc = stalldesc;
    }

    public Boolean getNeedconfirm() {
        return needconfirm;
    }

    public void setNeedconfirm(Boolean needconfirm) {
        this.needconfirm = needconfirm;
    }

    public Integer getDiffrate() {
        return diffrate;
    }

    public void setDiffrate(Integer diffrate) {
        this.diffrate = diffrate;
    }

    public String getWaitcolor() {
        return waitcolor;
    }

    public void setWaitcolor(String waitcolor) {
        this.waitcolor = waitcolor;
    }

    public String getHandlecolor() {
        return handlecolor;
    }

    public void setHandlecolor(String handlecolor) {
        this.handlecolor = handlecolor;
    }

    public String getAlreadycolor() {
        return alreadycolor;
    }

    public void setAlreadycolor(String alreadycolor) {
        this.alreadycolor = alreadycolor;
    }

    public Long getWeighttype() {
        return weighttype;
    }

    public void setWeighttype(Long weighttype) {
        this.weighttype = weighttype;
    }

    public Long getComport() {
        return comport;
    }

    public void setComport(Long comport) {
        this.comport = comport;
    }

    public Long getUnitid() {
        return unitid;
    }

    public void setUnitid(Long unitid) {
        this.unitid = unitid;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Long getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<StallWeighContentInfo> getStallWeighContentInfoList() {
        return stallWeighContentInfoList;
    }

    public void setStallWeighContentInfoList(List<StallWeighContentInfo> stallWeighContentInfoList) {
        this.stallWeighContentInfoList = stallWeighContentInfoList;
    }
}
