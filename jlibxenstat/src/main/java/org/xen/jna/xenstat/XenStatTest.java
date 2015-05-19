/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.jna.xenstat;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 *
 * @author root
 */
public class XenStatTest {

    public static void main(String[] args) {
        PointerByReference handler = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_init();
        System.out.println(handler);
        PointerByReference node = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_get_node(handler, OrgXenJnaXenstatLibrary.XENSTAT_ALL);
        int domainNumber = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_node_num_domains(node);
        System.out.println("domainNumber    " + domainNumber);
        for (int i = 0; i < domainNumber; i++) {
            PointerByReference domain = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_node_domain_by_index(node, i);
            int domainID = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_id(domain);
            System.out.print("domainID    " + domainID);
            Pointer name = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_name(domain);
            System.out.print("    domainName  " + name.getString(0));
            int count = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_num_vcpus(domain);
            System.out.print("    cpuNumber   " + count);
            long cpuns = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_cpu_ns(domain);
            System.out.print("    cpuNS   " + cpuns);
            int ssid = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_ssid(domain);
            System.out.print("    ssid    " + ssid);
            long reservation = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_cur_mem(domain);
            System.out.print("    reservation   " + reservation);
            long maxMem = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_max_mem(domain);
            System.out.print("    maxMem   " + maxMem);
            int dying = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_dying(domain);
            System.out.print("  dying   " + dying);
            int crashed = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_crashed(domain);
            System.out.print("  crashed   " + crashed);
            int running = OrgXenJnaXenstatLibrary.INSTANCE.xenstat_domain_running(domain);
            System.out.print("  running   " + running);
            System.out.println("");
        }
        OrgXenJnaXenstatLibrary.INSTANCE.xenstat_free_node(node);
    }

}
