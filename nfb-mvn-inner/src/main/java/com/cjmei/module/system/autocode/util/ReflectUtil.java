package com.cjmei.module.system.autocode.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import com.cjmei.module.system.autocode.ModuleProduced;
import com.cjmei.module.system.autocode.pojo.AutoBean;

/**
 * 反射工具类
 * @author ykai5
 *
 */
public class ReflectUtil {
	private final static Logger log = Logger.getLogger(ReflectUtil.class);
	// 
	public static String reflectMethod(ModuleProduced daoInterfaceProduced,
			String methodName, AutoBean autoBean) {
		return reflectMethod(daoInterfaceProduced,daoInterfaceProduced.getClass(), methodName, autoBean);
		// String methodName = TemplateFileFormat.METHOD_PRE+
		// StringUtil.getUpperCaseChar( methodPre);

		
	}
	
	/**
	 * 查找指定方法methodName，结束条件，找到合适的方法，找不到新的父类
	 * @param daoInterfaceProduced
	 * @param daoInterfaceProducedClass
	 * @param methodName
	 * @param autoBean
	 * @return
	 */
	public static String reflectMethod(ModuleProduced daoInterfaceProduced,Class<? extends ModuleProduced> daoInterfaceProducedClass,
			String methodName, AutoBean autoBean){
		try {
//			Class<? extends ModuleProduced> producedClass = daoInterfaceProducedClass;
			Method[] methods = daoInterfaceProducedClass.getDeclaredMethods();
			if (isExsitMethod(methods, methodName)) {
				Method method = daoInterfaceProducedClass.getMethod(
						methodName, autoBean.getClass());
				String result = (String) method.invoke(daoInterfaceProduced,
						autoBean);
				return result;
			}
			if (daoInterfaceProducedClass.getGenericSuperclass() != null) {
				daoInterfaceProducedClass = (Class<? extends ModuleProduced>) daoInterfaceProducedClass.getSuperclass();
				return reflectMethod(daoInterfaceProduced, daoInterfaceProducedClass,methodName, autoBean);
			}else{
				return "";
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isExsitMethod(Method[] methods, String methodName) {
		for (Method method : methods) {
			if (methodName.equals(method.getName()))
				return true;
		}
		return false;
	}

	/**
	 * 获得包下面的所有的class
	 * 
	 * @param pack
	 *            package完整名称
	 * @return List包含所有class的实例
	 */
	public static List<Class<?>> getClasssFromPackage(String pack) {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();

		// 是否循环搜索子包
		boolean recursive = true;

		// 包名字
		String packageName = pack;
		// 包名对应的路径名称
		String packageDirName = packageName.replace('.', '/');

		Enumeration<URL> dirs;

		try {
			dirs = Thread.currentThread().getContextClassLoader()
					.getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();

				String protocol = url.getProtocol();

				if ("file".equals(protocol)) {
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findClassInPackageByFile(packageName, filePath, recursive,
							clazzs);
				} else if("jar".equals(protocol)){
					findClassInPackageByJar(url, packageDirName, packageName, recursive, clazzs);
				}
			}

		} catch (Exception e) {
			System.out.println("sfsdfa>"+e.getMessage());
			log.error(e.getMessage(),e);
		}

		return clazzs;
	}
	
	/**
	 * 根据Jar获取class路径，后续改进
	 * @param url
	 * @param packageDirName
	 * @param packageName
	 * @param recursive
	 * @param clazzs
	 * @throws IOException
	 */
	public static void findClassInPackageByJar(URL url,String packageDirName,String packageName,
			boolean recursive,List<Class<?>> clazzs) throws IOException{
		 //如果是jar包文件   
        //定义一个JarFile  
        JarFile jar;  
        //获取jar  
        jar = ((JarURLConnection) url.openConnection()).getJarFile();  
        //从此jar包 得到一个枚举类  
        Enumeration<JarEntry> entries = jar.entries();  
        //同样的进行循环迭代  
        while (entries.hasMoreElements()) {  
            //获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件  
            JarEntry entry = entries.nextElement();  
            String name = entry.getName();  
            //如果是以/开头的  
            if (name.charAt(0) == '/') {  
                //获取后面的字符串  
                name = name.substring(1);  
            }  
            //如果前半部分和定义的包名相同  
            if (name.startsWith(packageDirName)) {  
                int idx = name.lastIndexOf('/');  
                //如果以"/"结尾 是一个包  
                if (idx != -1) {  
                    //获取包名 把"/"替换成"."  
                    packageName = name.substring(0, idx).replace('/', '.');  
                }  
                //如果可以迭代下去 并且是一个包  
                if ((idx != -1) || recursive){  
                    //如果是一个.class文件 而且不是目录  
                    if (name.endsWith(".class") && !entry.isDirectory()) {  
                        //去掉后面的".class" 获取真正的类名  
                        String className = name.substring(packageName.length() + 1, name.length() - 6);  
                        try {  
                            //添加到classes  
                        	clazzs.add(Class.forName(packageName + '.' + className));  
                        } catch (ClassNotFoundException e) {  
                            e.printStackTrace();  
                        }  
                      }  
                }  
            }  
        }  
	}

	/**
	 * 在package对应的路径下找到所有的class
	 * 
	 * @param packageName
	 *            package名称
	 * @param filePath
 	 *            package对应的路径
	 * @param recursive
	 *            是否查找子package
	 * @param clazzs
	 *            找到class以后存放的集合
	 */
	public static void findClassInPackageByFile(String packageName,
			String filePath, final boolean recursive, List<Class<?>> clazzs) {
		File dir = new File(filePath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 在给定的目录下找到所有的文件，并且进行条件过滤
		File[] dirFiles = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
				boolean acceptClass = file.getName().endsWith("class");// 接受class文件
				return acceptDir || acceptClass;
			}
		});

		for (File file : dirFiles) {
			if (file.isDirectory()) {
				findClassInPackageByFile(packageName + "." + file.getName(),
						file.getAbsolutePath(), recursive, clazzs);
			} else {
				String className = file.getName().substring(0,
						file.getName().length() - 6);
				try {
					clazzs.add(Thread.currentThread().getContextClassLoader()
							.loadClass(packageName + "." + className));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 判断该类是否为是实际类（非抽象，非接口）
	 * @param c
	 * @return
	 */
	public static boolean isFactClass(Class<?> c){
		return !Modifier.isAbstract(c.getModifiers());
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		List<Class<?>> classes = getClasssFromPackage("cluster.scheme.com");
//		List<Class<?>> classes = getClasssFromPackage("cluster.scheme.autocode.autoutil");
		for(Class<?> c : classes){
			System.out.println(c.getSimpleName());
			if("ReflectUtil".equals(c.getSimpleName())){
				
				c.newInstance();
			}
		}
//		System.out.println (ITestJar.class.getResource ("").getFile ());
//		System.out.println (ModuleProduced.class.getResource ("").getFile ());
//		System.out.println(classes.size());
//		getClasssFromPackage("cluster.scheme.autocode.autoutil");
		getClasssFromPackage("cluster.scheme.com");
		
		
		
	}

}
