
package kwak;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ZdjecieZwierzak {
    
    private JFrame okno = new JFrame("Zdjęcie");
    
    ZdjecieZwierzak(String sciezka){
        
    ImageIcon image = new ImageIcon(sciezka);
    JLabel imageLabel = new JLabel(image); 
    JScrollPane scrollPane = new JScrollPane(imageLabel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    okno.add(scrollPane, BorderLayout.CENTER);
    okno.setVisible(true);
    okno.pack();
    
    }
}
