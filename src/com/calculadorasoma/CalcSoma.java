package com.calculadorasoma;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcSoma extends Activity {

	EditText ednumero1, ednumero2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ednumero1 = (EditText) findViewById(R.id.numero1);
		ednumero2 = (EditText) findViewById(R.id.numero2);
		Button btsomar = (Button) findViewById(R.id.btsomar);
		Button btsubtrair = (Button) findViewById(R.id.btsubtrair);
		Button btmultiplicar = (Button) findViewById(R.id.btmultiplicar);
		Button btdividir = (Button) findViewById(R.id.btdividir);

		btsomar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double res = operar("soma");
				exibirResultado(res);
			}
		});
		btsubtrair.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double res = operar("subtracao");
				exibirResultado(res);
			}
		});
		btmultiplicar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double res = operar("multiplicacao");
				exibirResultado(res);
			}
		});
		btdividir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double num2 = Double.parseDouble(ednumero2.getText().toString());
				if (num2 == 0){
					exibirErro("Nao pode dividir por zero!");
				}else{
					double res = operar("divisao");
					exibirResultado(res);
				}
			}
		});

	}

	public double operar(String operacao) {
		double num1 = Double.parseDouble(ednumero1.getText().toString());
		double num2 = Double.parseDouble(ednumero2.getText().toString());
		double res = 0;
		if (operacao.equals("soma")) {
			res = num1 + num2;
		} else if (operacao.equals("subtracao")) {
			res = num1 - num2;
		} else if (operacao.equals("multiplicacao")) {
			res = num1 * num2;
		} else if (operacao.equals("divisao")) {
			res = num1 / num2;
		}
		return res;
	}

	public void exibirResultado(double res) {
		AlertDialog.Builder dialogo = new AlertDialog.Builder(CalcSoma.this);
		dialogo.setTitle("Aviso");
		dialogo.setMessage("Resultado: " + res);
		dialogo.setNeutralButton("OK", null);
		dialogo.show();
	}
	
	public void exibirErro(String mensagem) {
		AlertDialog.Builder dialogo = new AlertDialog.Builder(CalcSoma.this);
		dialogo.setTitle("Aviso");
		dialogo.setMessage("Erro: " + mensagem);
		dialogo.setNeutralButton("OK", null);
		dialogo.show();
	}
}