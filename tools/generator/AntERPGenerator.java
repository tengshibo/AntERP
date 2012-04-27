package generator;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * This Class is used to call myBatis-generator to generate POJO, DAO and SQL.
 */
public class AntERPGenerator {

	public static void main(String[] args) throws UnsupportedEncodingException {
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);

		boolean overwrite = true;
		// File configFile = new
		// File(findFile("generator/AntERPTableConfig.xml"));
		File configFile = new File(
				"D:/DTWorkSpace/Mirrors/gitProject/AntERP/tools/generator/AntERPTableConfig.xml");

		System.out.println(configFile.getAbsolutePath());
		try {
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String findFile(String path)
			throws UnsupportedEncodingException {
		path = URLDecoder.decode(path, Charset.defaultCharset().name());
		File f = new File(path);
		if (!f.exists()) {
			URL url = AntERPGenerator.class.getClassLoader().getResource(path);
			if (null == url)
				url = Thread.currentThread().getContextClassLoader()
						.getResource(path);
			if (null == url)
				url = ClassLoader.getSystemResource(path);
			if (null != url)
				return URLDecoder.decode(url.getPath(), "UTF-8");// 通过URL获取String,一律使用UTF-8编码进行解码
			return null;
		}
		return path;
	}

}
