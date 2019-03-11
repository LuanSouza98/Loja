package br.edu.ucsal.loja.teste.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ucsal.loja.bean.Cliente;

public class ClienteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	// private static final int COL_CPF = 2;
	private static final int COL_TELEFONE = 2;
	// private static final int COL_CELULAR = 4;
	private static final int COL_EMAIL = 3;
	List<Cliente> linhas;
	private String[] colunas = new String[] { "id", "nome", "telefone", "email" };

	public ClienteTableModel(List<Cliente> linhas) {
		this.linhas = new ArrayList<Cliente>();
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.linhas.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente cliente = linhas.get(row);

		if (column == COL_ID) {
			return cliente.getId();
		} else if (column == COL_NOME) {
			return cliente.getNome();
		} else if (column == COL_TELEFONE) {
			return cliente.getTelefone();
		} else if (column == COL_EMAIL) {
			return cliente.getEmail();
		}
		return "";

	}

	public void setValueAt(Object aValue, int row, int column) {
		Cliente cliente = linhas.get(row);
		if (column == COL_ID) {
			cliente.setId((Integer) aValue);
		} else if (column == COL_NOME) {
			cliente.setNome(aValue.toString());
		} else if (column == COL_TELEFONE) {
			cliente.setTelefone(aValue.toString());
		} else if (column == COL_EMAIL) {
			cliente.setEmail(aValue.toString());
		}
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	public Class getColumnClass(int columnIndex) {
		if (columnIndex == COL_ID) {
			return Integer.class;
		}
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Cliente getCliente(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addCliente(Cliente cliente) {
		linhas.add(cliente);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void updateCliente(int indiceLinha, Cliente marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	public void removeCliente(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}

}
