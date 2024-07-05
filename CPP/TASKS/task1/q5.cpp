
struct Name_t {
	char firstname[10];
	char middlename[10];
	char lastname[10];

};

struct BirthDay_t {
	int day;
	int month;
	int year;
};

struct Address_t {
	char street[10];
	char city[10];
	char country[10];

};

struct Contacts_t {
	char telephone[15];
	char mobile[15];
	char email[15];

};

struct Salary_t {
	float basic;
	float reduction;
	float taxes;
	float additional;
};

struct employee_t {
	Name_t name;
	BirthDay_t BirthDay;
	Address_t Address;
	Contacts_t Contacts;
	char job[20];
	Salary_t Salary;
};
