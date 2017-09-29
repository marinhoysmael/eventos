package br.com.eco.listener;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class AtividadeEventListener implements ChildEventListener {
	
	public void onCancelled(DatabaseError arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onChildAdded(DataSnapshot snapshot, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("AtividadeListener.onChildAdded: "+snapshot.getKey());
	}

	public void onChildChanged(DataSnapshot snapshot, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("AtividadeListener.onChildChanged: "+snapshot.getKey());
	}

	public void onChildMoved(DataSnapshot snapshot, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("AtividadeListener.onChildMoved: "+snapshot.getKey());
	}

	public void onChildRemoved(DataSnapshot snapshot) {
		// TODO Auto-generated method stub
		System.out.println("AtividadeListener.onChildRemoved: "+snapshot.getKey());
	}

}
