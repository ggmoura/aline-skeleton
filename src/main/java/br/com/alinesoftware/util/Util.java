package br.com.alinesoftware.util;

public class Util {

	private static Util instance;

	private Util() {
		super();
	}

	public static Util getInstance() {
		if (instance == null) {
			instance = new Util();
		}
		return instance;
	}


}
