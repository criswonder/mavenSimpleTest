package com.hongyun.javaVo2flexVo;

import java.util.Date;



public class BaseBizVO extends BaseVO{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Long id;
    
    private String code;
    
    private String creator;

    private Date createTime;
    
    private String lastUpdator;
    
    private Date lastUpdateTime;
    
    private Integer version;
    
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public String getLastUpdator() {
        return lastUpdator;
    }
    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
    
}
