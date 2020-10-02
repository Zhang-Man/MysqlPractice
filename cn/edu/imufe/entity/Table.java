package edu.imufe.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {
	private Integer rows;
	private Integer columns;
	private Long allnum;
	private Long frownum;
	private ArrayList<Long> frow;
	private Long[] frow2;
	private ArrayList<Long> fcolumn;
	private Long[] fcolumn2;
	private ArrayList<Long> erow;
	private Long[] erow2;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Long getAllnum() {
		return allnum;
	}

	public void setAllnum(Long allnum) {
		this.allnum = allnum;
	}

	public Long getFrownum() {
		return frownum;
	}

	public void setFrownum(Long frownum) {
		this.frownum = frownum;
	}

	public ArrayList<Long> getFrow() {
		return frow;
	}

	public void setFrow(ArrayList<Long> frow) {
		this.frow = frow;
		this.frow2 = new Long[frow.size()];
		int num = 0;
	    for(Long i:frow) 
	    {
	    	this.frow2[num] = i;
	    	num++;
	    }
	}

	public ArrayList<Long> getFcolumn() {
		return fcolumn;
	}

	public void setFcolumn(ArrayList<Long> fcolumn) {
		this.fcolumn = fcolumn;
	    this.fcolumn2 = new Long[fcolumn.size()];
	    int num = 0;
	    for(Long i:fcolumn) 
	    {
	    	this.fcolumn2[num] = i;
	    	num++;
	    }
	}

	public ArrayList<Long> getErow() {
		return erow;
	}

	public void setErow(ArrayList<Long> erow) {
		this.erow = erow;
		this.erow2 = new Long[erow.size()];
		int num = 0;
		for(Long i:erow) 
	    {
	    	this.erow2[num] = i;
	    	num++;
	    }
		Arrays.sort(this.erow2);
	}

	@Override  //此关键字可以帮助我们检查是否重写合乎要求
	public boolean equals(Object obj) {
	    if (this == obj)    //检测this与obj是否指向同一对象。这条语句是一个优化，避免直接去比较同一对象的各个域
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass()) // 比较this和obj是否属于同一个类 若是两个对象都不是同一个类的 则不相等
	        return false;

	    Table other = (Table) obj;  //将obj转换成相应的Student类型
	//对所有需要比较的域进行比较 基本类型使用== 对象域使用equal 数组类型的域，可以使用静态的Arrays.equals方法检测相应的数组元素是否相等
	    //行数
	    if (rows != other.rows)
	        return false;
	    if (rows == null) {
	        if (other.rows != null)
	            return false;
	    } else if (!rows.equals(other.rows))
	        return false;
	    System.out.println("行数相同");
	    //列数
	    if (columns != other.columns)
	        return false;
	    if (columns == null) {
	        if (other.columns != null)
	            return false;
	    } else if (!columns.equals(other.columns))
	        return false;
	    System.out.println("列数相同");
	    //总和
	    if (allnum.longValue() != other.allnum.longValue())
	        return false;
	    if (allnum == null) {
	        if (other.allnum != null)
	            return false;
	    } else if (!allnum.equals(other.allnum))
	        return false;
	    System.out.println("总和相同");
	    //首行和
	    if (frownum.longValue() != other.frownum.longValue())
	        return false;
	    if (frownum == null) {
	        if (other.frownum != null)
	            return false;
	    } else if (!frownum.equals(other.frownum))
	        return false;
	    System.out.println("首行和相同");
	    //首行首列
	    for(int i=0;i<frow2.length;i++)//行数 
	  		{
			if(frow2[i].longValue() != other.frow2[i].longValue()) 
			{
				return false;
			}
			if (frow2[i] == null) {
		        if (other.frow2[i] != null)
		            return false;
		    } else if (!frow2[i].equals(other.frow2[i]))
		        return false;
		}
	    for(int i=0;i<fcolumn2.length;i++)//列数 
		{
			if(fcolumn2[i].longValue()!=other.fcolumn2[i].longValue()) 
			{
				return false;
			}
			if (fcolumn2[i] == null) {
		        if (other.fcolumn2[i] != null)
		            return false;
		    } else if (!fcolumn2[i].equals(other.fcolumn2[i]))
		        return false;
		}
	    System.out.println("首行首列相同");
	    //每行和
	    for(int i=0;i<erow2.length;i++) 
		{
			if(erow2[i].longValue()!=other.erow2[i].longValue()) 
			{
				return false;
			}
			if (erow2[i] == null) {
		        if (other.erow2[i]!= null)
		            return false;
		    } else if (!erow2[i].equals(other.erow2[i]))
		        return false;
		}
	    System.out.println("每行和相同");
	    return true;
	}
}




