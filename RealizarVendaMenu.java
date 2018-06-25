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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RealizarVendaMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public RealizarVendaMenu(ArrayList<Servico> servicos,ArrayList<Produto> produtos) {
		setTitle("NOVA VENDA");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaAdicionarProdutos addProdutos = new RealizarVendaAdicionarProdutos(produtos);
				addProdutos.setVisible(true);
			}
		});
		btnAdicionarProduto.setBounds(138, 18, 170, 25);
		contentPanel.add(btnAdicionarProduto);
		
		JButton btnNewButton = new JButton("Remover Produto");
		btnNewButton.setBounds(138, 61, 170, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adicionar Servicos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVendaAdicionarServicos addServicos = new RealizarVendaAdicionarServicos(servicos);
				addServicos.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(138, 104, 170, 25);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover Produto");
		btnNewButton_2.setBounds(138, 147, 170, 25);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Concluir Venda");
		btnNewButton_3.setBounds(138, 190, 170, 25);
		contentPanel.add(btnNewButton_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
