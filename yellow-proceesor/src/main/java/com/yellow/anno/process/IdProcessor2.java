package com.yellow.anno.process;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.TypeElement;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
//
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

import javax.lang.model.type.ExecutableType;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

import com.yellow.anno.MyId;


@SupportedAnnotationTypes("com.yellow.anno.MyId")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IdProcessor2 extends AbstractProcessor {
    
    private Filer filer;
      private Messager messager;
     
      private int r = 1;//轮循次数
    
    public IdProcessor2() {
        super();
        System.out.println("222222222");
    }
      
      @Override
      public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        //初始化Filer和Messager
        this.filer = processingEnv.getFiler();
        this.messager = processingEnv.getMessager();
      }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //目的是：
        //扫描 MyId 注解，生成B端可用的 类
        //C端代码的生成在另外一个 处理器内
        
        
        messager.printMessage(Kind.NOTE, "process() is execute...");
        //获取所有编译类元素，并打印，测试用
        Set<? extends Element> elements = roundEnv.getRootElements();
        System.out.println("2222222 输入的所有类有：");
        for(Element e: elements){
          System.out.println(">>> "+e.getSimpleName());
        }
        
      //获取使用了注解@GenerateInterface的类元素
        System.out.println("需要生成相应接口的类有：");
        Set<? extends Element> genElements = roundEnv.getElementsAnnotatedWith(MyId.class);
        for(Element e: genElements){
          System.out.println(">>> "+e.getSimpleName());
          System.out.println(">>> "+e.getKind());
          
          if ( ElementKind.FIELD.equals(e.getKind())) {
              System.out.println("is field");
          }
//        GenerateInterface gi = e.getAnnotation(GenerateInterface.class);
//        String className = e.getSimpleName()+gi.suffix();
//        String classString = "package com.zenfery.example.annotation.bean;\n"
//          +"public interface "+className+" {\n";
//        //获取所有的方法元素
//        List<? extends Element> genElementAlls = e.getEnclosedElements();
//        System.out.println(">>>> 类"+e.getSimpleName()+"封装元素(仅对修饰符有public的生成接口方法):");
//        for(Element e1 : genElementAlls){
//          System.out.println(">>> >>> "+e1.getSimpleName()+" 修饰符："+e1.getModifiers());
//          if(!e1.getSimpleName().toString().equals("<init>") && e1.asType() instanceof ExecutableType && isPublic(e1)){
//            System.out.println(">>> >>> >>> "+e1.getSimpleName());
//            classString += " void "+e1.getSimpleName()+"();\n";
//          }
//        }
//        classString+="}";
          //System.out.println(classString);
          
          FileWriter fileWriter = null;
          BufferedWriter bufferedWriter = null;

//          try {
//              fileWriter = new FileWriter(path);
//              bufferedWriter = new BufferedWriter(fileWriter);
//
//              for (String string : arrayList) {
//                  bufferedWriter.write(string);
//
//                  bufferedWriter.newLine();
//              }
//
//          } catch (IOException e1) {
//              e1.printStackTrace();
//          } finally {
//              try {
//                  bufferedWriter.close();
//              } catch (IOException e) {
//                  e.printStackTrace();
//              }
//          }
          
        }
        
        System.out.println("-------------------注解处理器第"+(r++)+"次循环处理结束...\n");
        
        return false;
    }

}
