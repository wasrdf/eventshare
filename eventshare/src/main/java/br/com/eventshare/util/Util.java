package br.com.eventshare.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;

public class Util {

	public static String removerCaracterEspecial(String word) {
		if (StringUtils.isNotBlank(word)) {
			word = word.replaceAll("\\W", "");
		}
		return word;
	}

	/**
	 * Método responsável por formatar datas passando o formato por parametro.
	 * 
	 * @param formato
	 * @return
	 */
	public static String formatarFormatoData(String formato, Date data) {
		try {
			return new SimpleDateFormat(formato).format(data);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public static Boolean isNotNull(Object o) {
		try {
			if ((o != null)) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static Boolean isNull(Object o) {
		try {
			if (o == null) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static Boolean isNotNullOrBlank(String o) {
		try {
			if ((o != null) && !(o.isEmpty())) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("null")
	public static Boolean isNotNullOrEmpty(List<Object> o) {
		try {
			if ((o != null) || !(o.isEmpty())) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			throw new RuntimeException("Objeto nulo.");
		}
	}

	public static BigDecimal roundNumber(final BigDecimal number, final boolean isFloor) {
		return number.setScale(2, isFloor ? RoundingMode.FLOOR : RoundingMode.CEILING);
	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date data) {
		LocalDate localDate = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

	public static void sendMessage(String tipo, String msg) {
		if (tipo.equals("E")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
		}

	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {

			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static void mudarPagina(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String datePattern(Date date, String pattern) {
		DateFormat formatter = new SimpleDateFormat(pattern);
		String today = formatter.format(date);
		return today;
	}
	
	public static String dateToString(Date data) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(data);
	}

	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}

	public static String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other
																									// chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}

	public static String mascaraTelefome(String tel) {

		String telefone = tel.trim();

		if ((Util.isNotNull(telefone)) && (telefone != ""))

			if (telefone.length() == 10) {
				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-"
						+ telefone.substring(6, 10);
			} else if (telefone.length() == 11) {
				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-"
						+ telefone.substring(7, 11);
			}

		return telefone;
	}

	public static Date converterStringToDate(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		return formatter.parse(data);

	}

	public static boolean isValidDate(String input) {

		String[] parts = input.split("/");

		if ((Integer.valueOf(parts[0]) > 31) || (Integer.valueOf(parts[0]) < 01)) {
			return false;
		}

		if ((Integer.valueOf(parts[1]) > 12) || (Integer.valueOf(parts[1]) < 01)) {
			return false;
		}

		if ((Integer.valueOf(parts[2]) == 0000) || (Integer.valueOf(parts[2]) < 1000)) {
			return false;
		}

		Calendar c = Calendar.getInstance();
		c.getTime();
		Integer ano = c.get(Calendar.YEAR);
		if (Integer.valueOf(parts[2]) > ano) {
			return false;
		}

		return true;
	}

	public static String formatarCep(String cep) {
		if (StringUtils.isNotBlank(cep)) {
			if (cep.trim().length() == 8) {
				return cep.substring(0, 5) + "-" + cep.substring(5, 8);
			}
		}
		return cep;
	}

	public static int getAge(String date) {

		int age = 0;
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = df.parse(date);
			Calendar now = Calendar.getInstance();
			Calendar dob = Calendar.getInstance();
			dob.setTime(date1);
			if (dob.after(now)) {
				throw new IllegalArgumentException("Can't be born in the future");
			}
			int year1 = now.get(Calendar.YEAR);
			int year2 = dob.get(Calendar.YEAR);
			age = year1 - year2;
			int month1 = now.get(Calendar.MONTH);
			int month2 = dob.get(Calendar.MONTH);
			if (month2 > month1) {
				age--;
			} else if (month1 == month2) {
				int day1 = now.get(Calendar.DAY_OF_MONTH);
				int day2 = dob.get(Calendar.DAY_OF_MONTH);
				if (day2 > day1) {
					age--;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return age;

	}

}
