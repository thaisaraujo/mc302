package janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JanelaCatalogoAluguel {

	private JFrame frmCatalogoAluguel;

	public static void mostrarCatalogo(String saida) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCatalogoAluguel window = new JanelaCatalogoAluguel(saida);
					window.frmCatalogoAluguel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCatalogoAluguel(String saida) {
		initialize(saida);
	}

	private void initialize(String saida) {
		frmCatalogoAluguel = new JFrame();
		frmCatalogoAluguel.setBackground(Color.LIGHT_GRAY);
		frmCatalogoAluguel.setTitle("Catalogo Aluguel");
		frmCatalogoAluguel.setBounds(100, 100, 272, 670);
		frmCatalogoAluguel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatalogoAluguel.getContentPane().setLayout(null);
		
		JTextArea jarea = new JTextArea(saida);
		
		JScrollPane scrollPaneCatalago = new JScrollPane(jarea);
		scrollPaneCatalago.setBounds(10, 10, 234, 493);
		scrollPaneCatalago.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCatalago.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frmCatalogoAluguel.getContentPane().add(scrollPaneCatalago);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCatalogoAluguel.dispose();
			}
		});
		btnOK.setBounds(26, 516, 202, 76);
		frmCatalogoAluguel.getContentPane().add(btnOK);
	}
}
