package Servidor2;

public class Tabuleiro {
	Integer[][] tabuleiro;
	
	public Tabuleiro (){
		this.tabuleiro = new Integer[10][10];
		inicializarTabuleiro();
	}

	private void inicializarTabuleiro(){
		int contador=1;
		for(int i=0; i < 10; i++){
			for(int j=0; j < 10; j++){
				tabuleiro[i][j] = contador;
				contador++;
			}			
		}	
	}
	
	public void imprimeTabuleiro(){
		int contador=0;
		for(int i=0; i < 10; i++){
			for(int j=0; j < 10; j++){
				if(tabuleiro[i][j]==0){
				System.out.print(" "+tabuleiro[i][j]+" ");
				}else{
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
	}
	public String estadoTabuleiro(){
		String tabulerio = "";
		for(int i=0; i < 10; i++){
			for(int j=0; j < 10; j++){
				if(tabuleiro[i][j]==0){
				tabulerio += " "+tabuleiro[i][j]+" ";
				}else if (tabuleiro[i][j]==-1){
					tabulerio += " # ";
				}else{
					tabulerio += " * ";
				}
			}
			tabulerio += "\n";
		}
		return tabulerio;
	}


	public Integer[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int i, int j) {
		this.tabuleiro[i][j] = 0;
	}
	
	public void setTabuleiroAgua(int i, int j) {
		this.tabuleiro[i][j] = -1;
	}
	

}