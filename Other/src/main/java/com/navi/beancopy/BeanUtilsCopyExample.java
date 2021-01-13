package com.navi.beancopy;

import cn.hutool.core.bean.BeanUtil;
import com.navi.beancopy.dto.Student;
import com.navi.beancopy.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.dozer.DozerBeanMapper;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtilsCopyExample Class
 *
 * @author ganxf
 * @date 2020/8/14
 */
@Slf4j
public class BeanUtilsCopyExample {

    public static void main(String[] args) {

        StudentDTO zhangsan = StudentDTO.builder().age(20).name("zhangsan").good("lanqiu,yuedu,sanbu,youyong").build();
        copy(zhangsan);

        apacheBeanUtilsCopy(zhangsan, 10000000);
        springframeworkBeanUtilsCopy(zhangsan,10000000);
        hutoolBeanUtilsCopy(zhangsan,10000000);
        cglibBeanCopierCopy(zhangsan,10000000);
        apachePropertyUtilsCopy(zhangsan,10000000);
        dozerBeanMapperCopy(zhangsan,10000000);

    }

    private static void copy(StudentDTO dto){

        Student student = new Student();
        org.springframework.beans.BeanUtils.copyProperties(dto, student);
        log.info("springframeworkBeanUtils:{}", student);

        Student student1 = new Student();
        BeanUtil.copyProperties(dto,student1);
        log.info("hutoolBeanUtil:{}", student1);

        Student student2 = new Student();
        BeanCopier copier = BeanCopier.create(StudentDTO.class, Student.class, false);
        copier.copy(dto,student2,null);
        log.info("cglibBeanCopier:{}", student2);

        try {
            Student student3 = new Student();
            PropertyUtils.copyProperties(student3, dto);
            log.info("apachePropertyUtils:{}", student3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Student student4 = new Student();
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.map(dto,student4);
        log.info("DozerBeanMapper:{}", student4);

    }

    private static void apacheBeanUtilsCopy(StudentDTO dto, int count) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            for (int i = 0; i < count; i++) {
                Student student = new Student();
                org.apache.commons.beanutils.BeanUtils.copyProperties(student, dto);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        stopWatch.split();
        log.info("使用org.apache.commons.beanutils.BeanUtils.copyProperties，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());
    }

    private static void springframeworkBeanUtilsCopy(StudentDTO dto, int count) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < count; i++) {
            Student student = new Student();
            org.springframework.beans.BeanUtils.copyProperties(dto, student);
        }

        stopWatch.split();
        log.info("使用org.springframework.beans.BeanUtils.copyProperties，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());
    }

    private static void hutoolBeanUtilsCopy(StudentDTO dto, int count) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < count; i++) {
            Student student = new Student();
            BeanUtil.copyProperties(dto, student);
        }

        stopWatch.split();
        log.info("使用hutool.BeanUtil.copyProperties，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());
    }

    private static void apachePropertyUtilsCopy(StudentDTO dto, int count) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            for (int i = 0; i < count; i++) {
                Student student = new Student();
                PropertyUtils.copyProperties(student, dto);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        stopWatch.split();
        log.info("使用org.apache.commons.beanutils.PropertyUtils.copyProperties，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());
    }

    private static void cglibBeanCopierCopy(StudentDTO dto, int count) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        BeanCopier copier = BeanCopier.create(StudentDTO.class, Student.class, false);

        for (int i = 0; i < count; i++) {
            Student student = new Student();
            copier.copy(dto, student, null);
        }
        stopWatch.split();
        log.info("使用cglibBeanCopier，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());

    }

    private static void dozerBeanMapperCopy(StudentDTO dto, int count) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

        for (int i = 0; i < count; i++) {
            Student student = new Student();
            dozerBeanMapper.map(dto, student);

        }
        stopWatch.split();
        log.info("使用dozerBeanMapper，复制对象{}次，花费{}ms", count, stopWatch.getSplitTime());

    }

}

