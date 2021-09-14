package Farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PrincipalAtvSerializacao {

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
		
		List<Funcionario> funcListCsv = Funcionario.lerTodosFuncionarios();
		System.out.println("Funcion�rios pegos do csv.");
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);

		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(funcListCsv);
		}
		System.out.println("Funcion�rios serializados.");

		FileInputStream fis = new FileInputStream(f);
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			List<Funcionario> funcListSerialized = (List<Funcionario>) ois.readObject();
			System.out.println("Funcion�rios depois de serializado: ");
			System.out.println(funcListSerialized);	
			for (Funcionario funcionario : funcListSerialized) {
				System.out.print("To String do funcion�rio da lista: ");
				System.out.println(funcionario.toString());
			}
		}
	}

}
