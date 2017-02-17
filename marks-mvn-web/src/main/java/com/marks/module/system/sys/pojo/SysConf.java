package com.marks.module.system.sys.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysConf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ckey;
	private String cvalue;
	private String ckeyname;
	private Date createtime;
	private Date updatetime;
	private String creator;

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getCkeyname() {
		return ckeyname;
	}

	public void setCkeyname(String ckeyname) {
		this.ckeyname = ckeyname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public int hashCode() {
		return ckey.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysConf)
			return ckey.equals(((SysConf) obj).ckey);
		else
			return false;
	}
}
