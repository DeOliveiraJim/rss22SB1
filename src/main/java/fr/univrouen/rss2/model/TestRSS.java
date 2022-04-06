package fr.univrouen.rss2.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestRSS {

	private static Resource resource;

	public String loadFileXML() {
		resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");
		try {
			InputStream inputStream = resource.getInputStream();
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			for (int length; (length = inputStream.read(buffer)) != -1; ) {
				result.write(buffer, 0, length);
			}
			return  result.toString("UTF-8");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
