// package com.navi.service.impl;
//
// import com.navi.entity.Dept;
// import com.navi.service.impl.DeptServiceImpl;
// import java.lang.reflect.Method;
// import java.util.List;
// import org.aopalliance.aop.Advice;
// import org.springframework.aop.Advisor;
// import org.springframework.aop.SpringProxy;
// import org.springframework.aop.TargetClassAware;
// import org.springframework.aop.TargetSource;
// import org.springframework.aop.framework.Advised;
// import org.springframework.aop.framework.AopConfigException;
// import org.springframework.cglib.core.ReflectUtils;
// import org.springframework.cglib.core.Signature;
// import org.springframework.cglib.proxy.Callback;
// import org.springframework.cglib.proxy.Dispatcher;
// import org.springframework.cglib.proxy.Factory;
// import org.springframework.cglib.proxy.MethodInterceptor;
// import org.springframework.cglib.proxy.MethodProxy;
// import org.springframework.cglib.proxy.NoOp;
//
// public class DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d
//         extends DeptServiceImpl
//         implements SpringProxy,
//         Advised,
//         Factory {
//     private boolean CGLIB$BOUND;
//     public static Object CGLIB$FACTORY_DATA;
//     private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
//     private static final Callback[] CGLIB$STATIC_CALLBACKS;
//     private MethodInterceptor CGLIB$CALLBACK_0;
//     private MethodInterceptor CGLIB$CALLBACK_1;
//     private NoOp CGLIB$CALLBACK_2;
//     private Dispatcher CGLIB$CALLBACK_3;
//     private Dispatcher CGLIB$CALLBACK_4;
//     private MethodInterceptor CGLIB$CALLBACK_5;
//     private MethodInterceptor CGLIB$CALLBACK_6;
//     private static Object CGLIB$CALLBACK_FILTER;
//     private static final Method CGLIB$saveDept$0$Method;
//     private static final MethodProxy CGLIB$saveDept$0$Proxy;
//     private static final Object[] CGLIB$emptyArgs;
//     private static final Method CGLIB$deleleDeptById$1$Method;
//     private static final MethodProxy CGLIB$deleleDeptById$1$Proxy;
//     private static final Method CGLIB$updateDept$2$Method;
//     private static final MethodProxy CGLIB$updateDept$2$Proxy;
//     private static final Method CGLIB$selectDeptById$3$Method;
//     private static final MethodProxy CGLIB$selectDeptById$3$Proxy;
//     private static final Method CGLIB$selectAllList$4$Method;
//     private static final MethodProxy CGLIB$selectAllList$4$Proxy;
//     private static final Method CGLIB$equals$5$Method;
//     private static final MethodProxy CGLIB$equals$5$Proxy;
//     private static final Method CGLIB$toString$6$Method;
//     private static final MethodProxy CGLIB$toString$6$Proxy;
//     private static final Method CGLIB$hashCode$7$Method;
//     private static final MethodProxy CGLIB$hashCode$7$Proxy;
//     private static final Method CGLIB$clone$8$Method;
//     private static final MethodProxy CGLIB$clone$8$Proxy;
//
//     static void CGLIB$STATICHOOK9() {
//         CGLIB$THREAD_CALLBACKS = new ThreadLocal();
//         CGLIB$emptyArgs = new Object[0];
//         Class<?> clazz = Class.forName("com.navi.service.impl.DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d");
//         Class<?> clazz2 = Class.forName("com.navi.service.impl.DeptServiceImpl");
//         Method[] methodArray = ReflectUtils.findMethods(new String[]{"saveDept", "(Lcom/navi/entity/Dept;)Z", "deleleDeptById", "(Ljava/lang/Integer;)Z", "updateDept", "(Lcom/navi/entity/Dept;)Z", "selectDeptById", "(Ljava/lang/Integer;)Lcom/navi/entity/Dept;", "selectAllList", "()Ljava/util/List;"}, clazz2.getDeclaredMethods());
//         CGLIB$saveDept$0$Method = methodArray[0];
//         CGLIB$saveDept$0$Proxy = MethodProxy.create(clazz2, clazz, "(Lcom/navi/entity/Dept;)Z", "saveDept", "CGLIB$saveDept$0");
//         CGLIB$deleleDeptById$1$Method = methodArray[1];
//         CGLIB$deleleDeptById$1$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Integer;)Z", "deleleDeptById", "CGLIB$deleleDeptById$1");
//         CGLIB$updateDept$2$Method = methodArray[2];
//         CGLIB$updateDept$2$Proxy = MethodProxy.create(clazz2, clazz, "(Lcom/navi/entity/Dept;)Z", "updateDept", "CGLIB$updateDept$2");
//         CGLIB$selectDeptById$3$Method = methodArray[3];
//         CGLIB$selectDeptById$3$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Integer;)Lcom/navi/entity/Dept;", "selectDeptById", "CGLIB$selectDeptById$3");
//         CGLIB$selectAllList$4$Method = methodArray[4];
//         CGLIB$selectAllList$4$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/util/List;", "selectAllList", "CGLIB$selectAllList$4");
//         clazz2 = Class.forName("java.lang.Object");
//         Method[] methodArray2 = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, clazz2.getDeclaredMethods());
//         CGLIB$equals$5$Method = methodArray2[0];
//         CGLIB$equals$5$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$5");
//         CGLIB$toString$6$Method = methodArray2[1];
//         CGLIB$toString$6$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/String;", "toString", "CGLIB$toString$6");
//         CGLIB$hashCode$7$Method = methodArray2[2];
//         CGLIB$hashCode$7$Proxy = MethodProxy.create(clazz2, clazz, "()I", "hashCode", "CGLIB$hashCode$7");
//         CGLIB$clone$8$Method = methodArray2[3];
//         CGLIB$clone$8$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/Object;", "clone", "CGLIB$clone$8");
//     }
//
//     final boolean CGLIB$saveDept$0(Dept dept) {
//         return super.saveDept(dept);
//     }
//
//     public final boolean saveDept(Dept dept) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept(this, CGLIB$saveDept$0$Method, new Object[]{dept}, CGLIB$saveDept$0$Proxy);
//             return object == null ? false : (Boolean)object;
//         }
//         return super.saveDept(dept);
//     }
//
//     final boolean CGLIB$deleleDeptById$1(Integer n) {
//         return super.deleleDeptById(n);
//     }
//
//     public final boolean deleleDeptById(Integer n) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept(this, CGLIB$deleleDeptById$1$Method, new Object[]{n}, CGLIB$deleleDeptById$1$Proxy);
//             return object == null ? false : (Boolean)object;
//         }
//         return super.deleleDeptById(n);
//     }
//
//     final boolean CGLIB$updateDept$2(Dept dept) {
//         return super.updateDept(dept);
//     }
//
//     public final boolean updateDept(Dept dept) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept(this, CGLIB$updateDept$2$Method, new Object[]{dept}, CGLIB$updateDept$2$Proxy);
//             return object == null ? false : (Boolean)object;
//         }
//         return super.updateDept(dept);
//     }
//
//     final Dept CGLIB$selectDeptById$3(Integer n) {
//         return super.selectDeptById(n);
//     }
//
//     public final Dept selectDeptById(Integer n) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (Dept)methodInterceptor.intercept(this, CGLIB$selectDeptById$3$Method, new Object[]{n}, CGLIB$selectDeptById$3$Proxy);
//         }
//         return super.selectDeptById(n);
//     }
//
//     final List CGLIB$selectAllList$4() {
//         return super.selectAllList();
//     }
//
//     public final List selectAllList() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (List)methodInterceptor.intercept(this, CGLIB$selectAllList$4$Method, CGLIB$emptyArgs, CGLIB$selectAllList$4$Proxy);
//         }
//         return super.selectAllList();
//     }
//
//     final boolean CGLIB$equals$5(Object object) {
//         return super.equals(object);
//     }
//
//     public final boolean equals(Object object) {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_5;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_5;
//         }
//         if (methodInterceptor != null) {
//             Object object2 = methodInterceptor.intercept(this, CGLIB$equals$5$Method, new Object[]{object}, CGLIB$equals$5$Proxy);
//             return object2 == null ? false : (Boolean)object2;
//         }
//         return super.equals(object);
//     }
//
//     final String CGLIB$toString$6() {
//         return super.toString();
//     }
//
//     public final String toString() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return (String)methodInterceptor.intercept(this, CGLIB$toString$6$Method, CGLIB$emptyArgs, CGLIB$toString$6$Proxy);
//         }
//         return super.toString();
//     }
//
//     final int CGLIB$hashCode$7() {
//         return super.hashCode();
//     }
//
//     public final int hashCode() {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_6;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_6;
//         }
//         if (methodInterceptor != null) {
//             Object object = methodInterceptor.intercept(this, CGLIB$hashCode$7$Method, CGLIB$emptyArgs, CGLIB$hashCode$7$Proxy);
//             return object == null ? 0 : ((Number)object).intValue();
//         }
//         return super.hashCode();
//     }
//
//     final Object CGLIB$clone$8() throws CloneNotSupportedException {
//         return super.clone();
//     }
//
//     protected final Object clone() throws CloneNotSupportedException {
//         MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
//         if (methodInterceptor == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             methodInterceptor = this.CGLIB$CALLBACK_0;
//         }
//         if (methodInterceptor != null) {
//             return methodInterceptor.intercept(this, CGLIB$clone$8$Method, CGLIB$emptyArgs, CGLIB$clone$8$Proxy);
//         }
//         return super.clone();
//     }
//
//     public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
//         String string = ((Object)signature).toString();
//         switch (string.hashCode()) {
//             case -1564188806: {
//                 if (!string.equals("selectDeptById(Ljava/lang/Integer;)Lcom/navi/entity/Dept;")) break;
//                 return CGLIB$selectDeptById$3$Proxy;
//             }
//             case -508378822: {
//                 if (!string.equals("clone()Ljava/lang/Object;")) break;
//                 return CGLIB$clone$8$Proxy;
//             }
//             case 471463760: {
//                 if (!string.equals("saveDept(Lcom/navi/entity/Dept;)Z")) break;
//                 return CGLIB$saveDept$0$Proxy;
//             }
//             case 1248299189: {
//                 if (!string.equals("selectAllList()Ljava/util/List;")) break;
//                 return CGLIB$selectAllList$4$Proxy;
//             }
//             case 1369035652: {
//                 if (!string.equals("updateDept(Lcom/navi/entity/Dept;)Z")) break;
//                 return CGLIB$updateDept$2$Proxy;
//             }
//             case 1451794160: {
//                 if (!string.equals("deleleDeptById(Ljava/lang/Integer;)Z")) break;
//                 return CGLIB$deleleDeptById$1$Proxy;
//             }
//             case 1826985398: {
//                 if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
//                 return CGLIB$equals$5$Proxy;
//             }
//             case 1913648695: {
//                 if (!string.equals("toString()Ljava/lang/String;")) break;
//                 return CGLIB$toString$6$Proxy;
//             }
//             case 1984935277: {
//                 if (!string.equals("hashCode()I")) break;
//                 return CGLIB$hashCode$7$Proxy;
//             }
//         }
//         return null;
//     }
//
//     @Override
//     public final int indexOf(Advisor advisor) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).indexOf(advisor);
//     }
//
//     @Override
//     public final int indexOf(Advice advice) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).indexOf(advice);
//     }
//
//     @Override
//     public final boolean isFrozen() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).isFrozen();
//     }
//
//     @Override
//     public final TargetSource getTargetSource() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).getTargetSource();
//     }
//
//     public final Class[] getProxiedInterfaces() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).getProxiedInterfaces();
//     }
//
//     public final boolean isInterfaceProxied(Class clazz) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).isInterfaceProxied(clazz);
//     }
//
//     @Override
//     public final Advisor[] getAdvisors() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).getAdvisors();
//     }
//
//     @Override
//     public final boolean isProxyTargetClass() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).isProxyTargetClass();
//     }
//
//     @Override
//     public final void setTargetSource(TargetSource targetSource) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).setTargetSource(targetSource);
//     }
//
//     @Override
//     public final void setExposeProxy(boolean bl) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).setExposeProxy(bl);
//     }
//
//     @Override
//     public final boolean isExposeProxy() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).isExposeProxy();
//     }
//
//     @Override
//     public final void setPreFiltered(boolean bl) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).setPreFiltered(bl);
//     }
//
//     @Override
//     public final boolean isPreFiltered() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).isPreFiltered();
//     }
//
//     @Override
//     public final void addAdvisor(Advisor advisor) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).addAdvisor(advisor);
//     }
//
//     @Override
//     public final void addAdvisor(int n, Advisor advisor) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).addAdvisor(n, advisor);
//     }
//
//     @Override
//     public final void removeAdvisor(int n) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).removeAdvisor(n);
//     }
//
//     @Override
//     public final boolean removeAdvisor(Advisor advisor) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).removeAdvisor(advisor);
//     }
//
//     @Override
//     public final boolean replaceAdvisor(Advisor advisor, Advisor advisor2) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).replaceAdvisor(advisor, advisor2);
//     }
//
//     @Override
//     public final void addAdvice(int n, Advice advice) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).addAdvice(n, advice);
//     }
//
//     @Override
//     public final void addAdvice(Advice advice) throws AopConfigException {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         ((Advised)dispatcher.loadObject()).addAdvice(advice);
//     }
//
//     @Override
//     public final boolean removeAdvice(Advice advice) {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).removeAdvice(advice);
//     }
//
//     @Override
//     public final String toProxyConfigString() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((Advised)dispatcher.loadObject()).toProxyConfigString();
//     }
//
//     public final Class getTargetClass() {
//         Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
//         if (dispatcher == null) {
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//             dispatcher = this.CGLIB$CALLBACK_4;
//         }
//         return ((TargetClassAware)dispatcher.loadObject()).getTargetClass();
//     }
//
//     public DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d() {
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = this;
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d);
//     }
//
//     public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$THREAD_CALLBACKS.set(callbackArray);
//     }
//
//     public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArray) {
//         CGLIB$STATIC_CALLBACKS = callbackArray;
//     }
//
//     private static final void CGLIB$BIND_CALLBACKS(Object object) {
//         block2: {
//             Object object2;
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d;
//             block3: {
//                 deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = (DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d)object;
//                 if (deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BOUND) break block2;
//                 deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BOUND = true;
//                 object2 = CGLIB$THREAD_CALLBACKS.get();
//                 if (object2 != null) break block3;
//                 object2 = CGLIB$STATIC_CALLBACKS;
//                 if (CGLIB$STATIC_CALLBACKS == null) break block2;
//             }
//             Callback[] callbackArray = (Callback[])object2;
//             DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2 = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d;
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_6 = (MethodInterceptor)callbackArray[6];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_5 = (MethodInterceptor)callbackArray[5];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_4 = (Dispatcher)callbackArray[4];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_3 = (Dispatcher)callbackArray[3];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_2 = (NoOp)callbackArray[2];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_1 = (MethodInterceptor)callbackArray[1];
//             deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d2.CGLIB$CALLBACK_0 = (MethodInterceptor)callbackArray[0];
//         }
//     }
//
//     @Override
//     public Object newInstance(Callback[] callbackArray) {
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = new DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d();
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$SET_THREAD_CALLBACKS(null);
//         return deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d;
//     }
//
//     @Override
//     public Object newInstance(Callback callback) {
//         throw new IllegalStateException("More than one callback object required");
//     }
//
//     @Override
//     public Object newInstance(Class[] classArray, Object[] objectArray, Callback[] callbackArray) {
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d;
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
//         Class[] classArray2 = classArray;
//         switch (classArray.length) {
//             case 0: {
//                 deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = new DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d();
//                 break;
//             }
//             default: {
//                 throw new IllegalArgumentException("Constructor not found");
//             }
//         }
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$SET_THREAD_CALLBACKS(null);
//         return deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d;
//     }
//
//     @Override
//     public Callback getCallback(int n) {
//         Callback callback;
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = this;
//         switch (n) {
//             case 0: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_0;
//                 break;
//             }
//             case 1: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_1;
//                 break;
//             }
//             case 2: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_2;
//                 break;
//             }
//             case 3: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_3;
//                 break;
//             }
//             case 4: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_4;
//                 break;
//             }
//             case 5: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_5;
//                 break;
//             }
//             case 6: {
//                 callback = deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$CALLBACK_6;
//                 break;
//             }
//             default: {
//                 callback = null;
//             }
//         }
//         return callback;
//     }
//
//     @Override
//     public void setCallback(int n, Callback callback) {
//         switch (n) {
//             case 0: {
//                 this.CGLIB$CALLBACK_0 = (MethodInterceptor)callback;
//                 break;
//             }
//             case 1: {
//                 this.CGLIB$CALLBACK_1 = (MethodInterceptor)callback;
//                 break;
//             }
//             case 2: {
//                 this.CGLIB$CALLBACK_2 = (NoOp)callback;
//                 break;
//             }
//             case 3: {
//                 this.CGLIB$CALLBACK_3 = (Dispatcher)callback;
//                 break;
//             }
//             case 4: {
//                 this.CGLIB$CALLBACK_4 = (Dispatcher)callback;
//                 break;
//             }
//             case 5: {
//                 this.CGLIB$CALLBACK_5 = (MethodInterceptor)callback;
//                 break;
//             }
//             case 6: {
//                 this.CGLIB$CALLBACK_6 = (MethodInterceptor)callback;
//                 break;
//             }
//         }
//     }
//
//     @Override
//     public Callback[] getCallbacks() {
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = this;
//         return new Callback[]{this.CGLIB$CALLBACK_0, this.CGLIB$CALLBACK_1, this.CGLIB$CALLBACK_2, this.CGLIB$CALLBACK_3, this.CGLIB$CALLBACK_4, this.CGLIB$CALLBACK_5, this.CGLIB$CALLBACK_6};
//     }
//
//     @Override
//     public void setCallbacks(Callback[] callbackArray) {
//         this.CGLIB$CALLBACK_0 = (MethodInterceptor)callbackArray[0];
//         this.CGLIB$CALLBACK_1 = (MethodInterceptor)callbackArray[1];
//         this.CGLIB$CALLBACK_2 = (NoOp)callbackArray[2];
//         this.CGLIB$CALLBACK_3 = (Dispatcher)callbackArray[3];
//         this.CGLIB$CALLBACK_4 = (Dispatcher)callbackArray[4];
//         this.CGLIB$CALLBACK_5 = (MethodInterceptor)callbackArray[5];
//         Callback[] callbackArray2 = callbackArray;
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d deptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d = this;
//         this.CGLIB$CALLBACK_6 = (MethodInterceptor)callbackArray[6];
//     }
//
//     static {
//         DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$STATICHOOK9();
//     }
// }
