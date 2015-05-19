package org.xen.jna.xenstat;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 * <i>native declaration : line 40</i><br>
 * This file was autogenerated by
 * <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit
 * <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> ,
 * <a href="http://rococoa.dev.java.net/">Rococoa</a>, or
 * <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xenstat_node extends Structure {

    /**
     * C type : xenstat_handle*
     */
    public org.xen.jna.xenstat.xenstat_handle.ByReference handle;
    public int flags;
    public long cpu_hz;
    public int num_cpus;
    public long tot_mem;
    public long free_mem;
    public int num_domains;
    /**
     * Array of length num_domains<br>
     * C type : xenstat_domain*
     */
    public org.xen.jna.xenstat.xenstat_domain.ByReference domains;
    public NativeLong freeable_mb;

    public xenstat_node() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("handle", "flags", "cpu_hz", "num_cpus", "tot_mem", "free_mem", "num_domains", "domains", "freeable_mb");
    }

    /**
     * @param handle C type : xenstat_handle*<br>
     * @param domains Array of length num_domains<br>
     * C type : xenstat_domain*
     */
    public xenstat_node(org.xen.jna.xenstat.xenstat_handle.ByReference handle, int flags, long cpu_hz, int num_cpus, long tot_mem, long free_mem, int num_domains, org.xen.jna.xenstat.xenstat_domain.ByReference domains, NativeLong freeable_mb) {
        super();
        this.handle = handle;
        this.flags = flags;
        this.cpu_hz = cpu_hz;
        this.num_cpus = num_cpus;
        this.tot_mem = tot_mem;
        this.free_mem = free_mem;
        this.num_domains = num_domains;
        this.domains = domains;
        this.freeable_mb = freeable_mb;
    }

    public xenstat_node(Pointer peer) {
        super(peer);
    }

    public static class ByReference extends xenstat_node implements Structure.ByReference {

    };

    public static class ByValue extends xenstat_node implements Structure.ByValue {

    };
}
