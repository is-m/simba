package cn.ism.fw.simba.util.support;

import cn.ism.fw.simba.orm.NoImplementException;

public class FastJSONProvider implements JSONProvider {

	@Override
	public String toJSON(Object o) {
		throw new NoImplementException();
	}

	@Override
	public <T> T toObject(String JSONString,Class<?>... classes) {
		throw new NoImplementException();
	} 

}
