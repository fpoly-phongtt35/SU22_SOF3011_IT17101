package repository;

import model.Account;
import model.AccountRole;

public class AccountRepository {

	private static Account[] accounts = new Account[] {
			new Account("PhongTT35", "123", AccountRole.USER),
			new Account("admin", "321", AccountRole.ADMIN)
	};
	
	public Account getByUsername(String username) {
		// Duyệt ds
		for(Account account : accounts) {
			// Nếu tên tài khoản trùng với giá trị tìm kiếm
			if (account.getUsername().equals(username)) {
				return account; // thì trả về Tài khoản
			}
		}
		
		// Không tìm thấy
		return null;
	}
}
