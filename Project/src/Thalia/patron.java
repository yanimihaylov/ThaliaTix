package Thalia;

public class patron {
	
			private String name;
			
			private String phone;
			private String email;
			private String billing_address;
			private String cc_number;
			private String cc_exp_date;

			public patron(String n, String p, String e, String b_a, String cc_n, String cc_exp_d) {
				name = n;
				phone = p;
				email = e;
				billing_address = b_a;
				cc_number = cc_n;
				cc_exp_date = cc_exp_d;
		}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getPhone() {
				return phone;
			}

			public void setPhone(String phone) {
				this.phone = phone;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getBilling_address() {
				return billing_address;
			}

			public void setBilling_address(String billing_address) {
				this.billing_address = billing_address;
			}

			public String getCc_number() {
				return cc_number;
			}

			public void setCc_number(String cc_number) {
				this.cc_number = cc_number;
			}

			public String getCc_exp_date() {
				return cc_exp_date;
			}

			public void setCc_exp_date(String cc_exp_date) {
				this.cc_exp_date = cc_exp_date;
			}
}
