package testes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

public class CalcHermogenes {
	int parcelas;
	String statusComissao;
	double valorBase = 0, valorComissao = 0, porcentComissao = 0, comissaoDividida = 0, desconto = 0, totalVenda = 0,
			totalComissao = 0;

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getStatusComissao() {
		return statusComissao;
	}

	public void setStatusComissao(String statusComissao) {
		this.statusComissao = statusComissao;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}

	public double getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(double valorComissao) {
		this.valorComissao = valorComissao;
	}

	public double getPorcentComissao() {
		return porcentComissao;
	}

	public void setPorcentComissao(double porcentComissao) {
		this.porcentComissao = porcentComissao;
	}

	public double getComissaoDividida() {
		return comissaoDividida;
	}

	public void setComissaoDividida(double comissaoDividida) {
		this.comissaoDividida = comissaoDividida;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}

	public double getTotalComissao() {
		return totalComissao;
	}

	public void setTotalComissao(double totalComissao) {
		this.totalComissao = totalComissao;
	}

	public CalcHermogenes() {

	}

	public void calculo() {

		// Entrada de valores

		valorBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor base R$:"));
		valorComissao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da comissao R$:"));
		parcelas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o total de parcelas a prazo"));

		porcentComissao = valorComissao / valorBase * 100;
		totalVenda = valorBase * parcelas;
		comissaoDividida = totalVenda * (porcentComissao / 100) / parcelas;		
		totalComissao = valorComissao * parcelas;

		if (porcentComissao < 4.65 || porcentComissao < 3.72 || porcentComissao < 2.79) {
			statusComissao = "Atenção Comissão Abaixo do Padrão";
		} else {
			statusComissao = "Atende o Padrão estabelecido";

		}

		if (porcentComissao <= 4.65 && porcentComissao > 4.0 || porcentComissao >= 4.65) {
			desconto = 16;
		} else if (porcentComissao <= 3.72 && porcentComissao > 3.0 || porcentComissao >= 3.72) {
			desconto = 17;

		} else if (porcentComissao <= 2.79 && porcentComissao > 2.78 || porcentComissao >= 2.79) {
			desconto = 18;
		} else {
			desconto = 0;
		}

		// saida
		
		BigDecimal com = new BigDecimal(porcentComissao).setScale(3, RoundingMode.HALF_EVEN);
		BigDecimal comparcel = new BigDecimal(valorComissao).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal tv = new BigDecimal(totalVenda).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal tc = new BigDecimal(totalComissao).setScale(2, RoundingMode.HALF_EVEN);

		JOptionPane.showMessageDialog(null,
				statusComissao + "\n" + "\nTotal da Venda: R$" + tv + "\nParcela da Venda: R$" + valorBase
						+ "\nTotal Comissao: R$" + tc + "\nParcela da Comissao: R$" + comparcel
						+ "\nComissão Aplicada: " + com + "%" + "\nDesconto Aplicado: " + desconto
						+ "\nTotal de Parcelas:" + parcelas);

		// fim

		System.exit(1);

	}
	public double porcentCom() {
		porcentComissao = valorComissao / valorBase * 100;
		
		return porcentComissao;
	}
	public double comissaoDivi() {
		comissaoDividida = totalVenda * (porcentComissao / 100) / parcelas;
		return comissaoDividida;
	}
	public double totalVend() {
		totalVenda = valorBase * parcelas;
		return totalVenda;
	}
	public double totalcomissa() {
		totalComissao = valorComissao * parcelas;
		return totalComissao;
	}
	
	

}
