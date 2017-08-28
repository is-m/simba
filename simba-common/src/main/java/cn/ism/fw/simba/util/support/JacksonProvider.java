package cn.ism.fw.simba.util.support;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ism.fw.simba.util.Assert;

public class JacksonProvider implements JSONProvider {

	private static final Logger LOG = LoggerFactory.getLogger(JacksonProvider.class);

	private ObjectMapper om = new ObjectMapper();

	@Override
	public String toJSON(Object o) {
		try {
			return om.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}
 
	@Override
	@SuppressWarnings("unchecked")
	public <T> T toObject(String JSONString, Class<?>... classes) {
		Assert.notEmpty(classes, "classes arg not be empty");

		if (classes.length > 2) {
			LOG.warn("classes 参数超过了两位，多余的可能会被忽略");
		}

		Class<?> elementClass = classes[0];
		Class<?> collectionClass = classes.length > 1 ? classes[1] : null;

		try {
			if (collectionClass != null) {
				JavaType javaType = om.getTypeFactory().constructParametricType(collectionClass, elementClass);
				return (T) om.readValue(JSONString, javaType);
			} else {
				return (T) om.readValue(JSONString, elementClass);
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}

}
