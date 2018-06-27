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
import java.awt.Color;

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
		
		btnAdicionarProduto.setBackground(new Color(59, 89, 182));
		btnAdicionarProduto.setForeground(Color.white);
		
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RealizarVendaAdicionarProdutos addProdutos = new RealizarVendaAdicionarProdutos(venda, produtos);
				addProdutos.setVisible(true);
				setVisible(true);
			}
		});
		btnAdicionarProduto.setBounds(138, 18, 170, 30);
		
		//REMOVER PRODUTO
		JButton btnRemoverProduto = new JButton("Remover Produto");
		
		btnRemoverProduto.setBackground(new Color(59, 89, 182));
		btnRemoverProduto.setForeground(Color.white);
		
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RealizarVendaRemoverProdutos removeProdutos = new RealizarVendaRemoverProdutos(venda);
				removeProdutos.setVisible(true);
				setVisible(true);
			}
		});
		btnRemoverProduto.setBounds(138, 61, 170, 30);
		
		//ADICIONAR SERVICO
		JButton btnAdicionarServico = new JButton("Adicionar Servicos");
		
		btnAdicionarServico.setBackground(new Color(59, 89, 182));
		btnAdicionarServico.setForeground(Color.white);
		
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RealizarVendaAdicionarServicos addServicos = new RealizarVendaAdicionarServicos(venda, servicos);
				addServicos.setVisible(true);
				setVisible(true);
			}
		});
		btnAdicionarServico.setBounds(138, 104, 170, 30);
		
		//REMOVER SERVICO
		JButton btnRemoverServico = new JButton("Remover Servico");
		
		btnRemoverServico.setBackground(new Color(59, 89, 182));
		btnRemoverServico.setForeground(Color.white);
		
		btnRemoverServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RealizarVendaRemoverServicos removeServicos = new RealizarVendaRemoverServicos(venda);
				removeServicos.setVisible(true);
				setVisible(true);
			}
		});
		btnRemoverServico.setBounds(138, 147, 170, 30);
		
		//CONCLUIR
		JButton btnConcluirVenda = new JButton("Concluir Venda");
		
		btnConcluirVenda.setBackground(new Color(59, 89, 182));
		btnConcluirVenda.setForeground(Color.white);
		
		btnConcluirVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ConcluirVenda concluir = new ConcluirVenda(venda);
				concluir.setVisible(true);
				dispose();
			}
		});
		btnConcluirVenda.setBounds(138, 190, 170, 30);
		
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
	}
}
