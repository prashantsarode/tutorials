package com.sampleprograms.spring.boot.limits.service.beans;

public class LimitConfiguration {

	private Integer minimum;
	
	private Integer maximum;
	
	public LimitConfiguration() {
		super();
	}

	public LimitConfiguration(Integer minimum, Integer maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maximum == null) ? 0 : maximum.hashCode());
		result = prime * result + ((minimum == null) ? 0 : minimum.hashCode());
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
		LimitConfiguration other = (LimitConfiguration) obj;
		if (maximum == null) {
			if (other.maximum != null)
				return false;
		} else if (!maximum.equals(other.maximum))
			return false;
		if (minimum == null) {
			if (other.minimum != null)
				return false;
		} else if (!minimum.equals(other.minimum))
			return false;
		return true;
	}	
	
}
