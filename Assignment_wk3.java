/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_wk3;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import javax.management.MXBean;


/**
 *
 * @author osboxes
 */
public class Assignment_wk3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        System.out.println("Program starting...");        
        Runtime run = Runtime.getRuntime();
        //F.1 number of processor the VM has
        System.out.println(""+run.availableProcessors());
        
        //F.2 view info of OS
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(""); 
        System.out.println("the os name: "+os.getName()+" the os version: "+os.getVersion()); 
        
        //F.3 view info of VM
        RuntimeMXBean vm = ManagementFactory.getRuntimeMXBean();
        System.out.println("");
        System.out.println("VM name: "+vm.getName()+" vm spec version: "+vm.getVmVersion());
        
        //F.4 start new process. in this case its epiphany bc we are using a different distro elementary OS (you can change it to firefox)
        var processbuilder  = new ProcessBuilder();
        processbuilder.command("/usr/bin/epiphany");
        
        var process = processbuilder.start();
        
        var hold = process.waitFor();
        
        System.out.printf("epiphany start. ", hold);
        System.out.println("");
    }
    
}
