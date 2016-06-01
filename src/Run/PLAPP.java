
package Run;
import Grafica.*;
import SERVICIOS.Servicios;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author USER
 */
public class PLAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Servicios serPlapp = new Servicios();
       login VenInicio = new login();
       
       VenInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       VenInicio.setSize(new Dimension(610, 500));
       VenInicio.setTitle("PLAPP");
       VenInicio.setVisible(true);
    }
}
