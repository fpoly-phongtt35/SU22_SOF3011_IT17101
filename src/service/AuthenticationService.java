package service;

import model.Account;
import repository.AccountRepository;

public class AuthenticationService {
	
	private final AccountRepository accountRepo
		= new AccountRepository();
	
	public Account authenticate(String username, String password) {
		// 1. Kiểm tra tài khoản tồn tại
		Account account = accountRepo.getByUsername(username);
		if (account == null) { // NULL là không tồn tại
			return null; // Không hợp lệ
		}
		
		// 2. Kiểm tra mật khẩu trùng khớp
		// Nếu không khớp thì trả về không hợp lệ
		if(!account.getPassword().equals(password)) {
			return null;
		}
		
		return account; // OKKKK
	}
}
