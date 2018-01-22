package com.byxy.student.aop;

import java.util.UUID;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.byxy.student.entity.StudentLog;
import com.byxy.student.service.StudentLogService;

@Aspect // 1 声明切面
@Component // 2.注册为Bean
public class LogAop {
	@Resource
	private StudentLogService studentLogService;

	@Pointcut("execution(public * com.byxy.student.service.*.*(..))")
	public void matchService() {

	}

	@Pointcut("execution(public * com.byxy.student.service.StudentLogService.save(..))") // 3. 声明切入点
	public void matchLogService() {

	}

	// Service层加入Log日志， 除了Log日志自己的业务类不加面
	 @Around("!matchLogService() && matchService()") // 4. 注册切入点，加入过滤逻辑，运算符知识查看下表1
	Object around(ProceedingJoinPoint pjp) throws Throwable {
		// 创建日志记录对象
		StudentLog studentLog = new StudentLog();
		studentLog.setId(UUID.randomUUID().toString());
		// 拦截的参数类型
		Signature sig = pjp.getSignature();
		// 获取拦截方法名字
		String methodName = sig.getName();
		System.out.println("拦截方法名字 =" + methodName);
		studentLog.setMethod(methodName);
		// 获取拦截方法参数类型
		Class<?>[] parameterTypes = ((MethodSignature) sig).getMethod().getParameterTypes();
		// 获取拦截方法参数值
		Object[] args = pjp.getArgs();
		// 打印参数，类型，值
		for (int i = 0; i < args.length; i++) {
			System.out.println("参数" + i + " 参数类型=" + parameterTypes[i].getSimpleName() + " 值=" + args[i]);
		}
		// 继续执行
		Object object = pjp.proceed(); // 这是关键
		studentLogService.save(studentLog);
		// 保存日志记录对象
		return object;
	}
}
