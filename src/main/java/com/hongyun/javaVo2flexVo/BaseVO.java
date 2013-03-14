package com.hongyun.javaVo2flexVo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode().
 * 
 */
public class BaseVO implements Serializable {    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Returns a multi-line String with key=value pairs.
     * @return a String representation of this class.
     */
    public String toString(){
        ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE);
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Compares object equality. When using Hibernate, the primary key should
     * not be a part of this comparison.
     * @param o object to compare to
     * @return true/false based on equality tests
     */
    public boolean equals(Object o){
        return super.equals(o);
    }

    /**
     * When you override equals, you should override hashCode. See "Why are
     * equals() and hashCode() importation" for more information:
     * http://www.hibernate.org/109.html
     * @return hashCode
     */
    public int hashCode(){
        return super.hashCode();
    }
}
