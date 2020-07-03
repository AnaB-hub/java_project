package com.project.Protect.POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class AbreExcel {
	/** Mudar o caminho para atender o seu arquivo xls */
	private static final String fileName = "C:/Users/ana.garcia/Desktop/Backend projeto/Exemplo.xls";

	public static void main(String[] args) throws IOException {

		List<Aluno> listaAlunos = new ArrayList<Aluno>();

		try {
			/**
			 * O primeiro passo é abrir o arquivo, com a classe FileInputStream, passando o
			 * PATH completo do arquivo
			 */
			FileInputStream arquivo = new FileInputStream(new File(AbreExcel.fileName));

			/**
			 * Depois utilizando a classe HSSFWorkbook, o arquivo é validado se é ou não um
			 * arquivo Excel.
			 */
			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

			/**
			 * A classe HSSFSheet abre uma planilha específica do arquivo. O POI pode abrir
			 * diversas planilhas que estejam dentro de um arquivo Excel, no exemplo, como
			 * existe apenas uma planilha, é aberta a planilha com índice 0.
			 */
			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			/**
			 * Depois de aberto o arquivo, e com a planilha que será processado aberta, é
			 * necessário ler célula a célula do arquivo, para isso, é recuperado um
			 * iterator sobre todas as linhas do arquivo excel. Dentro de cada linha, é
			 * recuperado outro iterator, agora para iterar sobre as colunas de cada linha.
			 */
			Iterator<Row> rowIterator = sheetAlunos.iterator();

			while (rowIterator.hasNext()) {
				/**
				 * Para ler as linhas do arquivo, é utilizada a classe Row, e para a célula
				 * especifica é utilizada a classe Cell.
				 */
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				Aluno aluno = new Aluno();
				listaAlunos.add(aluno);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						aluno.setNome(cell.getStringCellValue());
						break;
					case 1:
						aluno.setRa(String.valueOf(cell.getNumericCellValue()));
						break;
					case 2:
						aluno.setNota1(cell.getNumericCellValue());
						break;
					case 3:
						aluno.setNota2(cell.getNumericCellValue());
						break;
					case 4:
						aluno.setMedia(cell.getNumericCellValue());
						break;
					case 5:
						aluno.setAprovado(cell.getBooleanCellValue());
						break;
					}
				}
			}
			arquivo.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		}

		if (listaAlunos.size() == 0) {
			System.out.println("Nenhum aluno encontrado!");
		} else {
			double soma = 0;
			double maior = 0;
			double menor = listaAlunos.get(0).getMedia();
			int aprovados = 0;
			int reprovados = 0;
			for (Aluno aluno : listaAlunos) {
				System.out.println("Aluno: " + aluno.getNome() + " Média: " + aluno.getMedia());
				soma = soma + aluno.getMedia();
				if (aluno.getMedia() > maior) {
					maior = aluno.getMedia();
				}
				if (aluno.getMedia() < menor) {
					menor = aluno.getMedia();
				}
				if (aluno.getMedia() >= 6) {
					aprovados++;
				}
				if (aluno.getMedia() < 6) {
					reprovados++;
				}
			}
			double media = soma / listaAlunos.size();
			System.out.println("A media de notas e: " + media);
			System.out.println("A maior nota e: " + maior);
			System.out.println("A menor nota e: " + menor);
			System.out.println("O numero de alunos aprovados e: " + aprovados);
			System.out.println("O numero de alunos reprovados e: " + reprovados);
			System.out.println("Número total de alunos: " + listaAlunos.size());
		}

	}
}
