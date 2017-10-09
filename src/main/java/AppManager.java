

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.mentawai.ajax.renderer.JsonRenderer;
import org.mentawai.core.ApplicationManager;
import org.mentawai.core.Context;
import org.mentawai.db.SessionHandler;
import org.mentawai.filter.AuthenticationFilter;
import org.mentawai.filter.AutoWiringFilter;
import org.mentawai.filter.HibernateFilter;
import org.mentawai.filter.InjectionFilter;
import org.mentawai.filter.IoCFilter;
import org.mentawai.filter.ValidationFilter;
import org.mentawai.transaction.HibernateTransaction;

import com.google.gson.Gson;

import br.com.we.congressus.action.AdministracaoAction;
import br.com.we.congressus.action.AtividadeAction;
import br.com.we.congressus.action.EnderecoAction;
import br.com.we.congressus.action.EventoAction;
import br.com.we.congressus.action.LoginAction;
import br.com.we.congressus.action.UsuarioAction;
import br.com.we.congressus.dao.DaoFactory;
import br.com.we.congressus.daoHbn.DaoFactoryHbn;
import br.com.we.congressus.filter.RegistroAcessoFilter;
import br.com.we.congressus.service.AtividadeService;
import br.com.we.congressus.service.CidadeService;
import br.com.we.congressus.service.ContaService;
import br.com.we.congressus.service.EnderecoService;
import br.com.we.congressus.service.EstadoService;
import br.com.we.congressus.service.EventoService;
import br.com.we.congressus.service.InscricaoService;
import br.com.we.congressus.service.UsuarioService;
import br.com.we.congressus.serviceImpl.AtividadeServiceImpl;
import br.com.we.congressus.serviceImpl.CidadeServiceImpl;
import br.com.we.congressus.serviceImpl.ContaServiceImpl;
import br.com.we.congressus.serviceImpl.EnderecoServiceImpl;
import br.com.we.congressus.serviceImpl.EstadoServiceImpl;
import br.com.we.congressus.serviceImpl.EventoServiceImpl;
import br.com.we.congressus.serviceImpl.InscricaoServiceImpl;
import br.com.we.congressus.serviceImpl.UsuarioServiceImpl;
import br.com.we.congressus.util.FirebaseConnection;

public class AppManager extends ApplicationManager{
	
	private HibernateFilter hibernateFilter;
	
	private SessionFactory sessionFactory;
	
	@Override
	public void onStarted(Context context) {
		
		new FirebaseConnection().start(); // Iniciar conexao com firebase
		
		super.onStarted(context);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		
		addGlobalConsequence(EXCEPTION, fwd("jsp/Mensagem/500.html"));
	}
	
	@Override
	public SessionHandler createSessionHandler() {
		 Configuration configuration = new Configuration();
         configuration.configure("hibernate.cfg.xml");
         
         StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
         sessionFactory = configuration.buildSessionFactory(ssrb.build());
         
	    return new SessionHandler(sessionFactory);
	}
	
	@Override
	public void loadFilters() {
		
		filter(new AuthenticationFilter());
		filter(new ValidationFilter());
		
		on(LOGIN, redir(LoginAction.class, "login"));
		
		hibernateFilter = new HibernateFilter("/hibernate.cfg.xml");
		hibernateFilter.setTransactional(true);
		
        ioc("sessionFactory", sessionFactory);
        ioc("transaction", HibernateTransaction.class);
        di("session", Session.class);
        di("sessionFactory", SessionFactory.class);
	    addGlobalFilter(hibernateFilter);
	    
		addGlobalFilter(new IoCFilter());
		addGlobalFilter(new AutoWiringFilter());
		addGlobalFilter(new InjectionFilter());
		addGlobalFilter(new RegistroAcessoFilter());
	}
	
	@Override
	public void setupIoC() {
		        
		// IOC
		//=============================
		ioc(AtividadeService.class, AtividadeServiceImpl.class);
		
		ioc(CidadeService.class, CidadeServiceImpl.class);
		ioc(ContaService.class, ContaServiceImpl.class);
		
		ioc(EnderecoService.class, EnderecoServiceImpl.class);
		ioc(EstadoService.class, EstadoServiceImpl.class);
		ioc(EventoService.class, EventoServiceImpl.class);
		
		ioc(InscricaoService.class, InscricaoServiceImpl.class);
		
		
		ioc(UsuarioService.class, UsuarioServiceImpl.class);

		// DI
		//=============================
		di("atividadeService", AtividadeService.class);
		
		di("cidadeService", CidadeService.class);
		di("contaService", ContaService.class);
		
		di("enderecoService", EnderecoService.class);
		di("estadoService", EstadoService.class);
		di("eventoService", EventoService.class);
		
		di("inscricaoService", InscricaoService.class);
		
		di("usuarioService", UsuarioService.class);
		
		ioc("daoFactory", DaoFactoryHbn.class);
		di("daoFactory", DaoFactory.class);
        di("session", Session.class);
		
	}
	
	@Override
	public void loadActions() {
		
		action(LoginAction.class, "efetuarLogin")
			.on(SUCCESS, ajax(new JsonRenderer()))
			.on(ERROR, ajax(new JsonRenderer()));
		
		action(LoginAction.class, "login")
			.on(SUCCESS, fwd("/login.html"));
		
		action(LoginAction.class, "logout")
			.on(SUCCESS, redir(LoginAction.class, "login"));
		
		action(AdministracaoAction.class, "index")
			.on(SUCCESS, fwd("/index.html"));
		
		action(AdministracaoAction.class, "dashboard")
			.on(SUCCESS, fwd("/dashboard.html"));
		
		action(AtividadeAction.class, "cadastro")
		.on(SUCCESS, fwd("jsp/admin/Atividade/cadastro.jsp"));

		action(AtividadeAction.class, "salvar")
			.on(ERROR, ajax(new JsonRenderer()))
			.on(SUCCESS, ajax(new JsonRenderer()));
		
		
		
		/*=========================
		 * EVENTO
		 *=========================
		 */
		action(EventoAction.class, "cadastro")
			.on(SUCCESS, fwd("/pages/Evento/cadastro.html"));
		
		action(EventoAction.class, "listar")
			.on(SUCCESS, fwd("/pages/Evento/lista.html"))
			.on(AJAX, ajax(new JsonRenderer()));
	
		
		action(EventoAction.class, "salvar")
			.on(ERROR, ajax(new JsonRenderer()))
			.on(SUCCESS, ajax(new JsonRenderer()));
		
		/*=========================
		 * ENDERECO
		 *=========================
		 */
		action(EnderecoAction.class, "listarEstados")
			.on(SUCCESS, ajax(new JsonRenderer()));
		
		action(EnderecoAction.class, "listarCidades")
			.on(SUCCESS, ajax(new JsonRenderer()));
		

		/*=========================
		 * USUARIO
		 *=========================
		 */
		action(UsuarioAction.class, "cadastro")
			.on(SUCCESS, fwd("pages/Usuario/cadastro.html"));

		action(UsuarioAction.class, "salvar")
			.on(SUCCESS, ajax(new JsonRenderer()))
			.on(ACCESSDENIED, ajax(new JsonRenderer()));
		
		action(UsuarioAction.class, "dashboard")
			.on(SUCCESS, fwd("pages/Usuario/dashboard.html"));
	}
	
}
