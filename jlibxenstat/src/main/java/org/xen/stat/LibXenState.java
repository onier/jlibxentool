/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.stat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author root
 */
public class LibXenState {

    private xenstat_handle handler;

    public LibXenState() {
        handler = XenstatLibrary.INSTANCE.xenstat_init();
    }

    public static void main(String[] args) throws InterruptedException {
          LibXenState libXenState = new LibXenState();
        for (;;) {
            System.out.println(Arrays.toString(libXenState.collectDomains().toArray()));
            Thread.sleep(5000);
//            XenstatLibrary.INSTANCE.xenstat_uninit(libXenState.handler);
        }
    }

    public List<Domain> collectDomains() {
        List<Domain> domains = new ArrayList<>();
        xenstat_node node = XenstatLibrary.INSTANCE.xenstat_get_node(handler, XenstatLibrary.XENSTAT_ALL);
        int domNum = node.num_domains;
        for (int i = 0; i < domNum; i++) {
            Domain domain = new Domain();
            domains.add(domain);
            xenstat_domain dom = XenstatLibrary.INSTANCE.xenstat_node_domain_by_index(node, i);
            domain.setDomID(dom.id);
            domain.setMaxMemory(XenstatLibrary.INSTANCE.xenstat_domain_max_mem(dom));
            domain.setCurrentyMemory(XenstatLibrary.INSTANCE.xenstat_domain_cur_mem(dom));
            domain.setDomName(dom.name.getString(0));
            domain.setSsid(XenstatLibrary.INSTANCE.xenstat_domain_ssid(dom));
            int vcpuNum = dom.num_vcpus;
            for (int j = 0; j < vcpuNum; j++) {
                xenstat_vcpu vcpu = XenstatLibrary.INSTANCE.xenstat_domain_vcpu(dom, j);
                domain.getVcpus().add(vcpu);
            }
            int networkNum = dom.num_networks;
            for (int j = 0; j < networkNum; j++) {
                xenstat_network network = XenstatLibrary.INSTANCE.xenstat_domain_network(dom, j);
                domain.getNetworks().add(network);
            }
            int vbdNum = dom.num_vbds;
            for (int j = 0; j < vbdNum; j++) {
                xenstat_vbd vbd = XenstatLibrary.INSTANCE.xenstat_domain_vbd(dom, j);
                domain.getVbds().add(vbd);
            }
            domain.setTmem(XenstatLibrary.INSTANCE.xenstat_domain_tmem(dom));
        }
//        XenstatLibrary.INSTANCE.xenstat_free_node(node);
        return domains;
    }

    public static class Domain {

        private int domID;
        private String domName;
        private int state;
        private long cpu_ns;
        private long currentyMemory;
        private long maxMemory;
        private int ssid;
        private List<xenstat_network> networks = new ArrayList<>();
        private List<xenstat_vcpu> vcpus = new ArrayList<>();
        private List<xenstat_vbd> vbds = new ArrayList<>();
        private xenstat_tmem tmem;

        @Override
        public String toString() {
            return domName + "    domID   " + domID + "    state   " + state + "   cpu_ns " + cpu_ns + "  currentyMemory  " + currentyMemory + "  maxMemory   "
                    + maxMemory + "   networks " + networks.size() + " vcpus   " + vcpus.size() + "    vbds    " + vbds.size() + " tmem    " + tmem;
        }

        /**
         * @return the domID
         */
        public int getDomID() {
            return domID;
        }

        /**
         * @param domID the domID to set
         */
        public void setDomID(int domID) {
            this.domID = domID;
        }

        /**
         * @return the domName
         */
        public String getDomName() {
            return domName;
        }

        /**
         * @param domName the domName to set
         */
        public void setDomName(String domName) {
            this.domName = domName;
        }

        /**
         * @return the state
         */
        public int getState() {
            return state;
        }

        /**
         * @param state the state to set
         */
        public void setState(int state) {
            this.state = state;
        }

        /**
         * @return the cpu_ns
         */
        public long getCpu_ns() {
            return cpu_ns;
        }

        /**
         * @param cpu_ns the cpu_ns to set
         */
        public void setCpu_ns(long cpu_ns) {
            this.cpu_ns = cpu_ns;
        }

        /**
         * @return the currentyMemory
         */
        public long getCurrentyMemory() {
            return currentyMemory;
        }

        /**
         * @param currentyMemory the currentyMemory to set
         */
        public void setCurrentyMemory(long currentyMemory) {
            this.currentyMemory = currentyMemory;
        }

        /**
         * @return the maxMemory
         */
        public long getMaxMemory() {
            return maxMemory;
        }

        /**
         * @param maxMemory the maxMemory to set
         */
        public void setMaxMemory(long maxMemory) {
            this.maxMemory = maxMemory;
        }

        /**
         * @return the ssid
         */
        public int getSsid() {
            return ssid;
        }

        /**
         * @param ssid the ssid to set
         */
        public void setSsid(int ssid) {
            this.ssid = ssid;
        }

        /**
         * @return the networks
         */
        public List<xenstat_network> getNetworks() {
            return networks;
        }

        /**
         * @param networks the networks to set
         */
        public void setNetworks(List<xenstat_network> networks) {
            this.networks = networks;
        }

        /**
         * @return the vcpus
         */
        public List<xenstat_vcpu> getVcpus() {
            return vcpus;
        }

        /**
         * @param vcpus the vcpus to set
         */
        public void setVcpus(List<xenstat_vcpu> vcpus) {
            this.vcpus = vcpus;
        }

        /**
         * @return the vbds
         */
        public List<xenstat_vbd> getVbds() {
            return vbds;
        }

        /**
         * @param vbds the vbds to set
         */
        public void setVbds(List<xenstat_vbd> vbds) {
            this.vbds = vbds;
        }

        /**
         * @return the tmem
         */
        public xenstat_tmem getTmem() {
            return tmem;
        }

        /**
         * @param tmem the tmem to set
         */
        public void setTmem(xenstat_tmem tmem) {
            this.tmem = tmem;
        }
    }

    public static class TMEM {

        public long curr_eph_pages;
        public long succ_eph_gets;
        public long succ_pers_puts;
        public long succ_pers_gets;

        public TMEM(xenstat_tmem tmem) {
            curr_eph_pages = tmem.curr_eph_pages;
            succ_eph_gets = tmem.succ_eph_gets;
            succ_pers_gets = tmem.succ_pers_gets;
            succ_pers_puts = tmem.succ_pers_puts;
        }
    }

    public static class VBD {

        public int back_type;
        public int dev;
        public long oo_reqs;
        public long rd_reqs;
        public long wr_reqs;
        public long rd_sects;
        public long wr_sects;

        public VBD(xenstat_vbd vbd) {
            this.back_type = vbd.back_type;
            this.dev = vbd.dev;
            this.oo_reqs = vbd.oo_reqs;
            this.rd_reqs = vbd.rd_reqs;
            this.wr_reqs = vbd.wr_reqs;
            this.rd_sects = vbd.rd_sects;
            this.wr_sects = vbd.wr_sects;
        }

    }

    public static class VCPU {

        public int online;
        public long ns;

        public VCPU(xenstat_vcpu vcpu) {
            online = vcpu.online;
            ns = vcpu.ns;
        }

    }

    public static class VNetWork {

        public int id;
        /**
         * Received
         */
        public long rbytes;
        public long rpackets;
        public long rerrs;
        public long rdrop;
        /**
         * Transmitted
         */
        public long tbytes;
        public long tpackets;
        public long terrs;
        public long tdrop;

        public VNetWork(xenstat_network network) {
            id = network.id;
            rbytes = network.rbytes;
            rpackets = network.rpackets;
            rerrs = network.rerrs;
            rdrop = network.rdrop;
            tbytes = network.tbytes;
            tpackets = network.tpackets;
            terrs = network.terrs;
            tdrop = network.tdrop;
        }

    }
}
