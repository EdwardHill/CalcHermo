package testes;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		CalcHermogenes c = new CalcHermogenes();
		
		try{
			c.calculo();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Valor Inválido!");
			
			
		}
		
		
	}
}
