package br.com.alinesoftware.util;

public class Util {

	private static Util instance;

	private Util() {
		super();
	}

	static {
		instance = new Util();
	}

	public static Util getInstance() {
		return instance;
	}


}
