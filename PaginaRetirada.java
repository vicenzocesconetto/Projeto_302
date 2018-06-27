import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaRetirada extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField valor;
	private Funcoes funcoes = new Funcoes();
   
    public PaginaRetirada(Empresa empresa) {
    	setTitle("Fazer Retirada");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
    	
    	JLabel labelValor = new JLabel("Valor (R$):");
    	labelValor.setBounds(59, 28, 79, 30);
    	
    	JLabel labelMotivo = new JLabel("Motivo:");
        labelMotivo.setBounds(80, 66, 58, 30);
        
        valor = new JTextField(10);
        valor.setBounds(140, 28, 200, 30);
        
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBounds(140, 66, 200, 79);
                
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(140, 66, 200, 79);
        
        JButton retirada = new JButton("Retirar!");
        retirada.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(Float.parseFloat(valor.getText())==0) {
        			JOptionPane.showMessageDialog(null, "Não é possivel retirar R$0!", null, JOptionPane.ERROR_MESSAGE);
        		}else if(textArea.getText().equals("")){
        			JOptionPane.showMessageDialog(null, "Preencha o motivo da retirada!", null, JOptionPane.ERROR_MESSAGE);
        		}else {
        			if(funcoes.retirarDinheiro(empresa, Float.parseFloat(valor.getText()), textArea.getText())) {
	        			JOptionPane.showMessageDialog(null, "Retira autorizada", null, JOptionPane.INFORMATION_MESSAGE);
	        			dispose();
	        		}else {
	        			JOptionPane.showMessageDialog(null, "Retira não autorizada!", null, JOptionPane.ERROR_MESSAGE);
	        		}
        		}
        	}
        });
        retirada.setBounds(207, 157, 100, 30);
        retirada.setBackground(Color.red);
        retirada.setForeground(Color.white);      
        
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        voltar.setBounds(95, 157, 100, 30);
        voltar.setBackground(new Color(59, 89, 182));
        voltar.setForeground(Color.white);
             
        contentPanel.add(scroll);
        contentPanel.add(labelValor);
        contentPanel.add(valor);
        contentPanel.add(labelMotivo);
        contentPanel.add(retirada);
        contentPanel.add(voltar);
        
       

    } 
}
