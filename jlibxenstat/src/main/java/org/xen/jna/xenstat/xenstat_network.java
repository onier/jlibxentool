package org.xen.jna.xenstat;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : line 81</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xenstat_network extends Structure {
	public int id;
	/** Received */
	public long rbytes;
	public long rpackets;
	public long rerrs;
	public long rdrop;
	/** Transmitted */
	public long tbytes;
	public long tpackets;
	public long terrs;
	public long tdrop;
	public xenstat_network() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("id", "rbytes", "rpackets", "rerrs", "rdrop", "tbytes", "tpackets", "terrs", "tdrop");
	}
	/**
	 * @param rbytes Received<br>
	 * @param tbytes Transmitted
	 */
	public xenstat_network(int id, long rbytes, long rpackets, long rerrs, long rdrop, long tbytes, long tpackets, long terrs, long tdrop) {
		super();
		this.id = id;
		this.rbytes = rbytes;
		this.rpackets = rpackets;
		this.rerrs = rerrs;
		this.rdrop = rdrop;
		this.tbytes = tbytes;
		this.tpackets = tpackets;
		this.terrs = terrs;
		this.tdrop = tdrop;
	}
	public xenstat_network(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xenstat_network implements Structure.ByReference {
		
	};
	public static class ByValue extends xenstat_network implements Structure.ByValue {
		
	};
}
