package cn.dgtp.com.pojo;

import java.io.Serializable;

public class Role implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6600161529847365317L;

	private String r_id;
	
	private String r_name;
	
	private Integer p_id;

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_id == null) ? 0 : p_id.hashCode());
		result = prime * result + ((r_id == null) ? 0 : r_id.hashCode());
		result = prime * result + ((r_name == null) ? 0 : r_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		if (r_id == null) {
			if (other.r_id != null)
				return false;
		} else if (!r_id.equals(other.r_id))
			return false;
		if (r_name == null) {
			if (other.r_name != null)
				return false;
		} else if (!r_name.equals(other.r_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [r_id=" + r_id + ", r_name=" + r_name + ", p_id=" + p_id + "]";
	}
}
