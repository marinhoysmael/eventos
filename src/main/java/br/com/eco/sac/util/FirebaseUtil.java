package br.com.eco.sac.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.eco.sac.modelo.util.Constantes;

public class FirebaseUtil {
	
	private static FirebaseDatabase firebaseRealTimeDatabase;

	public static FirebaseDatabase getFirebaseRealTimeDatabase() {
		if (firebaseRealTimeDatabase == null) {
			firebaseRealTimeDatabase = FirebaseDatabase.getInstance();

			// A aplicação, mesmo offline tem acesso aos dados
//			firebaseRealTimeDatabase.setPersistenceEnabled(false);
		}
		return firebaseRealTimeDatabase;
	}
	
	
	public static DatabaseReference getDataBaseReference(String childPath){
		String path = Constantes.REALTIME_APP_EVENTOS +"/"+Constantes.EVENTO_NAME;
		
		if(childPath != null){
			path +="/"+childPath;
		}
		return getFirebaseRealTimeDatabase().getReference(path);
		
	}
	
}
