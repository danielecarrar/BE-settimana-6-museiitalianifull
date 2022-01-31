package it.musei.presentation;
import it.musei.entity.Museo;


public class TransferMuseo {

	private boolean success;
	private Museo museo;
	private String message;
	
	public TransferMuseo(boolean success, Museo museo, String message) {
		this.success = success;
		this.museo = museo;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public Museo getMuseo() {
		return museo;
	}
	public String getMessage() {
		return message;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setMuseo(Museo museo) {
		this.museo = museo;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}