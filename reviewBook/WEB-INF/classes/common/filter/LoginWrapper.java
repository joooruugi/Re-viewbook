package common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper {

	public LoginWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if (name != null && name.equals("pwd"))
			name = getSha512(super.getParameter(name)); // SHA-512 암호화 메소드
		else
			name = super.getParameter(name);
		return name;
	}

	private static String getSha512(String pwd) {
		try { // SHA-512 암호화를 위한 로직 구현
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			return Base64.getEncoder().encodeToString(md.digest());
		} catch (Exception e) {
			System.out.println("Sha512 error.");
			e.printStackTrace();
			return null;
		}
//		이름에서 알 수 있듯이 512 비트, 즉 64 바이트입니다.
//		하지만 해시입니다. 문자열에서 해시의 특정 표현에 대해 궁금해하시는 경우가 많습니다. 
//		일반적으로 사용되는 것처럼, 주어진 표현에 따라 달라집니다.
//		16 진수로 해시를 쓰면 128 문자가됩니다.
//		base64로 해시를 작성하면 86 바이트 (또는 패딩의 경우 88)가됩니다.
		
	}

}
