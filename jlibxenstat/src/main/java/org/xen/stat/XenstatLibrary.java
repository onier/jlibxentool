package org.xen.stat;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
/**
 * JNA Wrapper for library <b>xenstat</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface XenstatLibrary extends Library {
	public static final String JNA_LIBRARY_NAME = "xenstat";
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(XenstatLibrary.JNA_LIBRARY_NAME);
	public static final XenstatLibrary INSTANCE = (XenstatLibrary)Native.loadLibrary(XenstatLibrary.JNA_LIBRARY_NAME, XenstatLibrary.class);
	public static final int XENSTAT_VCPU = (int)0x1;
	public static final int XENSTAT_ALL = (int)(0x1 | 0x2 | 0x4 | 0x8);
	public static final int SHORT_ASC_LEN = (int)5;
	public static final int XENSTAT_VBD = (int)0x8;
	public static final int XENSTAT_XEN_VERSION = (int)0x4;
	public static final int XENSTAT_NETWORK = (int)0x2;
	/**
	 * Initialize the xenstat library.  Returns a handle to be used with<br>
	 * subsequent calls to the xenstat library, or NULL if an error occurs.<br>
	 * Original signature : <code>xenstat_handle* xenstat_init()</code><br>
	 * <i>native declaration : line 36</i>
	 */
	xenstat_handle xenstat_init();
	/**
	 * Release the handle to libxc, free resources, etc.<br>
	 * Original signature : <code>void xenstat_uninit(xenstat_handle*)</code><br>
	 * <i>native declaration : line 39</i>
	 */
	void xenstat_uninit(xenstat_handle handle);
	/**
	 * Original signature : <code>int xenstat_collect_networks(xenstat_node*)</code><br>
	 * <i>native declaration : line 121</i>
	 */
	int xenstat_collect_networks(xenstat_node node);
	/**
	 * Original signature : <code>void xenstat_uninit_networks(xenstat_handle*)</code><br>
	 * <i>native declaration : line 122</i>
	 */
	void xenstat_uninit_networks(xenstat_handle handle);
	/**
	 * Original signature : <code>int xenstat_collect_vbds(xenstat_node*)</code><br>
	 * <i>native declaration : line 123</i>
	 */
	int xenstat_collect_vbds(xenstat_node node);
	/**
	 * Original signature : <code>void xenstat_uninit_vbds(xenstat_handle*)</code><br>
	 * <i>native declaration : line 124</i>
	 */
	void xenstat_uninit_vbds(xenstat_handle handle);
	/**
	 * Get all available information about a node<br>
	 * Original signature : <code>xenstat_node* xenstat_get_node(xenstat_handle*, unsigned int)</code><br>
	 * <i>native declaration : line 127</i>
	 */
	xenstat_node xenstat_get_node(xenstat_handle handle, int flags);
	/**
	 * Free the information<br>
	 * Original signature : <code>void xenstat_free_node(xenstat_node*)</code><br>
	 * <i>native declaration : line 130</i>
	 */
	void xenstat_free_node(xenstat_node node);
	/**
	 * Get information about the domain with the given domain ID<br>
	 * Original signature : <code>xenstat_domain* xenstat_node_domain(xenstat_node*, unsigned int)</code><br>
	 * <i>native declaration : line 137</i>
	 */
	xenstat_domain xenstat_node_domain(xenstat_node node, int domid);
	/**
	 * Get the domain with the given index; used to loop over all domains.<br>
	 * Original signature : <code>xenstat_domain* xenstat_node_domain_by_index(xenstat_node*, unsigned)</code><br>
	 * <i>native declaration : line 141</i>
	 */
	xenstat_domain xenstat_node_domain_by_index(xenstat_node node, int index);
	/**
	 * Get xen version of the node<br>
	 * Original signature : <code>char* xenstat_node_xen_version(xenstat_node*)</code><br>
	 * <i>native declaration : line 145</i>
	 */
	Pointer xenstat_node_xen_version(xenstat_node node);
	/**
	 * Get amount of total memory on a node<br>
	 * Original signature : <code>long long xenstat_node_tot_mem(xenstat_node*)</code><br>
	 * <i>native declaration : line 148</i>
	 */
	long xenstat_node_tot_mem(xenstat_node node);
	/**
	 * Get amount of free memory on a node<br>
	 * Original signature : <code>long long xenstat_node_free_mem(xenstat_node*)</code><br>
	 * <i>native declaration : line 151</i>
	 */
	long xenstat_node_free_mem(xenstat_node node);
	/**
	 * Get amount of tmem freeable memory (in MiB) on a node<br>
	 * Original signature : <code>long xenstat_node_freeable_mb(xenstat_node*)</code><br>
	 * <i>native declaration : line 154</i>
	 */
	NativeLong xenstat_node_freeable_mb(xenstat_node node);
	/**
	 * Find the number of domains existing on a node<br>
	 * Original signature : <code>int xenstat_node_num_domains(xenstat_node*)</code><br>
	 * <i>native declaration : line 157</i>
	 */
	int xenstat_node_num_domains(xenstat_node node);
	/**
	 * Find the number of CPUs existing on a node<br>
	 * Original signature : <code>int xenstat_node_num_cpus(xenstat_node*)</code><br>
	 * <i>native declaration : line 160</i>
	 */
	int xenstat_node_num_cpus(xenstat_node node);
	/**
	 * Get information about the CPU speed<br>
	 * Original signature : <code>long long xenstat_node_cpu_hz(xenstat_node*)</code><br>
	 * <i>native declaration : line 163</i>
	 */
	long xenstat_node_cpu_hz(xenstat_node node);
	/**
	 * Get the domain ID for this domain<br>
	 * Original signature : <code>int xenstat_domain_id(xenstat_domain*)</code><br>
	 * <i>native declaration : line 170</i>
	 */
	int xenstat_domain_id(xenstat_domain domain);
	/**
	 * Set the domain name for the domain<br>
	 * Original signature : <code>char* xenstat_domain_name(xenstat_domain*)</code><br>
	 * <i>native declaration : line 173</i>
	 */
	Pointer xenstat_domain_name(xenstat_domain domain);
	/**
	 * Get information about how much CPU time has been used<br>
	 * Original signature : <code>long long xenstat_domain_cpu_ns(xenstat_domain*)</code><br>
	 * <i>native declaration : line 176</i>
	 */
	long xenstat_domain_cpu_ns(xenstat_domain domain);
	/**
	 * Find the number of VCPUs allocated to a domain<br>
	 * Original signature : <code>int xenstat_domain_num_vcpus(xenstat_domain*)</code><br>
	 * <i>native declaration : line 179</i>
	 */
	int xenstat_domain_num_vcpus(xenstat_domain domain);
	/**
	 * Get the VCPU handle to obtain VCPU stats<br>
	 * Original signature : <code>xenstat_vcpu* xenstat_domain_vcpu(xenstat_domain*, unsigned int)</code><br>
	 * <i>native declaration : line 182</i>
	 */
	xenstat_vcpu xenstat_domain_vcpu(xenstat_domain domain, int vcpu);
	/**
	 * Find the current memory reservation for this domain<br>
	 * Original signature : <code>long long xenstat_domain_cur_mem(xenstat_domain*)</code><br>
	 * <i>native declaration : line 186</i>
	 */
	long xenstat_domain_cur_mem(xenstat_domain domain);
	/**
	 * Find the maximum memory reservation for this domain<br>
	 * Original signature : <code>long long xenstat_domain_max_mem(xenstat_domain*)</code><br>
	 * <i>native declaration : line 189</i>
	 */
	long xenstat_domain_max_mem(xenstat_domain domain);
	/**
	 * Find the domain's SSID<br>
	 * Original signature : <code>int xenstat_domain_ssid(xenstat_domain*)</code><br>
	 * <i>native declaration : line 192</i>
	 */
	int xenstat_domain_ssid(xenstat_domain domain);
	/**
	 * Get domain states<br>
	 * Original signature : <code>int xenstat_domain_dying(xenstat_domain*)</code><br>
	 * <i>native declaration : line 195</i>
	 */
	int xenstat_domain_dying(xenstat_domain domain);
	/**
	 * Original signature : <code>int xenstat_domain_crashed(xenstat_domain*)</code><br>
	 * <i>native declaration : line 196</i>
	 */
	int xenstat_domain_crashed(xenstat_domain domain);
	/**
	 * Original signature : <code>int xenstat_domain_shutdown(xenstat_domain*)</code><br>
	 * <i>native declaration : line 197</i>
	 */
	int xenstat_domain_shutdown(xenstat_domain domain);
	/**
	 * Original signature : <code>int xenstat_domain_paused(xenstat_domain*)</code><br>
	 * <i>native declaration : line 198</i>
	 */
	int xenstat_domain_paused(xenstat_domain domain);
	/**
	 * Original signature : <code>int xenstat_domain_blocked(xenstat_domain*)</code><br>
	 * <i>native declaration : line 199</i>
	 */
	int xenstat_domain_blocked(xenstat_domain domain);
	/**
	 * Original signature : <code>int xenstat_domain_running(xenstat_domain*)</code><br>
	 * <i>native declaration : line 200</i>
	 */
	int xenstat_domain_running(xenstat_domain domain);
	/**
	 * Get the number of networks for a given domain<br>
	 * Original signature : <code>int xenstat_domain_num_networks(xenstat_domain*)</code><br>
	 * <i>native declaration : line 203</i>
	 */
	int xenstat_domain_num_networks(xenstat_domain xenstat_domainPtr1);
	/**
	 * Get the network handle to obtain network stats<br>
	 * Original signature : <code>xenstat_network* xenstat_domain_network(xenstat_domain*, unsigned int)</code><br>
	 * <i>native declaration : line 206</i>
	 */
	xenstat_network xenstat_domain_network(xenstat_domain domain, int network);
	/**
	 * Get the number of VBDs for a given domain<br>
	 * Original signature : <code>int xenstat_domain_num_vbds(xenstat_domain*)</code><br>
	 * <i>native declaration : line 210</i>
	 */
	int xenstat_domain_num_vbds(xenstat_domain xenstat_domainPtr1);
	/**
	 * Get the VBD handle to obtain VBD stats<br>
	 * Original signature : <code>xenstat_vbd* xenstat_domain_vbd(xenstat_domain*, unsigned int)</code><br>
	 * <i>native declaration : line 213</i>
	 */
	xenstat_vbd xenstat_domain_vbd(xenstat_domain domain, int vbd);
	/**
	 * Get the tmem information for a given domain<br>
	 * Original signature : <code>xenstat_tmem* xenstat_domain_tmem(xenstat_domain*)</code><br>
	 * <i>native declaration : line 217</i>
	 */
	xenstat_tmem xenstat_domain_tmem(xenstat_domain domain);
	/**
	 * Get VCPU usage<br>
	 * Original signature : <code>int xenstat_vcpu_online(xenstat_vcpu*)</code><br>
	 * <i>native declaration : line 224</i>
	 */
	int xenstat_vcpu_online(xenstat_vcpu vcpu);
	/**
	 * Original signature : <code>long long xenstat_vcpu_ns(xenstat_vcpu*)</code><br>
	 * <i>native declaration : line 225</i>
	 */
	long xenstat_vcpu_ns(xenstat_vcpu vcpu);
	/**
	 * Get the ID for this network<br>
	 * Original signature : <code>int xenstat_network_id(xenstat_network*)</code><br>
	 * <i>native declaration : line 233</i>
	 */
	int xenstat_network_id(xenstat_network network);
	/**
	 * Get the number of receive bytes for this network<br>
	 * Original signature : <code>long long xenstat_network_rbytes(xenstat_network*)</code><br>
	 * <i>native declaration : line 236</i>
	 */
	long xenstat_network_rbytes(xenstat_network network);
	/**
	 * Get the number of receive packets for this network<br>
	 * Original signature : <code>long long xenstat_network_rpackets(xenstat_network*)</code><br>
	 * <i>native declaration : line 239</i>
	 */
	long xenstat_network_rpackets(xenstat_network network);
	/**
	 * Get the number of receive errors for this network<br>
	 * Original signature : <code>long long xenstat_network_rerrs(xenstat_network*)</code><br>
	 * <i>native declaration : line 242</i>
	 */
	long xenstat_network_rerrs(xenstat_network network);
	/**
	 * Get the number of receive drops for this network<br>
	 * Original signature : <code>long long xenstat_network_rdrop(xenstat_network*)</code><br>
	 * <i>native declaration : line 245</i>
	 */
	long xenstat_network_rdrop(xenstat_network network);
	/**
	 * Get the number of transmit bytes for this network<br>
	 * Original signature : <code>long long xenstat_network_tbytes(xenstat_network*)</code><br>
	 * <i>native declaration : line 248</i>
	 */
	long xenstat_network_tbytes(xenstat_network network);
	/**
	 * Get the number of transmit packets for this network<br>
	 * Original signature : <code>long long xenstat_network_tpackets(xenstat_network*)</code><br>
	 * <i>native declaration : line 251</i>
	 */
	long xenstat_network_tpackets(xenstat_network network);
	/**
	 * Get the number of transmit errors for this network<br>
	 * Original signature : <code>long long xenstat_network_terrs(xenstat_network*)</code><br>
	 * <i>native declaration : line 254</i>
	 */
	long xenstat_network_terrs(xenstat_network network);
	/**
	 * Get the number of transmit drops for this network<br>
	 * Original signature : <code>long long xenstat_network_tdrop(xenstat_network*)</code><br>
	 * <i>native declaration : line 257</i>
	 */
	long xenstat_network_tdrop(xenstat_network network);
	/**
	 * Get the back driver type  for Virtual Block Device<br>
	 * Original signature : <code>int xenstat_vbd_type(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 264</i>
	 */
	int xenstat_vbd_type(xenstat_vbd vbd);
	/**
	 * Get the device number for Virtual Block Device<br>
	 * Original signature : <code>int xenstat_vbd_dev(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 267</i>
	 */
	int xenstat_vbd_dev(xenstat_vbd vbd);
	/**
	 * Get the number of OO/RD/WR requests for vbd<br>
	 * Original signature : <code>long long xenstat_vbd_oo_reqs(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 270</i>
	 */
	long xenstat_vbd_oo_reqs(xenstat_vbd vbd);
	/**
	 * Original signature : <code>long long xenstat_vbd_rd_reqs(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 271</i>
	 */
	long xenstat_vbd_rd_reqs(xenstat_vbd vbd);
	/**
	 * Original signature : <code>long long xenstat_vbd_wr_reqs(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 272</i>
	 */
	long xenstat_vbd_wr_reqs(xenstat_vbd vbd);
	/**
	 * Original signature : <code>long long xenstat_vbd_rd_sects(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 273</i>
	 */
	long xenstat_vbd_rd_sects(xenstat_vbd vbd);
	/**
	 * Original signature : <code>long long xenstat_vbd_wr_sects(xenstat_vbd*)</code><br>
	 * <i>native declaration : line 274</i>
	 */
	long xenstat_vbd_wr_sects(xenstat_vbd vbd);
	/**
	 * Tmem functions - extract tmem information<br>
	 * Original signature : <code>long long xenstat_tmem_curr_eph_pages(xenstat_tmem*)</code><br>
	 * <i>native declaration : line 279</i>
	 */
	long xenstat_tmem_curr_eph_pages(xenstat_tmem tmem);
	/**
	 * Original signature : <code>long long xenstat_tmem_succ_eph_gets(xenstat_tmem*)</code><br>
	 * <i>native declaration : line 280</i>
	 */
	long xenstat_tmem_succ_eph_gets(xenstat_tmem tmem);
	/**
	 * Original signature : <code>long long xenstat_tmem_succ_pers_puts(xenstat_tmem*)</code><br>
	 * <i>native declaration : line 281</i>
	 */
	long xenstat_tmem_succ_pers_puts(xenstat_tmem tmem);
	/**
	 * Original signature : <code>long long xenstat_tmem_succ_pers_gets(xenstat_tmem*)</code><br>
	 * <i>native declaration : line 282</i>
	 */
	long xenstat_tmem_succ_pers_gets(xenstat_tmem tmem);
	public static class xs_handle extends PointerType {
		public xs_handle(Pointer address) {
			super(address);
		}
		public xs_handle() {
			super();
		}
	};
	public static class xc_interface extends PointerType {
		public xc_interface(Pointer address) {
			super(address);
		}
		public xc_interface() {
			super();
		}
	};
}
