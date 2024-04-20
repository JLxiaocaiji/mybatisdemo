package org.example.mybatisdemo.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class XmlParserUtils {
    public static <T> List<T> parse(String file, Class<T> targetClass) {
        ArrayList<T> list = new ArrayList<T>();

        try {
            // 1.获取一个解析器对象
            SAXReader saxReader = new SAXReader();
            // 2.利用解析器把 xml 文件加载到内存中
            Document document = saxReader.read(new File(file));
            // 3.获取到根标签
            Element rootElement = document.getRootElement();
            // 4.通过标签来获取 user 标签
            List<Element> elements = rootElement.elements("emp");

            // 遍历集合，得到每个 user 标签
            for( Element element: elements) {
                // 获取name 属性
                String name = element.element("name").getText();
                // age 属性
                String age = element.element("age").getText();
                // image 属性
                String image = element.element("image").getText();
                // gender 属性
                String gender = element.element("gender").getText();
                // job 属性
                String job = element.element("job").getText();

                // 组装数据
                Constructor<T> constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class);

                constructor.setAccessible(true);
                T object = constructor.newInstance(name, Integer.parseInt(age), image, gender, job);

                list.add(object);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
