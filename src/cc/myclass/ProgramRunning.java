package cc.myclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.Principal;
import java.util.List;


public class ProgramRunning {
	public ProgramRunning() {}
	
	public void run(List<Program> list) {
		for (Program program : list) {
			if (!isActive(program.getName(),program.getName())) {
				try {
					Runtime.getRuntime().exec(program.getPath());
					Thread.sleep(1000);
					System.out.println(program.getName() + "--程序启动成功");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else {
				System.out.println(program.getName() + "--程序已经在运行，无需重新启动");
			}
		}
	}
	
	private static boolean isActive(String processName, String name) {
		try {
//			Process process = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + processName + "\"");
			Process process = Runtime.getRuntime().exec("tasklist");
			BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream())); 
			String line = null;
			while((line=br.readLine())!=null) {
				if (line.contains(name)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	
}
