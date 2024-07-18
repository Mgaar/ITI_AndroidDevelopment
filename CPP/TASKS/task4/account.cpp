 #include "ctime"
#include "account.hpp" 
 #include "iostream"
#include <iomanip> 

 int Account::m_noofAccounts=0;

 int Account::m_totalAmount=0;

 int Account::m_totalNbDeposits=0;

 int Account::m_totalNbWithdrawals=0;

void Account::m_displayTimestamp(void)
 {
std::time_t now = std::time(nullptr);
std::tm* localTime = std::localtime(&now);
std::cout << std::put_time(localTime, "%Y-%m-%d %H:%M:%S");
 }

 Account::Account(void):m_accountIndex{m_noofAccounts},m_amount{0},m_noofDeposits{0},m_no0fWithdrawals{0}{m_noofAccounts++;}


 Account::Account(int initial_deposit):m_accountIndex{m_noofAccounts},m_amount{initial_deposit},m_noofDeposits{1},m_no0fWithdrawals{0}
 {m_noofAccounts++;
 m_totalAmount+=initial_deposit;
 m_totalNbDeposits++;
 }
Account::~Account(void)
{
  m_noofAccounts--;
 m_totalAmount-=m_amount;

}

void Account::makeDeposit (int deposit)
{
m_amount+=deposit;
m_noofDeposits++;
m_totalAmount+=deposit;
m_totalNbDeposits++;
}

bool Account::makeWithdrawal (int withdrawal)
{
    if (withdrawal<=m_amount)
    {
m_totalAmount-=withdrawal;
m_totalNbWithdrawals++;
m_amount-=withdrawal;
m_no0fWithdrawals++;
return true ;
    }

return false;
}
int Account::checkAmount(void) const
{
return m_amount;
}
void Account::displayStatus (void) const
{
    std::cout << "account id :"<<m_accountIndex<<""<<"\n amount="<<m_amount<<"\n number of deposits"<<m_noofDeposits<<"\n number of withdraws"<<m_no0fWithdrawals;
}


int Account::getNoOfAccounts(void)  // Returns the number of accounts
{
    return m_noofAccounts;
}
int  Account::getTotalAmount(void)  // Returns the total amount of all accounts
{
    return m_totalAmount;
}
int  Account::getNbDeposits (void) // Returns the number of deposits
{
    return m_totalNbDeposits;
}
int  Account::getNoOfWithdrawals(void)// Returns the number of withdrawals
{
    return m_totalNbWithdrawals;
}
void  Account::displayAccountsInfos (void)// Displays the number of accounts, the total amount of deposits, the total amount of withdrawals, and the total amount of all accounts
{
    m_displayTimestamp();
    std::cout << "Accounts :"<<m_noofAccounts<<" total amount:"<<m_totalAmount\
    <<" total number of withdraws :"<<m_totalNbWithdrawals<<"total number of deposits:"<<m_totalNbDeposits;
}
