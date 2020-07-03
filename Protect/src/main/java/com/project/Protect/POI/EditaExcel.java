package com.project.Protect.POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Outra possibilidade é abrir um arquivo já existente, e alterar os dados das
 * células. Por exemplo, caso o professor queira adicionar um ponto na nota 1 de
 * todos os alunos que estão no arquivo. É preciso alterar os dados da coluna
 * Nota1, Média e também da coluna Aprovado
 */
public class EditaExcel {

	private static final String fileName = "C:/Users/ana.garcia/Desktop/Backend projeto/novo.xls";

	public static void main(String[] args) throws IOException {

		try {
			FileInputStream file = new FileInputStream(new File(EditaExcel.fileName));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			for (int i = 0; i < sheetAlunos.getPhysicalNumberOfRows(); i++) {

				/**
				 * Na classe Cell, assim como existe os métodos get para recuperar os valores
				 * que estão nas células, existe também o método set, então para alterar os
				 * valores das células basta utilizar esses dois métodos.
				 */
				Row row = sheetAlunos.getRow(i);
				Cell cellNota1 = row.getCell(2);
				if (cellNota1.getNumericCellValue() < 9) {
					cellNota1.setCellValue(cellNota1.getNumericCellValue() + 1);
				} else {
					cellNota1.setCellValue(10);
				}

				Cell cellNota2 = row.getCell(3);
				Cell cellMedia = row.getCell(4);
				cellMedia.setCellValue((cellNota1.getNumericCellValue() + cellNota2.getNumericCellValue()) / 2);
				Cell cellAprovado = row.getCell(5);
				cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
			}
			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(EditaExcel.fileName));
			workbook.write(outFile);
			outFile.close();
			System.out.println("Arquivo Excel editado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}

}