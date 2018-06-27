import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BoxLayout;

public class ConsultarCadastro extends JDialog {

	public ConsultarCadastro(ArrayList<Servico> servicos, ArrayList<Cliente> clientes, ArrayList<Produto> produtos) {
		setTitle("Consultar/Atualizar Cadastros");
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 235, 450, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(59, 89, 182));
				cancelButton.setForeground(Color.white);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JButton btnConsultarCadastroDe = new JButton("Consultar cadastro de Produtos");
		btnConsultarCadastroDe.setBackground(new Color(59, 89, 182));
		btnConsultarCadastroDe.setForeground(Color.white);
		btnConsultarCadastroDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCadastroProduto Cproduto = new ConsultarCadastroProduto(produtos);
				Cproduto.setVisible(true);
			}
		});
		btnConsultarCadastroDe.setBounds(71, 25, 300, 50);
		getContentPane().add(btnConsultarCadastroDe);
		
		JButton btnConsultarCadastroDe_1 = new JButton("Consultar cadastro de serviços");
		btnConsultarCadastroDe_1.setBackground(new Color(59, 89, 182));
		btnConsultarCadastroDe_1.setForeground(Color.white);
		
		btnConsultarCadastroDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCadastroServico Cservico = new ConsultarCadastroServico(servicos);
				Cservico.setVisible(true);
			}
		});
		btnConsultarCadastroDe_1.setBounds(71, 99, 300, 50);
		getContentPane().add(btnConsultarCadastroDe_1);
		
		JButton btnConsultarCadastroDe_2 = new JButton("Consultar cadastro de Clientes");
		btnConsultarCadastroDe_2.setBackground(new Color(59, 89, 182));
		btnConsultarCadastroDe_2.setForeground(Color.white);
		btnConsultarCadastroDe_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCadastroCliente Ccliente = new ConsultarCadastroCliente(clientes);
				Ccliente.setVisible(true);
			}
		});
		btnConsultarCadastroDe_2.setBounds(71, 173, 300, 50);
		getContentPane().add(btnConsultarCadastroDe_2);
	}

}
