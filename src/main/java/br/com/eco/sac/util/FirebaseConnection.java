package br.com.eco.sac.util;

import java.io.InputStream;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.eco.listener.AtividadeEventListener;
import br.com.eco.sac.model.Atividade;
import br.com.eco.sac.modelo.util.Constantes;

public class FirebaseConnection extends Thread{
	public static boolean initialized = false;
	
	public FirebaseConnection(){
		setDaemon(true);
	}
	
	@Override
	public void run() {
		getDatabase(null); // initialize

		runEventoRealTimeDataBase();
	}
	
	public static final FirebaseDatabase getDatabase(String app) {
		if (!initialized) {

			InputStream inputStream = FirebaseConnection.class.getClassLoader()
					.getResourceAsStream(Constantes.GOOGLE_SERVICE_ACCOUNT_CREDENTIALS_FILE_CONFIG_PATH);

			FirebaseOptions options = new FirebaseOptions.Builder()
											.setServiceAccount(inputStream)
											.setDatabaseUrl(Constantes.REALTIME_DATABASE_URL)
											.build();

			FirebaseApp.initializeApp(options);
			initialized = true;
		}

		FirebaseDatabase instance = FirebaseDatabase.getInstance();

		return instance;

	}
	
	private void runEventoRealTimeDataBase(){
		
		FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
		
		//TODO: Pegar o nickname do banco
		DatabaseReference databaseReference = FirebaseUtil.getDataBaseReference(null);
		
		AtividadeEventListener atividadeEventListener = new AtividadeEventListener();
		
		databaseReference.child(Atividade.class.getSimpleName()).orderByKey().addChildEventListener(atividadeEventListener);
	}
}
