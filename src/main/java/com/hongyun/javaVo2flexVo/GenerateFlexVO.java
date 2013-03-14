package com.hongyun.javaVo2flexVo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import org.apache.commons.lang.StringUtils;

public class GenerateFlexVO {
    public GenerateFlexVO() {
    }

    // 根据java类对象的类型返回vo类型
    @SuppressWarnings("unchecked")
    public static String getClassType(Class c) {
        String typeName = c.getSimpleName();

        if (typeName.equals("String") || typeName.equals("Date")) {
            return typeName;
        } else if (typeName.equals("BigDecimal") || typeName.equals("Decimal")
                || typeName.equals("Double")) {
            return "Number";
        } else if (typeName.equals("Integer")) {
            return "int";
        } else if (typeName.equals("Boolean")) {
            return "boolean";
        } else {
            return "*";// 其它类型的设置为未知类型
        }

    }

    // 重复c字符count次，用于格式化生成的as文件
    public static String repeat(String c, int count) {
        String temp = "";
        for (int i = 0; i < count; i++) {
            temp += c;
        }
        return temp;
    }

    /**
     * 生成FLex POJO
     * 
     * @param pojoName
     *            java POJO的名称
     * @param packageName
     *            Flex包的名称
     * @param folder
     *            Flex包所在的路径
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static void generateAsFile(String pojoName, String packageName,
            String folder) throws ClassNotFoundException, IOException {
        Class c = Class.forName(pojoName);
        Field[] fields = c.getDeclaredFields();

        // as的vo对象名称结尾加上VO标志
        File f = new File(folder + c.getSimpleName() + ".as");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        // 包名，没有设置包名就取和java pojo一样的包名
        if (StringUtils.isEmpty(packageName)) {
            bw.write("package " + c.getPackage().getName() + "\n{\n");
        } else {
            bw.write("package " + packageName + "\n{\n");
        }

        // 写类
        bw.write(repeat(" ", 4) + "public class " + c.getSimpleName() + "\n");
        bw.write(repeat(" ", 4) + "{\n");

        // 写属性
        for (int i = 0; i < fields.length; i++) {
            Class fieldType = fields[i].getType();
            String typeName = getClassType(fieldType);
            bw.write(repeat(" ", 8) + "private var " + fields[i].getName()
                    + ":" + typeName + ";\n");
        }

        bw.write("\n\n\n");
        // 写空的构造函数
        bw.write(repeat(" ", 8) + "public function " + c.getSimpleName()
                + "(){}\n\n");

        // 写 setter/getter 方法
        for (int i = 0; i < fields.length; i++) {
            Class fieldType = fields[i].getType();
            String typeName = getClassType(fieldType);
            // setter
            bw.write(repeat(" ", 8) + "public function set "
                    + fields[i].getName() + "(value:" + typeName + "):void{\n");
            bw.write(repeat(" ", 12) + "this." + fields[i].getName()
                    + " = value;\n");
            bw.write(repeat(" ", 8) + "}\n\n");
            // getter
            bw.write(repeat(" ", 8) + "public function get "
                    + fields[i].getName() + "():" + typeName + "{\n");
            bw.write(repeat(" ", 12) + "return this." + fields[i].getName()
                    + ";\n");
            bw.write(repeat(" ", 8) + "}\n\n\n");

        }
        bw.write(repeat(" ", 4) + "}\n");
        bw.write("}");
        bw.close();
    }

    // 生成的主程序
    public static void main(String[] args) throws ClassNotFoundException,
            IOException {
        String[] pojos = { "com.hongyun.javaVo2flexVo.FilialeForecastVO" };

        for (int i = 0; i < pojos.length; i++) {
            // Class c = Class.forName(pojos[i]);
            // System.out.println("registerClassAlias('"+pojos[i]+"',login.flash.vo."+c.getSimpleName()+");");
            GenerateFlexVO
                    .generateAsFile(pojos[i], "com.wgw.flexvo",
                            "E:\\");
        }

    }

}