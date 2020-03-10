
package delpinoparcial;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class DelPinoParcial {

   
    public static Connection conectar() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/tienda?user=root&password=mysqladmin";
            con = (Connection) DriverManager.getConnection(url);
            if (con !=null);
            System.out.println("Conexion Satisfecha");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    
    }
         
        
      
        public static void main(String[] args) {
        
        try {
            JasperReport jr = (JasperReport)
            JRLoader.loadObject 
            (DelPinoParcial.class.getResource("./Reporte2.jasper"))   ;
             Map parametros = new HashMap<String,Object>();
             parametros.put ("REPORTE","Holas Nicolas");
             JasperPrint jp = JasperFillManager.fillReport
             (jr,parametros, new JREmptyDataSource());
             JasperViewer jv = new JasperViewer(jp);
             jv.show();
            
            
                    
        } catch (Exception e) {
            System.err.println(e);
        }
     



    }
}



    
    

