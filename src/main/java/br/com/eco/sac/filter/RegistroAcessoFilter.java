package br.com.eco.sac.filter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.mentawai.action.BaseLoginAction;
import org.mentawai.core.Context;
import org.mentawai.core.Filter;
import org.mentawai.core.InvocationChain;
import org.mentawai.core.SessionContext;

import br.com.eco.sac.model.Usuario;
import br.com.eco.sac.modelo.util.RegistroAcesso;

public class RegistroAcessoFilter implements Filter{

	public String filter(InvocationChain chain) throws Exception {
		long time = System.currentTimeMillis();
		Context context = chain.getAction().getSession();
		
		String action = chain.getActionName();
		String innerAction = chain.getInnerAction();
		String resultado = chain.invoke();
		
		Usuario usuario = (Usuario) BaseLoginAction.getUserSession(context);
		
		if(usuario != null){
			RegistroAcesso registroAcesso = new RegistroAcesso();
			
			action = action.replace("Action", "");
			registroAcesso.setAction(action);
			registroAcesso.setInnerAction(innerAction);
			registroAcesso.setUsuario(usuario);
			registroAcesso.setTempo(System.currentTimeMillis() - time);
			registroAcesso.setResultado(resultado);
			registroAcesso.setData(new Date());
		
		
			SessionContext sessionContext = (SessionContext) chain.getAction().getSession();
			List<RegistroAcesso> listaRegistroAcessos = (List<RegistroAcesso>) sessionContext.getAttribute("listaRegistroAcessos");
		   
			if(listaRegistroAcessos == null){
                listaRegistroAcessos = new ArrayList<RegistroAcesso>();
            }
	            
			synchronized (listaRegistroAcessos) {
			    
	            listaRegistroAcessos.add(registroAcesso);
	            
	            if(context instanceof SessionContext){
	                
	                Session session = (Session) chain.getAction().getInput().getValue("session"); // hibernate
	                if(listaRegistroAcessos.size() == 10){
	                    for (RegistroAcesso registro : listaRegistroAcessos) {
	                        session.save(registro);
	                    }
	                    listaRegistroAcessos.clear();
	                }
	                sessionContext.setAttribute("listaRegistroAcessos", listaRegistroAcessos);
	            }
            }
		}
		return resultado;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
