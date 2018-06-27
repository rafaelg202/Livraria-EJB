package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class LogInterceptador {

	@AroundInvoke
	public Object intercpta(InvocationContext context) throws Exception {
		
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed();
		
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		String nomeMetodo = context.getMethod().getName();
		
		System.out.println("[INFO] " + nomeClasse + "->" + nomeMetodo);
		System.out.println("[INFO] Tempo gasto no acesso ao BD: "
				+ (System.currentTimeMillis() - millis) + "ms");
		
		return o;
	}
}
