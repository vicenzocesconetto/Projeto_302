import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RealizarVendaMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public RealizarVendaMenu(Venda venda, ArrayList<Servico> servicos,ArrayList<Produto> produtos) {
		setTitle("NOVA VENDA");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//BOTOES
		
		//ADICIONAR PRODUTO
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaAdicionarProdutos addProdutos = new RealizarVendaAdicionarProdutos(venda, produtos);
				addProdutos.setVisible(true);
			}
		});
		btnAdicionarProduto.setBounds(138, 18, 170, 25);
		
		//REMOVER PRODUTO
		JButton btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaRemoverProdutos removeProdutos = new RealizarVendaRemoverProdutos(venda);
				removeProdutos.setVisible(true);
			}
		});
		btnRemoverProduto.setBounds(138, 61, 170, 25);
		
		//ADICIONAR SERVICO
		JButton btnAdicionarServico = new JButton("Adicionar Servicos");
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaAdicionarServicos addServicos = new RealizarVendaAdicionarServicos(venda, servicos);
				addServicos.setVisible(true);
			}
		});
		btnAdicionarServico.setBounds(138, 104, 170, 25);
		
		//REMOVER SERVICO
		JButton btnRemoverServico = new JButton("Remover Servico");
		btnRemoverServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaRemoverServicos removeServicos = new RealizarVendaRemoverServicos(venda);
				removeServicos.setVisible(true);
			}
		});
		btnRemoverServico.setBounds(138, 147, 170, 25);
		
		//CONCLUIR
		JButton btnConcluirVenda = new JButton("Concluir Venda");
		btnConcluirVenda.setBounds(138, 190, 170, 25);
		
		//ADICIONA NA TELA
		contentPanel.add(btnAdicionarProduto);
		contentPanel.add(btnRemoverProduto);
		contentPanel.add(btnAdicionarServico);
		contentPanel.add(btnRemoverServico);
		contentPanel.add(btnConcluirVenda);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
